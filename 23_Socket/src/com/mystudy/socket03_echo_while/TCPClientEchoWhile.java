package com.mystudy.socket03_echo_while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientEchoWhile {

	public static void main(String[] args) {
		//(실습) 클라이언트 : 쓰고, 읽기
		// 서버쪽으로 메시지를 보내기 - PrintWriter
		// 서버쪽에서 보내온 메시지 받기 - BufferedReader
		// PrintWriter <- OutputStream
		// BufferedReader <- InputStreamReader <- InputStream
		//------------------------------
		//(추가) 메시지 보내고, 받기 반복
		//-----------------------------
		System.out.println(">> 클라이언트 main() 시작~~");
		
		Socket socket = null;
		
		//메시지 쓰고, 읽기 위한 객체 저장할 변수 선언
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			socket = new Socket("localhost", 10000);
			System.out.println(":: 서버 접속 완료(성공)");
			
			//서버쪽으로 메시지 보내기
			pw = new PrintWriter(socket.getOutputStream());
			
			Scanner scan = new Scanner(System.in);
			
			
			String msg;
			while (true) {
				System.out.print(" > 보낸 메세지 (종료하려면 out을 입력하세요) : " );
				msg = scan.nextLine();
				
				if ("out".equalsIgnoreCase(msg)) {
                    System.out.println("종료합니다.");
                    break;
                }
				

				pw.println(msg);
				pw.flush(); 
				
				//서버쪽에서 보내온 메시지 받고 화면출력
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String receiveMsg = br.readLine();
				System.out.println(">받은 메시지 : " + msg);
					
			}
				
			
	
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
			try {
				if (br != null) br.close();
			} catch (IOException e) {}
			try {
				if (socket != null) socket.close();
			} catch (IOException e) {}
		}
		
		
		System.out.println(">> main() 끝~~");
	}

}
