package com.mystudy.bean.vo;

//import com.sun.tools.classfile.Opcode.Set;
//import jdk.internal.org.jline.terminal.impl.AbstractPty;

public class StudentManager {

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
		
		StudentVO student1 = new StudentVO ("김유신", 100, 90, 81);
		StudentVO student2 = new StudentVO ("이순신", 95, 88, 92);
		StudentVO student3 = new StudentVO ("홍길동", 90, 87, 77);

		
		System.out.println("------------------------");
				
		System.out.println(student1.getName() + " " + student1.getKor() + " " + student1.getEng() + " " + student1.getMath() + " " + student1.getAvg() + " " + student1.getTot());
		
		System.out.println(student2.getName() + " " + student2.getKor() + " " + student2.getEng() + " " + student2.getMath() + " " + student2.getAvg() + " " + student2.getTot());
		
		System.out.println(student3.getName() + " " + student3.getKor() + " " + student3.getEng() + " " + student3.getMath() + " " + student3.getAvg() + " " + student3.getTot());
		
		
	}

}
