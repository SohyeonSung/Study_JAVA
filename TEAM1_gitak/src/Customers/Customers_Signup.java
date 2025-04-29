package Customers;

import java.util.Scanner;

// 고객 회원가입, 회원탈퇴
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
        Customers_DAO dao = new Customers_DAO();
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
    
    	// 회원 탈퇴 메서드 추가
    public void deleteAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("	🗑 회원 탈퇴를 진행합니다.");
        System.out.println("	🗑 탈퇴 진행 시 예약 정보가 사라집니다");
        System.out.print("	- ID 입력: ");
        String custId = sc.nextLine();
        System.out.print("	- 비밀번호 입력 (숫자): ");
        int password = sc.nextInt();
        System.out.println("");

        Customers_DAO dao = new Customers_DAO();
        boolean success = dao.deleteCustomer(custId, password);

        if (success) {
            System.out.println("	✅ 회원 탈퇴가 완료되었습니다.");
            System.out.println("");
        } else {
            System.out.println("	❌ ID 또는 비밀번호가 일치하지 않습니다.");
            System.out.println("");
        }
    }
}
