package product.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
    public static Connection getConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1401;database=ahpu","SA","1234qwer!");
    }


}

