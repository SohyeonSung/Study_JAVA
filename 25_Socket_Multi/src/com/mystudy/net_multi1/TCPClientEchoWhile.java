package com.mystudy.net_multi1;

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
		//(추가) 메시지 보내고, 받기 반복 - "exit" 입력하면 종료
		//-----------------------------
		System.out.println(">> 클라이언트 main() 시작~~");
		
		Socket socket = null;
		
		//메시지 쓰고, 읽기 위한 객체 저장할 변수 선언
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			socket = new Socket("localhost", 10000);
			System.out.println(":: 서버 접속 완료(성공)");
			
			Scanner scan = new Scanner(System.in);
			pw = new PrintWriter(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while (true) {
				//메시지 보내기(출력/쓰기) ---------------
				System.out.print(">메시지 : ");
				String msg =scan.nextLine();
				
				pw.println(msg);
				pw.flush(); //버퍼 데이터 전송
				
				if (msg.equalsIgnoreCase("exit")) {
					System.out.println(":: 메시지 보내기 종료~~~");
					break;
				}
				
				//메시지 받기(입력/읽기) ------------------
//				String receiveMsg = br.readLine();
//				System.out.println(">받은메시지 : " + msg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
			System.out.println(":: PrintWriter 종료");
			try {
				if (br != null) br.close();
				System.out.println(":: BufferedReader 종료");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (socket != null) socket.close();
				System.out.println(":: Socket 종료");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(">> main() 끝~~");
	}

}