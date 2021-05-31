package com.work.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <pre>
 * 
 * 공통으로 사용하는 메서드를 위한 유틸리티 클래스
 * 
 * (1) 모든 메서드는 객체 생성 없이 사용하도록 class 선언 (static method)
 * 
 * </pre>
 * @author 김주리
 *
 */


public class Utility {

	
	
	/**
	 * <pre>
	 * 현재 날짜 기본 형식의 문자열로 변환하는 메서드 
	 * 
	 * (1) 기본 형식 : 년도 4자리-월 2자리-일 2자리
	 * </pre>
	 * 
	 * @return 현재날짜 기본 형식 문자열
	 */
	public static String getCorrentDate() {
		
//		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date todate = new Date();
//		System.out.println(todate);
//		return dataFormat.format(todate);		
		
		return getCorrentDate("yyyy-MM-dd");

	}
	
	private static String getCorrentDate(String pattern) {
	
//		SimpleDateFormat dataFormat = new SimpleDateFormat(pattern);
//		Date todate = new Date();
//		return dataFormat.format(todate);		 		
		return getCorrentDate(pattern, Locale.KOREA);
	}
	
	private static String getCorrentDate(String pattern, Locale locale) {
		
//		SimpleDateFormat dataFormat = new SimpleDateFormat(pattern, locale);
//		Date todate = new Date();
//		return dataFormat.format(todate);	
		return  new SimpleDateFormat(pattern,locale).format(new Date()) ;
	}

	/**
	 * 유틸리티 테스트 메서드
	 * @param args 테스트 메서드
	 */
	public static void main(String[] args) {
		
		System.out.println(getCorrentDate()); 		// 같은 클래스에서 호출했을 때
		System.out.println(Utility.getCorrentDate()); //다른 클래스에서 호출했을 때
	}
}
