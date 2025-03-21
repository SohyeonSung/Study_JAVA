package com.mystudy.ex04_interface2;


// 인터페이스(interface) 구현(implements)하는 방식으로 클래스 만들기
class Phone implements I_Phone {
	
	// 필드(속성) ------------
	private String type; // 전화타입(형태)
	private String phoneNo; // 전화번호

	// 생성자 -------------
	public Phone() {
	}

	public Phone(String phoneNo) {
		this.type = "Phone 타입";
		this.phoneNo = phoneNo;
	}

	public Phone(String type, String phoneNo) {
		super();
		this.type = type;
		this.phoneNo = phoneNo;
	}

	// 메소드 -----------------
	public String getType() {
		return type;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
		

	@Override
	public void view() {
		System.out.println("Phone >> 타입 : " + type);
		
	}

	@Override
	public void call() {
		System.out.println("Phone >> 전화 걸기");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("Phone >> 전화 받기");
		
	}

	@Override
	public void sendMsg() {
		System.out.println("Phone >> 메세지 보내기");
		
	}

	@Override
	public void receiveMsg() {
		System.out.println("Phnoe >> 메세지 받기");
		
	}

	
	
	
}