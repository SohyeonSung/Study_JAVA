package com.mystudy.net_multi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 메세지를 보내고 싶을 때 보내고, 서버에서 보낸 메세지를 언제든지 받기
// 쓰기 전용 스레드 : 메세지 작성 및 전송을 독립적으로 처리 (언제든지 메세지 보내기)
// 읽기 전용 스레드 : 서버쪽으로부터 받은 메세지를 읽어서 화면 출력 (언제든지 읽기)
public class TCPClientMultiChat {

	public void start() {
		System.out.println(">> client 시작!!");
		Socket socket = null;
		
		try {
			//socket = new Socket("localhost", 10000);
			socket = new Socket("192.168.18.26", 10000);
			System.out.println(":: 서버 접속 성공");
			
			//메시지 전송 쓰레드 만들기
			ClientSender clientSender = new ClientSender(socket);
			clientSender.start();
			
			//메시지 수신 쓰레드 만들기
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			clientReceiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 메시지 전송 쓰레드
	private class ClientSender extends Thread {
		private Socket socket;
		private DataOutputStream out;

		public ClientSender(Socket socket) {
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("[예외발생] ClientSender 생성자 "
						+ "out 객체 생성 실패");
			}
		}
		
		@Override
		public void run() {
			if (out == null) {
				System.out.println("[예외발생] out 객체가 null 입니다");
				return;
			}
			
			//메시지 작성하고, 작성된 메시지 서버로 전송
			Scanner sc = new Scanner(System.in);
			
			try {
				System.out.print("사용할 이름(별칭) 입력 : ");
				String name = sc.nextLine();
				
				out.writeUTF(name); //첫번째 메시지 전송 : 이름(별칭)
				
				while (true) {
					System.out.print("메시지 작성> ");
					String msg = sc.nextLine();
					
					out.writeUTF(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(":: 전송종료");
		}
		
	}
	
	//메시지 수신 쓰레드
	private class ClientReceiver extends Thread {
		private Socket socket;
		DataInputStream in;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// 메시지를 받아서 화면 출력(반복)
			try {
				while (true) {
					String msg = in.readUTF();
					System.out.println(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(":: 더이상 읽을 수 없습니다");
			}
		}
		
	}
	
	

}



