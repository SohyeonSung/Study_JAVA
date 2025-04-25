package Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation_DAO {

    // 데이터베이스 연결 정보
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "TEAM1";
    private static final String PASSWORD = "team1";

    // 예약 추가
    public boolean insertReservation(Reservation reservation) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO RESERVATION (RESERVATIONID, CUSTOMERID, ROOMNUMBER, CHECKINDATE, CHECKOUTDATE) "
                    + "VALUES (RESERVATION_SEQ.NEXTVAL, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, reservation.getCustomerId());
            pstmt.setInt(2, reservation.getRoomNumber());
            pstmt.setDate(3, new java.sql.Date(reservation.getCheckInDate().getTime()));
            pstmt.setDate(4, new java.sql.Date(reservation.getCheckOutDate().getTime()));

            int result = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 예약 ID로 예약 정보 조회
    public Reservation getReservationById(int reservationId) {
        Reservation reservation = null;
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM RESERVATION WHERE RESERVATIONID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, reservationId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int customerId = rs.getInt("CUSTOMERID");
                int roomNumber = rs.getInt("ROOMNUMBER");
                java.sql.Date checkInDate = rs.getDate("CHECKINDATE");
                java.sql.Date checkOutDate = rs.getDate("CHECKOUTDATE");

                reservation = new Reservation(reservationId, customerId, roomNumber, new java.util.Date(checkInDate.getTime()), new java.util.Date(checkOutDate.getTime()));
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    // 고객 ID로 해당 고객의 예약 조회
    public void getReservationsByCustomerId(int customerId) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM RESERVATION WHERE CUSTOMERID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int reservationId = rs.getInt("RESERVATIONID");
                int roomNumber = rs.getInt("ROOMNUMBER");
                java.sql.Date checkInDate = rs.getDate("CHECKINDATE");
                java.sql.Date checkOutDate = rs.getDate("CHECKOUTDATE");

                Reservation reservation = new Reservation(reservationId, customerId, roomNumber, new java.util.Date(checkInDate.getTime()), new java.util.Date(checkOutDate.getTime()));
                System.out.println(reservation);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 예약 취소
    public boolean cancelReservation(int reservationId) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "DELETE FROM RESERVATION WHERE RESERVATIONID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, reservationId);

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