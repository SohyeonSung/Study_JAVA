package edu.class1.basic;

/* === 메소드 4가지 형태 ===
 * 
 * 1. 리턴값 없음, 파라미터 없음
 * 		- void 메소드명 () {}
 *                  
 * 2. 리턴값 없음, 파라미터 있음 (1~n개)
 *		- void 메소드명 (파라미터 타입 변수명, ....) {}
 *  
 *  3. 리턴값 있음, 파라미터 없음
 *		- 리턴타입 메소드명() {}
 *   
 *  4. 리턴값 있음, 파라미터 있음
 *		- 리턴타입 메소드명(파라미터 타입 변수명, ...)
 */

public class Ex03_method {

	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 200;
		int sum = 0;
		
		sum = add(num1, num2); //메소드 실행 (호출)
		System.out.println("sum : " + sum);
		
		
		//static 영역에서 non-static 영역 접근시 객체(인스턴스)를 통해서 사용
		Ex03_method ex03 = new Ex03_method();
		System.out.println("sub() : " + ex03.sub(num1, num2));
		System.out.println("mul() : " + ex03.mul(num1, num2));
		System.out.println("div() : " + ex03.div(num1, num2));
		
		System.out.println("------------------------");
		
		System.out.println("add() : " + ex03.add(num1, num2));

	}
	
	//메소드 선언 (static 메소드)
	static int add (int num1, int num2) {
		return num1 + num2;
		
	}
	//메소드 선언 ((non-static) 메소드)
	//인스턴스 메소드 : static이 없는 메소드
	int sub (int a, int b) {
		return a - b;
	}
	
	int mul (int a, int b) {
		return a * b;
	}
	
	int div (int a, int b) {
		return a/b;
	}
	
	
	//--------------------
	void method1() {
		System.out.println("파라미터 값 X, 리턴 값 X ");
	}
	
	void method2(String param) {
		System.out.println("파라미터 값 O , 리턴 값 X ");
	}
	
	String method3() {
		System.out.println("파라미터 값 X, 리턴 값 O ");
		return "파라미터 값 X, 리턴 값 O ";
	}
	
	String method4(String param) {
		System.out.println("파라미터 값 O, 리턴 값 O ");
		return "파라미터 값 O, 리턴 값 O ";
	}
	
	
	
	
	
	
	
	
	

}
