package Manager;

import java.util.Scanner;

import Room.Room_DAO;

public class Manager_Main {

	public void runManager() {
	    Scanner sc = new Scanner(System.in);
	    ManagerDAO managerDAO = new ManagerDAO();
	    Room_DAO roomDAO = new Room_DAO();  // 객체 생성 확인

	    System.out.print("	- 관리자 ID: ");
	    String managerId = sc.nextLine();
	    System.out.print("	- 비밀번호: ");
	    int password = Integer.parseInt(sc.nextLine());  // 수정된 부분

	    if (managerDAO.login(managerId, password)) {
        	System.out.println("");
	        System.out.println("	✅ 로그인 성공 ✅ ");
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
	            System.out.println("	0. 🚪 종료");
	            System.out.println("	━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	            System.out.print("	>> 메뉴를 선택하세요 : ");
	        


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
	                	System.out.println("");
	                    System.out.print("	🔄 변경할 객실 번호: ");
	                    int roomNum = Integer.parseInt(sc.nextLine());
	                    System.out.print("	🔄 새 상태 입력 (예: 빈 객실, 사용 중): ");
	                    String newStatus = sc.nextLine();
	                    roomDAO.updateRoomStatus(roomNum, newStatus);
	                    break;
	                case 0:
	                    System.out.println("	👋 관리자 프로그램 종료");
	    	        	System.out.println("");
	    	        	System.out.println("");
	                    return;
	                default:
	                    System.out.println("	❗ 잘못된 입력입니다.");
	    	        	System.out.println("");
	    	        	System.out.println("");
	            }
	        }

	    } else {
	        System.out.println("	❌ 로그인 실패. 관리자 정보를 확인하세요.");
        	System.out.println("");
        	System.out.println("");
	    }
	}
}
