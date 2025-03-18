
public class Ex03_byte {

	public static void main(String[] args) {
		// 정수형 byte : 정수형 숫자 저장 256개(-128 ~ 127)
		System.out.println("---- byte 최소, 최대값 ----");
		System.out.println("byte 최소값 : " + Byte.MIN_VALUE);
		System.out.println("byte 최대값 : " + Byte.MAX_VALUE);
		System.out.println("================");
		
		byte byte1 = 100;
		byte byte2 = 25;
		byte sum = 0;
		System.out.println("byte1 : " + byte1);
		System.out.println("byte2 : " + byte2);
		
		//sum = byte1 + byte2; //Type mismatch: cannot convert from int to byte
		
		// 강제 형변환 처리
		sum = (byte)(byte1 + byte2);
		System.out.println("byte1 + byte2 : " + sum);
		
		System.out.println("==== 강제형변환 주의(저장범위) ====");
		byte1 = 100;
		byte2 = 29;
		System.out.println("byte1 : " + byte1);
		System.out.println("byte2 : " + byte2);
		
		//연산 결과 값이 표현(저장)범위를 벗어나면 예상치 못한 쓰레기 값이 될 수 있음
		sum = (byte)(byte1 + byte2);
		System.out.println("byte1 + byte2 : " + sum);
		
		
	}

}





