
public class Ex01_boolean {
	
	public static void main(String[] args) {
		// boolean : true, false 값을 가짐(논리형)
		// 사용타입지정  사용변수명 = 초기값;
		// 타입 변수명; // 변수 선언만
		// 타입 변수명 = 값; // 변수선언 + 초기값 설정
		boolean bool1 = true;
		boolean bool2 = false;
		
		System.out.println("bool1 : " + bool1);
		System.out.println("bool2 : " + bool2);
		
		bool1 = true;
		System.out.println("if문 직전 bool1 : " + bool1);
		if (bool1) {
			System.out.println("if문 bool1이 참(true)면 실행");
		} else {
			System.out.println("if문 bool1이 거짓(false)면 실행");
		}
		System.out.println("--- main() 메소드 끝 -----");
		
		
	} //main 끝

}





