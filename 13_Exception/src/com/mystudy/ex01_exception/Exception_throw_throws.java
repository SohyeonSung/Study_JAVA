package com.mystudy.ex01_exception;

public class Exception_throw_throws {

	public static void main(String[] args) {
		// throw : 예외를 발생시킬 때 사용
		// throw 예외객체;
		//-------------
		// throws : 예외를 던질 때(위임, 전가) 사용 - method 선언부에 사용
		// 예외가 발생한 곳에서 처리하지 않고, 예외를 던져서 다른 곳에서 처리토록 함
		// 메소드를 호출한 곳에서 처리하도록 예외를 던짐
		//-----------------
		System.out.println("--- main() 시작 ----");
		try {
			test(999);
		} catch (Exception e) {
			System.out.println("예외메시지 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("--- main() 끝 ----");
	}

	// throws : 호출한 곳으로 예외를 던짐(예외처리 위임, 전가)
	static void test(int idx) throws Exception {
		System.out.println(">> test() 시작 ---");
		int[] num = new int[3]; //인덱스 0, 1, 2
		
		try {
			num[idx] = 100;
			System.out.println("[정상] 인덱스값 정상 : " + idx);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("[비정상] 인덱스값 비정상");
			// 예외 발생 시키기 : throw 사용
			throw new Exception("잘못된 인덱스번호 사용");
		}
		
		System.out.println(">> test() 끝 ---");
	}

}










