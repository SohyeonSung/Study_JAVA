package Room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.DBUtil;

public class Room_DAO {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "TEAM1";
    private static final String PASSWORD = "team1";

    // 전체 객실 목록 조회
    public void getAllRooms() {
        String sql = "SELECT * FROM ROOM";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n[전체 객실 목록]");
            while (rs.next()) {
                int roomNumber = rs.getInt("roomNumber");
                String roomType = rs.getString("roomType");
                String roomStatus = rs.getString("roomStatus");

                System.out.println("객실 번호: " + roomNumber +
                                   ", 타입: " + roomType +
                                   ", 상태: " + roomStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 빈 객실 목록 조회
    public void getAvailableRooms() {
        String sql = "SELECT * FROM ROOM WHERE roomStatus = '빈방'";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n[빈 객실 목록]");
            boolean isEmpty = true;

            while (rs.next()) {
                int roomNumber = rs.getInt("roomNumber");
                String roomType = rs.getString("roomType");
                String roomStatus = rs.getString("roomStatus");

                System.out.println("객실 번호: " + roomNumber +
                                   ", 타입: " + roomType +
                                   ", 상태: " + roomStatus);
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
        String sql = "SELECT * FROM ROOM WHERE roomStatus = '예약중'";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n[예약된 객실 목록]");
            boolean isEmpty = true;

            while (rs.next()) {
                int roomNumber = rs.getInt("roomNumber");
                String roomType = rs.getString("roomType");
                String roomStatus = rs.getString("roomStatus");

                System.out.println("객실 번호: " + roomNumber +
                                   ", 타입: " + roomType +
                                   ", 상태: " + roomStatus);
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