package array4_copy;

public class ArrayCopy {

	public static void main(String[] args) {
		// 배열복사
		int[] num1 = new int[5];
		int[] num2 = new int[5];
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num1 == num2 : " + (num1 == num2)); //false : 서로 다른 객체
		
		num1[0] = 10;
		num1[1] = 20;
		num1[2] = 30;
		num1[3] = 40;
		num1[4] = 50;
		
		printData(num1); // 메소드 호출(실행)
		printData(num2);
		System.out.println("----------");
		printData(num1, "num1");
		printData(num2, "num2");
		
		System.out.println("=== 배열복사(주소값 복사, 얕은복사) ===");
		num2 = num1; // 주소값 복사(참조형 데이터)
		System.out.println("num1 == num2 : " + (num1 == num2));
		
		num1[0] = 999;
		
		printData(num1, "num1");
		printData(num2, "num2");
		
		System.out.println("==== 배열값 복사(물리적복사, 깊은복사(deep copy)) ===");
		int[] num3 = new int[5];
		printData(num3, "num3");
		
		// num3 <---- num1 데이터 복사
		for (int i = 0; i < num3.length; i++) {
			num3[i] = num1[i];
		}
		
		printData(num1, "num1");
		printData(num3, "num3");
		System.out.println("num1 == num3 : " + (num1 == num3));
		
		System.out.println("========================");
		int[] num4 = new int[num1.length];
		printData(num4, "num4");
		
		//System.arraycopy(src, srcPos, dest, destPos, length)
		//System.arraycopy(소스객체, 시작위치, 대상객체, 대상시작위치, 갯수)
		System.arraycopy(num1, 0, num4, 0, num1.length);
		
		System.out.println(">>System.arraycopy() 복사후");
		printData(num1, "num1");
		printData(num4, "num4");
		System.out.println("num1 == num4 : " + (num1 == num4));
		
		//===========================
		// 배열복사 방식 다양하게 존재 : 찾아보기
		
		

	}//main 끝
	
	static void printData(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	//메소드 오버로딩(method overloading)
	static void printData(int[] arr, String name) {
		System.out.print(name + " : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	

}//class 끝
















