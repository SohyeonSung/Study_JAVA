package Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@192.168.18.10:1521:xe"; // DB 주소
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
            conn.setAutoCommit(false); // 🔥 트랜잭션 시작 (꼭 해줘야 둘 다 성공/실패 같이 관리됨)

            // 1. 예약 중복 체크
            String checkAvailabilityQuery = "SELECT COUNT(*) FROM RESERVATION WHERE ROOMNUMBER = ? "
                + "AND (CHECKINDATE BETWEEN ? AND ? OR CHECKOUTDATE BETWEEN ? AND ?)";
            pstmt = conn.prepareStatement(checkAvailabilityQuery);
            pstmt.setInt(1, roomNumber);
            pstmt.setDate(2, checkIn);
            pstmt.setDate(3, checkOut);
            pstmt.setDate(4, checkIn);
            pstmt.setDate(5, checkOut);
            rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("❌ 해당 객실은 이미 예약되어 있습니다.");
                conn.rollback(); // 🔥 rollback 해줘야 해
                return false;
            }

            // 2. 예약 생성
            String insertReservationQuery = "INSERT INTO RESERVATION (RESERVATIONID, CUSTID, ROOMNUMBER, CHECKINDATE, CHECKOUTDATE) "
                + "VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertReservationQuery);
            pstmt.setInt(1, reservationId);
            pstmt.setString(2, custId);
            pstmt.setInt(3, roomNumber);
            pstmt.setDate(4, checkIn);
            pstmt.setDate(5, checkOut);

            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                // 3. 방 상태 업데이트
                String updateRoomStatusQuery = "UPDATE ROOM SET ROOMSTATUS = '사용 중' WHERE ROOMNUMBER = ?";
                pstmt = conn.prepareStatement(updateRoomStatusQuery);
                pstmt.setInt(1, roomNumber);
                int updateResult = pstmt.executeUpdate();

                if (updateResult > 0) {
                    success = true;
                    conn.commit(); // 🔥 둘 다 성공했으면 커밋
                    System.out.println("✅ 예약 완료 및 방 상태 '사용 중' 업데이트 완료");
                } else {
                    conn.rollback(); // 예약 성공했는데 방 상태 업데이트 실패하면 rollback
                    System.out.println("❌ 방 상태 업데이트 실패로 예약 취소됨");
                }
            } else {
                conn.rollback(); // 예약 insert 실패
            }
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
        String sql = "INSERT INTO CUSTOMERS (CUSTID, PASSWORD, CUSTOMERNAME) VALUES (?, ?, ?)";
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

