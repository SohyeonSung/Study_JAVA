package com.mystudy.string;

public class Ex03_String_exam {

	public static void main(String[] args) {
		

			//1. 전체자리수 14개 여부를 확인하고, '-'위치 : 7번째 여부 확인
			//2. 생년월일 출력(1~2 : 연도, 3~4 : 월, 5~6 : 일)
			//	예) 01년 10월 12일 또는 2001년 10월 12일을 출력
			//3. 성별 확인 출력 (1, 3 : 남성 / 2, 4 : 여성)
			//4. 데이터 값 검증 (월 : 1~12, 일 : 1~31)
			
			//참고) int 형변환할 때 int num = Integer.parseInt("10") 사용
			
			//1. 전체자리수 14개 여부 확인하고, '-' 위치: 7번째 여부 확인
			
			//String str = "011012-4515753"; // 주민번호
			
			String str = "011012-4515753";
			System.out.println(str);
					
			System.out.println("str.length() : " + str.length());
			System.out.println("str.indexOf('@') : " + str.indexOf('@'));
			
			if (str.length() == 14) {
				System.out.println("[정상] 전체길이 14자리");
			} else {
				System.out.println("[비정상] 전체길이 " + str.length());
			}
			int strLen = str.length();
			if (strLen != 14) {
				System.out.println("[비정상] 전체길이 " + strLen);
			}
			System.out.println("-------");
			
			//'-' 위치: 7번째 여부 확인
			System.out.println("str.charAt(6) : " + str.charAt(6));
			if (str.charAt(6) == '-') {
				System.out.println("[정상] '-' 문자위치 7번째");
			} else {
				System.out.println("[비정상1] '-' 문자위치 7번째 아님");
			}
			
			System.out.println("str.indexOf('-') : " + str.indexOf('-'));
			if (str.indexOf('-') != 6) {
				System.out.println("[비정상2] '-' 문자위치 7번째 아님");
			}
			
			System.out.println("str.substring(6, 7) : " + str.substring(6, 7));
			if (str.substring(6, 7).equals("-")) {
				System.out.println("[정상] '-' 문자위치 7번째");
			} else {
				System.out.println("[비정상3] '-' 문자위치 7번째 아님");
			}
			
			System.out.println("2 ====================");
			//2. 생년월일 출력(1-2:년도, 3-4:월, 5-6:일)
			//   예) 98년 10월 12일 또는 1998년 10월 12일
			//str = "981012-1234567";
			System.out.println("=== 생년월일 추출 ===");
			String yymmdd = str.substring(0, 6);
			System.out.println("yymmdd : " + yymmdd);
			
			String yy = str.substring(0, 2);
			String mm = str.substring(2, 4);
			String dd = str.substring(4, 6);
			System.out.println(yy + "년 " + mm + "월 " + dd + "일");
			
			char charFlag = str.charAt(7);
			System.out.println(charFlag == '1');
			
			String yyyy = "";
			if (charFlag == '1' || charFlag == '2') {
				yyyy = "19" + yy;
			} else if (charFlag == '3' || charFlag == '4') {
				yyyy = "20" + yy;
			}
			System.out.println(yyyy + "년 " + mm + "월 " + dd + "일");
			
			System.out.println("성별값 substring() 사용------------------");
			String strFlag = str.substring(7, 8);
			System.out.println("strFlag : " + strFlag); // "1"
			
			if (strFlag.equals("1") || "2".equals(strFlag)) {
				yyyy = "19" + yy;
			} if (strFlag.equals("3") || strFlag.equals("4")) {
				yyyy = "20" + yy;
			} 
			System.out.println(yyyy + "년 " + mm + "월 " + dd + "일");
			
			//3. 성별 확인 출력(1,3: 남성, 2,4: 여성) 
			if (charFlag == '1' || charFlag == '3') {
				System.out.println("성별 : 남성");
			} else if (charFlag == '2' || charFlag == '4') {
				System.out.println("성별 : 여성");
			}
			
			//4. 데이터 값 검증(월: 1~12, 일: 1~31)
			//참고) int num = Integer.parseInt("10") // "10" ---> 10
			String sMonth = str.substring(2, 4);
			int month = Integer.parseInt(sMonth);
			if (month >= 1 && month <= 12) {
				System.out.println("[정상] 월데이터 정상(1~12)");
			} else {
				System.out.println("[비정상] 월데이터 : " + month);
			}
			
			if (month < 1 || month > 12) {
				System.out.println("[비정상] 월데이터 1~12가 아님");
			}
			
			int date = Integer.parseInt(str.substring(4, 6));
			if (date >= 1 && date <= 31) {
				System.out.println("[정상] 일데이터 정상(1~31)");
			} else {
				System.out.println("[비정상] 일데이터 : " + date);
			}
			
			System.out.println(">>> main() 끝");
			
		}

	}



	
