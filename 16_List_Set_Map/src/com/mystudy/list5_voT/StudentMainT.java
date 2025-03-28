package com.mystudy.list5_voT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class StudentMainT {
	static final String TITLE = "학번\t이름\t국어\t영어\t수학\t총점\t평균";
	static final String LINE = "------------------------------------------------------";
	
	public static void main(String[] args) {
		/* (실습) List를 사용한 성적 처리
		사용클래스명 : StudentVO
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(학번,성명,국어,영어,수학)를 만들고(저장하고)
		   "A01", "김유신", 100, 90, 81
		   "A02", "이순신", 95, 88, 92
		   "A03", "홍길동", 90, 87, 77
		2. ArrayList 타입의 변수(list)에 저장하고
		3. list에 있는 전체 데이터 화면출력
		   학번  성명   국어  영어  수학  총점  평균
		   ------------------------------------------
		   A01  김유신  100   90    81    271   90.33
		   ...
		4. 특정 학생의 데이터를 수정(변경) 처리
		4-1. 학생번호(ID)가 A01 인 학생의 국어 점수를 95 점으로 수정 하고,
		4-2. A01 데이터만 출력
		   출력예 --------
		   학번 : A01
		   성명 : 김유신
		   국어 : 95
		   영어 : 90
		   ... 
		5. 전체 데이터 화면 출력
		   (3번 형식으로 출력 또는 학번,성명,총점,평균만)
		***********************************/
		/*
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(학번,성명,국어,영어,수학)를 만들고(저장하고)
		   "A01", "김유신", 100, 90, 81
		   "A02", "이순신", 95, 88, 92
		   "A03", "홍길동", 90, 87, 77
		======================= */
		StudentVOT stu1 = new StudentVOT("A01", "김유신", 100, 90, 81);
		StudentVOT stu2 = new StudentVOT("A02", "이순신", 95, 88, 92);
		StudentVOT stu3 = new StudentVOT("A03", "홍길동", 90, 87, 77);
		System.out.println("stu1 : " + stu1);
		System.out.println("stu2 : " + stu2);
		System.out.println("stu3 : " + stu3);
		
		System.out.println("2. =======================");
		//2. ArrayList 타입의 변수(list)에 저장하고
		//ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		//List<StudentVO> list = new LinkedList<StudentVO>();
		//List<StudentVO> list = new Vector<StudentVO>();
		List<StudentVOT> list = new ArrayList<StudentVOT>();
		
		//list.add(new StudentVO(stu1.getId(), stu1.getName(), stu1.getKor(), stu1.getEng(), stu1.getMath()));
		list.add(stu2);
		list.add(stu3);
		
		System.out.println("list : " + list);
		System.out.println("list.size() : " + list.size());
		
		System.out.println("3. =====================");
		/*
		3. list에 있는 전체 데이터 화면출력
		   학번  성명   국어  영어  수학  총점  평균
		   ------------------------------------------
		   A01  김유신  100   90    81    271   90.33
		************************* */
		System.out.println(TITLE);
		System.out.println(LINE);
		for (int i = 0; i < list.size(); i++) {
			StudentVOT vo = list.get(i);
			System.out.print(vo.getId() + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + 
					vo.getEng() + "\t" + vo.getMath() + "\t" + vo.getTot() + "\t" + vo.getAvg());
			System.out.println();
		}
		System.out.println("-------------");
		for (StudentVOT vo : list) {
			System.out.print(vo.getId() + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + 
					vo.getEng() + "\t" + vo.getMath() + "\t" + vo.getTot() + "\t" + vo.getAvg());
			System.out.println();
		}
		
		System.out.println("4. =================");
		/*
		4. 특정 학생의 데이터를 수정(변경) 처리
		4-1. 학생번호(ID)가 A01 인 학생의 국어 점수를 95 점으로 수정 하고,
		4-2. A01 데이터만 출력
		   출력예 --------
		   학번 : A01
		   성명 : 김유신
		   국어 : 95
		   영어 : 90
		   ... 
		************************* */
		//4-1. 학생번호(ID)가 A01 인 학생의 국어 점수를 95 점으로 수정 하고,
		for (StudentVOT vo : list) {
			if ("A01".equals(vo.getId())) {
				vo.setKor(95);
			}
		}
		
		//4-2. A01 데이터만 출력
//		for (StudentVO vo : list) {
//			if ("A01".equals(vo.getId())) {
//				printData(vo);
//			}
//		}
		printData(list, "A01");
		
		System.out.println("5. ========================");
		//5. 전체 데이터 화면 출력
		//   (3번 형식으로 출력 또는 학번,성명,총점,평균만)
		printData(list);

	}//main 끝
	
	static void printData(List<StudentVOT> list) {
		System.out.println(TITLE);
		System.out.println(LINE);
		for (StudentVOT vo : list) {
			System.out.print(vo.getId() + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + 
					vo.getEng() + "\t" + vo.getMath() + "\t" + vo.getTot() + "\t" + vo.getAvg());
			System.out.println();
		}
	}
	
	static void printData(StudentVOT vo) {
		System.out.println("학번 : " + vo.getId());
		System.out.println("이름 : " + vo.getName());
		System.out.println("국어 : " + vo.getKor());
		System.out.println("영어 : " + vo.getEng());
		System.out.println("수학 : " + vo.getMath());
		System.out.println("총점 : " + vo.getTot());
		System.out.println("평균 : " + vo.getAvg());
	}
	
	static void printData(List<StudentVOT> list, String id) {
		for (StudentVOT vo : list) {
			if (id.equals(vo.getId())) {
				printData(vo);
			}
		}
	}
	

}











