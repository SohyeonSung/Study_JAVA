package Manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;

import Util.DBUtil;

public class Manager_DAO {
	   
	   private static Connection getConnection() throws SQLException {
	        String url = "jdbc:oracle:thin:@192.168.18.10:1521:xe"; // DB 주소
	        String user = "TEAM1"; // DB 사용자명
	        String password = "team1"; // DB 비밀번호
	        return DriverManager.getConnection(url, user, password);
	    }


	// 로그인 확인
	public boolean login(String managerId, int password) {
	    String sql = "SELECT * FROM MANAGER WHERE MANAGERID = ? AND PASSWORD = ?";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, managerId);
	        pstmt.setInt(2, password);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            return rs.next(); // 로그인 성공 시 true
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return true;
	}

	// 관리자 등록
	public boolean insertManager(String managerId, String managerName, int password) {
	    String sql = "INSERT INTO MANAGER (MANAGERID, MANAGERNAME, PASSWORD) VALUES (?, ?, ?)";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, managerId);
	        pstmt.setString(2, managerName);
	        pstmt.setInt(3, password);

	        int result = pstmt.executeUpdate();
	        return result > 0; // 성공 시 true
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public static int getDailySales(Date date) {
	    int totalSales = 0;
	    String sql = "SELECT NVL(SUM(TOTALPRICE), 0) FROM RESERVATION WHERE CHECKINDATE = ?";
	    try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setDate(1, date);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            totalSales = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return totalSales;
	}

	// 2. 월매출 조회
	public static int getMonthlySales(String yearMonth) {
	    int totalSales = 0;
	    String sql = "SELECT NVL(SUM(TOTALPRICE), 0) FROM RESERVATION WHERE TO_CHAR(CHECKINDATE, 'YYYY-MM') = ?";
	    try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, yearMonth);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            totalSales = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return totalSales;
	}

	// 3. 기간별 매출 조회
	public static int getSalesBetweenDates2(Date startDate, Date endDate) {
	    int totalSales = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = getConnection();

	        // 기간별 매출 계산 SQL 쿼리
	        String query = "SELECT SUM(TOTALPRICE) AS TOTALSALES FROM RESERVATION "
	                     + "WHERE CHECKINDATE BETWEEN ? AND ? OR CHECKOUTDATE BETWEEN ? AND ?";

	        pstmt = conn.prepareStatement(query);
	        pstmt.setDate(1, startDate);  // 시작 날짜
	        pstmt.setDate(2, endDate);    // 종료 날짜
	        pstmt.setDate(3, startDate);  // 시작 날짜 (체크인 날짜)
	        pstmt.setDate(4, endDate);    // 종료 날짜 (체크인 날짜)

	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            totalSales = rs.getInt("TOTALSALES");  // 기간 내 매출 합계
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeResources(rs, pstmt, conn);
	    }

	    return totalSales;
	}

	// 연결 자원 반환 메서드
	private static void closeResources(ResultSet rs, PreparedStatement pstmt, Connection conn) {
	    try {
	        if (rs != null) rs.close();
	        if (pstmt != null) pstmt.close();
	        if (conn != null) conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}