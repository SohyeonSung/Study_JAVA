import java.util.Scanner;
import Customers.Customers;
import Customers.Customers_Login;
import Customers.Customers_Signup;

public class Hotel_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("🏨 WELCOME 🏨");

        while (isRunning) {
            System.out.println("\n======= MENU =======");
            System.out.println("1. 관리자");
            System.out.println("2. 고객");
            System.out.println("3. 회원가입");
            System.out.println("0. 종료");
            System.out.print(">> MENU : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n[관리자 모드]");
                    // Manager manager = new Manager();
                    // manager.login();  // 구현 필요
                    // 로그인 성공 시 관리자 메뉴 실행
                    break;
                case 2:
                    System.out.println("\n[고객]");
                    Customers_Login login = new Customers_Login();
                    login.login();
                    break;
                    
                case 3:
                	System.out.println("\n[회원가입]");
                	Customers_Signup signup = new Customers_Signup();
                	signup.signup();
                	break;
                	
                case 0:
                    System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다!");
                    isRunning = false;
                    break;
                default:
                	System.out.println();
                    System.out.println("⚠️ 올바른 번호를 선택해주세요 ⚠️");
            }
        }

        scanner.close();
    }
}
