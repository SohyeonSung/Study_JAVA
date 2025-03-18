
public class Ex06_for_star {

	public static void main(String[] args) {
		// ***** 화면 출력
		System.out.println("*****");
		System.out.println("-------------");
		
		System.out.print("*****");
		System.out.println(); //줄바꿈 역할
		System.out.println("-------------");
		
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		
		System.out.println(); //줄바꿈 역할
		
		System.out.println("--- 반복문 print * 찍기 반복 ---");
		for (int i = 1; i <= 5; i++) {
			System.out.print("*");
		}
		System.out.println(); //줄바꿈 역할
		System.out.println("=================");
		
		/* 문제 : 3개 행 출력 처리(각 행에 * 5개 출력)
		*****
		*****
		*****
		--------------- */
		System.out.print("*****");
		System.out.println();
		
		System.out.print("*****");
		System.out.println();
		
		System.out.print("*****");
		System.out.println();
		
		System.out.println("--- 반복문 1번 적용 ----------");
		for (int i = 1; i <= 5; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i = 1; i <= 5; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i = 1; i <= 5; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.println("==== for문 중첩(이중) 사용 ====");
		for (int line = 1; line <= 3; line++) {
			for (int i = 1; i <= 5; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("===================");
		
		for (int i = 1; i <= 3; i++) {
			System.out.print("*****");
			System.out.println();
		}
		System.out.println("-----------------");
		
		for (int i = 1; i <= 3; i++) {
			for (int star = 1; star <= 5; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//==============================
		System.out.println("==== 삼각형 * 찍기 ========");
		/* 화면(콘솔창)에 삼각형 모양을 출력
		*     : * 출력 1번 + 줄바꿈
		**    : * 출력 2번 + 줄바꿈
		***   : * 출력 3번 + 줄바꿈
		****
		*****
		---------------- */
		//System.out.print("*");
		//System.out.println();
		
		for (int i = 1; i <= 1; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i = 1; i <= 2; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i = 1; i <= 3; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i = 1; i <= 4; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i = 1; i <= 5; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("===============");
		int starCnt = 1;
		for (int line = 1; line <= 5; line++) {//5번 반복
			for (int star = 1; star <= starCnt; star++) {
				System.out.print("*");
			}
			System.out.println();
			starCnt++;
		}
		System.out.println("-----------------");
		
		/* 화면(콘솔창)에 삼각형 모양을 출력
		*     1라인 : * 출력 1번 + 줄바꿈
		**    2라인 : * 출력 2번 + 줄바꿈
		***   3라인 : * 출력 3번 + 줄바꿈
		****
		*****
		---------------- */
		for (int line = 1; line <= 5; line++) {
			for (int star = 1; star <= line; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}








