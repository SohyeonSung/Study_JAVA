package com.mystudy.ex03_sungjuk;

public class SungjukTest {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 -----------");
		StudentVO vo = new StudentVO("홍길동", 100, 90, 81);
		System.out.println("vo : " + vo);
		System.out.println("vo.toString() : " + vo.toString());
		System.out.println("-- 국어점수 999 설정 ---");
		vo.setKor(999);
		System.out.println("vo : " + vo);
		
		int eng = 95;
		int math = 90;
		System.out.println("-- 영어점수 " + eng + " 설정 ---");
		System.out.println("-- 수학점수 " + math + " 설정 ---");
		try {
			vo.setEng(eng);
			vo.setMath(math);
		} catch (ScoreOutOfBoundsException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage() + " : 0 ~ 100 범위의 값으로 입력하세요");
		}
		System.out.println("vo : " + vo);
		
		
		System.out.println("--- main() 끝 -----------");
	}

}


