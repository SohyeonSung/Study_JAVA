package com.mystudy.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calendar_Exam {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("new Date() : " + date);
		System.out.println("----");
		
		date = new Date(0, 3, 31);
		System.out.println("new Date(0, 3, 31) : " + date); //년도 0 일때 1900년
		System.out.println("-----");
		
		// 월 : 0 ~ 11 - 0:1월, 1:2월, ..., 11:12월
		date = new Date(2025 - 1900, 2, 31); //년도 : 기본 1900년
		System.out.println("new Date(2025 - 1900, 2, 31) : " + date);
		
		System.out.println("\n==== Calendar ========");
		Calendar cal = Calendar.getInstance();
		System.out.println("Calendar.getInstance() : " + cal);
		
		System.out.println("년도 : " + cal.get(Calendar.YEAR));
		System.out.println("월 : " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("일 : " + cal.get(Calendar.DATE));
		System.out.println("일 : " + cal.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("요일 : " + cal.get(Calendar.DAY_OF_WEEK)); //일,월~토 : 1~7
		
		System.out.println("오전오후 : " + cal.get(Calendar.AM_PM));
		System.out.println("시(12시간) : " + cal.get(Calendar.HOUR));
		System.out.println("시(24시간) : " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 : " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		System.out.println("밀리초 : " + cal.get(Calendar.MILLISECOND));
		System.out.println("------------------");
		
		//년-월-일 시:분:초  또는 년/월/일 시:분:초
		String dateTime = cal.get(Calendar.YEAR)
					+ "-" + (cal.get(Calendar.MONTH) + 1)
					+ "-" + cal.get(Calendar.DATE)
					+ " " + cal.get(Calendar.HOUR_OF_DAY)
					+ ":" + cal.get(Calendar.MINUTE)
					+ ":" + cal.get(Calendar.SECOND);
		System.out.println(">>년-월-일 시:분:초 : " + dateTime);
		
		System.out.println("============");
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
		date = new Date();
		System.out.println("new Date() : " + date);
		System.out.println("y-M-d H:m:s : " + sdf.format(date));
		
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("yyyy-MM-dd HH:mm:ss : " + sdf.format(date));
		
		System.out.println("-----");
		date = cal.getTime();
		System.out.println("yyyy-MM-dd HH:mm:ss : " + sdf.format(date));
		
		System.out.println(">> Calendar 값을 변경 가능");
		cal.add(Calendar.MONTH, 1);
		date = cal.getTime();
		System.out.println("yyyy-MM-dd HH:mm:ss : " + sdf.format(date));
		

	}

}













