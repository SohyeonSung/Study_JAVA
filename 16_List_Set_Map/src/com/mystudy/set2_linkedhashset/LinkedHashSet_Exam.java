package com.mystudy.set2_linkedhashset;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSet_Exam {

	public static void main(String[] args) {
		// LinkedHashSet : 저장된 순서가 유지되는 자료구조
		System.out.println("==== LinkedHashSet =====");
		System.out.println(":: LinkedHashSet : 저장된 순서가 유지되는 자료구조");
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("홍길동");
		linkedHashSet.add("김유신");
		linkedHashSet.add("강감찬");
		linkedHashSet.add("을지문덕");
		linkedHashSet.add("홍경래");
		System.out.println("LinkedHashSet : " + linkedHashSet);
		//LinkedHashSet : [홍길동, 김유신, 강감찬, 을지문덕, 홍경래]
		System.out.println("---------");
		for (String name : linkedHashSet) {
			System.out.println(name);
		}
		
		System.out.println("\n==== HashSet =======");
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("홍길동");
		hashSet.add("김유신");
		hashSet.add("강감찬");
		hashSet.add("을지문덕");
		hashSet.add("홍경래");
		System.out.println("hashSet : " + hashSet);
		//hashSet : [홍경래, 홍길동, 김유신, 을지문덕, 강감찬]
		
		System.out.println("---------");
		for (String name : hashSet) {
			System.out.println(name);
		}

	}

}






