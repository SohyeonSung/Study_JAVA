
public class Ex10_while {

	public static void main(String[] args) {
		// 반복문 : for, while, do ~ while
		/* while 반복문 사용 형태
		반복인자의 선언 및 초기값 설정(선택적);
		while (실행조건식) {
			반복인자값 증감설정(선택적);
			실행문(들);
			반복인자값 증감설정(선택적);
		}
		---------------------- */
		
		// 1~10 까지 출력
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("--------");
		
		// while 문으로
		int i = 1;
		while (i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println();
		
		System.out.println("-----------");
		
		i = 0;
		while (i < 10) { // i <= 9
			i++;
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("=== do ~ while 문 ====");
		/* do ~ while : 무조건 1번은 실행된다
		반복인자의 선언 및 초기값 설정(선택적);
		do {
			반복인자값 증감설정(선택적);
			실행문(들);
			반복인자값 증감설정(선택적);
		} while (실행조건식);
		---------------------- */
		// 1~10 까지 출력(do ~ while)
		int num = 1;
		do {
			System.out.println("do~while : " + num);
			num++;
		} while (num <= 10);
		System.out.println("-------");
		
		
		
		
	}

}









