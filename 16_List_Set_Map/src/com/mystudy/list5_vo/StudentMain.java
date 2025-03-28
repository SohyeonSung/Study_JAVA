package com.mystudy.list5_vo;

import java.util.ArrayList;

public class StudentMain {

	public static void main(String[] args) {
		/* (실습) List를 사용한 성적 처리
		사용클래스명 : StudentVO
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(학번,성명,국어,영어,수학)를 만들고(저장하고)
		   "A01", "김유신", 100, 90, 81
		   "A02", "이순신", 95, 88, 92
		   "A03", "홍길동", 90, 87, 77
		2. ArrayList 타입의 변수(list)에 저장하고
		3. list에 있는 전체 데이터 화면출력 (간격은 \tab 이용)
		   학번   성명   국어  영어  수학  총점  평균
		   ------------------------------------------
		   A01  김유신  100   90    81    271   90.33
		   ...
		4. ID가 A01 의 국어 점수를 95 점으로 수정 하고,
		   A01 데이터만 출력
		   출력예 --------
		   학번 : A01
		   성명 : 김유신
		   국어 : 95
		   영어 : 90
		   ... 
		5. 전체 데이터 화면 출력(3번 형식으로)
		***********************************/
		
		//2
		ArrayList<StudentVO> list = new ArrayList <>();
		
		//1
		list.add(new StudentVO("A01", "김유신", 100, 90, 81));
		list.add(new StudentVO("A02", "이순신", 95, 88, 92));
		list.add(new StudentVO("A03", "홍길동", 90, 87, 77));
		
		//3
		for (StudentVO student : list) {
			System.out.println(student);
		}
		
		//4
		System.out.println("");
		System.out.println("[A01 데이터만 출력]");
		for (StudentVO student : list) {
			if(student.getId().equals("A01")) {
				System.out.println("학번 : " + student.getId());
				System.out.println("성명 : " + student.getName());
				System.out.println("국어 : " + student.getKor());
				System.out.println("영어 : " + student.getEng());
				System.out.println("수학 : " + student.getMath());
				System.out.println("총점 : " + student.getTot());
				System.out.println("평균 : " + student.getAvg());
			}
		}
		
		
		//5
		System.out.println("");
		System.out.println("[전체 데이터 출력]");
		System.out.println("학번\t성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------------");
		for (StudentVO student : list) {
            System.out.println(student.getId() +"\t" +  student.getName() + "\t" +  student.getKor() + "\t" + 
            student.getEng() + "\t" +  student.getMath() +"\t" +  student.getTot() + "\t" +  student.getAvg());
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
