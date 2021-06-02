package com.work.view;

import java.util.ArrayList;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberService;

public class Test {
	
	
	/**
	 * 회원 가입 시스템 테스트 메서드
	 * (1) 사용자 입력 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * (2) service(model) : 사용자가 입력한 정보 + system에서 가입일(현재 날짜)/등급(일반 회원 부여
	 * (
	 * @param args 메인
	 */
	public static void main(String[] args) {
		
		
		print("회원관리 서비스 이용위한 객체 생성");
		MemberService service = new MemberService();
		
		print("초기화 회원 등록 : "+service.initMember());
		
		print("회원등록");
//		Member dto = new Member("아이디","비밀번호","이름","휴대폰","이메일");
//		Member dto = new GeneralMember ("test","test1234","테스트","01000000000","text@t.com");
		service.addMember("test01","test1234","테스트","01000000000","text@t.com");
		service.addMember("test02","test5678","테스트","01000000000","text@t.com");

		print("현재 등록 회원수 : "+service.getCount());
		
		print("전체 회원 조회");
		ArrayList list = service.getMember();
	
		for(int index = 0; index<list.size(); index++) {
			System.out.println(list.get(index));
		}
		
		print("회원 정보 전체 변경");
		Member dto = service.getMember("user01") ;
		
		//변경하고 싶은 속성 setter로 변경
		dto.setName("testnew");
		dto.setMemberPw("testnew");
		dto.setMobile("0109999999");
		
		service.setMember(dto);
		print("변경 후"+dto);
		
		//변경 객체(존재하지 않는 사용자)
		dto = new GeneralMember("xxxx", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		
		//변경 예외 처리
		boolean result = service.setMember(dto);
		//true
		if(result) {
			 service.getMember("xxxx") ;
		}else {
			System.out.println("해당 아이디의 회원 정보가 존재하지 않습니다");
		}
		
		//비밀번호 변경
		print("비밀번호 변경");
		print("user04");
		System.out.println(service.getMember("user04"));
		
		dto = service.getMember("user04");
		System.out.println(dto);

		service.setMemberPw("user04", "password04", "goodluck");
		
		if(result) {
			System.out.println("비밀번호가 정상 변경 처리 되었습니다");
		}else {
			System.out.println("[오류] : 회원 정보 확인 필요");
		}
		
		dto = service.getMember("user02");
		System.out.println(dto);
		
		print("user01");
		System.out.println(service.getMember("user01"));
		dto = service.removeMember("user01", "testnew");
		
		if(dto != null ) {
			System.out.println("탈퇴 성공"+dto.getName()+"안녕");
		}else {
			System.out.println("탈퇴실패ㅠㅠ");
		}
		
		print("등급변경");
		
//		service.setMemberPw("test01", "test1234", "test9999");
		
//		print("회원 상세 조회 : user01");
//		Member dto = service.getMember("user01");
//	
//		if(dto != null ) {
//			System.out.println(dto);
//		}
//		
//		print("회원 상세 조회 : 신규 등록 회원 > test01");
//		dto = service.getMember("test01");
//		
//		if(dto != null ) {
//			System.out.println(dto);
//		}
	}
	
	
	/**
	 * 회원관리시스템 테스트 메서드
	 * @param args 시작시에 전달받은 문자열 매개변수 배열
	 */

	public static void main1(String[] args) {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");
	

//		print("회원관리 서비스 이용위한 객체 생성");
		MemberService service = new MemberService();

//		print("회원등록");
		service.addMember(dto1);
		service.addMember(dto2);
		service.addMember(dto3);
		service.addMember(dto4);
		service.addMember(dto5);
		
		service.addMember(dto2); 
		service.addMember(dto2);
		
		print("등록인원수 : " + service.getCount());
		
//		print("user01 상세조회");
//		Member dto = service.getMember("user01");
//		if (dto != null) {
//			System.out.println(dto); 
//		}
//		
//		print("user99 상세조회");
//		dto = service.getMember("user99");
//		if (dto != null) {
//			System.out.println(dto); 
//		}
//		
//		print("전체조회");
//		
//		print("회원정보 전체변경");
//
//		print("암호변경");
//
//		print("회원탈퇴");
//		
//		print("회원전체탈퇴(배열요소 초기화)");
//		
//		print("회원 초기화 등록");
		
	}
	

	/**
	 *  테스트시에 출력위한 메서드
	 * @param message 메세지
	 */
	public static void print(String message) {
		System.out.println("\n### " + message);
	}
	
}
