package com.mystudy.stringbuilder;

import java.util.Arrays;
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
		      예) 홍길동,이순신,이순신,Tom,홍길동,TOM,을지문덕,...
		      예) 홍길동 이순신 이순신 Tom 홍길동 TOM 을지문덕,...
		2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
		3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력
		   (출력할 데이터를 StringBuilder로 만들기)
		   예) 홍길동,이순신,이순신,Tom,홍길동,TOM...   
		4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력
		   (출력할 데이터를 StringBuilder로 만들기)
		   예) 홍,이,이,T,홍,T,을... 
		5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
		   예) 인덱스번호:을지문덕
		********************************/
		String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		String str2 = "    TOM   을지문덕 김유신 연개소문";
		
		//1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		//StringBuilder sb = new StringBuilder(str1 + str2);
		//StringBuilder sb = new StringBuilder(str1);
		//sb.append(str2);
		
		StringBuilder sb = new StringBuilder();
		sb.append(str1).append(str2);
		System.out.println("sb : " + sb.toString());
		
		//2-1. sb의 문자열을 빈칸 1개(" ")를 구분자로 잘라서(이름만 추출) 화면 출력(데이터확인)
		//     (String split() 또는 StringTokenizer 클래스 사용)
		//      예) 홍길동,이순신,이순신,Tom,홍길동,TOM,을지문덕,...
		//      예) 홍길동 이순신 이순신 Tom 홍길동 TOM 을지문덕,...
		//-----------
		StringTokenizer stk = new StringTokenizer(sb.toString(), " ");
		System.out.println("stk.countTokens() : " + stk.countTokens());
		
		while (stk.hasMoreTokens()) {
			String name = stk.nextToken();
			//System.out.print(name + " ");
			System.out.print(name + ",");
		}
		System.out.println();
		System.out.println("stk.countTokens() : " + stk.countTokens());
		
		//2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
		System.out.println("--- 2-2. 배열변수(names)에 저장 ---------");
		stk = new StringTokenizer(sb.toString(), " ");
		System.out.println("토큰갯수 : " + stk.countTokens());
		
		String[] names = new String[stk.countTokens()];
		System.out.println("배열크기 : " + names.length);
		System.out.println("names : " + Arrays.toString(names));
		
		int idx = 0;
		while (stk.hasMoreTokens()) {
			//names[idx] = stk.nextToken();
			//idx++;
			names[idx++] = stk.nextToken();
		}
		
		//(개인적실습) 위의 while문 대신 for문 사용방식 사용
		
		System.out.println("names : " + Arrays.toString(names));
		
		System.out.println("\n문제3 ====================");
		//3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력
		//   (출력할 데이터를 StringBuilder로 만들기)
		//   예) 홍길동,이순신,이순신,Tom,홍길동,TOM...   
		StringBuilder sb3 = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (i != 0) {
				//System.out.print(",");
				sb3.append(",");
			}
			//System.out.print(names[i]);
			sb3.append(names[i]);
		}
		System.out.println("sb3 : " + sb3.toString());
		//(개인적실습) 개선된 for문 사용 방식
		
		//4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력
		//   (출력할 데이터를 StringBuilder로 만들기)
		//   예) 홍,이,이,T,홍,T,을... 
		System.out.println("\n문제4 ================");
		StringBuilder sb4 = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (i != 0) {
				//System.out.print(",");
				sb4.append(",");
			}
			//System.out.print(names[i]);
			sb4.append(names[i].charAt(0));
		}
		System.out.println("sb4 : " + sb4.toString());
		
		//5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
		//   예) 인덱스번호:을지문덕
		System.out.println("\n문제5 ================");
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				System.out.println(i + ":" + names[i]);
			}
		}
		
		//=====================================
		System.out.println("===== String split() 메소드 사용방식 ======= ");
		System.out.println("sb : " + sb.toString());
		String[] names2 = sb.toString().split(" ");
		System.out.println("names2 : " + Arrays.toString(names2));
		System.out.println("배열데이터 수 : " + names2.length);
		
		System.out.println("\n문제3 ====================");
		//3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력
		//   (출력할 데이터를 StringBuilder로 만들기)
		//   예) 홍길동,이순신,이순신,Tom,홍길동,TOM... 
		
		System.out.println("--- 이름만 출력 length() 사용 ---");
		for (String name : names2) {
			if (name.trim().length() > 0) {
				System.out.println("-" + name + "-");
			}
		}
		System.out.println("--- 이름만 출력 isEmpty() 사용 ---");
		for (String name : names2) {
			if (!name.trim().isEmpty()) {
				System.out.println("-" + name + "-");
			}
		}
		
		//====================
		//(개인적실습) 위의 배열(names2)에서 유의미한 데이터 선택해서 새로운 배열 만들기
		
		

	}

}








