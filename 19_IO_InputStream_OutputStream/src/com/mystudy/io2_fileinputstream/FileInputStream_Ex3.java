package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStream_Ex3 {

	public static void main(String[] args) {
		File file = new File("file/test01.txt");
		
		FileInputStream fis = null;
		
		try {
			//1. 파일을 읽기 위한 객체 생성
			fis = new FileInputStream(file);
			
			//read(byte[] b) 사용을 위한 byte 배열 선언
			byte[] bytes = new byte[10];
			System.out.println("bytes : " + Arrays.toString(bytes));
					
			//(실습)2. 객체 사용 작업 처리(읽고, 화면출력 반복)
/*			
			//반복방식1 -----------------
			int readCount = fis.read(bytes);
			while (true) {
				System.out.println("읽은횟수 : " + readCount);
				if (readCount == -1) break;
				System.out.println("bytes : " + Arrays.toString(bytes));
				for (int i = 0; i < readCount; i++) {
					System.out.println("int값: " + bytes[i] + ", char: " + (char)bytes[i]);
				}
				readCount = fis.read(bytes);
			}
*/		
/*			
			//반복방식2 -----------------
			int readCount = fis.read(bytes);
			System.out.println("읽은횟수 : " + readCount);
			while (readCount != -1) {
				System.out.println("bytes : " + Arrays.toString(bytes));
				for (int i = 0; i < readCount; i++) {
					System.out.println("int값: " + bytes[i] + ", char: " + (char)bytes[i]);
				}
				readCount = fis.read(bytes);
				System.out.println("읽은횟수 : " + readCount);
			}
*/
			//반복방식3 -----------------
			int readCount;
			while ((readCount = fis.read(bytes)) != -1) {
				System.out.println("읽은횟수 : " + readCount);
				System.out.println("bytes : " + Arrays.toString(bytes));
				for (int i = 0; i < readCount; i++) {
					System.out.println("int값: " + bytes[i] + ", char: " + (char)bytes[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용 객체 닫기(close)
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {}
			}
		}
		

	}

}








