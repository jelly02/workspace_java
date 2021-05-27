package com.work.static_test;

public class StaticTest {
	
//	*static 변수 (=class 멤버 변수)
	public static String classTitle = "빅데이터 과정";
	
//	*instance 변수
	public String instanceTitle = "자바프로그래밍";
	
	public static void main(String[] args) {
		
//		* static 변수는 그냥 사용 가능
		System.out.println(classTitle);
//		System.out.println(instanceTitle); >> ERROR : Cannot make a static reference to the non-static field instancTitle
		
		StaticTest test = new StaticTest();
		
//		*같은 class에 있는 instance 멤버는 statice 메서드에서는 반드시 명시적으로 생성 후 참조 변수를 통해서 사용
		System.out.println(test.instanceTitle);
		
		System.out.println(Math.random());
		System.out.println(Math.random() * 10);
		System.out.println((int)(Math.random() * 10));
		System.out.println(Math.PI);
		
		
		
		
	}
	
	public void instancMethod() {
		System.out.println(instanceTitle); // >> OK : 같은 클래스에 있는 인스턴스 멤버끼리는 그냥 호출 사용 (메모리 로딩 시점 동일)
	}
	
//	* static 멤버 변수, instance 멤버 변수
	public static void main1(String[] args) {
		
		System.out.println();
		System.out.println(SimpleMember.CLASS_COUNT);
		
		SimpleMember.CLASS_COUNT = 100;
		
		SimpleMember dto1 = new SimpleMember();
		
		System.out.println();
		SimpleMember dto2 = new SimpleMember();
		
		dto1.CLASS_COUNT = 1000;
		dto1.instancCount = 100;
		
		dto2.CLASS_COUNT = 1000;
		dto2.instancCount = 100;
		
		SimpleMember.CLASS_COUNT = 5000;
		System.out.println(dto1.CLASS_COUNT);
		System.out.println();
		
		System.out.println();
		System.out.println(dto2.CLASS_COUNT);
		System.out.println(dto2.instancCount);
		
		System.out.println();
		System.out.println(SimpleMember.CLASS_COUNT);
		
	}

	
	
}
