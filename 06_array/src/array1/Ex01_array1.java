package array1;

import java.util.Arrays;

public class Ex01_array1 {

	public static void main(String[] args) {
		// 배열(array) : 동일한 데이터 타입들의 연속된 저장 공간
		// 배열의 선언 : 자료형[] 변수명;
		// 배열에 값 저장 : 배열변수명[인덱스번호] = 값;
		/* 배열의 선언 및 생성
		1. 자료형[] 변수명 = new 자료형[크기];
		   자료형 변수명[] = new 자료형[크기];
		2. 자료형[] 변수명 = new 자료형[] {값1, 값2, 값3, ..., 값n};
		3. 자료형[] 변수명 = {값1, 값2, 값3, ..., 값n}; //n개의 저장공간생성 + 값저장
		-------------- */
		int[] arr = new int[5]; //int 타입값 5개 저장할 수 있는 배열 arr 선언
		System.out.println("arr : " + arr); //배열 - 참조형 데이터
		System.out.println("arr[0] : " + arr[0]);
		arr[0] = 10; //배열의 첫번째 위치(인덱스번호 0)에 10 설정(저장)
		
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		
		arr[1] = 11; //두번째
		arr[2] = 12;
		arr[3] = 13;
		arr[4] = 14; // 마지막 데이터(크기 - 1)
		//arr[5] = 15; //ArrayIndexOutOfBoundsException: 5
		System.out.println("--------");
		
		//배열의 전체 데이터 화면 출력
		System.out.println("--- 배열데이터 화면 출력 ---");
		System.out.println("arr.length : " + arr.length);
		for (int i = 0; i < 5; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
		System.out.println("---");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
		System.out.println("---------");
		
		//배열 데이터의 합계 구하기
		int sum = 0;
		sum = sum + arr[0]; // sum += arr[0]
		sum = sum + arr[1];
		sum = sum + arr[2];
		sum = sum + arr[3];
		sum = sum + arr[4];
		System.out.println("sum : " + sum);
		
		System.out.println("--- 합계(for문) ------");
		//(실습)위의 문장을 반복문으로 작성해서 합계구하기
		sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println("sum : " + sum);
		
		//===============================
		//2. 자료형[] 변수명 = new 자료형[] {값1, 값2, 값3, ..., 값n};
		System.out.println("===== 배열 선언 형태 2번 ======");
		//                     0    1    2    3    4 : 인덱스 번호
		int[] num = new int[] {100, 101, 102, 103, 104};
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
		
		//3. 자료형[] 변수명 = {값1, 값2, 값3, ..., 값n};
		//3번 방식은 변수 선언문과 함께만 사용가능
		System.out.println("===== 배열 선언 형태 3번 ======");
		int[] arr3 = {10, 11, 12, 13, 14, 15};
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		System.out.println("======================");
		
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		//초기값 설정 : 1, 2, 3, ....
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		System.out.println();
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		System.out.println("======================");
		System.out.println("=== 영어 알파벳 저장 출력(A~Z) ====");
		char[] ch = new char[26];
		System.out.println(Arrays.toString(ch));
		System.out.println("-" + ch[0] + "-");
//		ch[0] = 'A'; //65
//		System.out.println("ch[0] : " + ch[0]);
//		ch[1] = 'B'; //66
//		System.out.println("ch[1] : " + ch[1]);
//		ch[2] = 'B' + 1; //66 + 1 ---> 67
//		System.out.println("ch[2] : " + ch[2]);
		System.out.println("--------");
		
		ch[0] = 'A' + 0; //65 : A
		ch[1] = 'A' + 1; //66 : B
		ch[2] = 'A' + 2; //67 : C
		ch[3] = 'A' + 3; //68 : D
		
		//(개인적) 반복문으로 만들어 A~Z까지 입력
		
		System.out.println(Arrays.toString(ch));
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println(">>> main() 메소드 끝 ");
	}

}
















