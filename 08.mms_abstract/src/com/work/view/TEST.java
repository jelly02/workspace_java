package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberService;
import com.work.model.service.MemberServiceAbstract;

public class TEST {

	public static void main(String[] args) {
			
		Member dto1 = new GeneralMember ("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15","G",50000);
		Member dto2 = new GeneralMember ("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-15","G",950000);		
		Member dto3 = new SpecialMember("user03", "password03", "김유신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");

		
/* 	추상 클래스는 객체 생성 불가 : Cannot instantiate the type MemberServiceAbstract 
		MemberServiceAbstract service = new MemberServiceAbstract(); */
		
		//1) 회원 관리 서비스를 이용하기 위한 구현 객체 생성
		MemberService service = new MemberService();
		print("회원등록");
		
		//2) 서비스에 멤버 객체 전달
		service.addMember(dto1);
		service.addMember(dto2);
		service.addMember(dto3);
		service.addMember(dto4);
		service.addMember(dto5);

		print("등록 인원 수 : "+service.getCount());
		
		print("user01 상세조회");
		Member dto = service.getMember("user01");
		
		if(dto != null) {
			//실제 자식 객체에서 재정의 한 toStriong() 수행결과 출력 
//			System.out.println(dto);
		}
		
		print("user99 상세조회");
		dto = service.getMember("user99");
		
		if(dto != null) {
			//실제 자식 객체에서 재정의 한 toStriong() 수행결과 출력 
//			System.out.println(dto);
		}
	
		
		print("전체 회원 조회");
		service.getMember();
		
		print("비밀번호 변경");
//		service.setMemberPw("user01", "password01", "password555");
		
		print("회원 탈퇴");
		service.removeMember("user03", "password03");
		
		print("전체 회원 조회");
		service.getMember();
		
	}
	
	
	/**
	 * 테스트 메세지를 출력하기 위한 메서드
	 * @param messge
	 */
	public static void print(String messge) {
		//static만 사용 
		System.out.println("\n###"+ messge);
	}
	
	



}
