package com.mystudy.ex03_interface;

class Phone {
	
	private String type;
	private String phoneNo;
	
	public Phone() {}
	public Phone(String phoneNo) {
		this.type = "Phone 타입" ;
	}
	
	public Phone(String type, String phoneNo) {
		super();
		this.type = type;
		this.phoneNo = phoneNo;
	}
	
	
	//메소드 -----------------
	public String getType() {
		return type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	//전화걸기 기능
	public void call() {
		System.out.println("Phone>> 전화걸기");
	}
	
	//전화받기 기능
	public void receiveCall() {
		System.out.println("Phone>> 전화받기");
	}
	
	//전화정보 보기
	public void view() {
		System.out.println("Phone>>타입: " + type + ", 전화번호: " + phoneNo);
	}
	

	//메세지 보내기
	public void sendMsg() {
		System.out.println("Msg>> 메세지 보내기");
	}
	
	//메세지 받기
	public void receiveMsg() {
		System.out.println("Msg>> 메세지 받기");
	}
	
	
	
	
	
	
	
	
	
	
}














