package array3_2dim;

public class ArrayTwoDimesion {

	public static void main(String[] args) {
		// 2차원 배열 선언 및 객체 생성
		// 타입[][] 변수명 = new 타입[크기][크기];
		// 타입  변수명[][] = new 타입[크기][크기];
		// 타입[][] 변수명 = { {..}, {..}, ..., {..} };
		//---------------------
		int[][] nums = { {10, 20},  // 10 : nums[0][0], 20: nums[0][1]
						 {30, 40},  // 30 : nums[1][0], 40: nums[1][1]
						 {50, 60},
						 {70, 80, 90, 100} };
		System.out.println("nums : " + nums);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[0][0] : " + nums[0][0]);
		System.out.println("nums[0][1] : " + nums[0][1]);
		System.out.println("------");
		
		//배열 데이터 모두 출력
		// {10, 20}
		System.out.println("nums[0][0] : " + nums[0][0]);
		System.out.println("nums[0][1] : " + nums[0][1]);
		System.out.println();
		
		// {30, 40}
		System.out.println("nums[1][0] : " + nums[1][0]);
		System.out.println("nums[1][1] : " + nums[1][1]);
		System.out.println();
		System.out.println("==========");
		
		System.out.println("nums.length : " + nums.length); //2차원 배열 데이터 갯수
		
		//첫번째 배열 데이터 반복문 사용 화면 출력
		System.out.println("nums[0].length : " + nums[0].length);
		for (int i = 0; i < nums[0].length; i++) {
			System.out.print(nums[0][i] + " ");
		}
		System.out.println();
		
		//두번째 배열 데이터 반복문 사용 화면 출력
		System.out.println("nums[1].length : " + nums[1].length);
		for (int i = 0; i < nums[1].length; i++) {
			System.out.print(nums[1][i] + " ");
		}
		System.out.println();
		
		System.out.println("=== 이중(중첩) for문 사용 모든 배열 데이터 출력 ====");
		for (int d2 = 0; d2 < nums.length; d2++) {
			for (int i = 0; i < nums[d2].length; i++) {
				System.out.print(nums[d2][i] + " ");
			}
			System.out.println();
		}
			
			
		
	}
	
}





