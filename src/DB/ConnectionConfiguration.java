package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration
{
    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/Bibliotek?serverTimezone=CET&useSSL=false";
        String user = "root";
        String password = "sortebulk";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}