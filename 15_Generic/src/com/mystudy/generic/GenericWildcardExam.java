package com.mystudy.generic;

class BoxT<T> {
	T obj; 
	void setObj(T obj) { this.obj = obj; }
	T getObj() { return obj; }
}

public class GenericWildcardExam {

	public static void main(String[] args) {
		// 제네릭(Generic)의 대표문자(wildcard)
		//  1. <?> : 모든 타입(객체) 자료형에 대한 대표문자를 의미
		//  2. <? extends 자료형> : 자료형을 상속받은 자녀(sub) 클래스 타입 사용
		//  3. <? super 자료형> : 자료형의 부모(super) 타입 사용           
		//-------------------------------------------------------
		BoxT<String> box1 = new BoxT<String>();
		box1.setObj("문자열");
		//box1 = new BoxT<Integer>(); //Type mismatch: cannot convert from BoxT<Integer> to BoxT<String>
		
		BoxT<Integer> box2 = new BoxT<>();
		box2.setObj(1000);
		
		System.out.println("----------------");
		// <?> 모든 것을 담을 수 있는 형태
		BoxT<?> box3 = new BoxT<String>();
		box3 = new BoxT<Integer>();
		box3 = new BoxT<StringBuilder>();
		
		// <? extends 자료형> : 자료형을 상속받은 자녀(sub) 클래스 타입 사용
		BoxT<? extends Number> boxExtends = null;
		boxExtends = new BoxT<Number>();
		boxExtends = new BoxT<Integer>();
		boxExtends = new BoxT<Double>();
		
		// <? super 자료형> : 자료형의 부모(super) 타입 사용  
		BoxT<? super Number> boxSuper = null;
		boxSuper = new BoxT<Number>();
		boxSuper = new BoxT<Object>();
		
		//boxSuper = new BoxT<Integer>(); //Type mismatch
		

	}

}

