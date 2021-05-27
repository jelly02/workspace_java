package com.work.model.service;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * 회원을 관리하는 서비스   
 * 
 * - 회원들을 관리하기 위한 자료 저장 구조 : 배열의 다형성 반영 (부모타입으로 진행)
 * - 메서드 Argument 다형성(부모타입), 반환타입??
 * - 메서드 명(매개변수) : 반환
 * - CRUD 기능의 메서드 argument 다형성, 반환타입
 * 1)  R : 단일조회/상세 조회 > 아이디, 다중조회/전체조회/그룹조회 > 전체 조회(argument x), 등급별 회원 전체 조회
 * 2)  U : 전체 변경 > 전체 삭제/특정삭제, 부분 변경 > 비밀번호 변경
 */
public class MemberService {
	
	 Member[] list = new Member[] {};
	
	
	Member dto1 = new GeneralMember ("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15","G",50000);
	Member dto2 = new GeneralMember ("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-15","G",950000);		
	Member dto3 = new SpecialMember("user03", "password04", "김유신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
	Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
	AdminMember dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");
	
	//등록하기
	public void addMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage, String manager) {
		
		System.out.println(manager);
		
		for(int i=0; i<list.length; i++){
			list[i] = new Member(memberId,memberPw,name,mobile,email,entryDate,grade,mileage,manager);
		}
		
		for(int i=0; i<list.length; i++){
			System.out.println("--회원 정보 출력--");
			list[i].toString();
		}
		
		
		
	}
	
	

}
