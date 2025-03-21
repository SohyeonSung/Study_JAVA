package com.mystudy.poly02_overriding;

class Animal {
	String name; // 이름
	int legCnt; // 다리의 수
	
	void eat() {
		System.out.println(">> 먹는다");
	}
	void sleep() {
		System.out.println(">> 잠을 잔다");
	}
	
	void sound() {
		System.out.println(":: 울음소리 없음!");
	}
	

}
