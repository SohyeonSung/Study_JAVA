
public class Ex08_for_gugudan {

	public static void main(String[] args) {
		// 세로방향 구구단 출력
		/*(실습) 화면에 구구단 출력(for 문 사용)
		2*1=2  
		2*2=4  :: 4 : 2*2 결과값
		2*3=6
		...
		2*9=18
		------------*/
		System.out.println("2*" + 1 + "=" + (2 * 1));
		System.out.println("2*" + 2 + "=" + (2 * 2));
		System.out.println("2*" + 3 + "=" + (2 * 3));
		System.out.println("2*" + 4 + "=" + (2 * 4));
		System.out.println("---------");
		
		int dan = 9;
		System.out.println("--- " + dan + "단 출력 ---");
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "*" + i + "=" + (dan * i));
		}
		System.out.println("==================");
		
		System.out.println("---(실습) 2~9 단까지 출력(세로방향) ---");
		dan = 2;
		System.out.println("- " + dan + "단 -");
		for (int gop = 1; gop <= 9; gop++) {
			System.out.println(dan + "*" + gop + "=" + (dan * gop));
		}
		
		dan = 3;
		System.out.println("- " + dan + "단 -");
		for (int gop = 1; gop <= 9; gop++) {
			System.out.println(dan + "*" + gop + "=" + (dan * gop));
		}
		
		dan = 4;
		System.out.println("- " + dan + "단 -");
		for (int gop = 1; gop <= 9; gop++) {
			System.out.println(dan + "*" + gop + "=" + (dan * gop));
		}
		
		System.out.println("=== 2~9 단출력(중첩반복문) =====");
		for (dan = 2; dan <= 9; dan++) {
			System.out.println("\n- " + dan + "단 -");
			for (int gop = 1; gop <= 9; gop++) {
				System.out.println(dan + "*" + gop + "=" + (dan * gop));
			}
		}

	}

}






