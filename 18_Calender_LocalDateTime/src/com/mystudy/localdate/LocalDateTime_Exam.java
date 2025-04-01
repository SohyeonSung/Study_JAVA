package com.mystudy.localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class LocalDateTime_Exam {

	public static void main(String[] args) {
		// Calendar : 값이 변경됨(Muttable)
		Calendar cal = Calendar.getInstance();
		System.out.println("cal : " + cal);
		System.out.println("cal date : " + cal.get(Calendar.DATE));
		cal.set(Calendar.DATE, 10);
		System.out.println("cal 10일로 변경후 : " + cal);
		System.out.println("cal 10일로 변경후 date : " + cal.get(Calendar.DATE));
		
		System.out.println("\n=========================");
		// LocalDate, LocalTime, LocalDateTime : 데이터 불변(Immutable)
		System.out.println("====== LocalDate =====");
		LocalDate nowDate = LocalDate.now();
		System.out.println("LocalDate.now() : " + nowDate.toString()); //2025-04-01
		System.out.println("년 : " + nowDate.getYear()); //2025
		System.out.println("월 : " + nowDate.getMonthValue()); //4 : 1~12월
		System.out.println("일 : " + nowDate.getDayOfMonth()); //1
		
		LocalDate newLocalDate = nowDate.plusYears(2).plusMonths(2).plusDays(2);
		System.out.println("nowDate : " + nowDate);
		System.out.println("newLocalDate : " + newLocalDate);
		
		System.out.println("\n====== LocalTime =====");
		LocalTime nowTime = LocalTime.now(); 
		System.out.println("LocalTime.now() : " + LocalTime.now());//10:05:46.670051500
		System.out.println("시 : " + nowTime.getHour());
		System.out.println("분 : " + nowTime.getMinute());
		System.out.println("초 : " + nowTime.getSecond());
		System.out.println("나노초 : " + nowTime.getNano());
		
		System.out.println("\n====== LocalDateTime =====");
		LocalDateTime nowDT = LocalDateTime.now();
		System.out.println("LocalDateTime.now() : " + nowDT.toString());
		System.out.println("년 : " + nowDT.getYear()); //2025
		System.out.println("월 : " + nowDT.getMonthValue()); //4 : 1~12월
		System.out.println("일 : " + nowDT.getDayOfMonth()); //1
		System.out.println("시 : " + nowDT.getHour());
		System.out.println("분 : " + nowDT.getMinute());
		System.out.println("초 : " + nowDT.getSecond());

	}

}













