package com.mystudy.ex05_data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStream_Exam {

	public static void main(String[] args) {
		// DataInputStream, DataOutputStream
		// 기본 데이터 타입(8종류) 형식 쓰고, 읽기
		//---------------------
		File file = new File("file/data_io_stream.txt");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			// 파일에 쓰기위한 객체
			//fos = new FileOutputStream(file);
			//dos = new DataOutputStream(fos);
			dos = new DataOutputStream(new FileOutputStream(file));
			
			System.out.println(":: 기본데이터타입 값 출력");
			dos.writeBoolean(false); //1 byte
			dos.writeByte(100); //1 byte
			dos.writeShort(999); //2 byte
			dos.writeChar('A'); //2 byte
			dos.writeInt(100000); //4 byte
			dos.writeDouble(Math.PI); //8 byte
			dos.writeUTF("점심시간~~~ 신난다~~ ^^");
			System.out.println("파일크기: " + file.length() + "(byte)");
			
			//읽기 위한 객체 생성
			//fis = new FileInputStream(file);
			//dis = new DataInputStream(fis);
			
			dis = new DataInputStream(new FileInputStream(file));
			
			System.out.println(":: 기본데이터 형식으로 읽기");
			boolean readBoolean =  dis.readBoolean();
			byte readByte = dis.readByte();
			short readShort = dis.readShort();
			char readChar = dis.readChar();
			int readInt = dis.readInt();
			double readDouble = dis.readDouble();
			String readUTF = dis.readUTF();
			
			System.out.println("--- 읽은 데이터 화면 출력 ---");
			System.out.println("readBoolean : " + readBoolean);
			System.out.println("readByte : " + readByte);
			System.out.println("readShort : " + readShort);
			System.out.println("readChar : " + readChar);
			System.out.println("readInt : " + readInt);
			System.out.println("readDouble : " + readDouble);
			System.out.println("readUTF : " + readUTF);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) dos.close();
			} catch (IOException e) {}
		}
		
		
		
		
		

	}

}