package com.mystudy.ex03_isr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_Exam {

	public static void main(String[] args) {
		System.out.println(">> main() 시작");
		File file = new File("file/test_osw.txt");
		
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		
		try {
			fos = new FileOutputStream(file);
			fos.write('A'); // 정상출력
			fos.write('@'); // 정상출력
			fos.write('가'); //한글 출력 안됨(UTF-8 형식에서 "가"는 3byte문자)
			fos.write('\n');
			
			// byte 계열을 문자 계열로 전환
			osw = new OutputStreamWriter(fos);
			osw.write('가');
			osw.flush();
			
			osw.write("안녕~~ Hello Java!!!\n");
			osw.flush();
			
			osw.write("마지막문장~ close 하세요~~~\n");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (osw != null) osw.close();
			} catch (IOException e) {}
		}

		
		System.out.println(">> main() 끝");
	}

}




