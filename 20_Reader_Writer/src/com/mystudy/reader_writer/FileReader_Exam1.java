package com.mystudy.reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Exam1 {

	public static void main(String[] args) {
		// 문자(character) 단위 입력 처리
		// FileReader : 파일로부터 문자단위 데이터 읽기
		// 문자단위 : A, 1, $ -> 1 byte 문자(또는 2 byte)
		//         가, 대, 한 -> 3 byte (또는 2 byte)
		// UTF-8 방식 : ASCII 코드 1byte, 한글 3byte
		// UTF-16 방식 : 모든 문자 2byte
		//------------------------------------------
		
		File file = new File("file/test_char.txt");
		
		FileReader fr = null; 
		
		try {
			//1. 객체(인스턴스) 생성
			fr = new FileReader(file);
			
			//2. 객체 사용 작업 처리(1문자 읽고, 화면출력)
			int readValue = fr.read();
			System.out.println("첫번째문자값 : " + readValue 
					+ ", char: " + (char)readValue);
			
			readValue = fr.read();
			System.out.println("두번째문자값 : " + readValue 
					+ ", char: " + (char)readValue);
			
			readValue = fr.read();
			System.out.println("세번째문자값 : " + readValue 
					+ ", char: " + (char)readValue);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			//3. 사용객체 닫기(close)
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {}
			}
		}
		
		
		
		
		
		
	}

}
