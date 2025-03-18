
public class Ex04_if_sungjuk {

	public static void main(String[] args) {
		/*(실습) 성적처리
		입력 : 국어점수(kor), 영어(eng), 수학(math)
		처리 : 총점, 평균 구하고 평가하기
		- 총점(tot) : 국어 + 영어 + 수학
		- 평균(avg) : 총점 / 3
		-------
		평균점수의 구간에 따라 평가
		90 ~ 100 : A
		80 ~ 89 : B
		70 ~ 79 : C
		60 ~ 69 : D
		0 ~ 59 : F
		--------------------
		<결과출력>
		국어 : 100
		영어 : 90
		수학 : 80
		----------
		총점 : 270
		평균 : 90
		평가결과 : A
		------------------- */
		
		//입력 : 국어점수(kor), 영어(eng), 수학(math)
		int kor = 100;
		int eng = 90;
		int math = 82;
		
		//처리 : 총점, 평균 구하고 평가하기
		int tot = kor + eng + math;
		//double avg = tot / 3.0; // 90.66666666666667
		//avg = tot * 100 / 3; // 9066.0
		double avg = tot * 100 / 3 / 100.0; // 90.66
		
		//avg = Math.round( tot * 100 / 3.0 ) / 100.0; // 90.67
		
		//평균점수의 구간에 따라 평가
		String result = "평가안됨";
		
		//avg = 0;
		if (avg >= 90) {
			result = "A";
		} else if (avg >= 80) {
			result = "B";
		} else if (avg >= 70) {
			result = "C";
		} else if (avg >= 60) {
			result = "D";
		} else {
			result = "F";
		}
		
		//출력 : 화면에 출력 -----------------
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);
		System.out.println("평가결과 : " + result);

	}

}






