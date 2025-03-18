
public class Ex02_for_exam {

	public static void main(String[] args) {
		// for (초기값설정 ; 실행(종결)조건 ; 증감설정) { }
		//(실습) 1,2,3,4,5 화면출력
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		
		System.out.println("--- 11,12,13,14,15 화면출력 ---------");
		//(실습) 11,12,13,14,15 화면출력
		int num = 11;
		for (int i = 1; i <= 5; i++) {
			System.out.println(num);
			num++;
		}
		System.out.println("---");
		for (int i = 11; i <= 15; i++) {
			System.out.println(i);
		}
		System.out.println("------------");
		
		//(실습) 1 3 5 7 9 화면출력
		for (int i = 1; i <= 9; i += 2) {
			System.out.println(i);
		}
		System.out.println("------------");
		
		//(실습) 2 4 6 8 10 화면출력
		for (int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("------------");
		
		//(실습) 5,4,3,2,1 화면출력
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
		
		
		
	}

}










