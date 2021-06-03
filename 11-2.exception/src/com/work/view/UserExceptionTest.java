package com.work.view;

import com.work.exception.UserException;

public class UserExceptionTest {

	public static void main(String[] args) {

		//main() 메서드는 같은 클래스에 있는 인스턴스 메서들르 객체 생성 후 사용 가능
		
		UserExceptionTest us = new UserExceptionTest();
		
		try {
			us.doA("n");
		} catch (UserException e) {
			System.out.println("[오류메세지] :"+e.getMessage());
//			e.printStackTrace(); > 오류 난 줄 알려줌
		}
		
		System.out.println("정상 종료");
		

	}
	
	/**
	 * Grade : "G" "S" "A" 가 아니면 사용자가 제작한 예외를 발생시킨다! (=UserException)
	 * 사용자 예외 발생하는 방법 : throw new 사용자예외클래스명();
	 * @param grade
	 * @throws UserException 
	 */
	public void doA(String grade) throws UserException  {
		
//		if(!grade.equals("G") || !grade.equals("S") || !grade.equals("A")) {
//			System.out.println("올바른 등급");
//		} else {
//			throw new UserException();
//		}
//		
		switch(grade) {
		
		case "G" :
		case "S" :
		case "A" : 
			break;
		
		default:
			//System.out.println("[오류] : 등급은 G,S,A만 가능합니다.");
			throw new UserException("등급은 G,S,A만 가능합니다.");
		
		
		}
	}

}
