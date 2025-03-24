package com.mystudy.ex03_sungjuk;

public class ScoreOutOfBoundsException extends SungjukProcessException {
	public ScoreOutOfBoundsException() {
		super("점수 범위(0~100)를 벗어난 값입니다");
	}
	public ScoreOutOfBoundsException(String msg) {
		super(msg);
	}

}
