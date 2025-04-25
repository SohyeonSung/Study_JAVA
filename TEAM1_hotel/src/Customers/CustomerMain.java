package Customers;

import java.sql.Date; import java.util.List; import java.util.Scanner;

public class CustomerMain {

public  void runCustomer() {
    Scanner sc = new Scanner(System.in);
    CustomerDAO customerDAO = new CustomerDAO();
    ReservationDAO reservationDAO = new ReservationDAO();

    System.out.println("💁‍ 고객 로그인");
    System.out.print("고객 ID: ");
    int customerId = Integer.parseInt(sc.nextLine());
    System.out.print("비밀번호: ");
    String password = sc.nextLine();
    
    

    if (customerDAO.login(customerId, password)) {
        System.out.println("✅ 로그인 성공!\n");

        while (true) {
            System.out.println("\n===== 고객 예약 메뉴 =====");
            System.out.println("1. 예약 조회");
            System.out.println("2. 예약 생성");
            System.out.println("3. 예약 수정");
            System.out.println("4. 예약 취소");
            System.out.println("0. 종료");
            System.out.print("선택 > ");
            int menu = Integer.parseInt(sc.nextLine());

            switch (menu) {
                case 1:
                    List<String> list = reservationDAO.getReservationsByCustomer(customerId);
                    if (list.isEmpty()) {
                        System.out.println("❗ 예약 내역이 없습니다.");
                    } else {
                        list.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("예약번호: ");
                    int newResId = Integer.parseInt(sc.nextLine());
                    System.out.print("방 번호: ");
                    int roomNum = Integer.parseInt(sc.nextLine());
                    System.out.print("체크인 날짜 (yyyy-mm-dd): ");
                    Date checkIn = Date.valueOf(sc.nextLine());
                    System.out.print("체크아웃 날짜 (yyyy-mm-dd): ");
                    Date checkOut = Date.valueOf(sc.nextLine());

                    boolean success = reservationDAO.createReservation(newResId, customerId, roomNum, checkIn, checkOut);
                    System.out.println(success ? "✅ 예약 성공" : "❌ 예약 실패");
                    break;

                case 3:
                    System.out.print("수정할 예약번호: ");
                    int updateResId = Integer.parseInt(sc.nextLine());
                    System.out.print("새 체크인 날짜: ");
                    Date newIn = Date.valueOf(sc.nextLine());
                    System.out.print("새 체크아웃 날짜: ");
                    Date newOut = Date.valueOf(sc.nextLine());

                    boolean updated = reservationDAO.updateReservationDates(updateResId, newIn, newOut);
                    System.out.println(updated ? "✅ 수정 완료" : "❌ 수정 실패");
                    break;

                case 4:
                    System.out.print("취소할 예약번호: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    boolean deleted = reservationDAO.cancelReservation(delId);
                    System.out.println(deleted ? "🗑️ 예약 취소 완료" : "❌ 취소 실패");
                    break;

                case 0:
                    System.out.println("👋 종료합니다.");
                    return;

                default:
                    System.out.println("❗ 올바른 메뉴 번호를 입력하세요.");
            }
        }

    } else {
        System.out.println("❌ 로그인 실패: 고객 ID 또는 비밀번호를 확인하세요.");
    }

    sc.close();
}
}