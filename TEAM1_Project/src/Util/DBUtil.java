package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "TEAM1";  // 본인 계정명
    private static final String PASSWORD = "team1";  // 본인 비밀번호

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println(">> Oracle JDBC 드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
//            System.out.println("⚠️ 드라이버 로딩 실패");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
