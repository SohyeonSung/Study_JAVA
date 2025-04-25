package Customers;


import java.sql.*; import java.util.ArrayList; import java.util.List;

import Util.DBUtil;

public class ReservationDAO {

// 예약 생성
public boolean createReservation(int reservationId, int customerId, int roomNumber, Date checkIn, Date checkOut) {
    String sql = "INSERT INTO RESERVATION (RESERVATIONID, CUSTOMERID, ROOMNUMBER, CHECKINDATE, CHECKOUTDATE) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, reservationId);
        pstmt.setInt(2, customerId);
        pstmt.setInt(3, roomNumber);
        pstmt.setDate(4, checkIn);
        pstmt.setDate(5, checkOut);

        int result = pstmt.executeUpdate();
        return result > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

// 예약 조회 (고객별)
public List<String> getReservationsByCustomer(int customerId) {
    List<String> reservations = new ArrayList<>();
    String sql = "SELECT * FROM RESERVATION WHERE CUSTOMERID = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, customerId);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String info = String.format("예약번호: %d, 방번호: %d, 체크인: %s, 체크아웃: %s",
                        rs.getInt("RESERVATIONID"),
                        rs.getInt("ROOMNUMBER"),
                        rs.getDate("CHECKINDATE"),
                        rs.getDate("CHECKOUTDATE"));
                reservations.add(info);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return reservations;
}

// 예약 수정
public boolean updateReservationDates(int reservationId, Date newCheckIn, Date newCheckOut) {
    String sql = "UPDATE RESERVATION SET CHECKINDATE = ?, CHECKOUTDATE = ? WHERE RESERVATIONID = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setDate(1, newCheckIn);
        pstmt.setDate(2, newCheckOut);
        pstmt.setInt(3, reservationId);
        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

// 예약 취소
public boolean cancelReservation(int reservationId) {
    String sql = "DELETE FROM RESERVATION WHERE RESERVATIONID = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, reservationId);
        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}