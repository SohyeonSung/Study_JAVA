package com.mystudy.list4_exam_string;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_String_ExamT {

	public static void main(String[] args) {
		/* List 중 ArrayList<String> 사용 실습
		문자열 : "홍길동","을지문덕","이순신","이순신","을지문덕","연개소문","광개토대왕"
		1. 위의 문자열 값을 저장할 수 있는 ArrayList 타입 names 변수를 선언하고 입력
		2. List에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		   출력) 홍길동,을지문덕,이순신,이순신,...
		3. List에 있는 데이터의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
		   출력) 홍,을,이,이,...
		4. 이름이 을지문덕인 데이터를 찾아서 "인덱스번호:이름" 형태로 출력
		   출력) 1:을지문덕
		5. 이름이 4글자 이상인 데이터를 찾아서 "인덱스번호:이름" 형태로 출력
		   출력) 1:을지문덕
		6. 이름이 "이순신" 데이터 모두 삭제하고, 몇 개가 삭제되었는지 확인
		====================================== */
		
		
		//문자열 : "홍길동","을지문덕","이순신","이순신","을지문덕","연개소문","광개토대왕"
		//1. 위의 문자열 값을 저장할 수 있는 ArrayList 타입 names 변수를 선언하고 입력
		ArrayList<String> names = new ArrayList<String>();
		names.add("홍길동");
		names.add("을지문덕");
		names.add("이순신");
		names.add("이순신");
		names.add("을지문덕");
		names.add("연개소문");
		names.add("광개토대왕");
		System.out.println("names : " + names);
		System.out.println("names.size() : " + names.size());
				
		
		System.out.println("\n2번 =====================");
		//2. List에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		//  출력) 홍길동,을지문덕,이순신,이순신,...
		for (int i = 0; i < names.size(); i++) {
			System.out.println(i + " : " + names.get(i));   
			}
		System.out.println("----");
		
		for (String name : names) {
			System.out.print(name + ",");
		}
		System.out.println("\n----");
		
		StringBuilder sb = new StringBuilder();
		for (String name : names) {
			//sb.append(name + ",");
			sb.append(name).append(',');
		}
		System.out.println("sb : " + sb);
		sb.deleteCharAt(sb.length() - 1);
		System.out.println("sb : " + sb);
				
		
		System.out.println("\n3번 ======================");
		//3. List에 있는 데이터의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
		//   출력) 홍,을,이,이,...
		//--------------
		//sb.delete(0, sb.length());
		sb.setLength(0);
		for (String name : names) {
			//System.out.println(name.charAt(0));
			sb.append(name.charAt(0) + ",");
		}
		System.out.println("sb : " + sb.deleteCharAt(sb.length() - 1));
		
		System.out.println("\n4번 ======================");
		//4. 이름이 을지문덕인 데이터를 찾아서 "인덱스번호:이름" 형태로 출력
		//   출력) 1:을지문덕
		for (int i = 0; i < names.size(); i++) {
			if ("을지문덕".equals(names.get(i))) {
				System.out.println(i + " : " + names.get(i));   
				//System.out.println((i + 1) + "번째 : " + names.get(i));   
			}
		}
		
		System.out.println("\n5번 ======================");
		//5. 이름이 4글자 이상인 데이터를 찾아서 "인덱스번호:이름" 형태로 출력
		//   출력) 1:을지문덕
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() >= 4) {
				System.out.println(i + " : " + names.get(i));   
				//System.out.println((i + 1) + "번째 : " + names.get(i));   
			}
		}
		
		System.out.println("\n6번 ======================");
		//6. 이름이 "이순신" 데이터가 몇 개인지 확인하고 모두 삭제하기
		//6-1. "이순신" 데이터가 몇 개가 있는지 확인
		//6-2. "이순신" 데이터 모두 삭제
		//----------
		if (names.contains("이순신")) {
			System.out.println(":: 이순신 데이터가 있습니다");
		} else {
			System.out.println(":: 이순신 데이터가 없습니다~~~~");
		}
		
		System.out.println("삭제전 names : " + names + ", size : " + names.size());
		int beforeCnt = names.size();
		int removeCnt = 0;

				
		/*		
		int lastIdx = names.size() - 1;
		for (int i = lastIdx; i >= 0; i--) {
			if ("이순신".equals(names.get(i))) {
				names.remove(i);
				removeCnt++;
			}
		} */		
		
		
		//이터레이터(Iterator) 객체 사용
		Iterator<String> ite = names.iterator();
		
		
		System.out.println("삭제후 names : " + names + ", size : " + names.size());
		System.out.println("삭제건수 : " + removeCnt);
		System.out.println("삭제건수 : " + (beforeCnt - names.size()));
		
	}

}



		
				

		
		
		
		


