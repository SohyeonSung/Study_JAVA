package com.mystudy.scanner2_cafe;

import java.util.Scanner;


public class Scanner_Cafe {

	public static void main(String[] args) {
		/* [카페 음료 주문 처리]
		
		음료의 종류
		1. 아메리카노(3000) 2. 카페라떼(3500) 3. 카페모카 (4000) 4. 과일주스 (5000)

		입력값 : 메뉴번호, 주문수량, 입금액 (고객이 낸 돈)
		처리   : 판매액 (단가 * 수량), 잔돈 (입금액 - 판매액)
		출력값 : 입금액, 판매액, 잔액

		// ===================================================
		
	 	 [예시]
	 	 
		 1. 아메리카노(3000) 2. 카페라떼(3500) 3. 카페모카 (4000) 4. 과일주스 (5000)
		  > 메뉴 선택 (1~4) : 1
		  > 주문 수량 : 3
		  > 입금액 : 10000
		----------------------------------------- 
		  < 입금액 : 10000
		  < 판매액 : 9000
		  < 잔액 : 1000
		  ...
		  ...
		  [총 매출]
		  - 42500원
		  [각 음료별 판매량]
		  - 아메리카노 : 5
		  - 카페라떼 : 1
		  - 카페모카 : 6
		  - 과일주스 : 0
		 */
		
		
		
		
		Scanner scan = new Scanner(System.in);
	
		int[] prices = {3000, 3500, 4000, 5000};
		String[] drinks = {"아메리카노", "카페라떼", "카페모카", "과일주스"};
		
		int tot = 0;
		int tot_menu [] = new int[drinks.length] ;
			
		System.out.println("====[메뉴판]====");
		for (int i = 0; i < drinks.length; i++) {
			System.out.println((i + 1) + ". " + drinks[i] + "(" + prices[i] + ")");
		} System.out.println("================");
		
	
		
		
		System.out.println("");
		
		
		
		while (true) {
			
			System.out.println("---------------");
			
			System.out.print(" > 메뉴 선택 (1~4) : ");
			int menu = scan.nextInt();
			
			System.out.print(" > 주문 수량 : ");
			int amount = scan.nextInt();

			System.out.print(" > 입금액 : ");
			int money_in = scan.nextInt();
		
			int sell = prices[menu - 1] * amount;
			int money_out = money_in - sell;
				
			System.out.println("---------------");
		
			System.out.println(" < 입금액 : " + money_in);
			System.out.println(" < 판매액 : " + sell);
			System.out.println(" < 잔액 : " + money_out);
			
			tot += sell;
			tot_menu[menu - 1] += amount;
			
			
			System.out.println("---------------");
		

			System.out.print(">>>>>> 추가 주문을 하시겠습니까? (예: 1 / 아니오: 0) : ");
            int order = scan.nextInt();
            if (order == 0) {
                break;
            }
		}
		
		//판매량
		System.out.println("================");
		System.out.println("[총 매출]");
		System.out.println("- " + tot + "원");
		System.out.println("[각 음료별 판매량]");
		for (int i = 0; i < drinks.length; i++) {
			System.out.println("- " + drinks[i] + " : " + tot_menu[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}

	


