package Room;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.DBUtil;

public class Room_DAO {
    private static final String URL = "jdbc:oracle:thin:@192.168.18.10:1521:xe";
    private static final String USER = "TEAM1";
    private static final String PASSWORD = "team1";

    // 1. 전체 객실 목록 조회
    public void getAllRooms() {
    	String sql = "SELECT r.ROOMNUMBER, r.ROOMTYPE, r.ROOMSTATUS, rt.price " +
                "FROM ROOM r " +
                "JOIN room_types rt ON r.ROOMTYPE = rt.ROOMTYPE"; // 객실 정보, 가격 조회
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
        	
        	System.out.println("");
            System.out.println("	────────────────");
            System.out.println("	🏨 전체 객실 정보 🏨");
            System.out.println("	────────────────");
            Date currentDate = new Date(System.currentTimeMillis()); // 현재 날짜

            while (rs.next()) {
                int roomNumber = rs.getInt("roomNumber");
                String roomType = rs.getString("roomType");
                String roomStatus = rs.getString("roomStatus");
                int price = rs.getInt("price");

                // 현재 객실의 예약 상태를 체크하여, 상태를 최신화
                if ("빈 객실".equals(roomStatus)) {
                    // 예약된 체크인 날짜가 지난 경우, 객실 상태를 "사용 중"으로 변경
                    String checkInQuery = "SELECT CHECKINDATE FROM RESERVATION WHERE ROOMNUMBER = ? AND CHECKINDATE <= ?";
                    try (PreparedStatement checkInStmt = conn.prepareStatement(checkInQuery)) {
                        checkInStmt.setInt(1, roomNumber);
                        checkInStmt.setDate(2, currentDate);  // 현재 날짜와 비교
                        ResultSet checkInRs = checkInStmt.executeQuery();
                        
                        if (checkInRs.next()) {
                            roomStatus = "사용 중"; // 체크인 날짜가 지나면 "사용 중"
                        }
                        checkInRs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

             // 상태 업데이트
                System.out.println("	────────────────────────────────────────────────────────────────");
                System.out.print("	객실 번호: " + roomNumber + " | ");
                System.out.print("	타입: " + roomType + " | ");
                System.out.print("	상태: " + roomStatus + " | ");
                System.out.print("	💰 가격: " + String.format("%,d", price) + "원");
                System.out.println();
                System.out.println("	────────────────────────────────────────────────────────────────");



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    // 2. 빈 객실 목록 조회
    public void getAvailableRooms() {
        String sql =  "SELECT r.ROOMNUMBER, r.ROOMTYPE, r.ROOMSTATUS, t.PRICE " +
        			  "FROM ROOM r JOIN ROOM_TYPES t ON r.ROOMTYPE = t.ROOMTYPE " +
                      "WHERE r.ROOMSTATUS = '빈 객실'";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

        	System.out.println("");
            System.out.println("	────────────────");
            System.out.println("	🛏️ 빈 객실 정보 🏨");
            System.out.println("	────────────────");
            boolean isEmpty = true;

            while (rs.next()) {
                int roomNumber = rs.getInt("roomNumber");
                String roomType = rs.getString("roomType");
                String roomStatus = rs.getString("roomStatus");
                int price = rs.getInt("price");

                System.out.println("	────────────────────────────────────────────────────────────────");
                System.out.print("	객실 번호: " + roomNumber + " | ");
                System.out.print("	타입: " + roomType + " | ");
                System.out.print("	상태: " + roomStatus + " | ");
                System.out.print("	💰 가격: " + price + "원");
                System.out.println();
                System.out.println("	────────────────────────────────────────────────────────────────");
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("	⚠️ 현재 빈 객실이 없습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. 예약된 객실 목록 조회
    public void getAllReservations() {
        // RESERVATION 테이블과 CUSTOMERS 테이블을 조인하여 예약 정보를 가져옴
        String sql = "SELECT r.RESERVATIONID, r.CUSTID, c.CUSTOMERNAME, r.ROOMNUMBER, r.CHECKINDATE, r.CHECKOUTDATE, r.TOTALPRICE " +
                     "FROM RESERVATION r " +
                     "JOIN CUSTOMERS c ON r.CUSTID = c.CUSTID " +
                     "ORDER BY r.CHECKINDATE";  // 예약 날짜로 정렬

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

        	System.out.println();
        	System.out.println("");
        	System.out.println("	🌟 예약 상세 정보 🌟");
        	System.out.println("	════════════════════════════════════════════════════════════════════════════════");


        	boolean isEmpty = true;
        	while (rs.next()) {
        	    int reservationId = rs.getInt("RESERVATIONID");
        	    String custId = rs.getString("CUSTID");
        	    String customerName = rs.getString("CUSTOMERNAME");  // 고객 이름
        	    int roomNumber = rs.getInt("ROOMNUMBER");
        	    Date checkIn = rs.getDate("CHECKINDATE");
        	    Date checkOut = rs.getDate("CHECKOUTDATE");
        	    int totalPrice = rs.getInt("TOTALPRICE");

        	    // 예약 정보 출력
        	    System.out.printf("	📌 예약번호   : %-10d    👤 고객 ID : %-10s (%s)\n", reservationId, custId, customerName);
        	    System.out.printf("	🏨 객실 번호 : %-10d     🗓️ 체크인  : %s\n", roomNumber, checkIn.toString());
        	    System.out.printf("	🛏️ 체크아웃  : %-15s 💰 총 금액   : %,d원\n", checkOut.toString(), totalPrice);

        	    System.out.println("	════════════════════════════════════════════════════════════════════════════════");

        	    isEmpty = false;
        	}

        	if (isEmpty) {
        	    System.out.println("   😔 예약 정보가 없습니다.");
        	}


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("   ⚠️ SQL 오류 발생! : " + e.getMessage());
        }
    }

    // 4. 객실 상태 변경
    public boolean updateRoomStatus(int roomNumber, String newStatus) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "UPDATE ROOM SET ROOMSTATUS = ? WHERE ROOMNUMBER = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, roomNumber);

            int result = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}