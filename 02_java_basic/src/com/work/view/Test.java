package com.work.view;

public class Test {
	
	public static void main(String[] args) 
	{
		byte a = 5; // 선언 및 초기화인 경우에만 byte=int, 연산의 기본은 int임
		byte b = 10;
		
//		byte result = a+b;  Type mismatch: cannot convert from int to byte
//		byte result = (byte)a+b; * 연산자 우선순위로 인해 같은 오류 발생 
		byte result = (byte)(a+b); //연산 수행 결과에 대해서 명시적 형번환 할당
	}

	public static void main1(String[] args) //main 치고 컨스페이스
	{ 
		//우리의 이름을 변수에 저장
		String name = "김주리";
		int age = 26;
		
		System.out.println(name);
		System.out.println(age);

	}
	
	//할당 연산자 활용 
	public static void main2(String[] args) 
	{
		int no1 = 5; // int = int 같은 타입이라 자동 할당
		long no2 = 5; // long > int 큰 타입이라 자동 할당
//		int no3 = 5.2;  Type mismatch: cannot convert from double to int
		int no3 = (int)5.2; //정수 빼고 실수는 버림(소숫자리는 버림) > (int)double : 명시적 형번환
		
	}
	
	public static void main3(String[] args) 
	{
		char c1 = 'A';
		int c2 = c1; //문자가 아닌 해당하는 문자의 ASCII 코드 값으로 나옴
		char c3 = '0';
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println((char)70);
	}
	
	
	
	


}
