package Customers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Customers_Signup {
    public void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원가입을 시작합니다.");

        System.out.print("ID 입력: ");
        String username = sc.nextLine();

        System.out.print("비밀번호 입력: ");
        String password = sc.nextLine();

        System.out.print("이름 입력: ");
        String name = sc.nextLine();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "TEAM1", "team1");

            String sql = "INSERT INTO CUSTOMERS (customerId, username, password, customerName) VALUES (CUSTOMERS_SEQ.NEXTVAL, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, name);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("✅ 회원가입이 완료되었습니다!");
            } else {
                System.out.println("❌ 회원가입 실패!");
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
