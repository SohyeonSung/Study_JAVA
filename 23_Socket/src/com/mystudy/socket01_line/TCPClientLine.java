package com.mystudy.socket01_line;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientLine {

	public static void main(String[] args) throws UnknownHostException {
		// 서버 접속 후 PrintWriter 사용해서 메시지 1번 보내기
		// PrintWriter <- OutputStream
		//-------------------------------------------
		System.out.println(">>> 클라이언트 시작");
		Socket socket = null;
		
		System.out.println("현재컴퓨터IP : " + InetAddress.getLocalHost());
		System.out.println(">> 서버 접속 시도~~~");
		
		try {
			//1. 소켓(Socket) 생성 : 접속할 IP주소, 포트(port) 정보로 서버 접속
			//socket = new Socket(InetAddress.getLocalHost(), 10000);
			//socket = new Socket("192.168.18.26", 10000); //서버IP주소, 포트
			socket = new Socket("localhost", 10000); //동일컴퓨터(현재PC), 포트
			System.out.println(":: 서버 접속 성공!!!");
			
			//2. 소켓으로부터 입/출력 객체 생성 - InputStream, OutputStream
			InputStream is = socket.getInputStream();
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			//3. 전송(out)할 데이터가 있으면 쓰기(write)
			String msg = "안녕~~ 소켓통신 공부중";
			System.out.println("[Client-보낸메시지] " + msg);
			pw.println(msg);
			pw.flush(); //버퍼 데이터 강제출력
			
			//4. 받을 메시지가 있으면 읽기
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) socket.close();
			} catch (IOException e) {}
		}
		
		System.out.println(">>> 클라이언트 끝");
	}

}







