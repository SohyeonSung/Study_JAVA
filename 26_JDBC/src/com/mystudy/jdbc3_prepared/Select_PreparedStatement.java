package com.mystudy.jdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select_PreparedStatement {

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
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"MYSTUDY", "mystudypw");
			//3. Statement 문 실행(SQL 문 실행)
			String sql = "";
			sql += "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ";
			sql += "FROM STUDENT ";
			sql += "WHERE ID = ? "; //? : 데이터 설정 위치 지정
			
			//3-1. Connection 객체로부터 PreparedStatement 객체생성
			pstmt = conn.prepareStatement(sql);
			System.out.println("pstmt : " + pstmt);
			
			String id = "2025001";
			//3-2. ?(바인드변수,매개변수) 위치에 값 설정
			pstmt.setString(1, id);
			System.out.println("sql : " + sql);
			
			rs = pstmt.executeQuery(); //준비되어 있는 SQL문 실행요청
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			if (rs.next()) {
				String str = "";
				//str += rs.getString(1) + "\t";  //위치값 사용방식
				str += rs.getString("ID") + "\t"; //컬럼명 사용방식
				str += rs.getString("NAME") + "\t";
				str += rs.getInt("KOR") + "\t";
				str += rs.getInt("ENG") + "\t";
				str += rs.getInt("MATH") + "\t";
				str += rs.getInt("TOT") + "\t";
				str += rs.getDouble("AVG");
				
				System.out.println(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			try {
				if (rs != null) rs.close();
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