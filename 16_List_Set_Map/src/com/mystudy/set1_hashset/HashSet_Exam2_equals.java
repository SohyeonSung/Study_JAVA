package com.mystudy.set1_hashset;

import java.util.HashSet;

class Person {
	String id; //주민번호
	String name;
	String address;
	public Person(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	@Override
	public int hashCode() {
		System.out.println(":: hashCode() 실행 : " + id);
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println(":: equals(Object obj) 실행~~");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	 
	
}

public class HashSet_Exam2_equals {

	public static void main(String[] args) {
		Person p1 = new Person("991111-1234567", "홍길동", "서울");
		Person p2 = new Person("991111-1234567", "홍길동", "부산");

		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);
		System.out.println("p1.hashCode() : " + p1.hashCode());
		System.out.println("p2.hashCode() : " + p2.hashCode());
		System.out.println("p1.hashCode() == p2.hashCode() : " 
				+ (p1.hashCode() == p2.hashCode()));
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		
		System.out.println("===================");
		HashSet<Person> set = new HashSet<>();
		System.out.println(">> p1 입력(최초입력)");
		set.add(p1);
		System.out.println(">> p2 입력(두번째) ----");
		set.add(p2);
		
		System.out.println(">> 다른 데이터 입력 ----");
		set.add(new Person("11111-2222222", "테스트", "테스트"));
		System.out.println("set : " + set);
		
		System.out.println("==== 전체 데이터 확인 ===");
		for (Person vo : set) {
			System.out.println(vo.id + ", " + vo.name);
		}
		
		System.out.println("-- 홍경래 입력(주민번호 똑같은 입력)");
		set.add(new Person("991111-1234567", "홍경래", "서울"));
		
		System.out.println("==== 전체 데이터 확인 ===");
		for (Person vo : set) {
			System.out.println(vo.id + ", " + vo.name);
		}
		
	}

}












