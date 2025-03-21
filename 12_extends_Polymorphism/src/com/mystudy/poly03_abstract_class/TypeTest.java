package com.mystudy.poly03_abstract_class;

import javax.xml.catalog.Catalog;

//import jdk.internal.jshell.tool.resources.l10n;

class TypeTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.eat();
		cat.sleep();
		cat.sound();
		
		Dog dog = new Dog(); 		
		dog.sound();
		
		Pig pig = new Pig(); 
		pig.sound();

		
		System.out.println("--------------------");
		
		sound(cat);
		sound(dog);
		sound(pig);
		
	}
	
	static void sound(AbstractAnimal animal) {
		animal.sound();
	}

}
