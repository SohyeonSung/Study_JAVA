package com.mystudy.scanner3_bank;

import java.util.Scanner;

public class BankATM {
	
	private int money;
	
	public void startBank() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("======ATM======");
		System.out.println(" >> 어서오세요");
        
        
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("1.입금  2.출금  3.통장확인  0.종료");
            System.out.println("----------------------------------");
            System.out.print(" >> 작업선택 : ");
            int choice = scan.nextInt();

            switch (choice) {    
            
            case 1: // 입금
                System.out.print(" >> 입금액 : ");
                int inputMoney = scan.nextInt();
                money += inputMoney; // 입금 업데이트
                System.out.println(" ::통장금액 : " + money + "원");
                break;
            
            case 2 : // 출금
            	System.out.print(" >> 출금액 : ");
            	int outputMoney = scan.nextInt();
            	money -= outputMoney; // 출금 업데이트
            	System.out.println(" :: 통장금액 : " + money + "원");
            	break;
           
            case 3 : // 통장 확인
            	System.out.println(" :: 통장확인 : " + money + "원");
            	break;
            	
            case 0: //종료
            	System.out.println(" :: 작업을 종료했습니다 ");
            	return;
            	
            default :
            	System.out.println(" :: 잘못된 값입니다, 다시 입력해주세요");
            	System.out.println(" :: 재시작");
            

            }
        }
	}
}
