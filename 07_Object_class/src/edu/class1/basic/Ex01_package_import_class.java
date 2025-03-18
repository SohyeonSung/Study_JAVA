
/* package 선언문 : java 파일의 맨 첫 줄에 위치하며 한 번만 작성
 * - 자바 (class) 파일의 위치를 나타낸다
 * - 일반적으로 회사의 도메인명을 반대로 사용
 * - (ex) com.naver.project / com.itwill.myproject */


package edu.class1.basic;

/* import 선언문 : 선택 항목이지만 일반적으로 사용 */
import java.util.Scanner;

/* class 선언문 : 필수 항목 */
public class Ex01_package_import_class {

	public static void main(String[] args) {
		System.out.println("===[package, impoert,clss 알아보기]===");
		//java.until.Scanner scan = new java.util.Scanner(system.in);
		Scanner scan = new Scanner(System.in);
		System.out.println(">> 인사말 : ");
		String hello = scan.nextLine();
		System.out.println("인사말출력 : " + hello);

		

	}

}
