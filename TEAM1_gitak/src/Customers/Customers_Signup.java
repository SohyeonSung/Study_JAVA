package Customers;

import java.util.Scanner;

public class Customers_Signup {
    public void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("	📝 회원가입을 시작합니다.");

        System.out.print("	- ID 입력: ");
        String custId = sc.nextLine();

        System.out.print("	- 비밀번호 입력 (숫자): ");
        String password = sc.nextLine();  // 비밀번호를 String으로 받아도 될 경우

        System.out.print("	- 이름 입력: ");
        String customerName = sc.nextLine();

        // 중복 ID 체크
        CustomerDAO dao = new CustomerDAO();
        boolean idExists = dao.checkCustomerIdExists(custId);
        if (idExists) {
            System.out.println("	❌ 이미 존재하는 ID입니다. ❌	");
            return;
        }

        Customers customer = new Customers();
        customer.setCustId(custId);
        customer.setPassword(Integer.parseInt(password));  // 비밀번호는 숫자일 경우
        customer.setCustomerName(customerName);

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
