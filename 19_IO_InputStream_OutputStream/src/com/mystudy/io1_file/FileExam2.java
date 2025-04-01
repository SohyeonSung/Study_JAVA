package com.mystudy.io1_file;

import java.io.File;
import java.io.IOException;

public class FileExam2 {

	public static void main(String[] args) throws IOException {
		// 파일명 : temp.txt - 파일명.확장자(명)
		File file1 = new File("temp.txt"); //상대주소 방식
		// File 객체생성은 파일존재 여부와 관계없이 생성 가능
		System.out.println("file1 : " + file1.toString());
		
		//절대주소 방식 : Root 디렉토리(폴더)로 부터 전체 경로를 표시(위치 불변)
		//File file2 = new File("c:\\temp\\temp.txt");
		File file2 = new File("c:/temp/temp.txt");
		System.out.println("file2 : " + file2);
		
		//상대경로 방식(. : 현재위치, .. : 상위디렉토리(폴더))
		//현재위치에 따라 경로가 다르게 변함
		File file3 = new File("./file/temp.txt"); // ./file/temp.txt (동일 file/temp.txt)
		System.out.println("file3 : " + file3);
		
		System.out.println("====================");
		System.out.println("---- exists() : 파일의 물리적 존재 여부 ---");
		System.out.println("있냐? file1 : " + file1.exists());
		System.out.println("있냐? file2 : " + file2.exists());
		
		System.out.println("--- File 속성 정보 ---");
		System.out.println("file1.length() : " + file1.length() + " (byte)");
		System.out.println("file1.canRead() : " + file1.canRead());
		System.out.println("file1.canWrite() : " + file1.canWrite());
		System.out.println("file1.canExecute() : " + file1.canExecute());
		
		System.out.println("--- getPath() : 객체생성 경로와 파일명 ----");
		System.out.println("file1.getPath() : " + file1.getPath());
		System.out.println("file2.getPath() : " + file2.getPath());
		
		System.out.println("--- getName() : 파일명만 ----");
		System.out.println("file1.getName() : " + file1.getName());
		System.out.println("file2.getName() : " + file2.getName());
		
		System.out.println("--- isDirectory(), isFile() ---");
		System.out.println("file1.isDirectory() : " + file1.isDirectory());
		System.out.println("file1.isFile() : " + file1.isFile());
		
		System.out.println("================");
		File file4 = new File("file/temp4.txt");
		
		file4.createNewFile(); //없으면 새로 만듬 - 디렉토리는 못만듬(IOException)
		
		System.out.println("=========");
		File file5 = new File("temp1/temp2/temp3");
		System.out.println("file5.mkdirs() : " + file5.mkdirs());
		
		System.out.println(">> main() 끝");
	}

}








