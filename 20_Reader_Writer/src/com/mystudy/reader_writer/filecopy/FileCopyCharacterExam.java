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
		
		
		//0. 사용할 파일객체 생성
				File readFile = new File("file/test_char.txt");
				File writeFile = new File("file/test_char_copy.txt");
				
				//1. FileReader, FileWriter 객체 생성
				//1-1. FileReader, FileWriter 변수 선언 및 초기화
				FileReader fr = null;
				FileWriter fw = null;
				
				try {
					//1-2. FileReader, FileWriter 객체생성 - File 주입받아서
					fr = new FileReader(readFile);
					fw = new FileWriter(writeFile);
					
					//2. 반복작업(원본 파일에서 읽고, 복사파일에 쓰기)
					System.out.println(">> 파일 읽기, 쓰기 시작 ---");
					while (true) {
						int readValue = fr.read();
						if (readValue == -1) break;
						System.out.println(readValue);
						fw.write(readValue);
					}
					
					System.out.println(">> 파일 읽기, 쓰기 끝 ---");
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					//3. 사용객체 닫기(close)
					try {
						if (fr != null) fr.close();
					} catch (IOException e) {}
					try {
						if (fw != null) fw.close();
					} catch (IOException e) {}
					
				}
				
				
				

			}

		}
