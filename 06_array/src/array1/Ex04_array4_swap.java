package array1;

public class Ex04_array4_swap {

	public static void main(String[] args) {
		// 변수값 서로 교환하기
		int a = 100;
		int b = 200;
		System.out.println("교환 전 a : " + a);
		System.out.println("교환 전 b : " + b);
		System.out.println("-------");
		
		//(실습) a와 b의 값을 서로 교환하기
		//int temp; //백업할 저장공간
		int temp = a;
		a = b;
		b = temp;
		
		System.out.println("교환 후 a : " + a);
		System.out.println("교환 후 b : " + b);
		System.out.println("백업 temp : " + temp);
		System.out.println("============");
		
		//            0    1    2    3    4
		int[] nums = {100, 200, 300, 400, 500};
		System.out.println("배열의 크기 : " + nums.length);
		//(개인적실습) 위치 맞교환 하기(뒤집기)
		

	}

}









