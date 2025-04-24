package Customers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Customers_Login {
    public boolean login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID 입력: ");
        String username = sc.nextLine();

        System.out.print("비밀번호 입력: ");
        String password = sc.nextLine();

        boolean loginSuccess = false;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "TEAM1", "team1");

            String sql = "SELECT * FROM CUSTOMERS WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("✅ 로그인 성공! 환영합니다, " + rs.getString("customerName") + "님.");
                loginSuccess = true;
            } else {
                System.out.println("❌ 로그인 실패! 아이디 또는 비밀번호를 확인해주세요.");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loginSuccess;
    }
}
