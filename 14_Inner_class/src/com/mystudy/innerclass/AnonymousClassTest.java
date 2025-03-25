package com.mystudy.innerclass;

interface TestInter {
	int DATA = 100;
	void printData(); //추상메소드
}

//인터페이스를 구현한 클래스
class TestInterImpl implements TestInter {
	@Override
	public void printData() {
		System.out.println(">>> 구현한 메소드");
	}
}

public class AnonymousClassTest {

	public static void main(String[] args) {
		TestInterImpl imp = new TestInterImpl();
		imp.printData();
		
		TestInterImpl imp2 = new TestInterImpl();
		imp2.printData();
		
		//익명클래스 : 클래스에 이름이 없는 클래스
		//객체 생성해서 1번만 사용
		(new TestInter() {
			@Override
			public void printData() {
				System.out.println("익명클래스 DATA : " + DATA);
			}
		}).printData();
		
		//생성객체를 변수에 저장 사용
		TestInter test = new TestInter() {
			@Override
			public void printData() {
				System.out.println(">>> 익명클래스 DATA : " + DATA);
			}
		};
		test.printData();
		
		//=======================================
		
		//함수형 인터페이스 : 인터페이스에 추상 메소드가 1개만 선언된 인터페이스
		//람다식으로 작성 : () -> {}
		TestInter test2 = () -> {
			System.out.println(">>> 람다식 : 함수형 인터페이스 메소드 구현");
		};
		test2.printData();
		
		

	}

}











