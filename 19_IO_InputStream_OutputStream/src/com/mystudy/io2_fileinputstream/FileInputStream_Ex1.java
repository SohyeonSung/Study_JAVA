package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex1 {

	public static void main(String[] args) {
		//FileInputStream : byte 단위로 파일로 부터 읽기(입력)
		File file = new File("temp.txt");
		
		//파일로 부터 읽고, 읽은 값을 화면에 출력
		FileInputStream fis = null;
		try {
			//1. 사용할 객체 생성
			fis = new FileInputStream(file);
			
			//2. 객체 사용해서 작업 처리(읽기)
			int readValue = fis.read();
			System.out.println("read() int값 : " + readValue);
			System.out.println("(char)read() : " + (char)readValue);
			
			System.out.println("--- 나머지 전체 읽어서 화면 출력 ---");
			while (true) {
				//EOF(End Of File)를 만나면(더이상 읽을 것이 없으면) -1 리턴
				readValue = fis.read();
				if (readValue == -1) break; //파일의 끝이면
				System.out.println("read() int값 : " + readValue);
				System.out.println("char : " + (char)readValue);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("::파일이 없습니다");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용 객체 닫기(close)
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(">>main() 끝");
		
	}

}