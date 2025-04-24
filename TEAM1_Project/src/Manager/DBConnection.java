
package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static final String URL = "jdbc:oracle:thin:@192.168.18.10:1521:xe";
    private static final String USER = "TEAM1";
    private static final String PASSWORD = "team1";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}