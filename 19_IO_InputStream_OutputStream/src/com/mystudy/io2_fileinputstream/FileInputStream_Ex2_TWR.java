package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex2_TWR {

	public static void main(String[] args) {
		// try ~ with ~ resoures 구문
		// try (resource 정의) { }
		try (FileInputStream fis = new FileInputStream("file/test01.txt");) {
			
			int readValue;
			while ((readValue = fis.read()) != -1) {
				System.out.println("read int값 : " + readValue);
				System.out.println("char : " + (char)readValue);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(":: 파일을 못찾았습니다");
		} catch (IOException e) {
			System.out.println(":: 파일 읽다가 오류발생 ");
		} 
		System.out.println();
		
		System.out.println(">> main() 끝");
		
	}

}
