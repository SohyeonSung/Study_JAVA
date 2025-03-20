package com.mystudy.array;

public class SungjukExam {

	public static void main(String[] args) {
		/*
		국어, 영어, 수학점수를 저장할 수 있는 2차원 배열(students) 만들고
		3명의 성적을 입력하고 개인별 총점, 평균을 계산하여 화면 출력
		처리 : 총점, 평균 계산
		--------------
		국어\t영어\t수학 총점 평균
		------------------------
		100  90  80  270  90.0
		100  90  81  271  90.33
		99   91  82  272  90.66
		=========================== */
		int[][] students = { {97, 90, 80},
							 {100, 90, 81},
							 {99, 91, 82} };
		
		System.out.println("국어\t영어\t수학\t총점\t평균");
		
		for (int i = 0; i < students.length; i++) {
			//총점, 평균 구하기 ----------
			int tot = students[i][0] + students[i][1] + students[i][2]; //국어 + 영어 + 수학
			double avg = tot * 100 / 3 / 100.0;
			
			//계산 결과 출력 -------------
			System.out.println(students[i][0] + "\t" + 
								students[i][1] + "\t" + 
								students[i][2] + "\t" + 
								tot + "\t" + avg);
		}
		System.out.println("==================");
		
		for (int i = 0; i < students.length; i++) {
			int kor = students[i][0]; 
			int eng = students[i][1]; 
			int math = students[i][2]; 
			
			//총점, 평균 구하기 ----------
			int tot = kor + eng + math; 
			double avg = tot * 100 / 3 / 100.0;
			
			//계산 결과 출력 -------------
			System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg);
		}
		
		
		
		

	}

}




