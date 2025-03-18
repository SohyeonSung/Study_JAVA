package com.mystudy.string;

public class Ex01_String_basic {

	public static void main(String[] args) {
		// String 클래스 : 문자열 저장, 처리하기 위한 클래스
		// String 데이터 자체는 불변임(immutable)
		// 사용형태 2가지 ------------
		// String str = "홍길동"; // 기본 데이터 타입처럼 사용 가능 : 상수값처럼 공유 사용
		// String str = new String("홍길동"); // 객체(인스턴스) 생성 방식
		//-----------------
		String str1 = "홍길동";
		String str2 = "홍길동";
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str1 == str2 : " + (str1 == str2)); // 동일 객체 여부 확인(동일 주소값)
		System.out.println("------");
		
		// == : 객체(인스턴스, 주소값) 비교(동일 객체 여부 확인)
		String strObj1 = new String("홍길동"); // new : 새로 생성(인스턴스/객체 1개를 만듬)
		String strObj2 = new String("홍길동");
		System.out.println("strObj1 : " + strObj1);
		System.out.println("strObj2 : " + strObj2);
		System.out.println("strObj1 == strObj2 : " + (strObj1 == strObj2));
		System.out.println("str1 == strObj1 : " + (str1 == strObj1));
		
		System.out.println("--- 문자열 값 비교 equals() 메소드 사용(필수) ---");
		// equals() : 문자열 값을 비교할 때는 반드시 equals() 메소드 사용할 것
		System.out.println("str1.equals(str2) : " + str1.equals(str2));
		System.out.println("str1.equals(strObj1) : " + str1.equals(strObj1));
		System.out.println("strObj1.equals(strObj2) : " + strObj1.equals(strObj2));
		
		System.out.println("=================");
		
		System.out.println("--- concat() ---");
		String a = "Hello";
		String b = "World";
		String c = "~~~~";
		System.out.println("a + b : " + (a + b));
		System.out.println("a.concat(b) : " + a.concat(b));
		
		//체이닝기법(chainning 기법)
		String result = a.concat(b).concat(c).concat("!!!!");
		System.out.println("a.concat(b).concat(c).concat(\"!!!!\") : " + result);
		System.out.println("a : " + a);
		System.out.println("a.toString() : " + a.toString());
		
		System.out.println("=================");
		str1 = "JAVA";
		str2 = "java";
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str1.equals(str2) : " + str1.equals(str2));
		System.out.println("str1.equalsIgnoreCase(str2) : " + str1.equalsIgnoreCase(str2));
		
		
		

	}

}
















