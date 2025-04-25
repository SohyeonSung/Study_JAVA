package Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB 주소
        String user = "TEAM1"; // DB 사용자명
        String password = "team1"; // DB 비밀번호
        return DriverManager.getConnection(url, user, password);
    }

    private void closeResources(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    // 고객 로그인
    public boolean login(String custId, String password) {
        String sql = "SELECT * FROM CUSTOMERS WHERE CUSTID = ? AND PASSWORD = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, custId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 예약 생성
    public boolean createReservation(int reservationId, String custId, int roomNumber, Date checkIn, Date checkOut) {
        boolean success = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            
            // 예약 중복 체크
            String checkAvailabilityQuery = "SELECT COUNT(*) FROM RESERVATION WHERE ROOMNUMBER = ? "
                + "AND (CHECKINDATE BETWEEN ? AND ? OR CHECKOUTDATE BETWEEN ? AND ?)";
            pstmt = conn.prepareStatement(checkAvailabilityQuery);
            
            // 매개변수 바인딩 순서에 맞게 설정
            pstmt.setInt(1, roomNumber); // ROOMNUMBER
            pstmt.setDate(2, checkIn);    // CHECKINDATE의 시작
            pstmt.setDate(3, checkOut);   // CHECKOUTDATE의 끝
            pstmt.setDate(4, checkIn);    // CHECKINDATE의 시작
            pstmt.setDate(5, checkOut);   // CHECKOUTDATE의 끝
            
            rs = pstmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("❌ 해당 객실은 이미 예약되어 있습니다.");
                return false; // 예약 중복 시 false 반환
            }

            // 예약 생성
            String insertReservationQuery = "INSERT INTO RESERVATION (RESERVATIONID, CUSTID, ROOMNUMBER, CHECKINDATE, CHECKOUTDATE) "
                + "VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertReservationQuery);
            pstmt.setInt(1, reservationId); // RESERVATIONID
            pstmt.setString(2, custId);     // CUSTID
            pstmt.setInt(3, roomNumber);    // ROOMNUMBER
            pstmt.setDate(4, checkIn);      // CHECKINDATE
            pstmt.setDate(5, checkOut);     // CHECKOUTDATE

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, pstmt, conn);
        }

        return success;
    }


    // 고객 예약 조회
    public List<String> getReservationsByCustomer(String custId) {
        List<String> reservations = new ArrayList<>();
        String sql = "SELECT * FROM RESERVATION WHERE CUSTID = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, custId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int reservationId = rs.getInt("RESERVATIONID");
                int roomNumber = rs.getInt("ROOMNUMBER");
                Date checkInDate = rs.getDate("CHECKINDATE");
                Date checkOutDate = rs.getDate("CHECKOUTDATE");
                reservations.add("예약번호: " + reservationId + ", 방 번호: " + roomNumber + ", 체크인: " + checkInDate + ", 체크아웃: " + checkOutDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    // 예약 수정
    public boolean updateReservationDates(int reservationId, Date newCheckIn, Date newCheckOut) {
        String sql = "UPDATE RESERVATION SET CHECKINDATE = ?, CHECKOUTDATE = ? WHERE RESERVATIONID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, newCheckIn);
            stmt.setDate(2, newCheckOut);
            stmt.setInt(3, reservationId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 예약 취소
    public boolean cancelReservation(int reservationId) {
        String sql = "DELETE FROM RESERVATION WHERE RESERVATIONID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservationId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 회원가입
    public boolean signup(Customers customer) {
        String sql = "INSERT INTO CUSTOMER (CUSTID, PASSWORD, CUSTOMERNAME) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getCustId());
            stmt.setInt(2, customer.getPassword());
            stmt.setString(3, customer.getCustomerName());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkCustomerIdExists(String custId) {
        String sql = "SELECT COUNT(*) FROM CUSTOMERS WHERE CUSTID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, custId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;  // 0보다 큰 값이면 이미 존재하는 ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

