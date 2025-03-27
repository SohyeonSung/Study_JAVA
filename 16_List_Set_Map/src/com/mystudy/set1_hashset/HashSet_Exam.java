package com.mystudy.set1_hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSet_Exam {

	public static void main(String[] args) {
		// HashSet : Set 인터페이스 구현한 구현체(클래스)
		// 중복 허용안함, 순서가 없음(동일데이터는 1개만 존재)
		//-----------------
		// Set에서 동일데이터 여부 확인 hashCode(), equal() 값 확인
		// 1. 해시코드 값 확인 : hashCode()
		// 2. equals() 메소드 결과값이 모두 일치하면 동일 데이터 처리
		//-----------------
		//HashSet<String> set = new HashSet<String>();
		Set<String> set = new HashSet<String>();
		set.add("홍길동");
		set.add("김유신");
		set.add("홍길동"); //중복데이터 저장 안함
		set.add(new String("홍길동")); //중복데이터 저장 안함
		System.out.println("set : " + set);
		System.out.println("set.size() : " + set.size());
		
		System.out.println("set.contains(\"홍길동\") : " + set.contains("홍길동"));
		System.out.println("set.contains(\"홍길동999\") : " + set.contains("홍길동999"));
		
		set.add("홍경래");
		set.add("을지문덕");
		System.out.println("set : " + set);
		System.out.println("set.size() : " + set.size());
		
		System.out.println("--- Set 전체 데이터 조회(확인) ---");
		for (String name : set) {
			System.out.println(name);
		}
		
		System.out.println("--- 전체 데이터 조회 iterator() 사용 ---");
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		System.out.println("====(실습) 데이터 수정 작업 ====");
		//(실습) set 데이터 사용 
		//1. 수정(변경) : 김유신 ---> 김유신999
		//   일단 김유신이 있는지 확인해서 있으면 변경하고 없으면 진행하지 마세요
		//2. 홍길동 삭제 처리(데이터 삭제 여부 확인)
		//3. 수정(변경) : 일지매 ---> 일지매2
		//-----------------
		System.out.println("set : " + set);
		
		//1. 수정(변경) : 김유신 ---> 김유신999
		System.out.println("1. 김유신 ---> 김유신999 =================");
		if (set.contains("김유신")) {
			set.remove("김유신");
			set.add("김유신999");
		} else {
			System.out.println("김유신 없음 - 변경작업 안함");
		}
		System.out.println("set : " + set);
		
		System.out.println("2. 홍길동 삭제 처리(데이터 삭제 여부 확인) ===========");
		if (set.remove("홍길동")) {
			System.out.println(">> 홍길동 삭제 처리 완료");
		} else {
			System.out.println(">> 홍길동 삭제 못함");
		}
		System.out.println("set : " + set);
		
		System.out.println("3. 수정(변경) : 일지매 ---> 일지매2 ===========");
		if (set.remove("일지매")) {
			set.add("일지매2");
		} else {
			System.out.println(">> 데이터 없음");
		}
		
		System.out.println("set : " + set);

	}

}








