package com.mystudy.ex04_interface2;

//I_Phone 기능(전화정보확인, 전화걸고, 전화받고, 문자주고, 문자받고)
//I_Mp3Phone 기능(음악플레이)
//웹검색 기능
//----------------------
interface I_WebPhone extends I_Phone, I_Mp3Phone {
	//I_Phone 기능 정의 ----------
//	public abstract void view(); //전화정보 확인
//	public void call(); //전화걸기
//	void receiveCall(); //전화받기
//	void sendMsg(); //메시지 보내기
//	void receiveMsg(); //메시지 받기
	
//	Mp3Phone 기능(음악플레이) ----------
	void playMusic();
	
	//웹검색 기능
	void searchWeb();
	
}
