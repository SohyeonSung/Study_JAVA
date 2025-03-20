package com.mystudy.ex01_class;

class PhoneTest {

	public static void main(String[] args) {
		// Phone 객체(인스턴스) 생성 후 기능 테스트
		System.out.println("==== Phone =====");
		Phone ph1 = new Phone("010-1111-1111");
		ph1.view();
		ph1.call();
		ph1.receiveCall();
		
		System.out.println("=== Mp3Phone ====");
		Mp3Phone ph2 = new Mp3Phone("삼성갤럭시", "010-2222-2222");
		ph2.view();
		ph2.call();
		ph2.receiveCall();
		
		ph2.playMusic();
		
		

	}

}


