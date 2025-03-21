package com.mystudy.ex04_interface2;

class PhoneTest {

	public static void main(String[] args) {
		// Phone 객체(인스턴스) 생성 후 기능 테스트
//		System.out.println("==== Phone =====");
//		Phone ph1 = new Phone("010-1111-1111");
//		ph1.view();
//		ph1.call();
//		ph1.receiveCall();
//		ph1.sendMsg();
//		ph1.receiveMsg();
//		
//		System.out.println("=== Mp3 Phone ====");
//		Mp3Phone ph2 = new Mp3Phone("삼성갤럭시", "010-2222-2222");
//		ph2.view();
//		ph2.call();
//		ph2.receiveCall();	
//		ph2.playMusic();
		
		System.out.println("=== Web Phone ====");
		WebPhone ph3 = new WebPhone("애플아이폰", "010-3333-3333");
		ph3.view();
		ph3.call();
		ph3.receiveCall();
		ph3.sendMsg();
		ph3.receiveMsg();
		
		ph3.playMusic();
		ph3.searchWeb();
	
//		System.out.println("=== Web+Mp3 Phone ===");
//		WebMp3Phone ph4 = new WebMp3Phone ("메가폰", "010-4444-4444");
//		ph4.view();
//		ph4.call();
//		ph4.receiveCall();
//		
//		ph4.playMusic();
//		ph4.webSearch();

	}

}


