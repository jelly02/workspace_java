package com.work.view;

import com.work.model.dto.GeneralMember;

public class TEST {

	public static void main(String[] args) {
		
		//일반 회원 자식 객체 생성 절차 : 부모 먼저, 자식 나중에 
		GeneralMember g1 = new GeneralMember("user01","password01","홍길동","01012345678", "user01@work.com");
		
		System.out.println(g1.getMemberId());
		System.out.println(g1.getName());
		
	}

}
