
public class Ex01_if {

	public static void main(String[] args) {
		/*
		 * 제어문-분기문(비교문) : if 문 if (조건문) { 실행할 문장들(조건이 참일때); } ------------
		 */
		int num1 = 10;
		int num2 = 20;
		if (num1 < num2) {
			System.out.println("num1이 num2 보다 작다");
		}
		System.out.println(">> 비교작업 끝");
		System.out.println("----------");

		boolean result = num1 < num2;
		if (result) {
			System.out.println("num1이 num2 보다 작다");
		}
		System.out.println(">> 비교작업 끝2");
		System.out.println("=========================");
		/* 점수 평가 결과 출력
		90 ~ 100 : A
		80 ~ 89 : B
		70 ~ 79 : C
		60 ~ 69 : D
		0 ~ 59 : F
		--------- */
		System.out.println("--- 성적처리 ---");
		String name = "홍길동";
		int score = 90;
		String result2 = "평가안됨";
		
		System.out.println("이름 : " + name);
		System.out.println("점수 : " + score);
		
		if (score >= 90 && score <= 100) {
			//System.out.println("::평가결과 : A");
			result2 = "A";
		}
		if (score >= 80 && score <= 89) {
			//System.out.println("::평가결과 : B");
			result2 = "B";
		}
		if (score >= 70 && score <= 79) {
			//System.out.println("::평가결과 : C");
			result2 = "C";
		}
		if (score >= 60 && score <= 69) {
			//System.out.println("::평가결과 : D");
			result2 = "D";
		}
		if (score >= 0 && score <= 59) {
			//System.out.println("::평가결과 : F");
			result2 = "F";
		}
		System.out.println("::평가결과 : " + result2);
		
		System.out.println(">> 성적처리 끝 ----------");

	}

}





