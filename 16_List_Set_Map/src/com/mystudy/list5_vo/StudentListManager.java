package com.mystudy.list5_vo;

import java.util.List;

/*
성적처리를 위한 관리용 클래스를 생성 CRUD 기능을 구현하고 확인하시오
(학생 정보를 List에 저장하고 관리하되 학생번호는 중복되지 않는다)  
■ 클래스명 : StudentListManager
▶ 생성자 : 기본생성자, List를 전달받는 생성자
▶ 속성(필드변수) : StudentVO 저장을 위한 List
▶ 기능(메소드)
  - selectAll : 전체 데이터 리턴(List)
  - select : 학번(String)을 전달받아 동일한 학번 데이터 찾아서 리턴(VO)
  - select : StudentVO 타입 데이터를 전달받아 동일한 ID 데이터를 찾아서 리턴(VO)
  - insert : StudentVO 타입 데이터를 전달받아 List에 추가(동일데이터 없으면 추가)
  - update : StudentVO 타입 데이터를 전달받아 List에서 동일데이터 찾아서 수정(점수만)
  - updateName : 학번, 이름을 전달받아 List에 있는 동일한 학번의 이름 수정
  - updateKor : 학번, 점수를 전달받아 List에 있는 동일한 학번의 국어점수 수정
  - delete : StudentVO 타입 데이터를 전달받아 List에서 동일데이터 찾아서 삭제
  - delete : 학번(String)을 전달받아 동일한 학번 데이터 삭제
*/



public class StudentListManager {

	    List<StudentVO> studentList;

	    public StudentListManager(List<StudentVO> studentList) {
	        this.studentList = studentList;
	    }

	    public List<StudentVO> selectAll() {
	        return studentList;
	    }

	    public StudentVO select(String id) {
	        for (StudentVO student : studentList) {
	            if (student.getId().equals(id)) {
	                return student;
	            }
	        }
	        return null;
	    }

	    public StudentVO select(StudentVO student) {
	        return select(student.getId());
	    }

	    boolean insert(StudentVO student) {
	        if (select(student.getId()) == null) {
	            studentList.add(student);
	            return true; 
	        }
	        return false; 
	    }

	    boolean update(StudentVO student) {
	        StudentVO existingStudent = select(student);
	        if (existingStudent != null) {
	            existingStudent.setKor(student.getKor());
	            existingStudent.setEng(student.getEng());
	            existingStudent.setMath(student.getMath());
	            return true; 
	        }
	        return false; 
	    }

	    boolean updateName(String id, String name) {
	        StudentVO student = select(id);
	        if (student != null) {
	            student.setName(name);
	            return true;
	        }
	        return false; 
	    }


	    boolean updateKor(String id, int kor) {
	        StudentVO student = select(id);
	        if (student != null) {
	            student.setKor(kor);
	            return true;
	        }
	        return false;
	    }

	    boolean delete(StudentVO student) {
	        return delete(student.getId());
	    }

	    boolean delete(String id) {
	        StudentVO student = select(id);
	        if (student != null) {
	            studentList.remove(student);
	            return true;
	        }
	        return false; 
	    }
	}


