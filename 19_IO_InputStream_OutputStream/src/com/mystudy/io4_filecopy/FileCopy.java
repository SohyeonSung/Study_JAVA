package com.mystudy.io4_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		// 파일복사 : 원본 파일에서 읽고, 대상 파일에 쓰기
		// 복사할 원본 파일(source file : AS-IS)
		// 쓰기위한 대상 파일(target file : TO-BE)
		//--------------------
		File inputFile = new File("temp.txt"); //원본파일
		File outputFile = new File("file/temp_copy.txt"); //복사본
		
		//File inputFile = new File("file/img30.jpg"); //원본파일
		//File outputFile = new File("file/img30_copy.jpg"); //복사본
		
//		File inputFile = new File("src/com/mystudy/io4_filecopy/FileCopy.java"); //원본파일
//		File outputFile = new File("file/FileCopy_copy.java"); //복사본
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		//(실습) 파일복사 기능 구현
		try {
			//1. 파일을 읽고, 쓰기용 객체 생성(FileInputStream, FileOutputStream)
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			
			//2. 1 byte 읽고, 1 byte 쓰기 - read(), write(데이터) 반복
			System.out.println(">>복사시작---");
			while (true) {
				int readValue = fis.read();
				if (readValue == -1) break;
				fos.write(readValue);
			}
			System.out.println(">>복사끝---");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용객체 닫기(close)
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {}
			}
		}
		
		
		
		
		

	}

}



