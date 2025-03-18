package edu.class2.car;

public class CarMain {

	public static void main(String[] args) {
		System.out.println("[Car Main]");
		
		
		
		
		System.out.println("======Car1 사용======");
		//Car 클래스 이용해서 Car 타입의 객체 (인스턴스) 생성
		Car car1 = new Car ();
		
		System.out.println("car 1 : " + car1);
		System.out.println("차량명 : " + car1.name);
		System.out.println("모델명 : " + car1.model);
		System.out.println("색상명 : " + car1.color);
		System.out.println("에어백 : " + car1.hasAirbag);
		System.out.println("길이 : " + car1.CAR_LENGTH);
		System.out.println("폭 : " + car1.CAR_WIDTH);
		car1.run();
		car1.stop();
		car1.back();
		
		
		
		
		
		System.out.println("======Car2 사용======");
		//Car car2 = new Car();
		Car car2 = new Car("말랑이", "911", "노랑노랑");
		
		car2.displayData();
		
		car2.run();
		car2.stop();
		car2.back();
		
		
		
		
		
		
		
		
		
		
	}

}
