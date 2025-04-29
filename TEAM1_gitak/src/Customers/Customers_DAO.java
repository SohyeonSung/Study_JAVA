package Customers;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Customers_DAO {

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

    // 고객 로그인 기능 
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
        // (1) 과거 날짜 입력 방지
        LocalDate today = LocalDate.now();
        LocalDate checkInDate = newCheckIn.toLocalDate();
        LocalDate checkOutDate = newCheckOut.toLocalDate();

        if (checkInDate.isBefore(today) || checkOutDate.isBefore(today)) {
            System.out.println("❌ 과거 날짜로는 예약을 수정할 수 없습니다. 오늘 이후의 날짜로 다시 입력해주세요. ❌");
            return false;
        }

        if (!checkInDate.isBefore(checkOutDate)) {
            System.out.println("❌ 체크아웃 날짜는 체크인 날짜보다 이후여야 합니다. 다시 입력해주세요. ❌");
            return false;
        }

        // (2) 중복 예약 날짜 체크
        String checkAvailabilityQuery = "SELECT COUNT(*) FROM RESERVATION "
                + "WHERE ROOMNUMBER = (SELECT ROOMNUMBER FROM RESERVATION WHERE RESERVATIONID = ?) "
                + "AND RESERVATIONID != ? "
                + "AND (CHECKINDATE BETWEEN ? AND ? OR CHECKOUTDATE BETWEEN ? AND ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkAvailabilityQuery)) {
            checkStmt.setInt(1, reservationId);
            checkStmt.setInt(2, reservationId);
            checkStmt.setDate(3, newCheckIn);
            checkStmt.setDate(4, newCheckOut);
            checkStmt.setDate(5, newCheckIn);
            checkStmt.setDate(6, newCheckOut);
            
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("❌ 해당 날짜는 이미 다른 예약과 겹칩니다. 다시 선택해주세요. ❌");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        // (3) 예약 수정
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

    // 고객 예약 취소 메서드
    public boolean cancelReservationWithAuth(Scanner scanner) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean success = false;

        try {
            System.out.print("📝 예약번호를 입력하세요: ");
            int reservationId = Integer.parseInt(scanner.nextLine());

            System.out.print("🔐 비밀번호를 입력하세요: ");
            String inputPassword = scanner.nextLine();

            conn = getConnection();
            conn.setAutoCommit(false);

            // (1) 예약 ID로 고객 ID 및 방번호 조회
            String getReservationInfo = "SELECT CUSTID, ROOMNUMBER FROM RESERVATION WHERE RESERVATIONID = ?";
            pstmt = conn.prepareStatement(getReservationInfo);
            pstmt.setInt(1, reservationId);
            rs = pstmt.executeQuery();

            String custId = null;
            int roomNumber = -1;

            if (rs.next()) {
                custId = rs.getString("CUSTID");
                roomNumber = rs.getInt("ROOMNUMBER");
            } else {
                System.out.println("❌ 해당 예약번호는 존재하지 않습니다.");
                return false;
            }

            pstmt.close();
            rs.close();

            // (2) CUSTID로 고객 비밀번호 조회
            String getPasswordQuery = "SELECT PASSWORD FROM CUSTOMERS WHERE CUSTID = ?";
            pstmt = conn.prepareStatement(getPasswordQuery);
            pstmt.setString(1, custId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("PASSWORD");
                if (!dbPassword.equals(inputPassword)) {
                    System.out.println("❌ 비밀번호가 일치하지 않습니다.");
                    return false;
                }
            } else {
                System.out.println("❌ 고객 정보가 존재하지 않습니다.");
                return false;
            }

            pstmt.close();
            rs.close();

            // (3) 예약 삭제
            String deleteReservationQuery = "DELETE FROM RESERVATION WHERE RESERVATIONID = ?";
            pstmt = conn.prepareStatement(deleteReservationQuery);
            pstmt.setInt(1, reservationId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("❌ 예약 삭제에 실패했습니다.");
                conn.rollback();
                return false;
            }

            pstmt.close();

            // (4) 객실 상태 복구
            String updateRoomStatus = "UPDATE ROOM SET ROOMSTATUS = '빈 객실' WHERE ROOMNUMBER = ?";
            pstmt = conn.prepareStatement(updateRoomStatus);
            pstmt.setInt(1, roomNumber);
            pstmt.executeUpdate();

            conn.commit();
            System.out.println("✅ 예약이 정상적으로 취소되었습니다.");
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
    
    public boolean deleteCustomer(String custId, int inputPassword) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            // (1) 고객 비밀번호 확인
            String getPasswordQuery = "SELECT PASSWORD FROM CUSTOMERS WHERE CUSTID = ?";
            pstmt = conn.prepareStatement(getPasswordQuery);
            pstmt.setString(1, custId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("PASSWORD");
                if (!dbPassword.equals(String.valueOf(inputPassword))) {
                    System.out.println("❌ 비밀번호가 일치하지 않습니다.");
                    return false;
                }
            } else {
                System.out.println("❌ 존재하지 않는 아이디입니다.");
                return false;
            }

            rs.close();
            pstmt.close();

            // (2) 고객 예약 삭제
            String deleteReservationsQuery = "DELETE FROM RESERVATION WHERE CUSTID = ?";
            pstmt = conn.prepareStatement(deleteReservationsQuery);
            pstmt.setString(1, custId);
            pstmt.executeUpdate();
            pstmt.close();

            // (3) 고객 정보 삭제
            String deleteCustomerQuery = "DELETE FROM CUSTOMERS WHERE CUSTID = ?";
            pstmt = conn.prepareStatement(deleteCustomerQuery);
            pstmt.setString(1, custId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
            }

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

        return false;
    }
    

}










