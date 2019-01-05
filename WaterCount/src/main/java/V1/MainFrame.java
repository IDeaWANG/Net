package V1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    JPanel contentPane;
    JMenuBar jMenuBar1 = new JMenuBar();
    ImageIcon img = new ImageIcon("ahpu.jpg");
    JLabel jLabel3 = new JLabel(img);
    JMenuItem jMenuItem9 = new JMenuItem("退出");
    JMenu jMenu1 = new JMenu("电费管理");
    JMenuItem jMenuItem1 = new JMenuItem("添加记录");
    JMenuItem jMenuItem2 = new JMenuItem("删除记录");
    JMenu jMenu2 = new JMenu("电费查询");
    JMenuItem jMenuItem3 = new JMenuItem("按姓名查询");
    JMenuItem jMenuItem4 = new JMenuItem("按客户号查询");
    JMenu jMenu3 = new JMenu("单价查询");
    JMenuItem jMenuItem5 = new JMenuItem("电费单价查询");
    JMenu jMenu4 = new JMenu("顾客管理");
    JMenuItem jMenuItem6 = new JMenuItem("添加顾客");
    JMenuItem jMenuItem7 = new JMenuItem("按客户号删除");
    JMenuItem jMenuItem8 = new JMenuItem("按客户名删除");


    JLabel jLabel1 = new JLabel("欢迎使用电费管理系统！");
    JLabel jLabel2 = new JLabel("2018年12月06号");
    //构造方法；创建对象时自动调用；
    public   MainFrame(){
        try{
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    //界面初始化方法；
    private void jbInit() {
        contentPane=(JPanel)getContentPane();
        //contentPane.setLayout(null);
        contentPane.setLocation(400,300);
        setSize(new Dimension(400,300));
        setTitle("电费管理系统");
        //contentPane.setLocation(300,400); //选择主界面的摆放位置；
        contentPane.setVisible(true);
        //添加事件监听器；
        jMenuItem1.addActionListener(this);
        jMenuItem2.addActionListener(this);
        jMenuItem3.addActionListener(this);
        jMenuItem4.addActionListener(this);
        jMenuItem5.addActionListener(this);
        jMenuItem6.addActionListener(this);
        jMenuItem7.addActionListener(this);
        jMenuItem8.addActionListener(this);
        jMenuItem9.addActionListener(this);
        //添加菜单条
        setJMenuBar(jMenuBar1);
        //添加菜单组件到菜单条；
//        jMenuBar1.add(jMenuFile);
//        jMenuBar1.add(jMenuFile);
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);
        jMenuBar1.add(jMenuItem9);
        //jMenuBar1.add(jMenuExit);
        //添加菜单项组件到菜单组件；
        //jMenuFile.add(jMenuFileExit);

        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu2.add(jMenuItem3);
        jMenu2.add(jMenuItem4);
        jMenu3.add(jMenuItem5);
        jMenu4.add(jMenuItem6);
        jMenu4.add(jMenuItem7);
        jMenu4.add(jMenuItem8);
        //添加内容到内容面板；
        contentPane.add(jLabel1);
        contentPane.add(jLabel2);
        contentPane.add(jLabel3);

        //设置标签组件的大小和字体；
        jLabel1.setFont(new java.awt.Font("宋体",Font.BOLD,20));
        jLabel1.setBounds(new Rectangle(90,70,275,55));
        jLabel2.setFont(new java.awt.Font("宋体",Font.BOLD,16));
        jLabel2.setBounds(new Rectangle(130,130,200,35));
        jLabel3.setBounds(new Rectangle(0,0,img.getIconWidth(),img.getIconHeight()));

        }



    //菜单事件的处理方法；
    public  void actionPerformed(ActionEvent actionEvent) {


        //点击"退出"菜单下的退出选择菜单项；
        if (actionEvent.getSource() == jMenuItem9) {
            if (JOptionPane.showConfirmDialog(this, "确认要退出吗？") == JOptionPane.YES_OPTION)
               System.exit(0);
        }
            //点击"管理菜单"菜单下的"添加记录"菜单栏；
            if (actionEvent.getSource() == jMenuItem1) {
                AddUseWaterPanel add = new AddUseWaterPanel();
                this.remove(this.getContentPane());
                this.setContentPane(add);
                this.setVisible(true);
                add.AddWaterCountpanel();
            }
            //点击"管理菜单"菜单下的"删除记录"菜单栏；
            if (actionEvent.getSource() == jMenuItem2)
            {
                DelUseWaterNoPanel delete = new DelUseWaterNoPanel();
                this.remove(this.getContentPane());
                this.setContentPane(delete);
                this.setVisible(true);
                delete.DelWatercountpanel();
            }
            //点击"按姓名查询"面板内容；
            if (actionEvent.getSource() == jMenuItem3) {
                InquireONSNPanel onName = new InquireONSNPanel();
                this.remove(this.getContentPane());
                this.setContentPane(onName);
                this.setVisible(true);
                onName.InquireONSNpanel();

            }
            //点击"按学号查找"菜单；
            if (actionEvent.getSource() == jMenuItem4) {
                InquireONSOPanel onNO = new InquireONSOPanel();
                this.remove(this.getContentPane());
                this.setContentPane(onNO);
                this.setVisible(true);
                onNO.InquireONSOpanel();

            }
            //点击"单价查询"菜单；
            if (actionEvent.getSource() == jMenuItem5) {
                InquirePRICEpanel Price = new InquirePRICEpanel();
                this.remove(this.getContentPane());
                this.setContentPane(Price);
                this.setVisible(true);
                Price.InquirePricepanel();
            }
            if (actionEvent.getSource() == jMenuItem6) {
                addCustomerPanel add = new addCustomerPanel();
                this.remove(this.getContentPane());
                this.setContentPane(add);
                this.setVisible(true);
                add.addcustomerpanel();

            }
            if (actionEvent.getSource() == jMenuItem7) {
                delCustomerNoPanel delNo = new delCustomerNoPanel();
                this.remove(this.getContentPane());
                this.setContentPane(delNo);
                this.setVisible(true);
                delNo.delcustomernopanel();
            }
            if (actionEvent.getSource() == jMenuItem8) {
                delCustomerNnPanel delNn = new delCustomerNnPanel();
                this.remove(this.getContentPane());
                this.setContentPane(delNn);
                this.setVisible(true);
                delNn.delcustomernnpanel();
            }
        }
    }

