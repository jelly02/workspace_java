package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberService;

public class Test {
	
	public static void main(String[] args) {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");
	

		print("회원관리 서비스 이용위한 객체 생성");
		MemberService service = new MemberService();

		print("회원등록");
		service.addMember(dto1);
		service.addMember(dto2);
		service.addMember(dto3);
		service.addMember(dto4);
		service.addMember(dto5);
		
		service.addMember(dto2); 
		service.addMember(dto2);// 문제?? => 해결 => 등록되지않음
		
		print("등록인원수 : " + service.getCount());
		
		print("user01 상세조회");
		Member dto = service.getMember("user01");
		if (dto != null) {
			System.out.println(dto); 
		}
		
		print("user99 상세조회");
		dto = service.getMember("user99");
		if (dto != null) {
			System.out.println(dto); 
		}
		
		print("전체조회");
		
		print("회원정보 전체변경");

		print("암호변경");

		print("회원탈퇴");
		
		print("회원전체탈퇴(배열요소 초기화)");
		
		print("회원 초기화 등록");
		
	}
	

	/**
	 *  테스트시에 출력위한 메서드
	 * @param message 메세지
	 */
	public static void print(String message) {
		System.out.println("\n### " + message);
	}
	
}
