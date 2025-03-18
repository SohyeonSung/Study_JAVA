package array1;

public class Ex02_array2_exam {

	public static void main(String[] args) {
		//문제1 : 1~10 까지의 수를 배열(nums)에 저장(반복문사용) 하고
		//     배열데이터 출력(확인) 
		//배열선언 : 1. 자료형[] 변수명 = new 자료형[갯수];
		//출력 형태 : 변수명[인덱스번호] : 값
		//nums[0] : 1
		//nums[1] : 2
		//nums[2] : 3
		//------------------------------------
		int[] nums = new int[10];
		System.out.println("nums.length : " + nums.length);
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println("nums[" + i + "] : " + nums[i]);
		}
		
		System.out.println("==================");
		/*(실습)문제 : 다음 숫자를 배열(nums2)에 저장하고 홀수의 합 구하기(배열사용)
		저장할 숫자 : 3, 8, 7, 10, 6, 9, 1, 5, 2, 4
		0. 위의 숫자가 저장된 배열을 만드세요.
		1. 배열에 저장된 데이터를 화면 출력(반복문)
		2. 배열에 저장된 데이터의 합계 구하기(반복문)
		3. 합계결과 출력
		------------------------ */
		//0. 위의 숫자가 저장된 배열을 만드세요.
		int[] nums2 = {3, 8, 7, 10, 6, 9, 1, 5, 2, 4};
		
		//1. 배열에 저장된 데이터를 화면 출력(반복문)
		for (int i = 0; i < nums2.length; i++) {
			System.out.print(nums2[i] + " ");
		}
		System.out.println();
		
		//2. 배열에 저장된 데이터의 합계(홀수만) 구하기(반복문)
		int sum = 0;
		for (int i = 0; i < nums2.length; i++) {
			if (nums2[i] % 2 != 0) {
				System.out.println(nums2[i]);
				sum += nums2[i];
			}
		}
		
		//3. 합계결과 출력
		System.out.println("홀수합 sum : " +  sum);

	}

}








