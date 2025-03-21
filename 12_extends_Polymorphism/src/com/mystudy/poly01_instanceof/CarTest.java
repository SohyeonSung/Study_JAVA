package com.mystudy.poly01_instanceof;

//import sun.jvm.hotspot.runtime.StaticBaseConstructor;

public class CarTest {

	public static void main(String[] args) {
		
		System.out.println("=== [CAR 클래스] ===");
		Car car =new Car();
		car.type = "자동차";
		System.out.println("타입 : " + car.type);
		car.drive();
		car.stop();

		
		System.out.println("=== [Ambulance 클래스] ===");
		Ambulance am = new Ambulance();
		am.type = "구급차";
		System.out.println("타입 : " + am.type);
		am.drive();
		am.stop();
		am.siren();
		
	
		System.out.println("=== [Fire Truck 클래스] ===");
		FireTruck ft = new FireTruck();
		ft.type = "소방차";
		System.out.println("타입 : " + ft.type);
		ft.drive();
		ft.stop();
		ft.siren();
		ft.water();
		
		
		
		System.out.println();
		System.out.println();
		
		
		
		
		System.out.println("=== [형변환] ===");
		Car carTemp = car;  // Car <--- Car
		//carTemp = am; // Car <- Ambulance
		carTemp = ft; // Car <- FireEnging
		System.out.println("자동차타입 : " + carTemp.type);
		
		System.out.println("- 타입확인(instanceof) -");
		if (carTemp instanceof Object) {
			System.out.println(">> Object 타입이다");
		}
		if (carTemp instanceof Car) {
			System.out.println(">> Car 타입이다");
		}
		if (carTemp instanceof Ambulance) {
			System.out.println(">> Ambulance 타입이다"); 
			((Ambulance) carTemp).siren();
			
		}
		if (carTemp instanceof FireTruck) {
			System.out.println(">> FireTruck 타입이다");
			carTemp.drive();
			carTemp.stop();
			((FireTruck) carTemp).water(); //형변환 // Car -> FireTruck 형변환 후 water()
			((FireTruck) carTemp).siren(); //형변환 // Car -> FireTruck 형변환 후 siren()
		
		
		}
		
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("Car 타입 객체 전달 사용");
		typeCheck(car);
		
		System.out.println("--------------------");
		
		System.out.println("Fire Truck 타입 객체 전달 사용");
		typeCheck(ft);
		
		System.out.println("--------------------");
		
		System.out.println("Ambulance 타입 객체 전달 사용");
		typeCheck(am);
		
		
		
		
	}
	
	//메소드 오버로딩
	static void typeCheck(Car car) {
		System.out.println(":: Car 타입입니다");
		car.drive();
		car.stop();
		
	}
	
	static void typeCheck(FireTruck ft) {
		System.out.println(":: Car 타입입니다");
		ft.drive();
		ft.stop();
		
		System.out.println(":: Fire Truck 타입입니다");
		ft.siren();
		ft.water();
		
	}
	
	static void typeCheck(Ambulance am) {
		System.out.println(":: Car 타입입니다");
		am.drive();
		am.stop();
		
		System.out.println(":: Ambulance 타입입니다");
		am.siren();
		
	}
	
	
	
}























