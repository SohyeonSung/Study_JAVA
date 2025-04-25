package Customers;

import java.sql.*;

import Util.DBUtil;

public class CustomerDAO {
	public boolean signup(int customerId, String name, String username, String password) { String sql = "INSERT INTO CUSTOMER (CUSTOMERID, CUSTOMERNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)"; try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) { pstmt.setInt(1, customerId); pstmt.setString(2, name); pstmt.setString(3, username); pstmt.setString(4, password); int result = pstmt.executeUpdate(); return result > 0; } catch (SQLException e) { e.printStackTrace(); return false; } }


public boolean login(String customerId, String password) {
    String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMERID = ? AND PASSWORD = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, customerId);
        pstmt.setString(2, password);
        try (ResultSet rs = pstmt.executeQuery()) {
            return rs.next(); // 로그인 성공 시 true
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


public boolean login(int customerId, String password) {
	String sql = "SELECT * FROM CUSTOMERS WHERE CUSTOMERID = ? AND PASSWORD = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, customerId);
        pstmt.setString(2, password);
        try (ResultSet rs = pstmt.executeQuery()) {
            return rs.next(); // 로그인 성공 시 true
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
	return true;
}
}