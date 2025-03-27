package com.mystudy.set1_hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HashSet_Lotto {

	public static void main(String[] args) {
		//(실습) Set 을 이용한 로또 만들기 : 1~45 숫자 중 6개(랜덤숫자)를 Set에 저장
		// 1. 로또번호 6개를 추첨해서 Set 에 저장하고 화면 출력
		//    Math.random() : 0.0 ~ 0.9999... 실수형 데이터 생성(0 <= ran < 1)
		//    (int)(Math.random() * 45 + 1) : 1~45 랜덤(임의의)한 정수값
		// 2. 출력 작은 숫자부터 큰 숫자 형태로
		//    예) 금주의 로또번호 : 5, 8, 10, 25, 33, 41
		//----------------------------
		//System.out.println((int)(Math.random() * 45 + 1));
		
		// 1. 로또번호 6개를 추첨해서 Set 에 저장
		HashSet<Integer> lotto = new HashSet<Integer>();

		while (lotto.size() < 6) { //Set 데이터 갯수가 6개가 될때까지
			int ran = (int)(Math.random() * 45 + 1);
			System.out.println("ran : " + ran);
			lotto.add(ran);
			System.out.println("lotto.size() : " + lotto.size());
		}
		System.out.println("---------");
		System.out.println("lotto : " + lotto);
		System.out.println("lotto.size() : " + lotto.size());
		
		System.out.println("---- 정렬해서 발표 ----");
		// 2. 출력 작은 숫자부터 큰 숫자 형태로
		ArrayList<Integer> list = new ArrayList<Integer>(lotto);
		System.out.println("list : " + list);
		
		Collections.sort(list);
		System.out.println("정렬 후 list : " + list);
		
		
		
		
		
	}

}




