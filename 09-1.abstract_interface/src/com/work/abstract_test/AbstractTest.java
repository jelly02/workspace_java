package com.work.abstract_test;

public class AbstractTest {

	public static void main(String[] args) {
		 
//		Pet pet  = new Pet();  >  오류 발생하는 이유 : 추상클래스는 객체 생성이 불가능 하기 때문! 추상클래스를 상속 받는 서브 클래스가 필요하다!
		Pet[] pets  = new Pet[5];// 부모 타입의 다형성을 반영한 변수는 사용 가능

		pets[0] = new Dog();
		pets[1] = new Cat();
		pets[2] = new Dog();
		pets[3] = new Cat();
		pets[4] = new Dog();
		
		for(Pet p : pets) {
			//담겨 있는 갯수만큼 자기가 알아서 돈다
			p.eat();
		}
		
		pets[0].name = "코코";
		
		for(Pet p : pets) {
			//담겨 있는 갯수만큼 자기가 알아서 돈다
			System.out.println(p.name);
		}
		
	}

}

// 추상 클래스 
abstract class Pet {
	
	public String name = "씩씩이";
	
	
	public void eat() {
		System.out.println("애완동물은 음식을 먹습니다.");
	}
	
	public abstract void speak();
	
	public abstract void song();
}

// 상속 클래스 (PET의 자녀 클래스/ 메소드 재정의는 선택이지만, abstract 메소드는 구현 필수
class Dog extends Pet {
	
	// 다형성을 반영한 부모타입의 변후는 사용 가능 
	
	@Override
	public void eat() {
		System.out.println("로얄 캐닌을 먹어요");
	}
	
	
	@Override
	public void speak() {
		System.out.println("멍멍 짖어요");
		
	}


	@Override
	public void song() {
		System.out.println("멍~~~~~~~~멍");
		
	}	
}

class Cat extends Pet {
	
	
	@Override
	public void eat() {
		System.out.println("츄르를 먹어요");
	}
	
	
	@Override
	public void speak() {
		System.out.println("애옹 소리를 내요 ");
		
	}


	@Override
	public void song() {
		System.out.println("애~~~~~~옹");		
	}	
}