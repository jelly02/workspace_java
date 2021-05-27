package com.work.final_test;

class FinalTest {

/*	ERROR : The type A cannot subclass the final class String : String을 상속 받을 수 없음	
	class A extends String{
		
	}
*/	
	class B{
		
			public void doA() {
				System.out.println("A");
			}
			public final void doB() {
				System.out.println("B");
			}
		
		}
	
	class C extends B{
	
		public int count = 100;
		
		//상수 선언하는 방법
		public static final int MAX_COUNT = 30;
	
		
		@Override
		public void doA() {
			
			count = 200;
/*		ERROR :The final field FinalTest.C.MAX_COUNT cannot be assigned			
			MAX_COUNT = 300; 
*/			
			System.out.println("자식에서 재정의 변경합니다");
		}
		
/*		ERROR : Cannot override the final method from FinalTest.B
		public void doB() {
			System.out.println("자식에서 재정의 변경합니다");
		}
*/		
		//중복 정의
		public void doA(int no1, final int no2) {
			no1 = 100;
//			no2 = 100;	ERROR :The final local variable no2 cannot be assigned. It must be blank and not using a compound assignment
		}
	}
}
