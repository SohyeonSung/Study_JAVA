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

    // 전체 객실 목록 조회
    public void getAllRooms() {
    	String sql = "SELECT r.ROOMNUMBER, r.ROOMTYPE, r.ROOMSTATUS, rt.price " +
                "FROM ROOM r " +
                "JOIN room_types rt ON r.ROOMTYPE = rt.ROOMTYPE";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n[전체 객실 목록]");
            Date currentDate = new Date(System.currentTimeMillis()); // 현재 날짜 가져오기

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
                System.out.println("객실 번호: " + roomNumber +
                                   ", 타입: " + roomType +
                                   ", 상태: " + roomStatus +
                                   ", 가격: " + price + "원");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    // 빈 객실 목록 조회
    public void getAvailableRooms() {
        String sql =  "SELECT r.ROOMNUMBER, r.ROOMTYPE, r.ROOMSTATUS, t.PRICE " +
        			  "FROM ROOM r JOIN ROOM_TYPES t ON r.ROOMTYPE = t.ROOMTYPE " +
                      "WHERE r.ROOMSTATUS = '빈 객실'";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n[빈 객실 목록]");
            boolean isEmpty = true;

            while (rs.next()) {
                int roomNumber = rs.getInt("roomNumber");
                String roomType = rs.getString("roomType");
                String roomStatus = rs.getString("roomStatus");
                int price = rs.getInt("price");

                System.out.println("객실 번호: " + roomNumber +
                                   ", 타입: " + roomType +
                                   ", 상태: " + roomStatus +
                                   ", 가격: " + price + "원");
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("⚠️ 현재 빈 객실이 없습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 예약된 객실 목록 조회
    public void getOccupiedRooms() {
        String sql = "SELECT r.ROOMNUMBER, r.ROOMTYPE, r.ROOMSTATUS, t.PRICE " +
        			 "FROM ROOM r JOIN ROOM_TYPES t ON r.ROOMTYPE = t.ROOMTYPE " +
        			 "WHERE r.ROOMSTATUS = '사용 중'";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n[예약된 객실 목록]");
            boolean isEmpty = true;

            while (rs.next()) {
                int roomNumber = rs.getInt("roomNumber");
                String roomType = rs.getString("roomType");
                String roomStatus = rs.getString("roomStatus");
                int price = rs.getInt("price");

                System.out.println("객실 번호: " + roomNumber +
                                   ", 타입: " + roomType +
                                   ", 상태: " + roomStatus +
                                   ", 가격: " + price + "원");
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("⚠️ 현재 예약된 객실이 없습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 객실 상태 변경
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