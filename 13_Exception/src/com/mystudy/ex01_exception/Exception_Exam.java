package com.mystudy.ex01_exception;

public class Exception_Exam {

	public static void main(String[] args) {
		System.out.println("=== main() 시작 ===");
		System.out.println();
		
		//정보
		System.out.println("-정보-");
		int num1 = 100;
		int num2 = 0;
		int result = 0;
		
		System.out.println("num1 :" + num1 + ", num2 : " + num2);
		

	
		//예외 처리 (기본)
		System.out.println();
		System.out.println("-기본 구문으로 처리-");
		if (num2 == 0) {
			System.out.println("[예외 발생] 나누는 값이 0이다");
		} else {
			result = num1 / num2;
			System.out.println(">> 연산 결과 : " + result);
		}
		
			
		//예외 처리 (try ~ catch)
		System.out.println();
		System.out.println("-try ~ catch 구문으로 처리-");
		try {
			result = num1 / num2;
			System.out.println(">> 연산 결과 : " + result);
		} catch (ArithmeticException e) {
			System.out.println("[예외 발생(ArithmeticExcepton)]" + e.getMessage()); //작은 타입
		} catch (RuntimeException e) {
			System.out.println("[예외 발생(RuntimeException)]" + e.getMessage()); //중간 타입
		} catch (Exception e) {
			System.out.println("[예외 발생(Exception)] 나누는 값이 0이다"); //큰 타입 (범위가 클 수록 밑으로 적기)
		} finally {
			System.out.println("::: 무조건 실행 :::");
		}
		
		
		
		System.out.println();
		System.out.println("=== main() 끝 ===");
		
	}

}
