package com.work.view;

import com.work.model.dto.Member;

public class Test {

	public static void main(String[] args) {
		
		Member dto = new Member("test","test1234","테스트","01012345678","test@t.com","","",9,"");
		System.out.println("변경 전 : "+dto);
		
		// 아이디 변경
		dto.setMemberId("correct_id");
		dto.setMemberPw("4545545");
		dto.setMileage(100);
		dto.setGrade("B");
		System.out.println("변경 후 : "+dto);
		
		
		
		
		
	}
	//toString() 메서드 재정의 및 사용 테스트 
	public static void main11(String[] args) {
		// 가입 : 아이디, 비밀번호, 이름 , 휴대폰, 이메일
		Member dto = new Member("test","test1234","테스트","01012345678","test@t.com");
		
		//생성한 회원 객체의 정보를 출력
		//sysout(참조변수명) = 참조변수명.toString() 
//		System.out.println(dto.toString());
		System.out.println(dto);
	}

}
