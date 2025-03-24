package com.mystudy.poly04_interface;

abstract class AbstractAnimal implements Animal {
	private String name = "동물";
	
	public AbstractAnimal() {}
	public AbstractAnimal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void eat() {
		System.out.println(">>먹는다");
	}
	
	@Override
	public void sleep() {
		System.out.println(">>잠을잔다");
	}
	
	//추상메소드 작성을 안해도 됨
//	@Override
//	public abstract void sound();

	
}




