package V1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InquireONSOPanel extends JPanel implements ActionListener {
    private Connection cno;
    private Statement st;
    private JLabel jLabel1 = new JLabel("请输入待查询的客户的客户号：");
    private JTextField jTextField1 = new JTextField();
    private JButton jButton1 = new JButton("按客户号查询");
    private JButton jButton2 = new JButton("查询");
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea jTextArea1 = new JTextArea();

    public void InquireONSOpanel(){
        try{
            jbInit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception{
        cno = DBConnect.getConn();
        st = cno.createStatement();
        this.setLayout(null);
        jLabel1.setFont(new java.awt.Font("宋体",Font.BOLD,14));
        jLabel1.setBounds(new Rectangle(100,10,200,34));
        jButton2.setBounds(new Rectangle(270,45,40,36));
        jTextField1.setBounds(new Rectangle(75,50,160,36));
        jScrollPane1.setBounds(new Rectangle(45,115,308,130));

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        this.add(jScrollPane1);
        this.add(jLabel1);
        this.add(jTextField1);
        this.add(jButton1);
        this.add(jButton2);
        jScrollPane1.getViewport().add(jTextArea1);



    }
    public void actionPerformed(ActionEvent e) {
        String sno = jTextField1.getText();
        //jTextArea1.setText("");
        if (JOptionPane.showConfirmDialog(this, "确认要查询吗？") == JOptionPane.YES_OPTION) {
            try {
                ResultSet rs1 = st.executeQuery("select Customer.Cno,Cname,Free1.FreeNo,UseWaterL,ChargeY,ChargeS from  Customer,UseWater,Free1,Charge where Customer.Cno = UseWater.Cno  and Free1.FreeNo = Charge.FreeNo and Usewater.Cno = Customer.Cno and  Customer.Cno = '"+sno+"' ;");
                for(int i=0;i<100;i++) {
                    if(rs1.next()) {
                        jTextArea1.setText(rs1.getString(1)  +" "+ rs1.getString(2) + rs1.getString(3) + rs1.getString(4) + rs1.getString(5) + rs1.getString(6) + "\n");
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "查询失败！");

            }
            jTextField1.setText("");
        }
    }
}
