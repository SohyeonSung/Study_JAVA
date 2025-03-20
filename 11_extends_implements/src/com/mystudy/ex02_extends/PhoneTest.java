package com.mystudy.ex02_extends;

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
		
		System.out.println("=== WebPhone ====");
		WebPhone ph3 = new WebPhone("애플아이폰", "010-3333-3333");
		ph3.view();
		ph3.call();
		ph3.receiveCall();
		
		ph3.webSearch();
		
		

	}

}


