package com.mystudy.scanner1;

import java.util.Scanner;

/* (실습)Scanner 사용 성적처리
입력 : 성명, 국어, 영어, 수학 점수를 입력 받아
처리 : 총점, 평균 구하기
출력 : 결과를 화면 출력
<성적처리결과>
성명 : 홍길동
국어 : 100
영어 : 90
수학 : 82
------------
총점 : 272
평균 : 90.66
========================= */
public class ScannerSungjuk {

	Scanner scan = new Scanner(System.in);
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;

	public void start() {
		System.out.println("[ScannerSunguk]성적처리 데이터를 입력");
		
		while (true) {
			
			//입력 : 성명, 국어, 영어, 수학 점수를 입력 ----------------
			input();
			
			//처리 : 총점, 평균 구하기 --------------
			process();
			
			//출력 : 결과를 화면 출력 --------------
			//output(name, kor, eng, math, tot, avg);
			output();
			
			//계속할래? 그만할래?
			System.out.println("> 종료하려면 0 입력 : ");
			String answer = scan.nextLine();
			if ("0".equals(answer)) {
				System.out.println("성적처리를 중단합니다~~~");
				break;
			}
		}
		
	} //start() 끝
	
	public void input() {
		System.out.print("성명 : ");
		name = scan.nextLine();
		
		System.out.print("국어 : ");
		kor = scan.nextInt();
		
		System.out.print("영어 : ");
		eng = scan.nextInt();
		
		System.out.print("수학 : ");
		math = scan.nextInt();
		scan.nextLine(); //빈문자열 읽어서 버리기
	}
	
	public void process() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}
	
	public void output() {
		System.out.println("<성적처리 결과>");
		System.out.println("성명 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);
		System.out.println();
	}
	
	

}




