package com.mystudy.poly04_interface;

class Cat extends AbstractAnimal {
	
	public Cat() {
		super("고양이");
	}
	public Cat(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println(">>야옹~~");
	}
	
	public void jump() {
		System.out.println(">>폴짝 뛴다~~~");
	}


}



