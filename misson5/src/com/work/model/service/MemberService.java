package com.work.model.service;

import com.work.model.dto.Member;

public class MemberService {
	
	private Member[] member;
	
	
	
	
	public MemberService(Member[] member) {
		super();
		this.member = member;
	}


	public void addMember(String userId,String password, String phone,String email) {
		
		Member m = new Member();
		
		m.setUserId(userId);
		m.setPassword(password);
		m.setPhone(phone);
		m.setEmail(email);
		
	//	addMember(m);
		
		
	}
	

}
