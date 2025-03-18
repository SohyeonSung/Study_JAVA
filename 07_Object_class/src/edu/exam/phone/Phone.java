package edu.exam.phone;

import javax.management.modelmbean.ModelMBean;

public class Phone {
	//속성(필드변수) 선언
	String model; //모델명
	String type; //타입
	int hsize; //가로크기
	int vsize; //세로크기
	boolean hasLCD; //LCD 유무
	
	//생성자 -------------
	Phone() {} // 기본생성자
	
	Phone(String model, String type) {
		this.model = model; // this : 현재객체(인스턴스)
		this.type = type;
	}
	
	Phone(String model, String type, boolean hasLCD) {
		this.model = model;
		this.type = type;
		this.hasLCD = hasLCD;
	}
	
	//메소드 -------------
	//전화걸기
	void call() {
		System.out.println(">>전화걸기");
	}
	
	//전화받기
	void receiveCall() {
		System.out.println(">>전화받기");
	}
	
	//메시지 보내기
	void sendMsg(String msg) {
		System.out.println("[메시지전송] " + msg);
	}
	
	//메시지 받기
	String receiveMsg(String msg) {
		System.out.println("[메시지수신] " + msg);
		return "###" + msg + "###";
	}
	
	//전화기 정보 화면 출력 기능
	void view() {
		System.out.println("-- 전화기 정보 --");
		System.out.println("모델명 : " + model);
		System.out.println("타입 : " + type);
		System.out.println("가로크기 : " + hsize);
		System.out.println("세로크기 : " + vsize);
		System.out.println("LCD유무 : " + hasLCD);
	}
	
}

