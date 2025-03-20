package com.mystudy.bean.vo;

/* 자바빈(Java Bean) 형태의 클래스 작성
VO(Value Object) : 값(데이터)을 저장하기 위한 클래스(객체) - Oxxx, OxxxVO, OxxxVo
  사용예) Student, StudentVO, StudentVo
DTO(Data Transfer Object) : 값(데이터)을 저장해서 전달하기 위한 클래스(객체) 
  Oxxx, OxxxDTO, OxxxDto
  사용예) Student, StudentDTO, StudentDto
------------ */
public class StudentVO_T {
	//(실습)필드(변수)선언 ------------------
	//성명 - name : String
	//국어 - kor : int
	//영어 - eng : int
	//수학 - math : int
	//총점 - tot : int
	//평균 - avg : double
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	//생성자 작성(기본생성자 없음) ----------------------
	//생성자 - 성명, 국어, 영어, 수학 입력받는 생성자
	//생성자 - 성명, 국어, 영어, 수학, 총점, 평균 입력받는 생성자
	public StudentVO_T(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		computeTotAvg();
	}

	public StudentVO_T(String name, int kor, int eng, int math, int tot, double avg) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = tot;
		this.avg = avg;
		
		//computeTotAvg();
	}
	
	//setter, getter 메소드 작성 ----------------------
	//(나중에) 국어, 영어, 수학 점수는 0~100 까지 값만 입력되도록 처리
	//(나중에) 국어, 영어, 수학 점수 변경되면 총점, 평균 재계산 처리
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		if (kor >= 0 && kor <= 100) { //정상 데이터냐?
			this.kor = kor;
			computeTotAvg();
		} else {
			System.out.println("[예외발생] 정상(0~100) 아님");
		}
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		if (eng < 0 || eng > 100) { //비정상 데이터냐?
			System.out.println("[예외발생] 정상(0~100) 아님");
		} else {
			this.eng = eng;
			computeTotAvg();
		}
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		if (math < 0 || math > 100) {
			System.out.println("[예외발생] 정상(0~100) 아님");
			return; //메소드 종료
		}
		this.math = math;
		computeTotAvg();
	}

	public int getTot() {
		return tot;
	}

//	public void setTot(int tot) {
//		this.tot = tot;
//	}

	public double getAvg() {
		return avg;
	}

//	public void setAvg(double avg) {
//		this.avg = avg;
//	}
	
	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
				+ ", avg=" + avg + "]";
	}

	//==============================
	public void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}
	
	
	
	
	
}


