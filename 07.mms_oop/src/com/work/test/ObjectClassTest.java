package com.work.test;

import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;

public class ObjectClassTest {

	//Member class : equals() 재정의 하고  테스트
	// 회원의 아이디 정보가 같으면 같은 객체로 
	// 같은 객체 여부를 비교할 때는 반드시 equals() 메서드로 비교해야함! (hash+equals같이 확인)
	public static void main(String[] args) {
		
		Member dto1 = new GeneralMember ("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15","G",50000);
		Member dto2 = new GeneralMember ("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15","G",50000);
		Member dto3 = new GeneralMember ("user02", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15","G",50000);
		
		//생성한 객체의 hashcode() 참조 값 출력 
		// 각각 만들었기 때문에 참조주소가 다름. 
		System.out.println("dto1 : "+dto1.hashCode()); //참조값 같
		System.out.println("dto2 : "+dto2.hashCode()); //참조값 같
		System.out.println("dto3 : "+dto3.hashCode()); //참조값 다름
		
		//각각의 다른 개체이기 때문에 결과 값 false 출력
		System.out.println("--객체 비교--");
		System.out.println(dto1 == dto2); //false
		System.out.println(dto1 == dto3); //false
		
		System.out.println("--객체 비교(equals)--");
		System.out.println(dto1.equals(dto2)); //true
		System.out.println(dto1.equals(dto3)); //false
		
		
		System.out.println();
		
	}
	
	//Member class : equals() 재정의 하지 않고 테스트
	public static void main2(String[] args) {
		
		Member dto1 = new GeneralMember ("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15","G",50000);
		Member dto2 = new GeneralMember ("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15","G",50000);
		Member dto3 = new GeneralMember ("user02", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15","G",50000);
		
		//생성한 객체의 hashcode() 참조 값 출력 
		// 각각 만들었기 때문에 참조주소가 다름. 
		System.out.println("dto1 : "+dto1.hashCode());
		System.out.println("dto2 : "+dto2.hashCode());
		System.out.println("dto3 : "+dto3.hashCode());
		
		//각각의 다른 개체이기 때문에 결과 값 false 출력
		System.out.println("--객체 비교--");
		System.out.println(dto1 == dto2);
		System.out.println(dto1 == dto3);
		
		System.out.println("--객체 비교(equals)--");
		System.out.println(dto1.equals(dto2)); //true
		System.out.println(dto1.equals(dto3)); //false
		
		
	}
	
	//object 비교 : 같은 객체는같은 참조 값 따라서 ==, equals() 동일한 결과 
	public static void main1(String[] args) {
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		//obj1을 참조
		Object obj3 = obj1;
		
		//hash() : 실제로 메모리에 올라가 있는 참조 값
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		System.out.println("--객체 비교--");
		System.out.println(obj1 == obj2);
		System.out.println(obj1 == obj3);
		
		System.out.println("--객체 비교(equals)--");
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
	
		
		

	}

}
