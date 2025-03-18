
public class Ex09_for_gugudan2 {
	
	public static void main(String[] args) {
		// 가로방향 구구단 출력
		/*(실습) 구구단 2~9단 출력(가로방향)
		2*1=2   3*1=3   ... 9*1=9
		2*2=4   3*2=6   ... 9*2=18
		2*3=6   3*3=9   ... 9*3=29
		...
		2*9=18  3*9=27  ... 9*9=81
		---------------------- */
		System.out.println("*" + " " + "*" + " " + "*");
		// \t : 탭(tab) 간격 위치
		System.out.println("*" + "\t" + "*" + "\t" + "*");
		System.out.println("2*1=2" + "\t" + "3*1=3" + "\t" + "4*1=4");
		System.out.print("2*1=2" + "\t");
		System.out.print("3*1=3" + "\t");
		System.out.println();
		System.out.println("-----------------");
						
		System.out.print(2 + "*" + 1 + "=" + (2 * 1) + "\t");
		System.out.print(3 + "*" + 1 + "=" + (3 * 1) + "\t");
		System.out.print(4 + "*" + 1 + "=" + (4 * 1) + "\t");
		System.out.println();
		System.out.println("-------------");
		
		for (int dan = 2; dan <= 9; dan++) {
			System.out.print(dan + "*" + 1 + "=" + (dan * 1) + "\t");
		}
		System.out.println();

		for (int dan = 2; dan <= 9; dan++) {
			System.out.print(dan + "*" + 2 + "=" + (dan * 2) + "\t");
		}
		System.out.println();
		
		for (int dan = 2; dan <= 9; dan++) {
			System.out.print(dan + "*" + 3 + "=" + (dan * 3) + "\t");
		}
		System.out.println();
		System.out.println("----------");
		
		for (int gop = 1; gop <= 9; gop++) {
			for (int dan = 2; dan <= 9; dan++) {
				System.out.print(dan + "*" + gop + "=" + (dan * gop) + "\t");
			}
			System.out.println();
		}
		System.out.println("==============");
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + "*" + i + "=" + (j * i) + "\t");
			}
			System.out.println();
		}
		System.out.println("---------");
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
		
		
		
	}

}








