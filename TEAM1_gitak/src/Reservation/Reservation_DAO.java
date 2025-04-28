package Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import Util.DBUtil;

public class Reservation_DAO {

    // 예약 생성
    public void createReservation(Reservation_DTO reservation) {
        // 현재 날짜 가져오기 (현재 날짜를 java.sql.Date로 변환)
        Date currentDate = new Date(System.currentTimeMillis());

        // 체크인 날짜가 과거인 경우 예약 불가 처리
        if (reservation.getCheckInDate().before(currentDate)) {
            System.out.println("	❌ 예약 불가: 과거 날짜는 예약할 수 없습니다. ❌");
            return; // 과거 날짜이면 예약을 진행하지 않음
        }

        // 예약 INSERT
        String sql = "INSERT INTO RESERVATION (CUSTOMER_ID, ROOMNUMBER, CHECKINDATE, CHECKOUTDATE) VALUES (?, ?, ?, ?)";
        // 예약 생성 후 객실 상태 업데이트
        String updateRoomSql = "UPDATE ROOM SET ROOMSTATUS = '사용 중' WHERE ROOMNUMBER = ?";

        try (Connection conn = DBUtil.getConnection(); // DB 연결
             PreparedStatement pstmt = conn.prepareStatement(sql); // 예약 생성 쿼리 실행
             PreparedStatement pstmtUpdateRoom = conn.prepareStatement(updateRoomSql)) { // 객실 상태 업데이트 쿼리 실행

            pstmt.setInt(1, reservation.getCustomerId());
            pstmt.setInt(2, reservation.getRoomNumber());
            pstmt.setDate(3, reservation.getCheckInDate());
            pstmt.setDate(4, reservation.getCheckOutDate());

            pstmt.executeUpdate(); // 예약 생성

            pstmtUpdateRoom.setInt(1, reservation.getRoomNumber()); // 객실 상태 '사용 중'으로 업데이트
            pstmtUpdateRoom.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 예약 수정
    public void updateReservation(Reservation_DTO reservation) {
        // 현재 날짜 가져오기 (현재 날짜를 java.sql.Date로 변환)
        Date currentDate = new Date(System.currentTimeMillis());

        // 체크인 날짜가 과거인 경우 예약 불가 처리
        if (reservation.getCheckInDate().before(currentDate)) {
            System.out.println("	❌ 예약 수정 불가: 과거 날짜는 예약할 수 없습니다. ❌");
            return; // 과거 날짜이면 예약을 진행하지 않음
        }

        // 예약 정보 업데이트
        String updateReservationSql = "UPDATE RESERVATION SET CHECKIN_DATE = ?, CHECKOUT_DATE = ? WHERE RESERVATION_ID = ?";
        // 객실 상태 업데이트
        String updateRoomSql = "UPDATE ROOM SET ROOMSTATUS = ? WHERE ROOMNUMBER = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateReservationSql);
             PreparedStatement pstmtUpdateRoom = conn.prepareStatement(updateRoomSql)) {

            conn.setAutoCommit(false); // 자동 커밋 끄기

            // 예약 정보 업데이트
            pstmt.setDate(1, reservation.getCheckInDate());
            pstmt.setDate(2, reservation.getCheckOutDate());
            pstmt.executeUpdate();

            // 예약 상태와 객실 상태 업데이트
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
        // 예약 취소 변경
        String sql = "UPDATE RESERVATION SET RESERVATION_STATUS = '취소', LAST_MODIFIED = ? WHERE RESERVATION_ID = ?";
        // 객실 상태 '빈 객실'
        String updateRoomSql = "UPDATE ROOM SET ROOMSTATUS = '빈 객실' WHERE ROOMNUMBER = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             PreparedStatement pstmtUpdateRoom = conn.prepareStatement(updateRoomSql)) {

            conn.setAutoCommit(false); // 자동 커밋 끄기

            pstmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));  // 예약 상태 '취소'설정 , 수정일 현재 날짜
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
