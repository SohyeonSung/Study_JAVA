package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStream_Exam {

	public static void main(String[] args) {
		// ObjectInputStream, ObjectOutputStream
		// Object 타입의 데이터를 사용해서 입출력(I/O)
		//--------------
		// Object 타입의 데이터를 파일에 저장하고 읽어오기(StudentVO)
		
		System.out.println("--- 저장할 데이터 준비 ---");
		StudentVO stu1 = new StudentVO("A01", "김유신", 100, 90, 81);
		StudentVO stu2 = new StudentVO("A02", "이순신", 95, 88, 77);
		StudentVO stu3 = new StudentVO("A03", "홍길동", 100, 90, 82);
		System.out.println("---------화면 출력---------");
		System.out.println("stu1 : " + stu1);
		System.out.println("stu2 : " + stu2);
		System.out.println("stu3 : " + stu3);
		System.out.println("-------------------------");
			
		System.out.println(" === 파일에 저장하기 ===");
		// 파일에 쓰기 위한 용도
		File file = new File("file/object_io.txt");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		
		
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			System.out.println(" >> 파일에 쓰기 (ObjectOutputStream 사용)");
			oos.writeObject(stu1);
			// NotSerializableException
			
			
			
			
			System.out.println(" >> 파일에 쓰기 완료 (ObjectOutputStream 사용)");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos !=null) oos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}



