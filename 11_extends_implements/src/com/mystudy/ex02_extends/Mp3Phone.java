package com.mystudy.ex02_extends;

// Phone 클래스를 상속받아 (extends : 확장해서) Mp3Phone 만들기
// Phone이 허용한 속성, 기능을 사용 + Mp3Phone 속성, 기능 추가 작성

class Mp3Phone extends Phone {

	public Mp3Phone(String phoneNo) {
		super(phoneNo);
	}
	
	public Mp3Phone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	//메소드(기능) -----------
	public void playMusic() {
		System.out.println(">> Mp3Phone - 음악플레이");
	}
	
	
	
	
}

