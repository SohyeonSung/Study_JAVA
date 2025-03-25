package com.mystudy.list3_linkedlist;

import java.util.Arrays;
import java.util.LinkedList;



public class LinkedList_Exam {

	public static void main(String[] args) {
		// LinkedList : List 속성
		LinkedList<String> list = new LinkedList<String>();
		list.add("홍길동"); //0번 인덱스
		list.add("홍길동"); //1번 인덱스
		list.add("김유신");
		list.add("강감찬");
		System.out.println("list : " + list);
		System.out.println("size : " + list.size());
		
		list.remove("을지문덕");
		System.out.println("list : " + list);
		
		
		
		
		System.out.println("---------------");
		
		
		
		String str = "홍길동,홍길동,김유신,강감찬,을지문덕,홍경래,김유신,홍길동";
		String[] names = str.split(",");
		System.out.println("names : " + Arrays.toString(names));
		
		//배열에 있는 데이터를 리스트에 추가
		for(int i = 0; i <names.length; i++) {
			list.add(names[i]);
		}
		System.out.println("list : " + list);
		
		
		System.out.println("---------------");
		
		
		
		
		
		/* list : 홍길동,홍길동,김유신,강감찬,을지문덕,홍경래,김유신,홍길동
		 * 리스트에 있는 데이터 변경하기
		 * 1. 홍길동 모두 삭제 (delete)
		 * 2. 김유신 -> 김유신2로 모두 수정 (update)
		 */

       

		//1. 홍길동 모두 삭제(Delete)
		System.out.println("list.contains(\"홍길동\") : " + list.contains("홍길동"));
		
		String name = "홍길동";
		
//		(1)		
//		while (list.contains(name)) {
//			list.remove(name);
//		}
		
		
//		(2)
		//System.out.println("list.remove(\"홍길동999\") : " + list.remove("홍길동999"));
//		while (list.remove(name)) {
//			System.out.println(name + " 삭제");
//		}
		
		
		
//		(3)
//		System.out.println("list.indexOf(\"홍길동\") : " + list.indexOf("홍길동"));
//		
//		while (list.indexOf(name) != -1) {
//			list.remove(0);
//		}
		
		
//		(4) 기본 반복문 사용 , 데이터 비교 후 삭제 처리
		int lastIndex = list.size() - 1;
		for (int i = lastIndex; i >= 0; i--) {
			System.out.println(i + " - list: " + list);
			if ("홍길동".equals(list.get(i))) {
				list.remove(i);
			}
		}
		System.out.println("삭제후 list : " + list);
		
		
		
		
		
		
		System.out.println("\n======= 김유신 -> 김유신2 변경(수정) ===========");
		
		
		
		// 2. 김유신 -> 김유신2 모두 수정(Update)
		
//		(1)
//		while (list.indexOf("김유신") != -1) {
//			System.out.println("김유신 있음 : " + list.indexOf("김유신"));
//			list.set(list.indexOf("김유신"), "김유신2");
//		}
//		System.out.println("list.indexOf(\"김유신\") : " + list.indexOf("김유신"));

		
		
//		(2)
		for (int i = 0; i < list.size(); i++) {
			if("김유신".equals(list.get(i))) {
				list.set(i, "김유신2");
//				break; //break시 첫번째 김유신만 김유신2로 바뀜
			}

		}
		System.out.println("변경후 list : " + list);


}
}
