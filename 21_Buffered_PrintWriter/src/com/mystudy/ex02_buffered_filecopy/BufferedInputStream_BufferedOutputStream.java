package com.mystudy.ex02_buffered_filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStream_BufferedOutputStream {

	public static void main(String[] args) {
		//(실습) BufferedInputStream, BufferedOutputStream 적용
		// 파일복사(binary) : img30.jpg(원본) --> img30_copy_buf.jpg(복사본)
		// File -> FileInputStream -> BufferedInputStream
		// File -> FileOutputStream -> BufferedOutputStream
		//---------------------------------
		System.out.println(">>main() 시작");
		File inputFile = new File("file/img30.jpg");
		BufferedInputStream bis = null;
		
		BufferedOutputStream bos = null;
		
		try {
			//입력용 객체 생성
			FileInputStream fis = new FileInputStream(inputFile);
			bis = new BufferedInputStream(fis, 1000);
			
			//출력용 객체 생성
			FileOutputStream fos = new FileOutputStream("file/img30_copy_buf.jpg");
			bos = new BufferedOutputStream(fos, 1000);
			
			int readValue = bis.read();
			while (readValue != -1) {
				bos.write(readValue);
				readValue = bis.read();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) bis.close();
			} catch (IOException e) {}
			
			try {
				if (bos != null) bos.close();
			} catch (IOException e) {}
		}
		
		System.out.println(">>main() 끝");
	}

}



