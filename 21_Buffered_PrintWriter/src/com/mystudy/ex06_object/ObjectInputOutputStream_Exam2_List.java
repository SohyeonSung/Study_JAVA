package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputOutputStream_Exam2_List {

	public static void main(String[] args) {
		//(실습) StudentVO 객체를 ArrayList에 담아서 파일에 저장하고
		// 파일에서 읽어들인 ArrayList 객체에 담긴 VO 데이터 화면출력
		// 출력항목 : ID, 성명, 총점, 평균
		// 사용할 파일명 : file/object_io_list.txt
		//----------------------
		// VO 데이터 생성 -> List에 추가 -> List를 파일에 출력(저장)
		// 파일에서 List 읽기 -> List에 있는 VO 데이터 화면 출력
		//---------------------------
		
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		//List<StudentVO> list = new ArrayList<StudentVO>();
		list.add(new StudentVO("A01", "김유신", 100, 90, 81));
		list.add(new StudentVO("A02", "이순신", 95, 88, 77));
		list.add(new StudentVO("A03", "홍길동", 100, 90, 82));
		System.out.println("list.size() : " + list.size());
		System.out.println(list);
		System.out.println("-------");
		
		StudentVO vo1 = list.get(0);
		System.out.println(vo1.getId() + ", " + vo1.getName());
		
		System.out.println("==== List를 파일에 저장 ====");
		File file = new File("file/object_io_list.txt");
		
		try (ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(file));
			 ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(file)); ) {
			System.out.println(">> List 파일에 저장");
			oos.writeObject(list);
			System.out.println(">> List 파일에 완료");
			
			System.out.println("--- 파일데이터(List) 읽기 ----");
			List<StudentVO> readList = (List<StudentVO>) ois.readObject();
			System.out.println("readList.size() : " + readList.size());
			
			for (StudentVO vo : readList) {
				System.out.printf("%s, %s, %s, %s\n", 
						vo.getId(), vo.getName(), vo.getTot(), vo.getAvg());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
