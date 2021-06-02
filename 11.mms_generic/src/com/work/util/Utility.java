package com.work.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * <pre>
 * 
 * 공통으로 사용하는 메서드를 위한 유틸리티 클래스
 * 
 * - 모든 메서드는 객체 생성 없이 사용하도록 class 선언 (static method)
 * 
 * </pre>
 * @author 김주리
 *
 */


public class Utility {

	/**
	 * 유틸리티 테스트 메서드
	 * @param args 테스트 메서드
	 */
	public static void main(String[] args) {
		
/*		System.out.println(getCorrentDate()); 		// 같은 클래스에서 호출했을 때
		System.out.println(Utility.getCorrentDate()); //다른 클래스에서 호출했을 때
		
		System.out.println(getComma(129310237));
		System.out.println(getCorrentDate(12315464, Locale.JAPAN));
		System.out.println(getPassword("bluesky2020"));
*/		
		print("임시 발급 비밀번호 ");
		
		//영어 아스키코드로 변환해보기
		
		System.out.println(getSecureNumberString());
		System.out.println(getSecureNumberString(6));
		System.out.println(getSecureNumberString(10));
		System.out.println(getSecurAlphabetString());
	}
	
	private static void print(String message) {
		System.out.println("\n###"+message);
	}

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
	 *  TODO 1 : 아규먼트로 받은 정수형 숫자를 천단위마다 컴마표기 문자열 반환 메서드
	 *  @param num 매개변수
	 *  @return number 콤마 문자열
	 */
	public static String getComma(int num) {
		
		String number =  NumberFormat.getInstance().format(num);
		
		return number;
	}
	
	/**
	 *  TODO 2 : 아규먼트로 받은 정수형 숫자, 로케일을 받아서  화폐기호 및 천단위마다 컴마표기 문자열 반환 메서드
	 */
	public static String getCorrentDate(int num, Locale locale) {
		
//		String money = Currency.getInstance(locale).getSymbol();
//		String amount = NumberFormat.getInstance().format(num);
//		
//		System.out.println(money+amount);
		
		return Currency.getInstance(locale).getSymbol()+NumberFormat.getInstance().format(num);
	}
	
	/**
	 *  TODO 3 : 아규먼트로 받은 문자열 데이터를 앞에 2자리만 보여주고 나머지는 * 기호로 대체 변환한 문자열 반환 메서드
	 *  예시) 암호 bluesky2020 => bl*********
	 */
	public static String getPassword(String pw) {
	
		
		
		return pw;
				
	
	}
	
	
	/**
	 *  TODO 4 : TODO 3 중복정의 
	 *  아규먼트로 받은 문자열, 길이를 받아서 해당 자리수만 보여주고 나머지는 * 기호로 대체 변환한 문자열 반환 메서드
	 */
	
	public static String getSecureNumberString() {
		
//		Random random = new Random((long)(Math.random() * System.nanoTime()));
//		
//		StringBuilder secureString = new StringBuilder();
//			
//		for(int i = 0; i < 4; i++) {
//			secureString.append( random.nextInt(10));
//		}
//		
//		//StringBuilder은 String과 상속 관계가 아니라서 String 타입이 아니다
//		return secureString.toString();
		
		return getSecureNumberString(4);
	}
	
	//중복 정의 
	public static String getSecureNumberString(int length) {
		
	Random random = new Random((long)(Math.random() * System.nanoTime()));
			
			StringBuilder secureString = new StringBuilder();
				
			for(int i = 0; i < length; i++) {
				secureString.append( random.nextInt(10));
			}
			
			//StringBuilder은 String과 상속 관계가 아니라서 String 타입이 아니다
			return secureString.toString();
	}
	
	//보안 대문자
	public static String getSecurAlphabetString() {
		return getSecurAlphabetString(4);
	}
	
	
	
	//보안 대문자
	public static String getSecurAlphabetString(int length) {
		
	Random random = new Random((long)(Math.random() * System.nanoTime()));
			
			StringBuilder secureString = new StringBuilder();
				
			for(int i = 0; i < length; i++) {
				secureString.append((char)(random.nextInt(26) + 65)); //대문자는 65, 소문자 97
			}
			
			//StringBuilder은 String과 상속 관계가 아니라서 String 타입이 아니다
			return secureString.toString();
		
	}
	
	
	
	public static int getLottoNo() {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		
		return random.nextInt(45)+1; //0~44, 46:0~45/ 45:0~44+1 1~45
	}
	
	
	/**
	 *  TODO 5 : 보안문자 발급 메서드 : 기본으로 4자리 숫자형식의 문자열 반환 메서드
	 *  예시) 암호찾기 => 임시발급암호로 사용
	 *  배열 사용하지 마세요 => StringBuilder를 사용하는것이 편합니다.
	 *  참고 : java.util.Random#nextInt(10) 
	 *  참고 : java.lang.StringBuilder#append()
	 */
	
	public static String getSecurityNumber(String word) {
		
		StringBuilder sb = new StringBuilder();
		
		return null;
	}
	
	
	
	
	/**
	 * TODO 6 : TODO 5 중복정의
	 * 길이를 아규먼트로 전달받아서 전달받은 길이의 숫자형식의 문자열 반환 메서드
	 */
	
	/**
	 * TODO 7: TODO 6 중복정의
	 * 길이, 영문대소문자 여부를 아규먼트로 전달받아서 해당된 길이의 숫자 및 영문 대소문자를 랜덤하게 조합하여 변환한 문자열 반환 메서드
	 *  참고 : 영문 26자리, 영문대문자 ASCII CODE : 65, 영문소문자 ASCII CODE : 97
	 */
	
	/**
	 * 도전 TODO : 
	* 보안문자 반환 : 비밀번호, 이름, 휴대폰
	* 비밀번호 : bl****, blu****, blue***
	* 이름 : 홍*동, 문*, 남**재
	* 전화번호 : 02-1234-1234 => ********1234, 010-1234-2773 => ********2773
	* 메서드명(length, align) : String
	* 참고 : String#	lastIndexOf(String str)
	 * 
	 */
}
