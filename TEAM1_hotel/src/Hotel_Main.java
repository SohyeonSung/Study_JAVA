import java.util.Scanner;
import Customers.CustomerMain;
import Customers.Customers_Signup;
import Manager.Manager_Main;

public class Hotel_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n======= MENU =======");
            System.out.println("1. 관리자");
            System.out.println("2. 고객");
            System.out.println("3. 회원가입");
            System.out.println("0. 종료");
            System.out.print(">> MENU : ");

            try {
            	int choice = Integer.parseInt(scanner.nextLine()); 

                switch (choice) {
                    case 1:
                        System.out.println("\n[관리자 모드]");
                        Manager_Main manager = new Manager_Main();
                        manager.runManager(); // 관리자 기능 실행
                        break;

                    case 2:
                        System.out.println("\n[고객]");
                        CustomerMain main = new CustomerMain();
                        main.runCustomer();
                        break;

                    case 3:
                        System.out.println("\n[회원가입]");
                        Customers_Signup signup = new Customers_Signup();
                        signup.signup(); // 회원가입 실행
                        break;

                    case 0:
                        System.out.println("👋 프로그램을 종료합니다. 이용해주셔서 감사합니다!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("⚠️ 올바른 번호를 선택해주세요 ⚠️");
                }
            } catch (NumberFormatException e) {
                System.out.println("❗ 숫자만 입력해주세요.");
            }
        }

        scanner.close();
    }
}