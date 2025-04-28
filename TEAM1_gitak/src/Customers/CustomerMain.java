package Customers;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import Room.Room_DAO;

public class CustomerMain {

    public void runCustomer() {
        Scanner sc = new Scanner(System.in);
        CustomerDAO customerDAO = new CustomerDAO();
	    Room_DAO roomDAO = new Room_DAO(); 

        System.out.print("	- 고객 ID: ");
        String custId = sc.nextLine();
        System.out.print("	- 비밀번호: ");
        String password = sc.nextLine();

        if (customerDAO.login(custId, password)) {
            System.out.println("	✅ 로그인 성공 ✅ ");

            while (true) {
            	System.out.println("");
	        	System.out.println("");
	            System.out.println("	🌟 [고객 메뉴] 🌟");
	            System.out.println("	━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("	1. 🏨 전체 객실 조회");
                System.out.println("	2. 📜 예약 조회");
                System.out.println("	3. 📝 예약 생성");
                System.out.println("	4. 🔧 예약 수정");
                System.out.println("	5. ❌ 예약 취소");
                System.out.println("	0. 🚪 종료");
                System.out.print("	선택 > ");
                int menu = Integer.parseInt(sc.nextLine());

                switch (menu) {
                
                	case 1: // ✅ 객실 조회
                		roomDAO.getAllRooms();
	                    break;
                    case 2: // ✅ 예약 조회
                        List<String> list = customerDAO.getReservationsByCustomer(custId);
                        if (list.isEmpty()) {
                            System.out.println("	❗ 예약 내역이 없습니다.");
                        } else {
                            list.forEach(System.out::println);
                        }
                        break;

                    case 3: // ✅ 예약 생성
                        System.out.print("	- 예약번호: ");
                        int newResId = Integer.parseInt(sc.nextLine());
                        System.out.print("	- 방 번호: ");
                        int roomNum = Integer.parseInt(sc.nextLine());
                        System.out.print("	- 체크인 날짜 (yyyy-mm-dd): ");
                        Date checkIn = Date.valueOf(sc.nextLine());
                        System.out.print("	- 체크아웃 날짜 (yyyy-mm-dd): ");
                        Date checkOut = Date.valueOf(sc.nextLine());

                        boolean success = customerDAO.createReservation(newResId, custId, roomNum, checkIn, checkOut);
                        System.out.println(success ? "	✅ 예약 성공 ✅ " : "		❌ 예약 실패 ❌ ");

                        // 📌 최신 예약 조회
                        if (success) {
                        	System.out.println("");
                            System.out.println("	📋 최신 예약 내역 📋 ");
                            customerDAO.getReservationsByCustomer(custId).forEach(System.out::println);
                        }
                        break;

                    case 4: // ✏️ 예약 수정
                        System.out.print("	- 수정할 예약번호: ");
                        int updateResId = Integer.parseInt(sc.nextLine());
                        System.out.print("	- 새 체크인 날짜: ");
                        Date newIn = Date.valueOf(sc.nextLine());
                        System.out.print("	- 새 체크아웃 날짜: ");
                        Date newOut = Date.valueOf(sc.nextLine());

                        boolean updated = customerDAO.updateReservationDates(updateResId, newIn, newOut);
                        System.out.println(updated ? "	✅ 수정 완료" : "	❌ 수정 실패");

                        // 📌 최신 예약 조회
                        if (updated) {
                        	System.out.println("");
                            System.out.println("	📋 최신 예약 내역 📋 ");
                            customerDAO.getReservationsByCustomer(custId).forEach(System.out::println);
                        }
                        break;

                    case 5: // 🗑️ 예약 취소
                        System.out.print("	- 취소할 예약번호: ");
                        int delId = Integer.parseInt(sc.nextLine());
                        boolean deleted = customerDAO.cancelReservation(delId);
                        System.out.println(deleted ? "	🗑️ 예약 취소 완료" : "	❌ 취소 실패");

                        // 📌 최신 예약 조회
                        if (deleted) {
                        	System.out.println("");
                            System.out.println("	📋 최신 예약 내역 📋 ");
                            customerDAO.getReservationsByCustomer(custId).forEach(System.out::println);
                        }
                        break;

                    case 0:
                        System.out.println("	👋 고객 서비스를 종료합니다.");
                    	System.out.println("");
                        System.out.println("	──────────────────────────────────────");
                        return;
                }
            }
        } else {
            System.out.println("	❌ 로그인 실패");
        }
    }
}

