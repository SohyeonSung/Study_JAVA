package com.mystudy.ex04_printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriter_Exam {

	public static void main(String[] args) {
		// PrintWriter <-- FileOutputStream <-- File
		File file = new File("file/pw_out.txt");
		FileOutputStream fos = null;
		PrintWriter pw = null;
		
		try {
			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			
			pw.write("안녕하세요~~");
			pw.write("반갑습니다\n");
			pw.flush();
			
			pw.print("지금 자바 공부중~~~");
			pw.print("지금은 I-O, I/O 공부중~");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
		}
		
		
		
		
	}

}








