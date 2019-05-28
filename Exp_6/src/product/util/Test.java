package product.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        Date current = new Date(System.currentTimeMillis());
        String sql = null;
        sql = "insert into product(name,price,date) values(?,?,?)";
//        Random r = new Random();


        try {
            Connection conn = DBUtil.getConnection();
            conn.createStatement();
            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setInt(1,1);
            statement.setString(1,"iphoneX");
            statement.setFloat(2,12);
            statement.setDate(3,new Date(System.currentTimeMillis()));
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
