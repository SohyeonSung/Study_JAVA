package com.mystudy.bean.vo;


	//(실습)필드(변수)선언 ------------------
	//성명 - name : String
	//국어 - kor : int
	//영어 - eng : int
	//수학 - math : int
	//총점 - tot : int
	//평균 - avg : double
	
	
	//생성자 작성(기본생성자 없음) ----------------------
	//생성자 - 성명, 국어, 영어, 수학 입력받는 생성자
	//생성자 - 성명, 국어, 영어, 수학, 총점, 평균 입력받는 생성자

	
	//setter, getter 메소드 작성 ----------------------
	//(나중에) 국어, 영어, 수학 점수는 0~100 까지 값만 입력되도록 처리
	//(나중에) 국어, 영어, 수학 점수 변경되면 총점, 평균 재계산 처리
	
	
public class StudentVO {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;

	public StudentVO(String name, int kor, int eng, int math) {
		this.name = name;
		setKor(kor);
		setEng(eng);
		setMath(math);
		setTotAvg();
	}

	public StudentVO(String name, int kor, int eng, int math, int tot, double avg) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = tot;
		this.avg = avg;
	}

	
	
	//이름
	public String getName() {
		return name;
	}

	//국어
	public void setKor(int kor) {
		if (kor >= 0 && kor <= 100) {
			this.kor = kor;
		} else {
			System.out.print("점수륻 다시 입력해주세요");
		}
		setTotAvg();
	}

	
	public int getKor() {
		return kor;
	}
	
	
	//영어
	public void setEng(int eng) {
		if (eng >= 0 && eng <= 100) {
			this.eng = eng;
		} else {
			System.out.println("점수를 다시 입력해주세요");
		}
	}
	
	public int getEng() {
		return eng;
	}


	//수학
	public void setMath(int math) {
		if (math >= 0 && math <= 100) {
			this.math = math;
		} else {
			System.out.println("점수를 다시 입력해주세요");
		}
	}
	
	public int getMath() {
		return math;
	}

	
	//총점
	public int getTot() {
		return tot;
	}

	//평균
	public double getAvg() {
		return avg;
	}
	
	
	public void setTot (int tot) {
		this.tot = tot;
	}

	private void setTotAvg() {
		this.tot = kor + eng + math;
		this.avg = tot * 100 / 3 / 100.0;

	}
}















