package com.mystudy.poly02_overriding;

class TypeTest {

	public static void main(String[] args) {
		
		System.out.println(" == 기본 == ");
		
		Animal an = new Animal();
		Cat cat = new Cat();
		Dog dog = new Dog();
		Pig pig = new Pig();

		cat.sound();
		dog.sound();
		pig.sound();
		
		
		System.out.println(" == (1) 메소드 오버로딩 == ");
		sound_overloading(cat);
		sound_overloading(dog);
		sound_overloading(pig);
		
		System.out.println(" == (2) instance of == ");
		sound_instanceof(cat);
		sound_instanceof(dog);
		sound_instanceof(pig);
		
		System.out.println(" == (3) 메소드 오버라이딩(overriding) ==");
		sound(cat);
		sound(dog);
		sound(pig);
		
	}
	
	
	// (1) 메소드 오버로딩 (overloading)방식
	static void sound_overloading(Cat cat) {
		cat.sound();
	}

	static void sound_overloading(Dog dog) {
		dog.sound();
	}
	static void sound_overloading(Pig pig) {
		pig.sound();
	}


	
	// (2) instance of 방식
	static void sound_instanceof(Animal animal) {
		if (animal instanceof Cat) {
			((Cat) animal).sound(); // 형변환
		} else if (animal instanceof Dog) {
			((Dog) animal).sound(); // 형변환
		} else if (animal instanceof Pig) {
			((Pig) animal).sound(); // 형변환
		}

	}

	
	// (3) 메소드 오버라이딩 방식
	static void sound(Animal animal) {
		animal.sound();
	}

}
