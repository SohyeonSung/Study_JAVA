package com.mystudy.ex02_buffered_filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyBufferedTest {

	public static void main(String[] args) {
		// 경과시간 비교
		// BufferedInputStream, BufferedOutputStream 적용
		// 파일복사(binary) : img30.jpg(원본) --> img30_copy_buf.jpg(복사본)
		// File -> FileInputStream -> BufferedInputStream
		// File -> FileOutputStream -> BufferedOutputStream
		//---------------------------------
		//버퍼없이 : FileInputStream, FileOutputStream
		System.out.println("=== FileInputStream, FileOutputStream 사용 ===");
		File inputFile = new File("file/img30.jpg");
		File outputFile = new File("file/img30_copy.jpg");
		
		long runningTime = filCopy(inputFile, outputFile);
			
		
		//버퍼사용 : BufferedInputStream, BufferedOutputStream
		System.out.println("=== BufferedInputStream, BufferedOutputStream 사용 ===");
		String inputPath = inputFile.getPath();
		String outputPath = "file/img30_copy_buf2.jpg";
		System.out.println("inputPath : " + inputPath);
		
		runningTime = filCopy(inputPath, outputPath);
		
		
	}

	private static long filCopy(String inputPath, String outputPath) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		long runningTime = 0;
		
		try {
			//입력용 객체 생성
			FileInputStream fis = new FileInputStream(inputPath);
			bis = new BufferedInputStream(fis, 1000);
			
			//출력용 객체 생성
			FileOutputStream fos = new FileOutputStream(outputPath);
			bos = new BufferedOutputStream(fos, 1000);
			
			long startTime = System.currentTimeMillis();
			
			int readValue = bis.read();
			
			while (readValue != -1) {
				bos.write(readValue);
				readValue = bis.read();
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println("endTime : " + endTime);
			runningTime = endTime - startTime;
			System.out.println("Buffer 복사시간 : " + runningTime + " (밀리초)");
			
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
		return 0;
	}

	private static long filCopy(File inputFile, File outputFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		long runningTime = 0;
		try {
			//1. 파일을 읽고, 쓰기용 객체 생성(FileInputStream, FileOutputStream)
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			
			//2. 1 byte 읽고, 1 byte 쓰기 - read(), write(데이터) 반복
			long startTime = System.currentTimeMillis();
			
			while (true) {
				int readValue = fis.read();
				if (readValue == -1) break;
				fos.write(readValue);
			}
			long endTime = System.currentTimeMillis();
			runningTime = endTime - startTime;
			System.out.println("byte 복사시간 : " + runningTime + " (밀리초)");
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
		return runningTime;
	}

}
