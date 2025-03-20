package com.mystudy.stringbuilder;

public class Ex02_StringBuilder {

	public static void main(String[] args) {
		// StringBuilder 클래스
		StringBuilder sb = new StringBuilder("Hello Java!!!");
		System.out.println("sb : " + sb);
		System.out.println("sb.toString() : " + sb.toString());
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		
		System.out.println("--- StringBuilder : 데이터 변경 가능 ----");
		System.out.println("sb.toString() : " + sb.toString());
		StringBuilder appendReturn = sb.append(" 반갑습니다").append("~~~~"); //맨 뒤에 추가
		
		System.out.println("append 후 sb : " + sb.toString());
		System.out.println("appendReturn : " + appendReturn);
		System.out.println("sb == appendReturn : " + (sb == appendReturn));
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		
		sb.reverse();
		System.out.println("reverse 후 sb : " + sb);
		sb.reverse();
		System.out.println("reverse 후 sb : " + sb);
		
		System.out.println("---- delete(), insert(), replace() ------");
		//Hello Java!!! 반갑습니다~~~~
		//delete() 메소드 리턴값 : StringBuilder 데이터(현재 작업중인 StringBuilder 객체)
		System.out.println("sb.delete(0, 6) : " + sb.delete(0, 6));
		System.out.println("sb : " + sb.toString());
		
		System.out.println("sb.insert(0, \"Hello \") : " + sb.insert(0, "Hello "));
		System.out.println("sb : " + sb.toString());

		System.out.println("sb.replace(0, 5, \"Hi,\") : " + sb.replace(0, 5, "Hi,"));
		System.out.println("sb : " + sb.toString());
		
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		System.out.println("----------------");
		
		StringBuilder sb2 = new StringBuilder(100);
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		sb2.append("안녕하세요").append(" 반갑습니다!!!");
		System.out.println("sb2 : " + sb2.toString());
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println("--- trimToSize() 실행후 ---");
		sb2.trimToSize();
		System.out.println("sb2 : " + sb2.toString());
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println(">> sb2.setLength(5) 실행후 --- ");
		sb2.setLength(5); //데이터 크기 설정(작게 설정하면 delete 효과)
		//sb2.delete(5, sb2.length()); //앞에 5개 남기고 모두 삭제
		System.out.println("sb2 : " + sb2.toString());
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println(">> sb2.setLength(0) 실행후 --- ");
		sb2.setLength(0); 
		System.out.println("sb2 : " + sb2.toString());
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		
	}

}







