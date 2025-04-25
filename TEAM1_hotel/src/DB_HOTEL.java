import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_HOTEL {

   public static void main(String[] args) {
      //JDBC 이용한 DB 연동 프로그래밍 작성 절차
      //0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
      //1. JDBC 드라이버 로딩
      //2. DB연결 - Connection 객체 생성 <- DriverManager
      //3. Statement 문 실행(SQL 문 실행)
      //4. SQL 실행 결과에 대한 처리
      //   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
      //   - INSERT, UPDATE, DELETE : int 값(건수) 처리
      //5. 클로징 처리에 의한 자원 반납
      //--------------------
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
    	  try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
         conn = DriverManager.getConnection(
               "jdbc:oracle:thin:@192.168.18.10:1521:xe", 
               "TEAM1", "team1");
         String sql = "";
         sql += "";
         sql += "SELECT * ";
         sql += "FROM ROOM ";
         //sql += "WHERE ID = ? ";//? : 데이터 설정 위치 지정
         
         pstmt = conn.prepareStatement(sql);
         //String id = "2025001";
         //pstmt.setString(1, id);
         rs = pstmt.executeQuery();//준비되어 있는 sql문 실행요청
         if (rs.next()) {
            String str = "";
            str += rs.getInt("ROOMNUMBER") + "\t";
            str += rs.getNString("ROOMTYPE") + "\t";
            str += rs.getNString("ROOMSTATUS") + "\t";
            /*str += rs.getInt("ENG") + "\t";
            str += rs.getInt("MATH") + "\t";
            str += rs.getInt("TOT") + "\t";
            str += rs.getDouble("AVG") + "\t";
            */System.out.println(str);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         //5. 클로징 처리에 의한 자원 반납
         try {
            if (rs != null )rs.close();
         } catch (SQLException e1) {}
         try {
            if (pstmt != null) pstmt.close();
         } catch (SQLException e) {}
         try {
            if (conn != null) conn.close();
         } catch (SQLException e) {}
      }
      
      
      
      
   }

}

