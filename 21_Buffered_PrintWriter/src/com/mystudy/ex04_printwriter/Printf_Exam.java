package com.mystudy.ex04_printwriter;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Printf_Exam {

	public static void main(String[] args) {
		// printf() 메소드
		int a = 100;
		long b = 3_000_000_000L;
		float c = 34.95f;
		double d = 234.567;
		char e = 'A';
		String f = "Hello~~";
		boolean g = false;
		
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		System.out.printf("%tF", today);
		System.out.println();
		
		System.out.println(">> " + a + " " + b + " " + c);
		
		/* [] : 옵션(생략가능)
		%[인덱스$][-][크기]형식문자 : %, 형식문자 필수
		기본은 우측정렬
		마이너스부호(-)는 좌측정렬 적용 예) %-10d
		------------------------ */
		System.out.printf("%d %d %c %s%n", 100, 12345, 'A', "홍길동~~");
		System.out.printf("%d   %d   %c   %s\n", 100, 12345, 'A', "홍길동~~");
		
		System.out.println("--- 인덱스(파라미터위치값) 사용 ----");
		//[인덱스$] 파라미터 위치값 $ 부호와 함께 사용
		//(주의) 인덱스 적용시 데이터 매칭에서 제외됨
		System.out.printf("%1$d %1$d %c %s%n", 65, 'B', "홍길동~~");
		System.out.printf("%1$d %1$d %2$c %3$s%n", 65, 'B', "홍길동~~");
		
		System.out.println("--- 실수형 데이터 표시 ----");
		System.out.printf("%f  %1$a  %1$e  %1$g %n", 65.812345678);
		System.out.printf("%10f\n", 65.812345678);
		System.out.printf("%10.3f\n", 65.812345678); //전체 10자리, 소수점이항 3자리
		System.out.printf("%-10.3f\n", 65.812345678); //좌측정렬시 마이너스(-) 사용
		
		System.out.println("--- 날짜관련 ---");
		System.out.printf("%tF\n", today);
		System.out.printf("%1$tY/%1$tm/%1$td\n", today);
		System.out.printf("%1$tH:%1$tM:%1$tS\n", today);
		
		System.out.println(LocalDateTime.now());
		
		System.out.println("================");
		String name = "홍길동";
		int kor = 100, eng = 90, math = 81;
		System.out.println(name + "은 국어 " + kor + ", 영어 " + eng + " 입니다");
		System.out.printf("%s은 국어 %d, 영어 %d 입니다.\n", name, kor, eng);
		

	}

}









