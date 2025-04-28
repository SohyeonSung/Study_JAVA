package Customers;

import java.util.Scanner;

public class Customers_Signup {
    public void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("	📝 회원가입을 시작합니다.");

        // id 입력
        System.out.print("	- ID 입력: ");
        String custId = sc.nextLine();

        // 비밀번호 입력
        System.out.print("	- 비밀번호 입력 (숫자): ");
        String password = sc.nextLine();

        // 이름 입력
        System.out.print("	- 이름 입력: ");
        String customerName = sc.nextLine();

        // 중복 ID 체크
        Customer_DAO dao = new Customer_DAO();
        boolean idExists = dao.checkCustomerIdExists(custId);
        if (idExists) {
            System.out.println("	❌ 이미 존재하는 ID입니다. ❌	");
            return;
        }

        // 고객 정보를 저장할 customer 객체 생성
        Customers_DTO customer = new Customers_DTO();
        customer.setCustId(custId); // 고객 id 설정
        customer.setPassword(Integer.parseInt(password)); // 고객 비밀번호 설정 (숫자로 변환하여 설정)
        customer.setCustomerName(customerName); // 고객 이름 설정

        // 회원가입을 위해 DAO 메소드 호출
        boolean result = dao.signup(customer);

        if (result) {
            System.out.println("	✅ 회원가입이 완료되었습니다!	✅");
            System.out.println("");
        } else {
            System.out.println("	❌ 회원가입 실패! ❌");
            System.out.println("");
        }
    }
}
