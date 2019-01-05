package V1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection getConn() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1401;database=Sql_01","SA","1234qwer!");

    }
}
