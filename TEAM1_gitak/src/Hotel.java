import java.util.Scanner;
import Customers.Customers;
import Customers.Customers_Signup;
import Manager.Manager;

public class Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true; // 프로그램이 실행 중인지 여부를 나타내는 변수 초기화
        
        
        System.out.println(" ______    ____       ______                               _     \r\n"
    			+ "/\\__  _\\  /\\  _`\\    /\\  _  \\     /'\\_/`\\                /' \\    \r\n"
    			+ "\\/_/\\ \\/  \\ \\ \\L\\_\\  \\ \\ \\L\\ \\   /\\      \\              /\\_, \\   \r\n"
    			+ "   \\ \\ \\   \\ \\  _\\L   \\ \\  __ \\  \\ \\ \\__\\ \\             \\/_/\\ \\  \r\n"
    			+ "    \\ \\ \\   \\ \\ \\L\\ \\  \\ \\ \\/\\ \\  \\ \\ \\_/\\ \\               \\ \\ \\ \r\n"
    			+ "     \\ \\_\\   \\ \\____/   \\ \\_\\ \\_\\  \\ \\_\\\\ \\_\\               \\ \\_\\\r\n"
    			+ "      \\/_/    \\/___/     \\/_/\\/_/   \\/_/ \\/_/                \\/_/\r\n"
    			+ "                                                                 \r\n"
    			+ "                                                                 \r\n"
    			+ "");

        while (isRunning) {  // 프로그램이 실행되는 동안 반복하는 루프
      
            System.out.println("	😊 Welcome to Team 1 Hotel 😊");
            System.out.println("	━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("	1. 🛡️ 호텔 관리자");
            System.out.println("	2. 🧑‍💼 고객");
            System.out.println("	3. ✍️ 회원가입");
            System.out.println("	4. ⛔ 탈퇴 ");
            System.out.println("	0. 🚪 종료");
            System.out.println("	━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.print("	➡️  메뉴를 선택하세요 : ");

            try {
            	int choice = Integer.parseInt(scanner.nextLine());  // 사용자로부터 입력을 받아 정수로 변환

                switch (choice) {
                    case 1:
                        System.out.println("");
                        System.out.println("	──────────────────────────────────────");
                        System.out.println("	🛡️ 호텔 관리자 🛡️  ");
                        Manager manager = new Manager();
                        manager.runManager(); // 관리자 기능 실행
                        break;

                    case 2:
                    	System.out.println("");
                        System.out.println("	──────────────────────────────────────");
                        System.out.println("	🧑‍💼 고객 🧑‍💼 ");
                        Customers main = new Customers();
                        main.runCustomer();
                        break;

                    case 3:
                    	System.out.println("");
                        System.out.println("	──────────────────────────────────────");
                        System.out.println("	✍️ 회원가입 ✍️");
                        Customers_Signup signup = new Customers_Signup();
                        signup.signup(); 
                        break;     
                        
                    case 4:
                        System.out.println("");
                        System.out.println("	──────────────────────────────────────");
                        System.out.println("	⛔ 회원 탈퇴 ⛔");
                        Customers_Signup delete = new Customers_Signup();
                        delete.deleteAccount();  // 탈퇴 기능 실행
                        break;

                    case 0:
                    	System.out.println("");
                        System.out.println("	──────────────────────────────────────");
                        System.out.println("	👋 프로그램을 종료합니다. 이용해주셔서 감사합니다!");
                        isRunning = false;
                        break;

                    default: // 잘못된 입력이 들어왔을 때
                        System.out.println("	⚠️ 올바른 번호를 선택해주세요 ⚠️");
                }
            } catch (NumberFormatException e) { // 입력이 숫자가 아닐 경우 예외 처리
                System.out.println("	❗ 숫자만 입력해주세요.");
            }
        }

        scanner.close();
    }
}