package Customers;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Customer_DAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@192.168.18.10:1521:xe";
        String user = "TEAM1";
        String password = "team1";
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

 // 고객 로그인 기능 (회원 이름 반환)
    public String login(String custId, String password) {
        String sql = "SELECT * FROM CUSTOMERS WHERE CUSTID = ? AND PASSWORD = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, custId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("customerName"); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // 로그인 실패 시 null 반환
    }



    // 고객 예약 생성 기능
    public boolean createReservation(String custId, int roomNumber, Date checkIn, Date checkOut) {
        boolean success = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
        	LocalDate currentDate = LocalDate.now();
            LocalDate inputCheckInDate = checkIn.toLocalDate();  // checkIn을 LocalDate로 변환

            // (0) 입력한 체크인 날짜가 현재 날짜보다 이전이면 예약 불가
            if (inputCheckInDate.isBefore(currentDate)) {
                System.out.println("	❌ 예약은 현재 날짜 이후로만 가능합니다. ❌");
                return false;
            }

            conn = getConnection();
            conn.setAutoCommit(false); // 트랜잭션 시작

            // (1) 예약 중복 체크
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
                System.out.println("		❌ 해당 객실은 이미 예약되어 있습니다.❌");
                conn.rollback(); // 예약 실패시 롤백
                return false;
            }
            pstmt.close();
            rs.close();

            // (2) 객실 가격 조회
            String getRoomPriceQuery = "SELECT PRICE FROM ROOM_TYPES WHERE ROOMTYPE = (SELECT ROOMTYPE FROM ROOM WHERE ROOMNUMBER = ?)";
            pstmt = conn.prepareStatement(getRoomPriceQuery);
            pstmt.setInt(1, roomNumber);
            rs = pstmt.executeQuery();

            int pricePerDay = 0;
            if (rs.next()) {
                pricePerDay = rs.getInt("PRICE");
            }
            pstmt.close();
            rs.close();

            // (3) 예약 일수 계산
            long diffInMillies = checkOut.getTime() - checkIn.getTime();
            long diffDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            if (diffDays <= 0) {
                System.out.println("		❌ 체크아웃 날짜는 체크인 날짜보다 이후여야 합니다.❌");
                conn.rollback(); // 날짜가 유효하지 않으면 롤백
                return false; 
            }

            // (4) 총 가격 계산
            int totalPrice = (int)(pricePerDay * diffDays);

            System.out.println("	- 예약일수: " + diffDays + "일");
            System.out.println("	- 객실 가격: " + pricePerDay + "원 /일");
            System.out.println("	- 총 금액: " + totalPrice + "원");



            // (5) 예약 생성 (reservation_num.NEXTVAL 사용)
            String insertReservationQuery = "INSERT INTO RESERVATION (RESERVATIONID, CUSTID, ROOMNUMBER, CHECKINDATE, CHECKOUTDATE, TOTALPRICE) "
                + "VALUES (reservation_num.NEXTVAL, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertReservationQuery);
            pstmt.setString(1, custId);
            pstmt.setInt(2, roomNumber);
            pstmt.setDate(3, checkIn);
            pstmt.setDate(4, checkOut);
            pstmt.setInt(5, totalPrice);

            int rowsAffected = pstmt.executeUpdate(); // 예약 입력
            pstmt.close();

            if (rowsAffected > 0) {

            // (6) 방 상태 업데이트
			String updateRoomStatusQuery = "UPDATE ROOM SET ROOMSTATUS = '사용 중' WHERE ROOMNUMBER = ?";
			pstmt = conn.prepareStatement(updateRoomStatusQuery);
			pstmt.setInt(1, roomNumber);
			int updateResult = pstmt.executeUpdate();
			pstmt.close();

			if (updateResult > 0) {
			// 생성된 예약번호 출력
			String getReservationIdQuery = "SELECT reservation_num.CURRVAL FROM dual";
			pstmt = conn.prepareStatement(getReservationIdQuery);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int generatedReservationId = rs.getInt(1);
					System.out.println("	- 🎟️ 고객님의 예약번호는 [" + generatedReservationId + "] 입니다. 꼭 기억해 주세요!");
					}
                    success = true; 
                    conn.commit();
                } else {
                    conn.rollback();
                    System.out.println("	❌ 방 상태 업데이트 실패로 예약 취소됨 ❌");
                }
            } else {
                conn.rollback();
                System.out.println("	❌ 예약 생성 실패 ❌");
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
    
    
   
    
    // 고객 예약 조회 기능
    public List<String> getReservationsByCustomer(String custId) {
        List<String> reservations = new ArrayList<>();
        String sql = "SELECT r.ROOMNUMBER, r.ROOMTYPE, r.ROOMSTATUS, rt.PRICE, res.RESERVATIONID, res.CHECKINDATE, res.CHECKOUTDATE " +
                     "FROM RESERVATION res " +
                     "JOIN ROOM r ON res.ROOMNUMBER = r.ROOMNUMBER " +
                     "JOIN ROOM_TYPES rt ON r.ROOMTYPE = rt.ROOMTYPE " +
                     "WHERE res.CUSTID = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, custId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int reservationId = rs.getInt("RESERVATIONID");
                int roomNumber = rs.getInt("ROOMNUMBER");
                Date checkInDate = rs.getDate("CHECKINDATE");
                Date checkOutDate = rs.getDate("CHECKOUTDATE");
                int pricePerNight = rs.getInt("PRICE");

                // 예약 기간 계산
                long diffInMillies = checkOutDate.getTime() - checkInDate.getTime();
                long daysBetween = diffInMillies / (1000 * 60 * 60 * 24);  // 일수 계산

                // 총 가격 계산
                int totalPrice = (int) (daysBetween * pricePerNight);

                // 예약 정보 추가
                reservations.add(String.format("	╔══════════════════════════════════════════════════════════════════════════╗"));
                reservations.add(String.format("	║ 예약번호: %-6s │ 방 번호: %-6s │ 체크인: %-10s │ 체크아웃: %-10s  ║", 
                                                reservationId, roomNumber, checkInDate, checkOutDate));
                reservations.add(String.format("	╠══════════════════════════════════════════════════════════════════════════╣"));
                reservations.add(String.format("	║ 1박 가격: %-10s │ 총 가격: %-12s                                ║", 
                                                String.format("%,d", pricePerNight), String.format("%,d", totalPrice)));
                reservations.add(String.format("	╚══════════════════════════════════════════════════════════════════════════╝"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }


    // 고객 예약 수정
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

    // 고객 예약 취소
    public boolean cancelReservation(int reservationId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean success = false;
        int roomNumber = -1;  // 예약된 방 번호를 저장할 변수

        try {
            conn = getConnection();
            conn.setAutoCommit(false);  // 트랜잭션 시작

            // (1) 예약 id로 방 번호 조회
            String getRoomNumberQuery = "SELECT ROOMNUMBER FROM RESERVATION WHERE RESERVATIONID = ?";
            pstmt = conn.prepareStatement(getRoomNumberQuery);
            pstmt.setInt(1, reservationId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                roomNumber = rs.getInt("ROOMNUMBER");
            } else {
                // 예약이 존재하지 않으면
                conn.rollback();
                return false;
            }

            rs.close();
            pstmt.close();

            // (2) 예약 삭제
            String deleteReservationQuery = "DELETE FROM RESERVATION WHERE RESERVATIONID = ?";
            pstmt = conn.prepareStatement(deleteReservationQuery);
            pstmt.setInt(1, reservationId);
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            if (rowsAffected == 0) {
                conn.rollback();
                return false;
            }

            // (3) ROOM 테이블 상태 "빈 객실"로 변경
            String updateRoomStatusQuery = "UPDATE ROOM SET ROOMSTATUS = '빈 객실' WHERE ROOMNUMBER = ?";
            pstmt = conn.prepareStatement(updateRoomStatusQuery);
            pstmt.setInt(1, roomNumber);
            pstmt.executeUpdate();

            // (4) 성공하면 커밋
            conn.commit();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    // 고객 회원가입
    public boolean signup(Customers_DTO customer) {
        String sql = "INSERT INTO CUSTOMERS (CUSTID, PASSWORD, CUSTOMERNAME) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getCustId());
            stmt.setInt(2, customer.getPassword());
            stmt.setString(3, customer.getCustomerName());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // 회원가입 성공 여부 반환
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // 고객 id 중복체크
    public boolean checkCustomerIdExists(String custId) {
        String sql = "SELECT COUNT(*) FROM CUSTOMERS WHERE CUSTID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, custId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;  // id가 존재하면 true 반환
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // id가 존재하면 false 반환
    }

}

