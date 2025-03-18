package com.mystudy.stringbuilder;

import java.util.StringTokenizer;

public class Ex04_String_controls_exam {

	public static void main(String[] args) {
		
		/* 문자열 다루기
		0.문자열 데이터
		  String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		  String str2 = "    TOM   을지문덕 김유신 연개소문";
		  
		1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		
		2-1. sb의 문자열을 빈칸 1개(" ")를 구분자로 잘라서(이름만 추출) 화면 출력(데이터확인)
		     (String split() 또는 StringTokenizer 클래스 사용)
		      예) 홍길동, 이순신, 이순신, Tom, 홍길동, TOM...
		      
		2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
		
		3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력
		   (출력할 데이터를 StringBuilder로 만들기)
		   예) 홍길동,이순신,이순신,Tom,홍길동,TOM...   
		   
		4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력
		   (출력할 데이터를 StringBuilder로 만들기)
		   예) 홍,이,이,T,홍,T,을... 
		   
		5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
		   예) 인덱스번호:을지문덕
		*********************************/
		
		
		//0.문자열 데이터
		String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		String str2 = "    TOM   을지문덕 김유신 연개소문";
		
		
		//1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		StringBuilder sb = new StringBuilder();
		sb.append(str1).append(" ").append(str2);
		
		
		//2-1. sb의 문자열을 빈칸 1개(" ")를 구분자로 잘라서(이름만 추출) 화면 출력(데이터확인)
        StringTokenizer tokenizer = new StringTokenizer(sb.toString().trim());
        System.out.println("이름 -");
        while (tokenizer.hasMoreTokens()) {
            String name = tokenizer.nextToken();
            System.out.println(name);
        }

		// 2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
		String[] names = new String[tokenizer.countTokens()];
		tokenizer = new StringTokenizer(sb.toString().trim());
		
		int index = 0;
		while (tokenizer.hasMoreTokens()) {
			names[index++] = tokenizer.nextToken();
		}
		
		
		//3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력
		StringBuilder Comm = new StringBuilder();
		for (int i = 0; i < names.length; i++) { 
			Comm.append(names[i]);
			if (i < names.length - 1) {
		        Comm.append(","); 
		    }
		System.out.println("이름 구분 : " + Comm.toString());
		
		
		//4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력
		StringBuilder firstL = new StringBuilder();
		
		for (i = 0; i < names.length; i++) {
			firstL.append(names[i].charAt(0)); 
			if (i < names.length - 1) {
				firstL.append(","); 
			}
		}
		System.out.println("첫번째 글자 : " + firstL.toString());
        
        
        
		// 5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력

		System.out.println("4글자 이상 - ");

		for (i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				System.out.println(i + " : " + names[i] + " ");
			}
		}

	}
}
}

		


