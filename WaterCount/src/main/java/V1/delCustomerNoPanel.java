package V1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class delCustomerNoPanel extends JPanel implements ActionListener {
    private Connection cno;
    private Statement st;
    private JLabel jLabel1 = new JLabel("输入待删除的客户号：");
    private JTextField jTextField1 = new JTextField();
    JButton jButton1 = new JButton("删除数据");
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea jTextArea1 = new JTextArea();

    public void delcustomernopanel(){
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
        jLabel1.setBounds(new Rectangle(130,20,200,24));
        jTextField1.setBounds(new Rectangle(110,85,170,30));
        jButton1.setBounds(new Rectangle(110,185,170,30));

        jButton1.addActionListener(this);
        this.add(jScrollPane1);
        jScrollPane1.getViewport().add(jTextArea1);
        this.add(jLabel1);
        this.add(jTextField1);
        this.add(jButton1);
    }
    public void actionPerformed(ActionEvent e) {
        String Cno1 = jTextField1.getText();

        try{
            st.executeUpdate("delete from Customer where Cno = '"+Cno1+"' ");
            jTextField1.setText("");
            JOptionPane.showMessageDialog(this,"删除成功！");

        }catch (Exception ex){
            JOptionPane.showMessageDialog(this,"删除失败或者数据库不让操作！");
            ex.printStackTrace();

        }

    }

}

