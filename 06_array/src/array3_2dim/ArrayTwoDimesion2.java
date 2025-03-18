package array3_2dim;

import java.util.Arrays;

public class ArrayTwoDimesion2 {

	public static void main(String[] args) {
		// 2차원 배열 선언 및 객체 생성
		// 타입[][] 변수명 = new 타입[크기][크기];
		// 타입  변수명[][] = new 타입[크기][크기];
		// 타입[][] 변수명 = { {..}, {..}, ..., {..} };
		//---------------------
		int[][] nums = new int[3][]; // 2차원 배열 크기값은 반드시 지정
		System.out.println("Arrays.toString(nums) : " + Arrays.toString(nums));
		System.out.println("Arrays.deepToString(nums) : " + Arrays.deepToString(nums));
		
		System.out.println("-------------");
		nums[0] = new int[2];
		nums[0][0] = 10;
		nums[0][1] = 20;
		
		System.out.println("Arrays.toString(nums) : " + Arrays.toString(nums));
		System.out.println("Arrays.deepToString(nums) : " + Arrays.deepToString(nums));
		System.out.println(Arrays.toString(nums[0]));
		
		System.out.println("------------");
		nums[1] = new int[] {30, 40};
		nums[2] = new int[] {50, 60, 70};
		
		System.out.println("Arrays.toString(nums) : " + Arrays.toString(nums));
		System.out.println("Arrays.deepToString(nums) : " + Arrays.deepToString(nums));
		
		

	}

}







