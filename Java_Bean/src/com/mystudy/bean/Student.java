package com.mystudy.bean;

/*
■ 캡슐화(Encapsulation) - 정보은닉(Infomation Hiding)
- 사용자의 편의와 안정성을 위해 숨길 것은 숨기고, 공개할 것은 공개
- 주로 속성은 숨기고 속성에 접근시 메소드(기능)를 통해 접근 처리	
	
■ 자바빈(Java Bean)
- 멤버변수(property)의 접근제어자는 private
- 멤버변수(property) 마다 get/set 메소드 제공(선택적으로 get만 제공)
- get/set 메소드는 public
- get 메소드는 파라미터 없고, set 메소드는 하나 이상의 파라미터 존재
- 멤버변수(property)가 boolean 타입이면 get 메소드 대신 is 메소드 사용가능
- 외부에서 멤버변수(property) 접근시에는 get/set 메소드를 통해 접근
----------------- */
/* 자바빈(Java Bean) 형태의 클래스 작성
VO(Value Object) : 값(데이터)을 저장하기 위한 클래스(객체) - Oxxx, OxxxVO, OxxxVo
  사용예) Student, StudentVO, StudentVo
DTO(Data Transfer Object) : 값(데이터)을 저장해서 전달하기 위한 클래스(객체) 
  Oxxx, OxxxDTO, OxxxDto
  사용예) Student, StudentDTO, StudentDto
------------ */
class Student {
	//필드변수 ===========================
	private String name; //private 선언시 외부에서 사용못함(접근 불가)
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	// 생성자 =============================
	public Student() {
		//super : 부모클래스의 객체(인스턴스)
		super(); // 부모클래스 객체(인스턴스)의 기본생성자 호출(생략시 컴파일러가 추가)
	}
	
	public Student(String name) {
		super(); // 생략시 컴파일러 자동으로 추가
		this.name = name;
	}
	
	public Student(String name, int kor, int eng, int math) {
		//현재객체(인스턴스)의 생성자 호출
		//생성자의 재사용
		this(name); //생성자 호출 구문은 맨처음 작성되어 실행되어야 한다
		//this.name = name;
		
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		computeTotAvg();
	}

	// 기능(동작) 메소드 ======================
	// 외부에서 사용할 수 있도록 메소드 제공(public)
	//----------------
	//외부에서 데이터를 전달받아 필드(멤버변수)에 데이터 저장
	//명칭(호칭) : set메소드, setter, set property(속성값 설정,쓰기)
	public void setName(String name) {
		this.name = name;
	}
	
	//외부에서 데이터를 읽어가기 위한 get 메소드
	//명칭(호칭) : get메소드, getter, get property(속성값 읽기)
	public String getName() {
		return name;
	}
	
	//kor : setter, getter
	public void setKor(int kor) {
		//적절한 데이터 여부 확인
		if (kor >= 0 && kor <= 100) {
			this.kor = kor;
			computeTotAvg();
		} else {
			System.out.println("[예외발생] 국어 0~100 값이 아님");
		}
	}
	
	public int getKor() {
		return kor;
	}
	
	//(실습) setter, getter 만들기 ==========
	// eng, math, tot, avg 필드변수의 set, get 메소드 작성
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		//return super.toString(); //부모타입 Object의 toString() 호출(사용)
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot + ", avg="
				+ avg + "]";
	}
	
	//-------------------
	public void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}
	
	
}

















