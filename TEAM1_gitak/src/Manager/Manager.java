package Manager;

import java.sql.Date;
import java.util.Scanner;

import Room.Room_DAO;

public class Manager {

	public void runManager() {
	    Scanner sc = new Scanner(System.in);
	    Manager_DAO managerDAO = new Manager_DAO(); // 관리자 (ManagerDAO) 객체
	    Room_DAO roomDAO = new Room_DAO();  // 객실 (ROOMDAO) 객체

	    System.out.print("	- 관리자 ID: ");
	    String managerId = sc.nextLine();
	    System.out.print("	- 비밀번호: ");
	    int password = Integer.parseInt(sc.nextLine());  // 비밀번호는 정수로 입력

	    if (managerDAO.login(managerId, password)) {
        	System.out.println("");
	        System.out.println("	✅ 로그인 성공 ✅ " + " 환영합니다 관리자님 " );
	        System.out.println("	──────────────────────────────────────");

	        while (true) {
	        	System.out.println("");
	        	System.out.println("");
	            System.out.println("	🌟 [관리자 메뉴] 🌟");
	            System.out.println("	━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	            System.out.println("	1. 🏨 전체 객실 상태 보기");
	            System.out.println("	2. 🛏️ 빈 객실만 보기");
	            System.out.println("	3. 🚪 사용 중인 객실 보기");
	            System.out.println("	4. 🔄 객실 상태 변경");
	            System.out.println(" 	5. 💰 일매출 조회");
	            System.out.println("	6. 💰 월매출 조회");
	            System.out.println("	7. 💰 기간별 매출 조회");
	            System.out.println("	8. 👤 전체 회원 목록 보기");
	            System.out.println("	9. 🔍 회원 이름으로 검색");
	            System.out.println("	0. 🚪 종료");
	            System.out.println("	━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	            System.out.print("	➡️  ");
	        


	            int menu = Integer.parseInt(sc.nextLine());

	            switch (menu) {
	                case 1: // 전체 객실
	                    roomDAO.getAllRooms();
	                    break;
	                case 2: // 빈 객실
	                    roomDAO.getAvailableRooms();
	                    break;
	                case 3: // 예약 된 객실
	                    roomDAO.getOccupiedRooms();
	                    break;
	                case 4: // 객실 상태 변경
	                       System.out.print("   🔄 변경할 객실 번호: ");
	                       int roomNum = Integer.parseInt(sc.nextLine());
	                       System.out.print("   🔄 새 상태 입력 (예: 빈 객실, 사용 중): ");
	                       String newStatus = sc.nextLine();
	                       roomDAO.updateRoomStatus(roomNum, newStatus);
	                       break;
	                case 5: // 일매출 조회
	                       System.out.print("   🔄 조회할 날짜 (yyyy-mm-dd): ");
	                       String dailyDate = sc.nextLine();
	                       Date date = Date.valueOf(dailyDate);  // 날짜 형식 변환
	                       int dailySales = Manager_DAO.getDailySales(date);
	                       System.out.println("   💰 일매출: " + dailySales + "원");
	                       break;
	                case 6: // 월매출 조회
	                       System.out.print("   🔄 조회할 월 (yyyy-mm): ");
	                       String month = sc.nextLine();
	                       int monthlySales = Manager_DAO.getMonthlySales(month);
	                       System.out.println("   💰 월매출: " + monthlySales + "원");
	                       break;
	                case 7: // 기간별 매출 조회
	                       System.out.print("   🔄 시작 날짜 (yyyy-mm-dd): ");
	                       String startDateStr = sc.nextLine();
	                       System.out.print("   🔄 종료 날짜 (yyyy-mm-dd): ");
	                       String endDateStr = sc.nextLine();
	                       Date startDate = Date.valueOf(startDateStr);
	                       Date endDate = Date.valueOf(endDateStr);
	                       int periodSales = Manager_DAO.getSalesBetweenDates2(startDate, endDate);
	                       System.out.println("   💰 기간별 매출: " + periodSales + "원");
	                       break;    
	                case 8: // 전체 회원 목록 조회
	                       managerDAO.getAllMembers();
	                       break;

	                case 9: // 회원 이름으로 검색
	                	   System.out.println("");
	                       System.out.print("	🔍 검색할 이름: ");
	                       String searchName = sc.nextLine();
	                       managerDAO.searchMemberByName(searchName);
	                       break;          
	                case 0: // 종료
	                       System.out.println("	👋 관리자 프로그램 종료");
	                       System.out.println("");
	                       return;
	                default:
	                       System.out.println("   ❗ 잘못된 입력입니다.");
	                       System.out.println("");
	               }
	           }
	       } else {
	           System.out.println("	❌ 로그인 실패. 관리자 정보를 확인하세요.");
               System.out.println("");
	       }
	   }
	}
