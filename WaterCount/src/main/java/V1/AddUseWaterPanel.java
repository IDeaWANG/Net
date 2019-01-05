package V1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

public class AddUseWaterPanel extends JPanel implements ActionListener {

    Connection con;
    Statement st;


    JLabel jLabel1 = new JLabel("客户号:");
    JLabel jLabel2 = new JLabel("用电类型:");
    JLabel jLabel3 = new JLabel("月份:");
    JLabel jLabel4 = new JLabel("用电量:");
    JTextField jTextField1 =new JTextField();
    JTextField jTextField2 =new JTextField();
    JTextField jTextField3 =new JTextField();
    JTextField jTextField4 = new JTextField();

    JButton jButton1 = new JButton("存入数据库");


    //构造方法；
    public void AddWaterCountpanel(){
        try{
            jbInit();
        }catch (Exception e){
            System.out.println("Add Occur Error！！！Please solve the Bug！");
            e.printStackTrace();
        }
    }


    public void jbInit() throws Exception{
         con = DBConnect.getConn();
         st = con.createStatement();
        this.setLayout(null);
        //设置各组件的大小；
        jLabel1.setBounds(new Rectangle(30,15,80,24));
        jLabel2.setBounds(new Rectangle(30,51,80,22));
        jLabel3.setBounds(new Rectangle(30,86,65,27));
        jLabel4.setBounds(new Rectangle(30,125,65,25));
        jTextField1.setBounds(new Rectangle(102,10,200,30));
        jTextField2.setBounds(new Rectangle(102,49,200,30));
        jTextField3.setBounds(new Rectangle(102,90,200,30));
        jTextField4.setBounds(new Rectangle(102,130,200,30));
        jButton1.setBounds(new Rectangle(107,185,198,30));

        jButton1.addActionListener(this);
        this.add(jTextField1);
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(jTextField2);
        this.add(jTextField3);
        this.add(jTextField4);

        this.add(jButton1);

    }

    //点击按钮事件
    //事件相应器 当你定义的事件捕捉以后就会执行这里的代码；
    public void actionPerformed(ActionEvent e){

        String cno1 = jTextField1.getText();
        String TypeNo1 = jTextField2.getText();
        String month1= jTextField3.getText();
        String UseWaterL1= jTextField3.getText();
        try{//在Java里面的sql语句使用自己定义的变量格式：' "+变量名+" ' （单引号+ 空格 + 双引号 + 加号 + 变量名 + 加号 + 双引号 +单引号）;
            st.executeUpdate("insert    into  UseWater values(' "+cno1+" ',' " +TypeNo1+" ',' "+month1+" ','"+UseWaterL1+"')" );
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            JOptionPane.showMessageDialog(this,"插入成功！");

        }catch (Exception ex){
            JOptionPane.showMessageDialog(this,"插入数据异常，或者数据库不让插入！");
            ex.printStackTrace();
        }
    }

}