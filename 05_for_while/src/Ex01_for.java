
public class Ex01_for {
	
	public static void main(String[] args) {
		//제어문 - 반복문(for, while, do ~ while)
		// for (초기값설정 ; 실행(종결)조건 ; 증감설정) { }
		// 실행(종결)조건이 true 일 때 실행문 처리
		// for ( ; ; ) { } //무한반복
		//-------------------------
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("----------");
		
		// for (초기값설정 ; 실행(종결)조건 ; 증감설정) { }
		for (int i = 1; i <= 3; i++) { // i값이 1부터 3까지 변하는 동안 3번 반복
			System.out.println("i : " + i);
			System.out.println("*");
		}
		System.out.println("----------");
		
		for (int i = 1; i <= 5; i++) { //5번 반복 : 1, 2, 3, 4, 5
			System.out.println("*****");
		}
		System.out.println("----------");
		
		for (int i = 0; i < 5; i++) { //5번 반복 : 0, 1, 2, 3, 4
			System.out.println("홍길동");
		}
		//============================
		System.out.println("===== 1 부터 10까지 출력 =====");
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println("...");
		System.out.println(10);
		
		System.out.println("---- num 변수사용 -----");
		//별도의 변수(num) 사용해서 출력
		int num = 1;
		for (int i = 1; i <= 10; i++) {
			//System.out.println(num);
			//num++;
			System.out.println(num++);
		}
		
		System.out.println("--- 반복인자 i값 사용 -----");
		//반복인자 값을 사용해서 출력
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		System.out.println("--- 2씩 증가처리 적용 ---");
		// i값을 2씩 증가처리
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i);
		}
		
		
	}
	
}