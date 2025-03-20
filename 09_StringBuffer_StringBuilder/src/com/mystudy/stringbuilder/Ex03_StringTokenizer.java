package com.mystudy.stringbuilder;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex03_StringTokenizer {

	public static void main(String[] args) {
		// String 클래스의 split() vs StringTokenizer 클래스
		System.out.println("--- String split() ----");
		String str = "사과,배,복숭아,,포도";
		System.out.println("str : " + str.toString());
		
		//String[] strSplit = str.split("[,:]"); //정규표현식 사용 가능
		String[] strSplit = str.split(",");
		System.out.println("strSplit.length : " +strSplit.length);
		System.out.println(Arrays.toString(strSplit));
		
		for (int i = 0; i < strSplit.length; i++) {
			System.out.println(i + " : -" + strSplit[i] + "-");
		}
		System.out.println("----");
		
		//개선된(향상된) for문
		for (String str2 : strSplit) {
			System.out.println(str2);
		}
		System.out.println("----");
		
		System.out.println("==== StringTokenizer 클래스 =======");
		str = "사과,배,복숭아,,포도";
		System.out.println("str : " + str);
		StringTokenizer strToken = new StringTokenizer(str, ",");
		System.out.println("strToken.countTokens() : " + strToken.countTokens());
		
		while (strToken.hasMoreTokens()) {
			String token = strToken.nextToken();
			System.out.println("-" + token + "-");
		}
		System.out.println("strToken.countTokens() : " + strToken.countTokens());
		
		System.out.println("===============");
		//(개인적실습) for문 사용해서 데이터 처리
		
		
		
		

	}

}










