package V1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

public  class DelUseWaterNoPanel extends JPanel implements ActionListener {
    Connection con;
    Statement st;
    JLabel jLabel1 = new JLabel("请输入待删除的客户号！");
    JTextField jTextField1= new JTextField();
    JButton jButton1 = new JButton("删除");

    public void DelWatercountpanel(){
        try{
            jbInit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Del Occur Error !!!!  please solve the Bug!!");
        }
    }


    //界面初始化；
    private void jbInit() throws Exception{
        con = DBConnect.getConn();
        st=con.createStatement();
        this.setLayout(null);
        //jLabel1.setFont(new java.awt.Font("宋体", Font.BOLD,14));
        jLabel1.setBounds(new Rectangle(130,20,200,30));
        jTextField1.setBounds(new Rectangle(90,85,205,36));
        jButton1.setBounds(new Rectangle(90,155,205,36));
        jButton1.addActionListener(this);
        this.add(jTextField1);
        this.add(jLabel1);
        this.add(jButton1);


    }
public void actionPerformed(ActionEvent e){
        String cno = jTextField1.getText();
        if(JOptionPane.showConfirmDialog(this,"确认要删除吗？")==JOptionPane.YES_OPTION){
            try{
                st.executeUpdate("delete * from UseWater where cno = ' "+cno+" ' ");
                JOptionPane.showMessageDialog(this,"删除成功！");
                jTextField1.setText("");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this,"删除操作失败！");
            }
        }
}


}

