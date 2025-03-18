package array1;

public class Ex03_array3_star {

	public static void main(String[] args) {
		/* 별찍기
		*
		**
		***
		****
		*****
		------------ */
		//char 타입의 데이터를 5개 저장할 수 있는 배열을 만들고
		//배열 데이터를 위의 모양으로 출력
		char[] ch = {'0', '1', '2', '3', '4'};
		ch = new char[] {'!', '@', '#', '$', '%'};
		/* 
		0
		01
		012
		0123
		01234
		---------- */
		int cnt = 1;
		for (int line = 1;  line <= ch.length; line++) {
			for (int i = 0; i < cnt; i++) {
				System.out.print(ch[i] + " ");
			}
			System.out.println();
			cnt++;
		}
		System.out.println("----");
		for (int line = 1;  line <= ch.length; line++) {
			for (int i = 0; i < line; i++) {
				System.out.print(ch[i]);
			}
			System.out.println();
		}
		
		

		

	}

}









