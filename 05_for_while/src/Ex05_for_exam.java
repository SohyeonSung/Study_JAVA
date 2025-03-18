
class Ex05_for_exam {

	public static void main(String[] args) {
		//문제 : 1~10까지의 숫자중 2의 배수(짝수)출력
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println("2의배수(짝수) : " + i);
			}
		}
		System.out.println("------------");
		
		//(실습) 1~20 숫자 중 3의 배수인 숫자를 출력
		for (int i = 1; i <= 20; i++) {
			if (i % 3 == 0) {
				System.out.println("3의배수 : " + i);
			}
		}
		System.out.println("------------");
		
		//(실습) 900~1000 숫자 중 17의 배수 숫자 출력
		for (int i = 900; i <= 1000; i++) {
			if (i % 17 == 0) {
				System.out.println("17의배수 : " + i);
			}
		}
		System.out.println("------------");
		
		//(실습) 20000 ~ 30000 숫자 중 399의 배수를 출력
		int count = 0;
		for (int i = 20000; i <= 30000; i++) {
			if (i % 399 == 0) {
				//System.out.println("399의배수 : " + i);
				count++;
			}
		}
		System.out.println("count : " + count);
		System.out.println("------------");
		
		System.out.println("======================");
		//변수를 사용해서 일반화 하기
		int startNum = 900;
		int endNum = 1000;
		int divNum = 17;
		
		for (int i = startNum; i <= endNum; i++) {
			if (i % divNum == 0) {
				System.out.println(divNum + "의배수 : " + i);
			}
		}
		
		
	}

}









