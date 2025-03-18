package array1;

import java.util.Arrays;

public class Ex05_array_lotto {

	public static void main(String[] args) {
		// 난수(랜덤값) 생성 - Math.random()
		// 0 <= Math.random() < 1 : 0 부터 1 미만의 실수값(double) 생성
		// Math.random() : 0.00000 ~ 9.99999999... (0.0 <= 값 < 1)
		// (int)(Math.random() * 45) : 0 ~ 44 랜덤값 생성
		System.out.println("Math.random() : " + Math.random());
/*		
		System.out.println("--- Math.random() -------");
		for (int i = 1; i <= 1000; i++) {
			//System.out.println((int)(Math.random() * 2)); // 정수부 : 0, 1
			//System.out.println((int)(Math.random() * 3); // 정수부 : 0, 1, 2
			//System.out.println((int)(Math.random() * 5); // 정수부 : 0, 1, 2, 3, 4
			System.out.println((int)(Math.random() * 45) + " "); //정수부 : 0 ~ 44
		}
*/		
		System.out.println("======= 로또 번호 생성 =========");
		//=========================
		//(실습)로또 번호 생성기
		//1. int 타입의 숫자 45개를 저장할 수 있는 배열 선언(balls)
		//2. 초기화 : 1~45 까지의 숫자(번호)를 입력
		//3. 충분히 많이 섞고
		//   3-1 : 0~44 임의의 숫자 생성(Math.random() 사용)
		//   3-2 : 0번 인덱스 위치값과 랜덤인덱스(0~44) 위치값을 서로 맞교환
		//   3-1,3-2 반복(충분히 많이)
		//4. 6개 번호를 추출(앞에서 부터 6개)
		//-------------------------------------
		//1. int 타입의 숫자 45개를 저장할 수 있는 배열 선언(balls)
		int[] balls = new int[45];
		System.out.println("balls.length : " + balls.length);
		
		System.out.println("--- 배열값 확인 ---");
		for (int i = 0; i < balls.length; i++) {
			System.out.print(balls[i] + " ");
		}
		System.out.println();
		
		//2. 초기화 : 1~45 까지의 숫자(번호)를 입력
		System.out.println("--- 초기화 작업 ---");
		for (int i = 0; i < balls.length; i++) {
			balls[i] = i + 1;
		}
		
		for (int i = 0; i < balls.length; i++) {
			System.out.print(balls[i] + " ");
		}
		System.out.println();
		
		System.out.println("--- 충분히 많이 섞고 ----");
		//3. 충분히 많이 섞고
		//   3-1 : 0~44 임의의 숫자 생성(Math.random() 사용)
		//   3-2 : 0번 인덱스 위치값과 랜덤인덱스(0~44) 위치값을 서로 맞교환
		//   3-1,3-2 반복(충분히 많이)
		//System.out.println("(int)(Math.random() * 45) : " + (int)(Math.random() * 45));
		//------------------
		//   3-1 : 0~44 임의의 숫자 생성(Math.random() 사용)
		//   3-2 : 0번 인덱스 위치값과 랜덤인덱스(0~44) 위치값을 서로 맞교환
		//   3-1,3-2 반복(충분히 많이)
		
		for (int i = 1; i <= 1_000_000; i++) {
			int ran = (int)(Math.random() * 45);
			//System.out.println("ran : " + ran);
		
			int temp = balls[0];
			balls[0] = balls[ran];
			balls[ran] = temp;
		}
		
		System.out.println(">> 충분히 많이 교환 후 ---- ");
		for (int i = 0; i < balls.length; i++) {
			System.out.print(balls[i] + " ");
		}
		System.out.println();
		
		System.out.println("--- 로또번호 6개 선택 ----");
		//4. 6개 번호를 추출(앞에서 부터 6개)
		for (int i = 0; i < 6; i++) {
			System.out.print(balls[i] + " ");
		}
		System.out.println();
		
		System.out.println("---- 당첨번호 별도 저장하기 ------");
		int[] lottoNums = new int[6];
		for (int i = 0; i < 6; i++) {
			lottoNums[i] = balls[i];
		}
		System.out.println("로또번호 : " + Arrays.toString(lottoNums));
		
		//=================
		// Arrays.sort() 사용 오름정렬 처리
		Arrays.sort(lottoNums);
		System.out.println("정렬된 로또번호 : " + Arrays.toString(lottoNums));
		
	}
	
	

}













