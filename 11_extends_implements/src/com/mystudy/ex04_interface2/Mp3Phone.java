package com.mystudy.ex04_interface2;

/*--Mp3Phone 기능 구현--
(반드시 I_Phone, I_Mp3Phone 구현)
 
 전화 정보 확인, 전화 걸기, 전화 받기, 문자 보내기, 문자 받기
 +) 음악 플레이
 
-------------------- */

//Phone 클래스를 상속 확장하고, I_Mp3Phone 인터페이스 기능을 구현
class Mp3Phone extends Phone implements I_Mp3Phone {

	public Mp3Phone(String phoneNo) {
		super("Mp3Phone", phoneNo);
	}

	public Mp3Phone(String type, String phoneNo) {
		super("Mp3Phone", phoneNo);
	}

	@Override
	public void playMusic() {
		System.out.println(">> 음악 플레이");
		
	}
}
