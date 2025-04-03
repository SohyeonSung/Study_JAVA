package com.mystudy.ex03_isr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_Exam {

	public static void main(String[] args) {
		// InputStream ---> Reader
		// byte 처리 계열 ---> 문자(Charecter) 처리 계열 전환
		// InputStreamReader : InputStream -> Reader 전환
		// OutputStreamWriter : OutputStream -> Writer 전환
		//--------------------
		
		File file = new File("file/test_isr.txt");
		
		FileInputStream fis = null;
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream(file);
			
//			int readByte = fis.read(); // 1 byte 읽기
//			System.out.println((char)readByte);
//			
//			readByte = fis.read(); // 1 byte 읽기
//			System.out.println((char)readByte); //한글깨짐
			
			// byte 처리계열을 문자 처리계열로 전환
			isr = new InputStreamReader(fis);
			
			int readIsr = isr.read(); // 1문자 읽기
			System.out.println((char) readIsr);
			
			readIsr = isr.read(); // 1문자 읽기
			System.out.println((char) readIsr);
			
			//버퍼기능 사용해서 라인단위 읽기
			br = new BufferedReader(isr); //버퍼기능 + 문자단위 + 파일에서 읽기
			String str = br.readLine();
			System.out.println(str);
			
			while (true) {
				str = br.readLine(); //EOF 만나면 null 리턴
				if (str == null) break;
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException e) {}
		}

	}

}







