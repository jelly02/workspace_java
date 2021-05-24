package com.work.test;

public class MethodType {
	
	//1.매개변수 없고, 반환타입 없음
	public void doA(){
		System.out.println("doA()메소드 입니다");
	}
	
	//2. 매개변수 있고, 반환타입 없음
	public void doB(String message) {
		System.out.println("doB()"+message);
	}
	
	//3. 매개변수 없고, 반환타입 있음
	public int doC() {
		
		return 1004;
	}
	
	//4. 매개변수 있고, 반환타입 있음 : 2개의 정수 데이터를 매개변수로 받아서 매개변수로 전달 받은 데이터의 덧셈 결과를 반환하는 메서드
	public long add(int a, int b) {
		System.out.println("int, int");
		return a+b;
	}
	
	public long add(long a, long b) {
		System.out.println("long, long");
		return a+b;
	}
	
	public double add(double a, double b) {
		System.out.println("double, double");
		return a+b;
	}

}
