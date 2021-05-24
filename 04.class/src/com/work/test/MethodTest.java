package com.work.test;

public class MethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1번-----------------------------------------
		MethodType test = new MethodType();
//		test.doA();
	
		//2번-----------------------------------------
		//문자열 배열을 사용해서 인사말 정보를 저장 : 
		String[] hello = {"안녕하세요","반갑습니다"};
		
		//반복횟수를 지정하지 않아도 배열에 담긴 갯수만큼 자동으로 반복하면 한 개씩 가져와서 할당
		//형식 : for (타입 변수명 : 배열 명 또는 Collection 객체 참조 변수 명) {}
		for(String message : hello) {
//			test.doB(message);
		}
		
		//3번-----------------------------------------
		System.out.println();
		int result = test.doC();
//		System.out.println(result);
//		System.out.println(test.doC());
		
		//4번-----------------------------------------

		System.out.println();
		test.add(100L, 1234); //long, int
		test.add(100, 1234L); //int, long
		test.add(100L, 1234); //long,long	
		test.add(100, 1234F); //int, float => double, double로 출력
		
	}

}
