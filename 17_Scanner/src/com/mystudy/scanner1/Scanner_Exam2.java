package com.mystudy.scanner1;

import java.awt.print.Printable;
import java.util.Scanner;

public class Scanner_Exam2 {

	public static void main(String[] args) {
		/* Scanner 사용 성적 처리
		 
		 입력 : 성명, 국어, 영어, 수학 점수를 입력
		 처리 : 총점, 평균 구하기
		 출력 : 결과를 화면 출력
		 
		 <출력 예시>
		 성명 : 홍길동
		 국어 : 100
		 영어 : 90
		 수학 : 82
		 -----------
		 총점 : 272
		 평균 : 90.66
		 
		 */
		
			
		
		Scanner scan = new Scanner(System.in);
		
		
		while (true) {
			System.out.println("<성적 처리를 위해 데이터를 입력하세요>");
		
		
		//입력
		System.out.print("성명: ");
        String name = scan.nextLine();

        System.out.print("국어 : ");
        int kor = scan.nextInt();
        System.out.print("수학 : ");
        int math = scan.nextInt();
        System.out.print("영어 : ");
        int eng = scan.nextInt();
        
        System.out.println("-------");
        
        
        //처리
        int tot = kor + math + eng;
        int avg = tot / 3;
        
        
        //출력
        System.out.println("<성적 처리 결과>");
        System.out.println("국어 : " + kor);
        System.out.println("수학 : " + math);
        System.out.println("영어 : " + eng);
        System.out.println("총점 : " + tot);
        System.out.println("평균 : " + avg);
        
        System.out.println();
        System.out.println();
        
        
        //지속 여부
        System.out.println(" : : 계속하시겠습니까? (Y/N)");
        
        String answer = scan.nextLine();
		if ("y".equalsIgnoreCase(answer)) {
			System.out.println("성적처리를 중단합니다~~~");
			break;
		}

			

        
        
		}   
       
		
	}
	

}
