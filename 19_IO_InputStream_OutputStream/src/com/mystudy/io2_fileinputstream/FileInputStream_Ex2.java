package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex2 {

	public static void main(String[] args) {
		//File file = new File("file/test01.txt");

		FileInputStream fis = null;
		try {
			//1. 객체 생성
			//fis = new FileInputStream(file); // File 객체 전달받아 사용
			fis = new FileInputStream("file/test01.txt");
			
			//(실습)2. 객체 사용 작업처리(1 byte 읽고, 화면 출력 반복)
			/*
			int readValue = fis.read();
			while (readValue != -1) {
				System.out.println("read int값 : " + readValue);
				System.out.println("char : " + (char)readValue);
				readValue = fis.read();
			}
			*/
			int readValue;
			while ((readValue = fis.read()) != -1) {
				System.out.println("read int값 : " + readValue);
				System.out.println("char : " + (char)readValue);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(":: 파일을 못찾았습니다");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println(":: 파일 읽다가 오류발생 ");
			//e.printStackTrace();
		} finally {
			//3. 사용 객체 닫기(close)
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		System.out.println();
		
		System.out.println(">> main() 끝");
		
	}

}