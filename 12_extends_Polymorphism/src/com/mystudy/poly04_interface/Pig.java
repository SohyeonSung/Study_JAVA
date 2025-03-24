package com.mystudy.poly04_interface;

class Pig extends AbstractAnimal {
	
	
	public Pig() {
		super("돼지");
	}

	@Override
	public void sound() {
		System.out.println(">>꿀꿀~~");
	}
	
	public void eat() {
		System.out.println(">>야무지게 먹눈다");
	}
	


}
