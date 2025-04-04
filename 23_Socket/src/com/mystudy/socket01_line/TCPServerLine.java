package com.mystudy.socket01_line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerLine {

	public static void main(String[] args) {
		// 서버측 : 클라이언트가 보내온 메시지를 1번 읽어서 화면 출력
		// BufferedReader 사용해서 라인단위로 읽기
		// BufferedReader <-- InpuStreamReader <-- InpuStream
		//-------------------------------
		System.out.println("::: 서버 시작");
		
		ServerSocket server = null;
		
		try {
			//1. ServerSocket 객체 생성 - 서비스할 포트번호(port) 지정
			server = new ServerSocket(10000);
			System.out.println("서버/IP : " + InetAddress.getLocalHost());
			System.out.println(">> 서버(ServerSocket) 대기중~~~");
			
			//2. 서버소켓 대기중 접속한 Socket과 통신할 수 있는 Socket 객체 생성
			Socket socket = server.accept();
			System.out.println(">> 클라이언트 접속됨~~~");
			
			//3. Socket 으로 부터 InputStream, OutputStream 객체 생성
			OutputStream os = socket.getOutputStream();
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			//4. 받을 메시지가 있으면 읽기
			String msg = br.readLine();
			System.out.println("[서버-받은메시지] " + msg);
			
			//5. 보낼 메시지가 있으면 보내기(쓰기)
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//6. 자원 반납(close)
			try {
				if (server != null) server.close();
			} catch (IOException e) {}
		}
		
		
		
		System.out.println("::: 서버 종료");
	}

}










