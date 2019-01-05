package V1;

import sun.tools.jps.Jps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;


public class addCustomerPanel extends JPanel implements ActionListener {
        private Connection cno;
        private Statement st;
        private JLabel jLabel1 = new JLabel("客户号：");
        private JLabel jLabel2 = new JLabel("客户名：");
        private  JLabel jLabel3 = new JLabel("客户地址：");
        private  JLabel jLabel4 = new JLabel("客户电话:");
        private JTextField jTextField1 = new JTextField();
        private JTextField jTextField2 = new JTextField();
        private JTextField jTextField3 = new JTextField();
        private JTextField jTextField4 = new JTextField();
        JButton jButton1 = new JButton("存入数据库");
        private JScrollPane jScrollPane1 = new JScrollPane();
        private JTextArea jTextArea1 = new JTextArea();

        public void addcustomerpanel(){
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
            //jLabel1.setFont(new java.awt.Font("宋体",Font.BOLD,14));
            jLabel1.setBounds(new Rectangle(30,15,64,24));
            jLabel2.setBounds(new Rectangle(30,51,53,22));
            jLabel3.setBounds(new Rectangle(30,86,65,27));
            jLabel4.setBounds(new Rectangle(30,125,65,25));
            jTextField1.setBounds(new Rectangle(102,10,200,30));
            jTextField2.setBounds(new Rectangle(102,49,200,30));
            jTextField3.setBounds(new Rectangle(102,90,200,30));
            jTextField4.setBounds(new Rectangle(102,130,200,30));
            jButton1.setBounds(new Rectangle(107,185,198,30));

            jButton1.addActionListener(this);
            this.add(jScrollPane1);
            jScrollPane1.getViewport().add(jTextArea1);
            this.add(jLabel2);
            this.add(jLabel3);
            this.add(jLabel4);
            this.add(jLabel1);
            this.add(jTextField1);
            this.add(jTextField2);
            this.add(jTextField3);
            this.add(jTextField4);
            this.add(jButton1);
        }
        public void actionPerformed(ActionEvent e) {
            String Cno1 = jTextField1.getText();
            String Cname1 = jTextField2.getText();
            String Cadder1 = jTextField3.getText();
            String Cnumber1 = jTextField4.getText();

            try{
                st.executeUpdate("insert  into  Customer values ('"+Cno1+"' , '"+Cname1+"' , '"+Cadder1+"' , '"+Cnumber1+"')");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                JOptionPane.showMessageDialog(this,"插入成功！");

        }catch (Exception ex){
                JOptionPane.showMessageDialog(this,"插入失败或者数据库不让操作！");
                ex.printStackTrace();

            }

    }

}
