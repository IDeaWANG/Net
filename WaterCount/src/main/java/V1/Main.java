package V1;
import java.awt.*;

 class Main {
     public static void main(String[] args) {
         LoginPassFrame loginPassFrame = new LoginPassFrame();
         loginPassFrame.loginpassFrame();
//         MainFrame mainFrame = new MainFrame();
//         Dimension screeneSize = Toolkit.getDefaultToolkit().getScreenSize();
//         Dimension frameSize = loginPassFrame.getSize();
//         if(frameSize.height>screeneSize.height)
//             frameSize.height = screeneSize.height;
//         if(frameSize.width>screeneSize.width);
//         frameSize.width = screeneSize.width;
//
//         mainFrame.setLocation(((screeneSize.width-(frameSize.width/2))/2),(screeneSize.height-frameSize.height)/2);//主界面的初始摆放位置；
//         loginPassFrame.setLocation(((screeneSize.width-(frameSize.width/2))/2),(screeneSize.height-frameSize.height)/2);//主界面的初始摆放位置；
         loginPassFrame.setLayout(null);
         loginPassFrame.setLocation(400,300);
         loginPassFrame.setVisible(true);
     }

}
