package com.mystudy.net_multi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

// == 멀티채팅 서버측 기능 ==
// 읽기전용 스레드 : 클라이언트로부터 받은 메세지를 읽고, 접속자 전체에게 메세지 전송
//---------------
// 다중 접속 가능하게 처리
// 현재 접속자 명단 가지고 있기 (유지하기)
// 받은 메세지를 접속자 전체에게 전송하는 기능

public class TCPServerMultiChat {
	private HashMap<String, DataOutputStream> clients; //접속자 명단(별칭, 출력객체)

	public TCPServerMultiChat() {
		clients = new HashMap<String, DataOutputStream>();
	}
	
	//서버소켓 생성하고 대기하다가
	//클라이언트 접속하면 메시지 읽기전용 쓰레드 생성
	public void start() {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println(">> 서버가 시작되었습니다....");
			System.out.println("IP번호:포트번호 - "
					+ InetAddress.getLocalHost().getHostAddress()
					+ ":" + serverSocket.getLocalPort());
			while (true) {
				Socket socket = serverSocket.accept(); //접속 대기
				System.out.println("[" + socket.getInetAddress() 
						+ ":" + socket.getPort() + "] 접속~~");
				
				// 접속자가 보낸 메시지를 읽을 수 있는 읽기 전용 쓰레드 생성
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start(); //쓰레드로 동작
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//ServerReceiver : 접속자가 보낸 메시지 수신 후 접속자 전체에게 전달
	// 생성될때 : 첫메시지(별칭,이름) 사용 + 접속자 명단에 추가 + 입장알림
	// 메시지수신 : 접속자가 보낸 메시지 수신 후 접속자 전체에게 전달
	// 종료할때 : 접속자 명단에서 삭제 + 퇴장알림
	private class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		String name;
		
		public ServerReceiver(Socket socket) { //연결된 소켓 받아서 작업
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void run() {
			// 생성될때 접속자명단에 추가
			// 종료할때 접속자명단에서 삭제
			// 메시지를 받고, 접속된 모든 사람에게 메시지 전달
			
			try {
				//클라이언트로 부터 받은 첫번째 메시지 : 별명(아이디)
				name = in.readUTF();
				System.out.println(":: 접속자> " + name);
				
				//전체에게 접속한 사람 알림
				sendToAll("<" + name + ">님이 입장했습니다");
				
				//접속자 정보를 접속자명단(clients)에 등록
				clients.put(name, out);
				
				//반복작업 - 메시지를 읽고, 전체에게 전달, 화면출력
				while (true) {
					String msg = in.readUTF();
					System.out.println(name + "> " + msg); //서버화면에 출력
					sendToAll(name + "> " + msg); //접속자 전원에게 전달
				}
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				// 클라이언트 접속 종료시 처리
				// 종료할때 접속자명단에서 삭제
				clients.remove(name);
				String outMsg = "<" + name + ">님이 나갔습니다";
				sendToAll(outMsg);
				System.out.println(outMsg);
			}
		}

		//접속자 전체에게 메시지 전달
		private void sendToAll(String msg) {
			for (String key : clients.keySet()) {
				DataOutputStream out = clients.get(key);
				try {
					out.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}





