package Customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import Util.DBUtil;

public class ReservationDAO {

    // 예약 생성
    public void createReservation(ReservationDTO reservation) {
        String sql = "INSERT INTO RESERVATION (CUSTOMER_ID, ROOMNUMBER, CHECKINDATE, CHECKOUTDATE) VALUES (?, ?, ?, ?)";

        String updateRoomSql = "UPDATE ROOM SET ROOMSTATUS = '사용 중' WHERE ROOMNUMBER = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             PreparedStatement pstmtUpdateRoom = conn.prepareStatement(updateRoomSql)) {

            pstmt.setInt(1, reservation.getCustomerId());  // 고객 ID
            pstmt.setInt(2, reservation.getRoomNumber());
            pstmt.setDate(3, reservation.getCheckInDate());
            pstmt.setDate(4, reservation.getCheckOutDate());
//            pstmt.setString(5, reservation.getReservationStatus());
//            pstmt.setDate(6, reservation.getLastModified());

            pstmt.executeUpdate();

            pstmtUpdateRoom.setInt(1, reservation.getRoomNumber());
            pstmtUpdateRoom.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 예약 수정
    public void updateReservation(ReservationDTO reservation) {
        String updateReservationSql = "UPDATE RESERVATION SET CHECKIN_DATE = ?, CHECKOUT_DATE = ? WHERE RESERVATION_ID = ?";
        String updateRoomSql = "UPDATE ROOM SET ROOMSTATUS = ? WHERE ROOMNUMBER = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateReservationSql);
             PreparedStatement pstmtUpdateRoom = conn.prepareStatement(updateRoomSql)) {

            conn.setAutoCommit(false); // 자동 커밋 끄기

            // 예약 정보 업데이트
            pstmt.setDate(1, reservation.getCheckInDate());
            pstmt.setDate(2, reservation.getCheckOutDate());
//            pstmt.setString(3, reservation.getReservationStatus());
            pstmt.executeUpdate();

            // 현재 날짜와 체크인 날짜 비교
            Date currentDate = new Date(System.currentTimeMillis());
            String roomStatus = "사용 중"; // 예를 들어 예약 상태에 따라 사용 중으로 설정
            if (reservation.getCheckInDate().after(currentDate)) {
                roomStatus = "빈 객실"; // 체크인 날짜가 아직 지나지 않았을 경우 빈 객실로 설정
            }

            // 객실 상태 업데이트
            pstmtUpdateRoom.setString(1, roomStatus);
            pstmtUpdateRoom.setInt(2, reservation.getRoomNumber());
            pstmtUpdateRoom.executeUpdate();

            conn.commit(); // 트랜잭션 커밋

        } catch (SQLException e) {
            e.printStackTrace();
          
        }
    }


    // 예약 취소
    public void cancelReservation(int reservationId, int roomNumber) {
        String sql = "UPDATE RESERVATION SET RESERVATION_STATUS = '취소', LAST_MODIFIED = ? WHERE RESERVATION_ID = ?";
        String updateRoomSql = "UPDATE ROOM SET ROOMSTATUS = '빈 객실' WHERE ROOMNUMBER = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             PreparedStatement pstmtUpdateRoom = conn.prepareStatement(updateRoomSql)) {

            conn.setAutoCommit(false); // 자동 커밋 끄기

            pstmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));  // 현재 시간으로 수정일 설정
            pstmt.setInt(2, reservationId);
            pstmt.executeUpdate();

            // 객실 상태 업데이트
            pstmtUpdateRoom.setInt(1, roomNumber);
            pstmtUpdateRoom.executeUpdate();

            conn.commit(); // 트랜잭션 커밋

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }
