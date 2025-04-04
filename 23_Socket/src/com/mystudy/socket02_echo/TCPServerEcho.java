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

public class TCPServerEcho {
	public static void main(String[] args) {
		//(실습) 서버측 : 읽고, 쓰기
		// 클라이언트에서 보내온 메시지를 1번 받고, - BufferedReader
		// 받은 메시지를 클라이언트에게 다시 보내기 - PrintWriter
		// BufferedReader <- InputStreamReader <- InputStream
		// PrintWriter <- OutputStream
		//------------------------------------------
		
		ServerSocket server = null;
		Socket socket = null;
		
		//메시지를 읽고, 보내기 위한 객체 생성
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			server = new ServerSocket(10000);
			System.out.println(">> 서버시작, 대기중~~~");
			
			socket = server.accept();
			System.out.println("클라이언트 접속 : " + socket.getRemoteSocketAddress());
			
			//클라이언트가 보내온 메시지 읽기
			//InputStream is = socket.getInputStream();
			//System.out.println("Socket InputStream : " + is);
			//InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String msg = br.readLine(); //줄바꿈 문자 이전까지 읽기
			System.out.println("> 받은 메시지 : " + msg);
			
			//받은 메시지 되돌려 주기 ----------
			//OutputStream os = socket.getOutputStream();
			//pw = new PrintWriter(os);
			pw = new PrintWriter(socket.getOutputStream());
			pw.println(msg);
			pw.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(">> 서버 종료");

	}

}
