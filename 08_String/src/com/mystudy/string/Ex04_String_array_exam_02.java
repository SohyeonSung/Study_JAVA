package com.mystudy.string;

public class Ex04_String_array_exam_02 {

	public static void main(String[] args) {
		
		
		System.out.println("[내가 만든 코드]");
		
	
	

		/* 배열 String[]과 String 메소드 사용 실습
		문자열 : "홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"
		1. 위의 문자열 값을 저장할 수 있는 String 배열(names) 변수를 선언하고 입력
		2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		   출력 예) 홍길동,이순신,이순신,을지문덕....
		3. 배열에 있는 데이터의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
		   출력 예) 홍,이,이,을,김,연,T,T
		4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력
		   예) 3:을지문덕
		========================= */

		
		
		
		// 1.
		String names[] = { "홍길동", "이순신", "이순신", "을지문덕", "김유신", "연개소문", "Tom", "TOM" };

		
		
		// 2.
		System.out.print("이름 - ");

		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i]);
			if (i < names.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();

		
		// 3.
		StringBuilder firstL = new StringBuilder();

		for (int i = 0; i < names.length; i++) {
			firstL.append(names[i].charAt(0));

			if (i < names.length - 1) {
				firstL.append(",");
			}
		}
		System.out.println("첫번째 글자 - " + firstL.toString());

		
		
		// 4.
		System.out.print("4글자 이상 - ");
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				System.out.print(i + ":" + names[i] + "  ");

			}

		}
	}
}



