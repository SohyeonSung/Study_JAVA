package com.mystudy.ex02_extends;


	// 클래스 상속(extends:확장) 실습
	/* (실습) : Phone 클래스 상속 확장(extends)
	WebPhone 클래스 작성
	Phone 클래스를 상속 확장해서 작성
	생성자 정의
		- phoneNo 전달받는 생성자
		- type, phoneNo 전달받는 생성자
	기능 : 전화걸고, 받고, 전화정보보기, 웹검색 할 수 있는 전화기
		웹검색기능
		webSearch() : ">>WebPhone - 웹 검색" 문구 화면 출력
	========================== */


	class WebPhone extends Phone {
		
		public WebPhone(String phoneNo) {
			super(phoneNo);
		}
		
		public WebPhone(String type, String phoneNo) {
			super(type, phoneNo);
		}
		
		//메소드 (기능) -----
		
		public void webSearch() {
			System.out.println(">>WebPhone - 웹 검색");
		}
		
		

	}



