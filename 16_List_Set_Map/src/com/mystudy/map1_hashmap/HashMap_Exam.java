package com.mystudy.map1_hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class HashMap_Exam {

	public static void main(String[] args) {
		// Map<K, V> 인터페이스 : 키(key)-값(value) 쌍으로 데이터 저장 관리
		// - 특징 : 키(key)-값(value) 쌍으로 데이터 저장
		// - 키(key) : 중복 안됨(중복값 없이 유일한 데이터)
		// - 값(value) : 중복 데이터 저장 가능
		
		
		// HashMap<String,Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		//입력 - Create, Insert
		System.out.println(" -- 입력 : put (key, value) --");
		map.put("홍길동", 100);
		map.put("김유신", 95);
		map.put("강감찬", 88);
		map.put("홍길동", 90); //같은 key를 입력하면 값이 덮여진다
		
		System.out.println("map : " + map);
		System.out.println("map.size() : " + map.size());
		
		// 조회(검색) - Read
		System.out.println("\n--- 조회(검색) : get(key) ---");
		int returnValue = map.get("홍길동");
		System.out.println("map.get(\"홍길동\") : " + returnValue);
		
		// key, value 존재 여부 확인
		System.out.println("map.containsKey(\"을지문덕\") : " + map.containsKey("을지문덕"));
		System.out.println("map.containsValue(88) : " + map.containsValue(88));
		
		
		// 수정 - Update
		System.out.println("=== 수정 replace(key, value) : value ======");
		System.out.println("map.replace(\"홍길동\", 99) : " + map.replace("홍길동", 99));
		System.out.println("map.get(\"홍길동\") : " + map.get("홍길동"));
		
		// 일치하는 key 가 없는 경우 : 수정못함, null 리턴
		System.out.println("map.replace(\"을지문덕\", 99) : " + map.replace("을지문덕", 99));
		System.out.println("map : " + map);
				
		System.out.println("=== 수정 replace(key, oldValue, newValue) : boolean ======");
		System.out.println("map.replace(\"홍길동\", 9999, 88) : " + map.replace("홍길동", 9999, 88));
		System.out.println("map : " + map);

		
		// 삭제 - Delete
		System.out.println("\n=== 삭제 remove(key), remove(key, value)");
		System.out.println("map.remove(\"홍길동\") : " + map.remove("홍길동"));
		System.out.println("map.get(\"홍길동\") : " + map.get("홍길동"));
				
		System.out.println("map.remove(\"김유신\", 100) : " + map.remove("김유신", 100));
		System.out.println("map.get(\"김유신\") : " + map.get("김유신"));
				
		System.out.println("map.remove(\"김유신\", 95) : " + map.remove("김유신", 95));
		System.out.println("map.get(\"김유신\") : " + map.get("김유신"));
				
		System.out.println("map : " + map);
		
		
		map.put("홍길동", 100);
		map.put("김유신", 95);
		map.put("강감찬", 88);
		map.put("계백", 77);
		map.put("을지문덕", 90);
		
		System.out.println("\n==== Map 전체 데이터 사용 ========");
		System.out.println("map : " + map);
		System.out.println("map.size() : " + map.size());
		
		System.out.println("--- keySet() 사용 ----");
		Set<String> keySet = map.keySet();
		System.out.println("map.keySet() : " + keySet);
		
		for(String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("--------------------");
		
		
		System.out.println(" -- values() 사용 --");
		Collection<Integer> values = map.values();
		System.out.println("values : " + values);
		
		for (Integer value : values) {
			System.out.println("점수 : " + value);
		}
		
		System.out.println("\n---- entrySet() 사용 -----");
		// Entry<K, V> : Map 인터페이스 내부에 정의된 인터페이스(Map.Entry)
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println("entrySet : " + entrySet);
		

		
		System.out.println("\n--- 개선된 for문 형태로 ---");
		for (Entry<String,Integer> entry : entrySet) {
			 System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
		}
				
		

		System.out.println("\n--- entrySet.iterator() 사용 ---");
		Iterator<Entry<String, Integer>> ite = entrySet.iterator();
		while (ite.hasNext()) {
			Entry<String, Integer> entry = ite.next();
			System.out.println("key: " + entry.getKey() 
					+ ", value: " + entry.getValue());
		}

		
		System.out.println("-- 점수 합계, 평균 구하기 --");
		int sum = 0;
		for (int value : map.values()) {
			sum += value;
		}
		double avg = sum * 100 / 5 / 100.0;
		
		
		
		System.out.println("점수 합계 : " + sum);
		System.out.println("점수 평균 : " + avg);
		
		
		

	}

}




