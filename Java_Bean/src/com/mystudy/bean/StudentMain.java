package com.mystudy.bean;

public class StudentMain {

	public static void main(String[] args) {
		Student stu = new Student();
		//stu.name = "홍길동";
		//System.out.println("stu.name : " + stu.name);
		
		stu.setName("홍길동");
		String name = stu.getName();
		System.out.println("name : " + name);
		System.out.println("stu.getName() : " + stu.getName());
		
		//stu.kor = -999;
		stu.setKor(100);
		System.out.println("stu.getKor() : " + stu.getKor());
		
		stu.setEng(90);
		System.out.println("stu.getEng() : " + stu.getEng());
		
		stu.setMath(81);
		System.out.println("stu.getMath() : " + stu.getMath());
		
		stu.setTot(stu.getKor() + stu.getEng() + stu.getMath());
		System.out.println("stu.getTot() : " + stu.getTot());
		
		stu.setAvg(stu.getTot() * 100 / 3 / 100.0);
		System.out.println("stu.getAvg() : " + stu.getAvg());
		
		System.out.println("====== 생성자 사용 입력처리 =====");
		Student stu2 = new Student("김유신", 100, 90, 82);
		System.out.println("stu2 : " + stu2);
		
		stu2.setKor(90);
		System.out.println("stu2 : " + stu2);
		
		//stu2.setTot(300);
		//stu2.setAvg(100);
		//stu2.computeTotAvg();
		System.out.println("stu2 : " + stu2);
		
		
		System.out.println("COMMIT TEST");
		
	}

}











