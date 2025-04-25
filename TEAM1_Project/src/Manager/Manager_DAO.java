package Manager;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import Util.DBUtil;
import java.sql.DriverManager;

public class Manager_DAO {


// 로그인 확인
public boolean login(int managerId, String password) {
    String sql = "SELECT * FROM MANAGER WHERE USERNAME = ? AND PASSWORD = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, managerId);
        pstmt.setString(2, password);

        try (ResultSet rs = pstmt.executeQuery()) {
            return rs.next(); // 로그인 성공 시 true
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return true;
}

// 관리자 등록
public boolean insertManager(int managerId, String managerName, String username, String password) {
    String sql = "INSERT INTO MANAGER (MANAGERID, MANAGERNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, managerId);
        pstmt.setString(2, managerName);
        pstmt.setString(3, username);
        pstmt.setString(4, password);

        int result = pstmt.executeUpdate();
        return result > 0; // 성공 시 true
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

// 모든 관리자 정보 출력
public void showAllManagers() {
    String sql = "SELECT * FROM MANAGER ORDER BY MANAGERID";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        System.out.println("ID\t이름\t\tUSERNAME\tPASSWORD");
        while (rs.next()) {
            int id = rs.getInt("MANAGERID");
            String name = rs.getString("MANAGERNAME");
            String user = rs.getString("USERNAME");
            String pwd = rs.getString("PASSWORD");
            System.out.printf("%d\t%s\t\t%s\t\t%s\n", id, name, user, pwd);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// 사용자명 중복 체크
public boolean isUsernameTaken(String username) {
    String sql = "SELECT 1 FROM MANAGER WHERE USERNAME = ?";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, username);
        try (ResultSet rs = pstmt.executeQuery()) {
            return rs.next(); // 존재하면 true
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

//public boolean login(int managerId, String managerPw) {
//	// TODO Auto-generated method stub
//	return true;
//}

}