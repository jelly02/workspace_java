package com.work.api.string;

import java.util.StringTokenizer;

public class StringTest {
	
	public static void main(String[] args) {
		
		//wrapper API 테스트
		String data = "100 + 200 + 3";
		
		//숫자 데이터 가져오기!
//		String[] tokens = data.split("\\+ "); > 기호 escape 처리

		StringTokenizer tokenizer = new StringTokenizer(data,"+ "); //+-*/ 처럼 한 번에 다 넣어도 됨
		
		int sum = 0;
		
		//element 확인
		while(tokenizer.hasMoreElements()) {	
			String token = tokenizer.nextToken();
//			System.out.println(token);
			
//			(1) 숫자형식 문자열을 넣어서 덧셈함
//			sum += Integer.parseInt(token);
			
//			(2) 객체를 만들어서 덧셈함			
//			Integer integer = new Integer(token);
//			sum+= integer.intValue();
			
//			(3)
			sum += new Integer(token).intValue();
		}	
		System.out.println("sum : "+sum );
		
	}
	
	public static void main3(String[] args) {
		
		//문자열 토큰 테스트
		String data1 = "user01, password01, 홍길동, 01012341000, hong@work.com";
		String data2 = "100 + 200 * 3";
		
		//String#split() 사용 : () 괄호 안을 기준으로 쪼갠다
		String[] tokens = data1.split(",");
		
		for(String token: tokens) {
			System.out.println(token);
		}
		
		System.out.println("--------------------------------");
		
		//StringTokenizer 사용
		// 기본 구분자 : \t \n \r \f									 () 괄호 안을 기준으로 쪼갠다
		StringTokenizer tokenizer = new StringTokenizer(data1,", ");
		System.out.println(tokenizer.countTokens());
		
		//element 확인
		while(tokenizer.hasMoreElements()) {
			
			String data = tokenizer.nextToken();
			System.out.println("nextToken 사용 "+data);
			
		}
		
	}
	
	
	public static void main2(String[] args) {
		
/*		* StringBuffer, StringBuilder : 가변 문자열
		- 반드시 new StringBuffer(), new StringBuilder() : new 키워드 사용해서 객체 생성 
		- StringBuffer : jdk 1.0 ver, StringBuilder : jdk 1.5 ver*/
		
		StringBuffer buffer = new StringBuffer("여러분");
		buffer.append("안녕하세요");
		
		System.out.println(buffer);
		
		buffer.append("안녕하세요").append("점심은").append("아직 안 먹었지만").append("페리카나가 먹고 싶다");
		System.out.println(buffer);
	}

	public static void main1(String[] args) {
		
		//String : 불변 문자열
		String msg1 = "Hello";					 //heap area 의 literal pool
		String msg2 = "Hello";					//heap area 의 literal pool
		String msg3 = new String("Hello");  //heap area 
		String msg4 = new String("Hello");  //heap area 
		
		print("== 연산자 문자열 비교 ==");
		// 같은 문자열인데도 false가 발생 
		System.out.println(msg1 == msg2); //true
		System.out.println(msg1 == msg3); //false
		System.out.println(msg1 == msg4); //false
		
		print("equals() 연산자 문자열 비교 =="); 
		// 같은 객체인지 비교 : 같은 값이면 같은 객체로 바라보는 걸로 인식함 (참조 값x 문자 비교)
		// 같은 내용이면 equals()로 비교 
		System.out.println(msg1.equals(msg2)); //true
		System.out.println(msg1.equals(msg3)); //true
		System.out.println(msg1.equals(msg4)); //true
	

	}
	
	public static void print (String msg) {
		
		System.out.println("\n###"+msg);
	}

}
