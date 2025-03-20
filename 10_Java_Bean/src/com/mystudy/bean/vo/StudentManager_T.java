package com.mystudy.bean.vo;


public class StudentManager_T {

	public static void main(String[] args) {
		/*(실습) 3명의 성적처리 
		StudentVO 사용해서 성적처리 후 화면 출력
		"김유신", 100, 90, 81
		"이순신", 95, 88, 92
		"홍길동", 90, 87, 77
		==============================
		김유신	100	90	81	271	90.33
		이순신	95	88	92	275	91.66
		홍길동	90	87	77	254	84.66
		******************************** */
		StudentVO stu1 = new StudentVO("김유신", 100, 90, 81);
		//stu1.setTot(stu1.getKor() + stu1.getEng() + stu1.getMath());
		//stu1.setAvg(stu1.getTot() * 100 / 3 / 100.0);
		System.out.println("stu1 : " + stu1.toString());
		
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92, 0, 0);
		System.out.println("stu2 : " + stu2);
		//stu2.computeTotAvg();
		System.out.println("계산후 stu2 : " + stu2);
		
		StudentVO stu3 = new StudentVO("홍길동", 90, 87, 77);
		System.out.println("stu3 : " + stu3);
		
		System.out.println("==== 화면출력 ====");
		printData(stu1);
		printData(stu2);
		printData(stu3);
		
		System.out.println("== 데이터 수정(변경) ==");
		//김유신 국어 100 ---> 95
		stu1.setKor(99);
		stu1.setEng(80);
		
//		stu1.setTot(300);
//		stu1.setAvg(100);
		printData(stu1);
		
		//==============================
		//(개인실습) StudentVO 데이터를 저장할 수 있는 배열 선언 저장 사용
		// 배열에 저장된 데이터 값 중 이름, 총점, 평균을 화면 출력
		
	}
	
	static void printData(StudentVO vo) {
		System.out.println(vo.getName() + "\t" + 
				vo.getKor() + "\t" + 
				vo.getEng() + "\t" + 
				vo.getMath() + "\t" + 
				vo.getTot() + "\t" + 
				vo.getAvg());
	}
	
	

}






