package com.mystudy.string;

import java.util.Arrays;

public class Ex02_String_method {

	public static void main(String[] args) {
		// String 클래스 메소드를 사용 문자열 처리(단, 원본문자열 불변)
		//            0123456789
		String str = "Java World";
		System.out.println("str : " + str);
		System.out.println("--- charAt(인덱스번호) ----");
		char ch = str.charAt(0);
		System.out.println("str.charAt(0) : " + ch);
		System.out.println("str.charAt(1) : " + str.charAt(1));
		
		System.out.println("--- compareTo() : 문자열 비교(결과: 음수, 0, 양수) ---");
		System.out.println("aaa vs aaa : " + "aaa".compareTo("aaa")); //0
		System.out.println("bbb vs aaa : " + "bbb".compareTo("aaa")); //1
		System.out.println("ccc vs aaa : " + "ccc".compareTo("aaa")); //2
		System.out.println("c vs a : " + "c".compareTo("a")); //2
		
		System.out.println("aaa vs bbb : " + "aaa".compareTo("bbb")); //-1
		System.out.println("a vs b : " + "a".compareTo("b")); //-1
		
		System.out.println("==========================");
		//     0123456789
		str = "Java World";
		System.out.println("str : " + str);
		
		System.out.println("--- indexOf() : 문자(문자열) 위치값 확인 ---");
		System.out.println("str.indexOf('J') : " + str.indexOf('J')); //0
		System.out.println("str.indexOf(\"Java\") : " + str.indexOf("Java")); //0
		System.out.println("str.indexOf(\"a\") : " + str.indexOf("a")); //1
		System.out.println("str.indexOf(\"a\", 2) : " + str.indexOf("a", 2)); //3
		
		System.out.println("str.indexOf(\"d\") : " + str.indexOf("d")); //9
		System.out.println("str.lastIndexOf(\"d\") : " + str.lastIndexOf("d")); //9
		System.out.println("str.lastIndexOf(\"a\") : " + str.lastIndexOf("a")); //3
		
		System.out.println("--- startsWith(), endsWith() ----");
		System.out.println("str.startsWith(\"Java\") : " + str.startsWith("Java")); //true
		System.out.println("str.startsWith(\"World\") : " + str.startsWith("World")); //false
		
		System.out.println("str.endsWith(\"Java\") : " + str.endsWith("Java")); //false
		System.out.println("str.endsWith(\"World\") : " + str.endsWith("World")); //true
		System.out.println();
		
		System.out.println("--- isEmpty() ---");
		System.out.println("str.isEmpty() : " + str.isEmpty());
		str = ""; //빈 문자열(비어있는 문자열)
		System.out.println("str : -" + str + "-");
		System.out.println("str.isEmpty() : " + str.isEmpty());
		System.out.println();
		
		System.out.println("--- replace() : 문자, 문자열 변경값 리턴 ---");
		//	   0123456789
		str = "Java World";
		System.out.println("str : " + str);
		System.out.println("str.replace('a', 'm') : " + str.replace('a', 'm'));
		System.out.println("str.replace(\"Java\", \"Hello\") : " + str.replace("Java", "Hello"));
		
		System.out.println("str : " + str); //원본 데이터 불변
		System.out.println("----");
		
		//	   0123456789
		str = "java java";
		System.out.println("str : " + str);
		
		System.out.println("str.replace(\"ja\", \"JA\") : " + str.replace("ja", "JA"));
		System.out.println("str.replaceAll(\"ja\", \"JA\") : " + str.replaceAll("ja", "JA"));
		
		//replaceAll(정규표현식, 바꿀문자열)
		System.out.println("str.replaceAll(\"[jv]\", \"X\") : " + str.replaceAll("[jv]", "X"));
		System.out.println("str : " + str);
		
		System.out.println("===========");
		System.out.println("--- substring() : 부분 문자열 추출 ---");
		//	   0123456789
		str = "Java World";
		System.out.println("str : " + str);
		
		System.out.println("str.substring(5) : " + str.substring(5));
		System.out.println("str.length() : " + str.length());
		
		// substring(beginIndex, endIndex) : begin 부터, end 이전까지
		System.out.println("str.substring(0, str.length()) : " + str.substring(0, str.length()));
		// 0부터 4이전까지 / 맨앞에서 4글자
		System.out.println("str.substring(0, 4) : " + str.substring(0, 4)); 
		
		// 맨뒤에서 5개 문자 추출
		System.out.println(str.substring(str.length() - 5));
		
		System.out.println("------------------");
		str = "   Java World   ";
		System.out.println("str : -" + str + "-");
		System.out.println("str.toUpperCase() : " + str.toUpperCase());
		System.out.println("str.toLowerCase() : " + str.toLowerCase());
		
		System.out.println("str.trim() : " + str.trim());

		System.out.println("--- toCharArray() : 문자열을 char[] 변환 ----");
		str = "Java World";
		System.out.println("str : " + str);
		
		char[] chs = str.toCharArray();
		System.out.println(Arrays.toString(chs)); //[J, a, v, a,  , W, o, r, l, d]
		System.out.println("chs[0] : " + chs[0]);
		
		System.out.println("--- String.valueOf() : 문자열로 변환 ----");
		int num = 100;
		//str = 100; //Type mismatch: cannot convert from int to String
		str = num + ""; // 100 ---> "100"
		str = String.valueOf(100); // int 타입 데이터 문자열로 형변환
		str = String.valueOf(num); // int 타입 데이터 문자열로 형변환
		
		System.out.println(">>> main() 끝");
	}

}
