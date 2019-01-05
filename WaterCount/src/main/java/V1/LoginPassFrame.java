package V1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPassFrame extends JFrame implements ActionListener {
    private Connection cno;
    private Statement st;
    JPanel contentPane1 ;
    ImageIcon img = new ImageIcon("ahpu.jpg");
    JLabel jLabel4 = new JLabel(img);
    JLabel jLabel1 = new JLabel("欢迎使用电费管理系统！");
    JLabel jLabel2 = new JLabel("输入用户名");
    JLabel jLabel3 = new JLabel("请输入密码");
    JButton jButton1  =new JButton("登陆");
    JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
  public  void   loginpassFrame(){
        try{
            jbInit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void  jbInit()throws Exception {
        cno = DBConnect.getConn();
        st = cno.createStatement();
        contentPane1=(JPanel)getContentPane();
        contentPane1.setLayout(null);
        setSize(new Dimension(400,300));
        setTitle("电费管理系统");
        //contentPane.setLocation(300,400); //选择主界面的摆放位置；
        contentPane1.setVisible(true);
        jLabel1.setFont(new java.awt.Font("宋体",Font.BOLD,20));
        jLabel1.setBounds(new Rectangle(110,0,275,55));
        jLabel2.setBounds(new Rectangle(30,51,64,24));
        jLabel3.setBounds(new Rectangle(30,80,53,22));
        jButton1.setBounds(new Rectangle(130,150,100,50));
        jTextField1.setBounds(new Rectangle(102,49,200,30));
        jTextField2.setBounds(new Rectangle(102,85,200,30));
        jLabel4.setBounds(new Rectangle(0,0,img.getIconWidth(),img.getIconHeight()));
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jButton1);
        this.add(jTextField1);
        this.add(jTextField2);
        contentPane1.add(jLabel4);
        jButton1.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {
        String cname = jTextField1.getText();
        String Passwd = jTextField2.getText();
        if (JOptionPane.showConfirmDialog(this, "确认要登陆吗？") == JOptionPane.YES_OPTION) {
            try {
                ResultSet rs = st.executeQuery("select WorkName from WorkNo ;");
                for (int i = 0; i < 100; i++) {
                    if (rs.next()) {

                        if(cname.equals(rs)&&Passwd.equals("1")){
                        JOptionPane.showMessageDialog(this,"登陆成功！");
                            
                        }
                    }
                }
                MainFrame mainFrame1 = new MainFrame();
                this.remove(this.getContentPane());
                mainFrame1.setLocation(400,300);
                mainFrame1.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "登陆失败！");



            }


        }

    }
}

