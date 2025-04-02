package com.mystudy.ex01_buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExamTWR {

	public static void main(String[] args) {
		// 버퍼(buffer) 기능이 구현되어 있는 클래스
		// 버퍼 : 데이터를 저장하는 공간
		// BufferedReader, BufferedWriter
		// File -> FileReader -> BufferedReader
		//-----------------
		
		
		//파일로 부터 읽기 위한 객체(인스턴스) 생성
		//버퍼기능 + 파일읽기(문자단위)
		//파일에 쓰기 위한 객체 생성
		File inFile = new File("file/test_buf_rw_in.txt");
		File outFile = new File("file/test_buf_rw_out.txt");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFile));
			 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFile));) {
			
			bufferedWriter.write("안녕하세요. 자바공부중입니다\n");
			bufferedWriter.write("Hello Java~~~");
			bufferedWriter.newLine();
			bufferedWriter.write("I/O, I-O 할만한가요?");
			bufferedWriter.newLine();
			bufferedWriter.write("---------------");
			bufferedWriter.newLine();
			
			//======================
			//파일로 부터 읽고, 파일에 쓰기(버퍼기능 이용)
			//파일에서 읽기(한 번 읽기)
			String str = bufferedReader.readLine();
			System.out.println("readLine() 읽은 값 : " + str);
			
			//파일에 쓰기(한 번 쓰기)
			bufferedWriter.write(str);
			bufferedWriter.newLine();
			
			//남은 데이터 모두 읽고, 쓰기
			while (true) {
				str = bufferedReader.readLine(); //EOF : null 리턴
				if (str == null) break;
				System.out.println("readLine() 읽은 값 : " + str);
				bufferedWriter.write(str);
				bufferedWriter.newLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
		
		

	}

}
