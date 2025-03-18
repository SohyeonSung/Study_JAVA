
public class Ex02_char {

	public static void main(String[] args) {
		// 문자형(char) : 2 byte 사용, 문자 1글자 저장(0~65535)
		// 자바 문자처리 방식은 유니코드(Unicode) 형태 - 2byte 사용(UTF-16)
		//------------
		// UTF-16 : 모든 문자를 2byte로 표현(고정길이)
		// UTF-8 : 가장 많이 사용되는 가변 길이 유니코드 인코딩
		//   가변길이 : 1, A - 1byte 사용, 한글 - 3byte
		//-------------------
		char char1 = 'A'; // "A" 문자열(String), 'A' 는 문자(char)
		System.out.println("char1 : " + char1);
		System.out.println("char1 다음문자 : " + (char1 + 1));
		System.out.println("char1 다음문자 : " + (char)(char1 + 1)); //65+1 -> 66 -> char변환       
		
		char char2 = '한';
		System.out.println("char2 : " + char2);
		
		char char3 = '\uAC00'; //유니코드 값으로 설정
		System.out.println("char3 : " + char3); //가
		
		System.out.println("(int)char3 : " + (int)char3); //44032
		
		
		
	} //main 끝

} //class 끝




