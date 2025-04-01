package com.mystudy.io1_file;

import java.io.File;

public class FileExam1 {

	public static void main(String[] args) {
		// File 클래스
		String separator = File.separator; //파일 경로 구분자
		System.out.println("File.separator : " + separator);
		
		char separatorChar = File.separatorChar;
		System.out.println("File.separatorChar : " + separatorChar);
		
		String pathSeparator = File.pathSeparator;
		System.out.println("File.pathSeparator : " + pathSeparator);
		System.out.println("----------");
		
		File[] listRoots = File.listRoots();
		for (File file : listRoots) {
			System.out.println(file);
		}
		

	}

}




