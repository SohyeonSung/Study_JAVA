package com.mystudy.ex04_interface2;

//인터페이스는 static final 속성값, 추상(abstract)메소드가 있다
interface I_Phone { //public 있고, 없고

	
	// {} 없음 : 추상메소드 (abstract method)
	// 인터페이스에 정의된 추상메소드는 모두 public abstract 메소드
	public abstract void view(); //전화번호 확인
	public void call(); //전화걸기 (abstract 생략)
	void receiveCall(); //전화받기 (public, abstract 생략)
	void sendMsg(); //메세지 보내기 (public, abstract 생략)
	void receiveMsg(); //메세지 받기 (public, abstract 생략)

	
	
	
	

	
}

