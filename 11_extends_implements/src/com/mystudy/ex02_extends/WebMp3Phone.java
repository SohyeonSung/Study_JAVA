package com.mystudy.ex02_extends;

class WebMp3Phone extends Phone{
	
	public WebMp3Phone(String phoneNo) {
		super(phoneNo);
	}
	
	public WebMp3Phone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	
	//메소드 (기능) -----
	
	public void webSearch() {
		System.out.println(">> WebMp3Phone - 웹 검색");
	}
	
	public void playMusic() {
		System.out.println(">> WebMp3Phone - 음악플레이");
	}

}
