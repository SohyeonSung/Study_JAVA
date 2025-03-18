
public class Ex11_while_exam {

	public static void main(String[] args) {
		// while 문 사용해서 처리
		//(실습)문제0 : 1~10 까지 화면출력
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println("-------");
		
		int num = 1;
		while (num <= 10) {
			System.out.println("num  : " + num);
			num++; // num = num + 1;
		}
		System.out.println("-------");
		
		//(실습)문제1 : 1~10까지의 합을 구하고 결과를 화면 출력
		num = 1;
		int sum = 0;
		while (num <= 10) {
			sum += num;
			num++; // num = num + 1;
		}
		System.out.println("1~10까지의 합 : " + sum);
		
		System.out.println("---------");
		/*(실습) 문제2 
		****
		****
		****
		****
		****
		-------------- */
		num = 1;
		while (num <= 5) {
			int count = 1;
			while (count <= 4) {
				System.out.print("*");
				count++;
			}
			System.out.println();
			
			num++;
		}
		
		
		
		
		
	}

}
