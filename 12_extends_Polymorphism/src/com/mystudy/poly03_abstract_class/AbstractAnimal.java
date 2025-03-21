package com.mystudy.poly03_abstract_class;

// 추상클래스 : abstract class
// 클래스에 추상메소드가 1개라도 있으면 추상클래스로 선언
// 추상클래스는 객체(인스턴스) 생성 못함
abstract class AbstractAnimal {
	String name; //이름, 명칭
	int legCnt; //다리갯수
	
	void eat() {
		System.out.println(">>먹는다");
	}
	
	void sleep() {
		System.out.println(">>잠을 잔다");
	}
	
	abstract void sound(); //추상 메소드(abstract 메소드)
	
}
