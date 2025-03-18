
public class Ex03_switch_case {

	public static void main(String[] args) {
		// switch case 문 : 동등비교구문
		/*
		switch (조건값) {
		case 비교값1 : 
			실행할 문장(들);
			break;
		case 비교값2 : 
			실행할 문장(들);
			break;
		...
		default :
			실행할 문장(들);
			break;
		}
		----------------- */
		int month = 12;
		
		switch (month) {
		case 1 :
			System.out.println(month + "월은 31일까지 있습니다");
			break; //중단하고 빠져나감
		case 2 : 
			System.out.println(month + "월은 28일 또는 29일까지 있습니다");
			break;
		case 3 :
			System.out.println(month + "월은 31일까지 있습니다");
			break;
		case 4 :
			System.out.println(month + "월은 30일까지 있습니다");
			break;
		default :
			System.out.println("일치하는 값이 없습니다");
			break;
		}
		System.out.println("-------------");
		
		switch (month) {
		case 1 :
		case 3 :
		case 5 :
		case 7: case 8: case 10: case 12:
			System.out.println(month + "월은 31일까지 있습니다");
			break;
		case 2 : 
			System.out.println(month + "월은 28일 또는 29일까지 있습니다");
			break;
		case 4 : case 6: case 9: case 11:
			System.out.println(month + "월은 30일까지 있습니다");
			break;
		default :
			System.out.println("일치하는 값이 없습니다");
			break;
		}
		System.out.println("=========================");
		/*(실습) 추첨 결과에 따라서 상품 지급
		1등:냉장고, 2등:김치냉장고, 3등:세탁기, 4등:청소기
		등수안에 없으면(꽝인경우) : 휴지
		추첨결과 당첨상품을 출력하시오
		출력예시) 당첨상품 : 냉장고
		출력예시) 추첨결과 : 2등, 당첨상품 : 김치냉장고
		---------------- */
		String result = "1등"; //추첨결과
		String resultMsg = "상품없음";
		       
		//당첨 여부 확인
		switch (result) {
		case "1등" :
			//System.out.println("당첨상품 : 냉장고");
			resultMsg = "냉장고";
			break;
		case "2등" :
			//System.out.println("당첨상품 : 김치냉장고");
			resultMsg = "김치냉장고";
			break;
		case "3등" :
			//System.out.println("당첨상품 : 세탁기");
			resultMsg = "세탁기";
			break;
		case "4등" :
			//System.out.println("당첨상품 : 청소기");
			resultMsg = "청소기";
			break;
		default : 
			//System.out.println("당첨상품 : 휴지");
			resultMsg = "휴지";
			break;
		}
		System.out.println("추첨결과 : " + result + ", 당첨상품 : " + resultMsg);
		
		System.out.println("--------------");
		

	}

}






