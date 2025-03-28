package com.mystudy.scanner1;

import java.util.Scanner;

public class Scanner_Exam {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자열 입력 1 : ");
		String str1 = scan.nextLine();
		System.out.println("> str1 : " + str1);
		System.out.println("------");
		
		System.out.print("문자열 입력 2 : ");
		String str2 = scan.nextLine();
		System.out.println("> str2 : " + str2);
		
		System.out.println("=====================================");
		System.out.println("정수값을 2개를 입력하면 더한 결과 출력");
		//int num1 = 100;
		//int num2 = 200;
		
		System.out.print("숫자입력1 : ");
		int num1 = scan.nextInt();
		scan.nextLine(); // 줄바꿈앞의 문자를 읽어서 버림처리
		
		System.out.print("숫자입력2 : ");
		int num2 = Integer.parseInt(scan.nextLine()); //
		
		int sum = num1 + num2;
		System.out.println("합계 : " + sum);
		
		System.out.print("문자열 입력 : ");
		String msg = scan.nextLine();
		System.out.println("msg : " + msg);
		
		System.out.println("\n>> main() 끝 ----------");
	}

}

