import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DBUtil;

public class DB_Hotel {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM ROOM";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String str = "";
                str += rs.getInt("ROOMNUMBER") + "\t";
                str += rs.getString("ROOMTYPE") + "\t";
                str += rs.getString("ROOMSTATUS") + "\t";
                System.out.println(str);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pstmt, conn); // 간단하게 자원 반납
        }
    }
}


