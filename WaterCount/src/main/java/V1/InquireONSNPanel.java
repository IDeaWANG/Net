package V1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InquireONSNPanel extends JPanel implements ActionListener {
    Connection cno;
    Statement st;
    JLabel jLabel1 = new JLabel("请输入待查询的客户的名字：");
    JTextField jTextField1 = new JTextField();//JButton jButton1 = new JButton("按名字查询");
    JButton jButton2 = new JButton("查询");
    JTextArea jTextArea1 = new JTextArea();
    JScrollPane jScrollPane1 = new JScrollPane();

    public void InquireONSNpanel(){
        try{
            jbInit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception{
        cno = DBConnect.getConn();
        st =cno.createStatement();
        this.setLayout(null);
        jLabel1.setFont(new java.awt.Font("宋体",Font.BOLD,14));
        jLabel1.setBounds(new Rectangle(100,10,200,34));
        jButton2.setBounds(new Rectangle(270,45,40,36));
        jTextField1.setBounds(new Rectangle(75,50,160,36));
        //jTextArea1.setBounds(new Rectangle(45,115,308,130));
        jScrollPane1.setBounds(new Rectangle(45,115,308,130));



        jButton2.addActionListener(this);
        this.add(jLabel1);
        this.add(jTextArea1);
        this.add(jTextField1);
        this.add(jButton2);
        this.add(jScrollPane1);
        jScrollPane1.getViewport().add(jTextArea1);
    }
    public void actionPerformed(ActionEvent e) {
        String same1 = jTextField1.getText();
        //jTextArea1.setText("");
        if (JOptionPane.showConfirmDialog(this, "确认要查询吗？") == JOptionPane.YES_OPTION) {
            try {
                ResultSet rs = st.executeQuery("select * from Customer,Free1,UseWater where  Customer.Cno = Free1.Cno and Free1.Cno = Usewater.Cno and Customer.Cname ='"+same1+"'  \n");
                for(int i=0;i<100;i++) {
                    if(rs.next()) {
                        jTextArea1.append(rs.getString(1) +" "+ rs.getString(2) + rs.getString(3) + rs.getString(6)+rs.getString(7)+rs.getString(8)+rs.getString(12));
                        }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "查询失败！");

            }
            jTextField1.setText("");

        }
    }
}
