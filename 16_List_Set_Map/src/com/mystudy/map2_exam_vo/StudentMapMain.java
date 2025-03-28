package com.mystudy.map2_exam_vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.mystudy.list5_vo.StudentVO;

public class StudentMapMain {

	public static void main(String[] args) {
		/* (실습) Map<K,V>을 사용한 성적 처리
		사용클래스명 : StudentVO
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(학번,성명,국어,영어,수학)를 만들고(저장하고)
		   "A01", "김유신", 100, 90, 81
		   "A02", "이순신", 95, 88, 92
		   "A03", "홍길동", 90, 87, 77
		2. HashMap 타입의 변수(map)에 저장하고
		2-1. map에 StudentVO 데이터 입력하기
		2-2. map 데이터 중 "A01" 데이터 화면 출력해보기
		3. map에 있는 전체 데이터 화면출력
		   학번  성명   국어  영어  수학  총점  평균
		   ------------------------------------------
		   A01  김유신  100   90    81    271   90.33
		   ...
		4. 특정 학생의 데이터를 수정(변경) 처리
		4-1. 학생번호(ID)가 A01 인 학생의 국어 점수를 95 점으로 수정 하고,
		4-2. A01 데이터만 출력
		   출력예 --------
		   학번 : A01
		   성명 : 김유신
		   국어 : 95
		   영어 : 90
		   ... 
		5. 전체 데이터 화면 출력
		   (3번 형식으로 출력 또는 학번,성명,총점,평균만)
		***********************************/
		/*
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(학번,성명,국어,영어,수학)를 만들고(저장하고)
		   "A01", "김유신", 100, 90, 81
		   "A02", "이순신", 95, 88, 92
		   "A03", "홍길동", 90, 87, 77
		======================= */
		StudentVO stu1 = new StudentVO("A01", "김유신", 100, 90, 81);
		StudentVO stu2 = new StudentVO("A02", "이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("A03", "홍길동", 90, 87, 77);
		System.out.println("stu1 : " + stu1);
		System.out.println("stu2 : " + stu2);
		System.out.println("stu3 : " + stu3);
		
		System.out.println("2. =====================");
		//2. HashMap 타입의 변수(map)에 저장하고
		//HashMap<String, StudentVO> map = new HashMap<String, StudentVO>();
		Map<String, StudentVO> map = new TreeMap<String, StudentVO>();
		map.put(stu3.getId(), stu3);
		map.put(stu2.getId(), stu2);
		map.put(stu1.getId(), stu1);
		
		System.out.println("map : " + map);
		System.out.println("map.size() : " + map.size());
		
		System.out.println("3. ====================");
		//3. map에 있는 전체 데이터 화면출력
		Collection<StudentVO> mapCollection = map.values();
		for (StudentVO vo : mapCollection) {
			System.out.println(vo.getId() + ", " + vo.getName() + ", " + vo.getAvg());
		}
		System.out.println("-----");
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			StudentVO vo = map.get(key);
			System.out.println(vo.getId() + ", " + vo.getName());
		}
		System.out.println("-----");
		
		// Entry 타입 데이터 사용방법
		
		System.out.println("4. =====================");
		//4. 특정 학생의 데이터를 수정(변경) 처리
		//4-1. 학생번호(ID)가 A01 인 학생의 국어 점수를 95 점으로 수정 하고,
		String findId = "A03";
		StudentVO student = map.get(findId);
		if (student != null) {
			student.setKor(95);
		} else {
			System.out.println(findId + "이 없어서 수정못함");
		}
		System.out.println("student : " + student);
		if (student != null) {
			printData(student);
		} else {
			System.out.println(findId + " 찾은 데이터가 없어서 출력못함");
		}
		
		
		

	}

	static void printData(StudentVO vo) {
		System.out.println("학번 : " + vo.getId());
		System.out.println("이름 : " + vo.getName());
		System.out.println("국어 : " + vo.getKor());
		System.out.println("영어 : " + vo.getEng());
		System.out.println("수학 : " + vo.getMath());
		System.out.println("총점 : " + vo.getTot());
		System.out.println("평균 : " + vo.getAvg());
	}
	
	
	
}











