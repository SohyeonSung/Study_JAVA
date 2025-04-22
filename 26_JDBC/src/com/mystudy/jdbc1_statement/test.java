package com.mystudy.jdbc1_statement;

import java.sql.*;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Connection conn = null;
        Scanner sc = new Scanner(System.in);

        try {
            // 1. JDBC 드라이버 로딩
            Class.forName("oracle.jdbc.OracleDriver");

            // 2. DB 연결
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "MYSTUDY",
                "mystudypw"
            );

            while (true) {
                System.out.println("\n=== 메뉴 ===");
                System.out.println("1. 학생 정보 입력");
                System.out.println("2. 학생 정보 출력");
                System.out.println("3. 학생 정보 수정");
                System.out.println("4. 학생 정보 삭제");
                System.out.println("5. 종료");
                System.out.print("선택 >> ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertStudent(conn, sc);
                        break;
                    case 2:
                        printAllStudents(conn);
                        break;
                    case 3:
                        updateStudent(conn, sc);
                        break;
                    case 4:
                        deleteStudent(conn, sc);
                        break;
                    case 5:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("DB 연결이 종료되었습니다.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void insertStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("학생 ID: ");
        String id = sc.next();
        sc.nextLine();

        System.out.print("이름: ");
        String name = sc.nextLine();

        System.out.print("국어 점수: ");
        int KOR = sc.nextInt();

        System.out.print("영어 점수: ");
        int ENG = sc.nextInt();

        System.out.print("수학 점수: ");
        int MATH = sc.nextInt();

        int TOT = KOR + ENG + MATH;
        double AVG = TOT / 3.0;

        String sql = String.format(
            "INSERT INTO student (ID, NAME, KOR, ENG, MATH, TOT, AVG) " +
            "VALUES ('%s', '%s', %d, %d, %d, %d, %.2f)",
            id, name, KOR, ENG, MATH, TOT, AVG
        );

        Statement stmt = conn.createStatement();
        int result = stmt.executeUpdate(sql);
        if (result > 0) {
            System.out.println("학생 정보가 저장되었습니다.");
        } else {
            System.out.println("학생 정보 저장 실패.");
        }
        stmt.close();
    }

    private static void printAllStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM student ORDER BY ID";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n=== 학생 목록 ===");
        while (rs.next()) {
            System.out.printf("ID: %s | 이름: %s | 국어: %d | 영어: %d | 수학: %d | 총점: %d | 평균: %.2f\n",
                    rs.getString("ID"),
                    rs.getString("NAME"),
                    rs.getInt("KOR"),
                    rs.getInt("ENG"),
                    rs.getInt("MATH"),
                    rs.getInt("TOT"),
                    rs.getDouble("AVG"));
        }
        rs.close();
        stmt.close();
    }

    private static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.println("\n=== 수정할 학생 목록 ===");
        printStudentIDs(conn);

        System.out.print("수정할 학생 ID를 선택하세요: ");
        String id = sc.next();
        sc.nextLine(); // 줄바꿈 처리

        String selectSql = "SELECT * FROM student WHERE ID = '" + id + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSql);

        if (rs.next()) {
            System.out.printf("기존 정보 - ID: %s | 이름: %s | 국어: %d | 영어: %d | 수학: %d\n",
                    rs.getString("ID"),
                    rs.getString("NAME"),
                    rs.getInt("KOR"),
                    rs.getInt("ENG"),
                    rs.getInt("MATH"));
        } else {
            System.out.println("해당 ID의 학생이 없습니다.");
            rs.close();
            stmt.close();
            return;
        }
        rs.close();

        System.out.print("새 이름: ");
        String name = sc.nextLine();

        System.out.print("새 국어 점수: ");
        int KOR = sc.nextInt();

        System.out.print("새 영어 점수: ");
        int ENG = sc.nextInt();

        System.out.print("새 수학 점수: ");
        int MATH = sc.nextInt();

        int TOT = KOR + ENG + MATH;
        double AVG = TOT / 3.0;

        String updateSql = String.format(
            "UPDATE student SET NAME='%s', KOR=%d, ENG=%d, MATH=%d, TOT=%d, AVG=%.2f WHERE ID='%s'",
            name, KOR, ENG, MATH, TOT, AVG, id
        );

        int result = stmt.executeUpdate(updateSql);
        if (result > 0) {
            System.out.println("학생 정보가 수정되었습니다.");
        } else {
            System.out.println("수정 실패.");
        }
        stmt.close();
    }

    private static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.println("\n=== 삭제할 학생 목록 ===");
        printStudentIDs(conn);  // 삭제할 학생 ID 목록 출력

        System.out.print("삭제할 학생 ID를 선택하세요: ");
        String id = sc.next();

        String deleteSql = "DELETE FROM student WHERE ID = '" + id + "'";

        Statement stmt = conn.createStatement();
        int result = stmt.executeUpdate(deleteSql);

        if (result > 0) {
            System.out.println("학생 정보가 삭제되었습니다.");
        } else {
            System.out.println("해당 ID의 학생이 존재하지 않거나 삭제 실패했습니다.");
        }
        stmt.close();
    }

    private static void printStudentIDs(Connection conn) throws SQLException {
        String sql = "SELECT ID FROM student ORDER BY ID";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println("ID: " + rs.getString("ID"));
        }
        rs.close();
        stmt.close();
    }
}
