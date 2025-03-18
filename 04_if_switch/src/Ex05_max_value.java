
public class Ex05_max_value {

	public static void main(String[] args) {
		/* (실습) 숫자 3개 중 가장 큰 수를 구하시오(찾으시오)
		a: 30, b: 60, c: 20
		<결과>
		가장큰수 : 60
		-------------- */
		int a = 30;
		int b = 60;
		int c = 20;
		
		if (a > b) { // a가 큰 경우
			if (a > c) {
				System.out.println("가장큰수 : " + a);
			} else {
				System.out.println("가장큰수 : " + c);
			}
		} else { // b가 큰 경우
			if (b > c) {
				System.out.println("가장큰수 : " + b);
			} else {
				System.out.println("가장큰수 : " + c);
			}
		}
		System.out.println("===============");
		/* (실습) 숫자 5개 중 가장 큰 수를 구하시오(찾으시오)
		a: 30, b: 60, c: 20, d: 15, e: 70
		<결과>
		가장큰수 : 70
		-------------- */
		a = 30;
		b = 60;
		c = 20;
		int d = 15;
		int e = 70;
		
		//int max = -1;
		int max = Integer.MIN_VALUE;
		
		if (a > max) {
			max = a;
		}
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		if (d > max) {
			max = d;
		}
		if (e > max) {
			max = e;
		}
		
		System.out.println("가장큰수 : " + max);
		
		
		
		
		
		

	}

}
