package com.mystudy.innerclass;

public class LocalClass {
	int a = 100;
	
	void print() {
		System.out.println("a : " + a);
	}
	
	void innerTest(int k) {
		int b = 200; //지역변수(local variable) 
		int c = k;
		
		// 내부 : 지역 클래스  - 메소드 내에서 선언된 클래스
		// 선언된 메소드 내부에서만 사용 가능
		class Inner {
			void printData() {
				System.out.println("Inner printData() 실행 시작----");
				System.out.println("외부 int a : " + a);
				System.out.println("외부 메소드 int b : " + b);
				System.out.println("외부 메소드 int c : " + c);
				System.out.println("외부 메소드 파라미터 k : " + k);
				
				System.out.println("Inner printData() 실행 끝----");
			}
		}
		
		Inner in = new Inner(); 
		in.printData();
	}


	

}
