package com.mystudy.ex03_interface;

//인터페이스는 static final 속성값, 추상(abstract)메소드가 있다
interface I_Phone { //public 있고, 없고

	
	// {} 없음 : 추상메소드 (abstract method)
	// 인터페이스에 정의된 추상메소드는 모두 public abstract 메소드
	public abstract void view(); //전화번호 확인
	public void call(); //전화걸기 (abstract 생략)
	void receiveCall(); //전화받기 (public, abstract 생략)
	void sendMsg(); //메세지 보내기 (public, abstract 생략)
	void receiveMsg(); //메세지 받기 (public, abstract 생략)

	
	
	class Phone {
		//필드(속성) ------------
		private String type; //전화타입(형태)
		private String phoneNo; //전화번호
		
		//생성자 -------------
		public Phone() {}
		public Phone(String phoneNo) {
			this.type = "Phone 타입";
			this.phoneNo = phoneNo;
		}
		
		public Phone(String type, String phoneNo) {
			super();
			this.type = type;
			this.phoneNo = phoneNo;
		}
		
		//메소드 -----------------
		public String getType() {
			return type;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		
		//전화걸기 기능
		public void call() {
			System.out.println("Phone>> 전화걸기");
		}
		
		//전화받기 기능
		public void receiveCall() {
			System.out.println("Phone>> 전화받기");
		}
		
		//전화정보 보기
		public void view() {
			System.out.println("Phone>>타입: " + type + ", 전화번호: " + phoneNo);
		}
		

		
	}
}
