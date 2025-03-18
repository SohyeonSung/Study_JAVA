package edu.class1.basic;

//클래스 선언부
public class Ex02_class {
	//===== 변수 선언 영역 =========
	// 필드변수(인스턴스변수, 속성-property, 멤버변수, 전역변수) 선언
	// (변수 선언문에 static 키워드가 없는 변수)
	int num = 111;
	
	//스테틱(static) 변수, 클래스변수, 인스턴스(객체) 공통변수
	static int staticNum = 222;

	//===== 생성자 선언 영역 ========
	Ex02_class() { } // 기본생성자(default constructor) 생략가능
	
	
	//===== 메소드, 메소드(method) 선언 영역 ========
	// main() 메소드
	public static void main(String[] args) {
		// 로컬변수(지역변수)
		int num1 = 300;
		int num2 = 500;
		int result = num1 + num2;
		System.out.println("로컬변수 num1 : " + num1);
		System.out.println("로컬변수 num2 : " + num2);
		System.out.println("로컬변수 result : " + result);
		
		System.out.println("staticNum : " + staticNum);
		
		result = add(num1, num2);
		System.out.println("add() result : " + result);
		
		//System.out.println("인스턴스변수 num : " + num); //Cannot make a static reference to the non-static field num
		
		System.out.println("==== 객체(인스턴스) 생성 사용 ==========");
		Ex02_class ex02 = new Ex02_class(); //Ex02_class 타입의 인스턴스(객체) 생성
		System.out.println("ex02 : " + ex02);
		System.out.println("인스턴스변수 num : " + ex02.num);
		

	} //main() 끝
	
	// static 메소드
	static int add(int a, int b) {
		return a + b; // return : 호출한 곳으로 값을 되돌려줌
	}

	

}


// 변수 -> 생성사 -> 메소드 순으로 작성하는게 가독성을 높임!








