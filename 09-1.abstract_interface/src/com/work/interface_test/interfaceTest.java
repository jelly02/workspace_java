package com.work.interface_test;

public class interfaceTest {

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
		
//		pets[0].name = "코코"; > 인터페이스의 멤버 변수는 자동으로 상수 처리가 되기 때문에 변경 불가 
		System.out.println(Pet.name); //변경이 아니라 호출은 가능함
		
		for(Pet p : pets) {
			//담겨 있는 갯수만큼 자기가 알아서 돈다
			System.out.println(p.name);
		}
		
	}

}

//interface의 최상위 부모
interface Animal{
	
	public void sleep();
	
}



// 부모 인터페이스 : 부모, 자식 인터페이스끼리는 상속 관계 > extends 사용 / implements 불가 : 
interface Pet extends Animal {
	
	public String name = "씩씩이";
	
	//어차피 자바가 알아서 abstract를 붙여줌 
	public void eat();
	
	//수행문이 없는 메서드도 메서드다!
	public abstract void speak();
	
	public abstract void song();
}

// 부모가 interface 일 경우에는 상속 받을 때 
class Dog implements Pet {
	
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


	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}	
}

class Cat implements Pet {
	
	
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


	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}	
}