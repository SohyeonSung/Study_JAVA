package com.mystudy.net_multi1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 다중 접속을 처리할 수 있는 서버(독립적인 쓰레드 - 읽기전용 쓰레드)
public class TCPServerMulti_InnerClass {

	public TCPServerMulti_InnerClass() {
		serverStart();
	}
	
	private void serverStart() {
		// 서버소켓을 만들고, 클라이언트의 접속 처리를 반복
		// 접속된 클라이언트에 대한 읽기전용 쓰레드 생성
		ServerSocket server = null;
		
		try {
			System.out.println(">> 서버소켓 객체(인스턴스) 생성");
			server = new ServerSocket(10000);
			
			while (true) {
				System.out.println(">> 접속 대기중...."
						+ InetAddress.getLocalHost().getHostAddress()
						+ ":" + server.getLocalPort());
	
				Socket socket = server.accept();
				System.out.println("[" + socket.getRemoteSocketAddress() + "] 접속");
				
				// 접속된 클라이언트에 대한 처리 - 읽기전용 쓰레드 생성
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start(); // 쓰레드로 동작 시키기
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null) server.close();
			} catch (IOException e) {}
		}
		System.out.println("::: 서버종료~~~");
	}//메소드 끝

	//ServerReceiver : 클라이언트에서 보내온 메시지 수신 전용 쓰레드
	//클라이언트에서 보내온 메시지 읽어서 화면에 표시
	private class ServerReceiver extends Thread {
		Socket socket;

		public ServerReceiver(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			//클라이언트에서 보내온 메시지를 읽어서 화면 출력
			System.out.println(":: 읽기전용 쓰레드 시작~~");
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				while (true) {
					String msg = br.readLine();
					if (msg == null || "exit".equalsIgnoreCase(msg)) break;
					System.out.println("> " + msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println(socket.getInetAddress().getHostAddress()+">> 클라이언트 종료");
				try {
					if (br != null) br.close();
				} catch (IOException e) {}
			}
			
		}
	}
	
	
	
}//class 끝






