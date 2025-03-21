package com.mystudy.ex06_type_casting;

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
		System.err.println("타입 : " + am.type);
		am.drive();
		am.stop();
		am.siren();
		
	
		System.out.println("=== [Fire Truck 클래스] ===");
		FireTruck ft = new FireTruck();
		ft.type = "소방차";
		System.err.println("타입 : " + ft.type);
		ft.drive();
		ft.stop();
		ft.siren();
		ft.water();
		
		
		
		System.out.println();
		System.out.println();
		
		
		
		
		System.out.println("=== [형변환] ===");
		Car carTemp = new Car();
		carTemp.drive();
		carTemp.stop();
		//carTemp.siren(); -> undifined : Car 타입에는 siren() 없음. 정의되지 않음

		
		System.out.println("=== [Car <- Ambulance 저장] ===");
		// Car <- Ambulance 저장 = 부모 타입 <- 자녀타입 (자동 형변환)
		// Car car2 = new Ambulance();
		carTemp = am; //Car <- Ambulance (자동형변환)
		carTemp.drive();
		carTemp.stop();
		// carTemp.siren(); -> undifined : Car 타입에는 siren() 없음. 정의되지 않음
		
		
		System.out.println("=== [Ambulance <- Car 저장 (실체 Ambulance)] ===");
		Car car2 = new Car();
		//Ambulance am2 = (Ambulance) car2; //실행시 ClassCastException 오류 : 실체가 Car 이므로
		Car car3 = new Ambulance();
		Ambulance am2 = (Ambulance) car3;
		am2.drive();
		am2.stop();
		am2.siren();

		
		System.out.println("=== [carTemp에 저장된 앰뷸런스 사이렌 울리기] ===");
		// Car에 저장된 Ambulance 객체(인스턴스)를 사용할때
		// siren() 메소드 사용하려면 Ambulance 타입이 되어야함
		// (앰뷸런스).siren()
		((Ambulance)carTemp).siren(); //Ambulance로 형변환 후 siren() 사용

	
	}
	

}























