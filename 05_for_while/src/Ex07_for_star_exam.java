
public class Ex07_for_star_exam {

	public static void main(String[] args) {
		// 문제1 --------------
		//***** : * 5번 + 줄바꿈
		//****  : * 4번 + 줄바꿈
		//***   : * 3번
		//**    : * 2번
		//*     : * 1번
		//----------------------------
		int starCnt = 5;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= starCnt; j++) {
				System.out.print("*");
			}
			System.out.println();
			starCnt--;
		}
		System.out.println("-----------");
		starCnt = 5;
		
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;
		
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;
		
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;

		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;
		
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		starCnt--;
		
		System.out.println("----------------");	
		int lineCnt = 5;
		starCnt = lineCnt;
		String dispStr = "*";
		
		for (int line = 1; line <= lineCnt; line++) {
			for (int star = 1; star <= starCnt; star++) {
				System.out.print(dispStr);
			}
			System.out.println();
			starCnt--;
		}
		
		System.out.println("문제2 =============");
		// 문제2 -------------
		//    *  : 빈칸4 + "*" 1개 + 줄바꿈
		//   **  : 빈칸3 + "*" 2개 + 줄바꿈
		//  ***  : 빈칸2 + "*" 3개 + 줄바꿈
		// ****
		//*****
		//----------------------
		int spaceCnt = 4;
		starCnt = 1;
		
		for (int line = 1; line <= 5; line++) {
			// 빈칸 출력용 반복문(4,3,2,1,0,...)
			for (int space = 1; space <= spaceCnt; space++) {
				System.out.print(" ");
			}
			// "*" 출력용 반복문(1,2,3,...)
			for (int star = 1; star <= starCnt; star++) {
				System.out.print("*");
			}
			System.out.println();
			spaceCnt--;
			starCnt++;
		}
		System.out.println("-------------------");
		spaceCnt = 4;
		starCnt = 1;
		
		//1번째 줄 ------
		for (int i = 1; i <= spaceCnt; i++) {
			System.out.print(" ");
		}
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		spaceCnt--;
		starCnt++;
		
		//2번째 줄 -----
		for (int i = 1; i <= spaceCnt; i++) {
			System.out.print(" ");
		}
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		spaceCnt--;
		starCnt++;
		
		//3번째 줄 -----
		for (int i = 1; i <= spaceCnt; i++) {
			System.out.print(" ");
		}
		for (int i = 1; i <= starCnt; i++) {
			System.out.print("*");
		}
		System.out.println();
		spaceCnt--;
		starCnt++;
		System.out.println("----------");
		
		spaceCnt = 4;
		starCnt = 1;
		for (int m = 1; m <= 5; m++) {
			for (int i = 1; i <= spaceCnt; i++) {
				System.out.print(" ");
			}
			for (int i = 1; i <= starCnt; i++) {
				System.out.print("*");
			}
			System.out.println();
			spaceCnt--;
			starCnt++;
		}

		System.out.println("문제3 =============");
		//문제3 -------------
		//*****  : 빈칸0 + "*" 5개 + 줄바꿈
		// ****  : 빈칸1 + "*" 4개 + 줄바꿈
		//  ***  : 빈칸2 + "*" 3개 + 줄바꿈
		//   **  : 빈칸3 + "*" 2개 + 줄바꿈
		//    *
		//----------------------
		spaceCnt = 0;
		starCnt = 5;
		
		for (int line = 1; line <= 5; line++) {
			// 빈칸 출력용 반복문(4,3,2,1,0,...)
			for (int space = 1; space <= spaceCnt; space++) {
				System.out.print(" ");
			}
			// "*" 출력용 반복문(1,2,3,...)
			for (int star = 1; star <= starCnt; star++) {
				System.out.print("*");
			}
			System.out.println();
			spaceCnt++;
			starCnt--;
		}
		
		System.out.println("문제4 =============");
		//문제4 -------------
		//1        : (1 + 빈칸1) + 줄바꿈
		//1 2      : (1 + 빈칸1) + (2 + 빈칸1) + 줄바꿈
		//1 2 3    : (1 + 빈칸1) + (2 + 빈칸1) + (3 + 빈칸1) + 줄바꿈
		//1 2 3 4 
		//----------------------
		int num;
		
		num = 1;
		for (int i = 1; i <= 1; i++) {
			System.out.print(num + " ");
			num++;
		}
		System.out.println();
		
		num = 1;
		for (int i = 1; i <= 2; i++) {
			System.out.print(num + " ");
			num++;
		}
		System.out.println();
		
		num = 1;
		for (int i = 1; i <= 3; i++) {
			System.out.print(num + " ");
			num++;
		}
		System.out.println();
		
		num = 1;
		for (int i = 1; i <= 4; i++) {
			System.out.print(num + " ");
			num++;
		}
		System.out.println();
		System.out.println("----------");
		
		int cnt = 1;
		for (int line = 1; line <= 4; line++) {
			num = 1;
			for (int i = 1; i <= cnt; i++) {
				System.out.print(num);
				System.out.print(" ");
				num++;
			}
			System.out.println();
			cnt++;
		}
			
			
		System.out.println("문제5 =============");
		//문제5 -------------
		//1        : (1 + 빈칸1) + 줄바꿈
		//2 3      : (2 + 빈칸1) + (3 + 빈칸1) + 줄바꿈
		//4 5 6    : (4 + 빈칸1) + (5 + 빈칸1) + (6 + 빈칸1) + 줄바꿈
		//7 8 9 10 
		//----------------------		
		cnt = 1;
		num = 1;
		for (int line = 1; line <= 4; line++) {
			for (int i = 1; i <= cnt; i++) {
				System.out.print(num);
				System.out.print(" ");
				num++;
			}
			System.out.println();
			cnt++;
		}
		
		System.out.println("-------------");
		num = 1;
		for (int line = 1; line <= 5; line++) {
			for (int star = 1; star <= line; star++) {
				System.out.print(num);
				System.out.print(" ");
				num++;
			}
			System.out.println();
		}
		
			
	}

}
