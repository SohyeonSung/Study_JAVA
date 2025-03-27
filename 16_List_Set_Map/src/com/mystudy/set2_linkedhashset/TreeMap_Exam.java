package com.mystudy.set2_linkedhashset;

import java.util.TreeMap;

public class TreeMap_Exam {

	public static void main(String[] args) {
		// TreeMap : key 데이터를 정렬해서 저장
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.put("홍길동", 100);
		map.put("김유신", 95);
		map.put("강감찬", 88);
		map.put("을지문덕", 77);
		map.put("홍경래", 90);
		System.out.println("map : " + map);
		
		System.out.println("\n=== 전체데이터 화면 출력 ===");
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		



	}
}