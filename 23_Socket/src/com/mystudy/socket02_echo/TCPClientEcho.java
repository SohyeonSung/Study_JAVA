package com.mystudy.socket02_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEcho {
	public static void main(String[] args) {
		//(실습) 클라이언트 : 쓰고, 읽기
		// 서버쪽으로 메시지를 보내기 - PrintWriter
		// 서버쪽에서 보내온 메시지 받기 - BufferedReader
		// PrintWriter <- OutputStream
		// BufferedReader <- InputStreamReader <- InputStream
		//------------------------------------------
		System.out.println(">> 클라이언트 main() 시작~~");
		
		Socket socket = null;
		
		//메시지 쓰고, 읽기 위한 객체 저장할 변수 선언
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			socket = new Socket("localhost", 10000);
			System.out.println(":: 서버 접속 완료(성공)");
			
			//서버쪽으로 메시지 보내기
			//OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(socket.getOutputStream());
			
			String msg = "안녕~~~";
			pw.println(msg);
			pw.flush(); //버퍼 데이터 전송
			System.out.println(">보낸메시지 : " + msg);
			
			//서버쪽에서 보내온 메시지 받고 화면출력
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String receiveMsg = br.readLine();
			System.out.println(">받은메시지 : " + msg);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(">> main() 끝~~");
	}

}
