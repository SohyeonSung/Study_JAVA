package com.mystudy.string;

public class Ex03_String_exam_02 {

	public static void main(String[] args) {
		
		System.out.println("[내가 만든 코드]");
		
	
	
		//String str = "011012-4515753"; // 주민번호
		
		String str = "011012-4515753";
		System.out.println(str);
		
		//1. 전체자리수 14개 여부를 확인하고, '-'위치 : 7번째 여부 확인
		//2. 생년월일 출력(1~2 : 연도, 3~4 : 월, 5~6 : 일)
		//	예) 01년 10월 12일 또는 2001년 10월 12일을 출력
		//3. 성별 확인 출력 (1, 3 : 남성 / 2, 4 : 여성)
		//4. 데이터 값 검증 (월 : 1~12, 일 : 1~31)
		
		//참고) int 형변환할 때 int num = Integer.parseInt("10") 사용
		
		//1. 전체자리수 14개 여부 확인하고, '-' 위치: 7번째 여부 확인
		
		
		
		

		//1.
		if (str.length() == 14) {
			if (str.charAt(6) == '-'){
				System.out.println("정확한 주민번호 형식입니다");
			}
		} else {
				System.out.println("정확하지 않은 주민번호 형식입니다");
			}
		
		
		//2.
		String year = str.substring(0, 2); 
		String month = str.substring(2, 4);
		String day = str.substring(4, 6);
		
		System.out.println(year + "년 " + month + "월 " + day + "일 ");
		
		
		
		//3. 
		String gender = str.substring(7, 8); 
		
		if (gender.equals("1") || gender.equals("3")){
			System.out.println("남성입니다");
				
		} else if (gender.equals("2") || gender.equals("4")){
			System.out.println("여성입니다");
		
		} else {
			System.out.println("정확하지 않은 성별 번호입니다");
		}
		
		
		
		//4. 
		int monthchk = Integer.parseInt(month);
		int daychk = Integer.parseInt(day);
		
		
		if ( monthchk >= 1 || monthchk <= 12) {
			System.out.println("정확한 달입니다");
			
		} else {
			System.out.println("정확하지 않은 달입니다");
		}
		
		if ( daychk >= 1 || daychk <= 31) {
			System.out.println("정확한 일입니다");
			
		} else {
			System.out.println("정확하지 않은 일입니다");
		}
	
	}
}
		








