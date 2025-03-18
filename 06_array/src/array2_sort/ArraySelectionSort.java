package array2_sort;

public class ArraySelectionSort {

	public static void main(String[] args) {
		// 배열 숫자 데이터 정렬(오름차순 : ASC)
		// 선택정렬 방식으로 작은 숫자를 앞으로 보내기
		int[] num = {30, 20, 50, 40, 10};
		//배열 데이터 화면 출력
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		System.out.println("--------");
		
		System.out.println("--- 비교 교환 ----");
		// 기준(첫번째) 데이터와 두번째 데이터 크기 비교
		// 기준(첫번째) 데이터가 크면 서로 위치 교환
/*		
		if (num[0] > num[1]) {
			int temp = num[0];
			num[0] = num[1];
			num[1] = temp;
		}
		printData(num);
		System.out.println("-----");
		
		if (num[0] > num[2]) {
			int temp = num[0];
			num[0] = num[2];
			num[2] = temp;
		}
		printData(num);
		System.out.println("-----");
		
		if (num[0] > num[3]) {
			int temp = num[0];
			num[0] = num[3];
			num[3] = temp;
		}
		printData(num);
		System.out.println("-----");
		
		if (num[0] > num[4]) {
			int temp = num[0];
			num[0] = num[4];
			num[4] = temp;
		}
*/			
/*		
		System.out.println(">> 0번인덱스 기준");
		//기준(0번인덱스) 인 경우 비교 처리
		for (int i = 1; i < num.length; i++) {
			if (num[0] > num[i]) {
				int temp = num[0];
				num[0] = num[i];
				num[i] = temp;
			}
			printData(num);
		}
		System.out.println("-------------------------");
		
		System.out.println(">> 1번인덱스 기준");
		//기준(1번인덱스) 인 경우 비교 처리
		for (int i = 2; i < num.length; i++) {
			if (num[1] > num[i]) {
				int temp = num[1];
				num[1] = num[i];
				num[i] = temp;
			}
			printData(num);
		}
		System.out.println("-------------------------");
		
		System.out.println(">> 2번인덱스 기준");
		//기준(2번인덱스) 인 경우 비교 처리
		for (int i = 3; i < num.length; i++) {
			if (num[2] > num[i]) {
				int temp = num[2];
				num[2] = num[i];
				num[i] = temp;
			}
			printData(num);
		}
		System.out.println("-------------------------");
		
		System.out.println(">> 3번인덱스 기준");
		//기준(3번인덱스) 인 경우 비교 처리
		for (int i = 4; i < num.length; i++) {
			if (num[3] > num[i]) {
				int temp = num[3];
				num[3] = num[i];
				num[i] = temp;
			}
			printData(num);
		}
		System.out.println("-------------------------");
*/		
		System.out.println("---- 중첩(이중) 반복문 처리 ----");
		// 기준인덱스 : 0 ~ 3 (3: 마지막 이전데이터) 
		// 비교대상값 : 기준인덱스+1 ~ 마지막데이터
		for (int gijun = 0; gijun < 4; gijun++) {
			System.out.println(">> 기준인덱스 : " + gijun);
			for (int i = gijun + 1; i < num.length; i++) {
				if (num[gijun] > num[i]) {
					int temp = num[gijun];
					num[gijun] = num[i];
					num[i] = temp;
				}
				printData(num);
			}
			System.out.println("-------");
		}
		System.out.println("=================");
		// 배열 데이터 화면 출력
		printData(num);
		
		
	} //main 끝
	
	static void printData(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
	
	

} //class 끝





