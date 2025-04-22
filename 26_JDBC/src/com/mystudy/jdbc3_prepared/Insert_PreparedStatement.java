package com.mystudy.jdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_PreparedStatement {

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
		
		try {
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"MYSTUDY", "mystudypw");
			
			//3. Statement 문 실행(SQL 문 실행)
			//3-1. SQL 실행을 위한 준비(PreparedStatement 객체 생성)
			String sql = "";
			sql += "INSERT INTO STUDENT ";
			sql += "       (ID, NAME, KOR, ENG, MATH) ";
			sql += "VALUES (?, ?, ?, ?, ?) "; //1, 2, 3, 4, 5 번 위치
			pstmt = conn.prepareStatement(sql);
			
			//3-2. SQL 문장의 ? 위치에 값 설정(매칭, 설정)
			String id = "S2025007";
			String name = "테스트7";
			int kor = 97;
			int eng = 87;
			int math = 77;
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, math);
			
			//3-3. 준비된 SQL 실행(요청)
			int result = pstmt.executeUpdate();
			
			//4. SQL 실행 결과에 대한 처리
			//   - INSERT, UPDATE, DELETE : int 값(건수) 처리
			System.out.println("::처리건수 : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			try {
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		

	}

}
