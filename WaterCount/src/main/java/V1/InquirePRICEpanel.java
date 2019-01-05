package V1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InquirePRICEpanel extends JPanel implements ActionListener {
    Connection cno;
    Statement st;
    JButton jButton1 = new JButton("查询");
    JLabel jlabel2  = new JLabel("查询电费单价");
    JTextArea jTextArea1 = new JTextArea();

    public void InquirePricepanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        cno = DBConnect.getConn();
        st = cno.createStatement();
        this.setLayout(null);
        this.add(jTextArea1);
        this.add(jButton1);
        this.add(jlabel2);
        jlabel2.setFont(new java.awt.Font("宋体",Font.BOLD,16));
        jlabel2.setBounds(new Rectangle(150,10,200,34));

        jTextArea1.setBounds(new Rectangle(45,115,308,130));
        jButton1.setBounds(new Rectangle(160,45,80,36));
        jButton1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        //jTextArea1.setText("dada");
        if (JOptionPane.showConfirmDialog(this, "确认要查询吗？") == JOptionPane.YES_OPTION) {
                try {
                    ResultSet rs = st.executeQuery("select TypeNo,TypeName,TypePrice from WaterType ;");
                    for (int i = 0; i < 100; i++) {
                        if (rs.next()) {

                            jTextArea1.append(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + "\n");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "查询失败！");

                }

            }
    }
}


