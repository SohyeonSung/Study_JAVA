package edu.class2.car;


/* 
 * 자동차 클래스
 * 속성 : 차량명, 모델명, 차량색상
 * 기능 : 가고, 서고, 뒤로가고, 차량정보확인
 */

public class Car {
	// 필드 변수 (속성)
	String name = "붕붕이"; //차량명
	String model = "G63"; //모델명
	String color = "화이트"; //차량색상
	
	boolean hasAirbag; //에어백 장착 여부 (T/F)
	
	// final 제한자 : 변수에 값이 할당되면 더이상 변경할 수 없음 (설정값 불변)
	// final 붙은 변수 : 상수화
	
	final int CAR_LENGTH = 350; //차량길이 (ctrl + shift + X : 대문자)
	                            //       (             + Y : 소문자)  
	final int CAR_WIDTH = 200;
	
	
	// 생성자
	// 클래스명(){} - 기본 생성자
	// 클래스명(매개변수, ...){}
	// 주의 : 명시적으로 생성자 선언시 기본생성자 만들어 주지 않음
	Car(){}
	
	Car(String n, String m, String c) {
		name = n;
		model = m;
		color = c;
	}
	


	//메소드 (기능, 동작, 함수)
	void run() {
		System.out.println(">> 앞으로 이동");

	}
	
	void stop() {
		System.out.println(">> 멈추기");
	}
	
	void back() {
		System.out.println(">> 뒤로가기");
	}
	
	void displayData() {
		System.out.println("차량명 : " + name);
		System.out.println("모델명 : " + model);
		System.out.println("색상명 : " + color);
		System.out.println("에어백 : " + hasAirbag);
		System.out.println("길이 : " + CAR_LENGTH);
		System.out.println("폭 : " + CAR_WIDTH);
	}
	
	
	
	
	
	
	
	
	
	
	

}
