package com.mystudy.reader_writer.filecopy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopyCharacterExam {

	public static void main(String[] args) {
		// FileReader, FileWriter 사용해서 파일복사
		// 원본파일 : file/test_char.txt
		// 복사파일 : file/test_char_copy.txt
		// 처리 : 원본파일에서 읽어서 복사파일에 쓰기/저장(문자 단위 처리)
		
		
		File rfile = new File ("file/test_char.txt"); //원본
		File wfile = new File ("file/test_char_copy.txt"); //복사본
		
		FileReader fr = null;
		FileWriter fw = null;
		
		
		
		// 1. 파일을 읽고 쓰기용 객체 생성 
		
		try {
			fr = new FileReader(rfile);
			fw = new FileWriter(wfile);	
			
		//2. 1 byte 읽고, 1 byte 쓰기 - read(), write() 반복	
			System.out.println(">>복사시작");
			while (true) {
				int readValue = fr.read();
				if (readValue == -1) break;
				fw.write(readValue);
			}
			System.out.println(">>복사끝");
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
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {}
			}
		}
		
		
		
		
		

	}

}

