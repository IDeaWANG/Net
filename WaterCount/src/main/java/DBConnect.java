import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection getConn() throws Exception{
        Class.forName("sun.jdbc.oracle.jdbcOdbcDriver");
        return DriverManager.getConnection("jdbc:odbc:StudentManger");

    }
}
