package Customers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import Customers.Customers_DAO;

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
        
        
        
     // DTO 객체 생성
        Customers customers = new Customers();
        customers.setUsername(username);
        customers.setPassword(password);
        customers.setCustomerName(name);

        // DAO 호출
        Customers_DAO dao = new Customers_DAO();
        boolean result = dao.insertCustomer(customers);

        if (result) {
            System.out.println("✅ 회원가입이 완료되었습니다!");
        } else {
            System.out.println("❌ 회원가입 실패!");
        }
    }
}