package com.work.model.service;

import java.util.ArrayList;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.util.Utility;

/**
 * Collection API 활용 변경
 * -- ArrayList
 */
public class MemberService {
	/** 회원들을 저장관리하기 위한 자료 저장구조 */
	private ArrayList list = new ArrayList();

	/** 기본생성자 : 초기화 회원 등록 수행 */
	public MemberService() {
//		int count = initMember();
//		System.out.println("초기화회원 등록작업이 완료되었습니다. : " + initMember());
	}
	
	/** 현재 등록한 전체 회원 조회 */
	public ArrayList getMember() {
		return list;
	}
	
	/**
	 * 현재 등록 인원수 조회
	 * @return 현재 등록 인원수
	 */
	public int getCount() {
		return list.size();
	}
	
	/**
	 * 회원 등록
	 * @param dto 등록 회원
	 */
	public void addMember(Member dto) {
		if (exist(dto.getMemberId()) == -1) {
			list.add(dto);	// list 순서존재, 중복 허용 구조 => 개발자 등록전에 중복여부 검증 처리 : 순서 인덱스는 사용하고, 중복되지않고 처리 가능??
		} else {
			System.out.println("[오류] 동일한 아이디가 존재합니다. : " + dto.getMemberId());
		} 
	}
	
	/**
	 * 회원 등록
	 * -- 사용자 입력 데이터 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * -- 시스템 최초 가입시 일반회원 가입처리 : 가입일, 등급, [마일리지]
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰 
	 * @param email 이메일
	 */
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) {
		GeneralMember dto = new GeneralMember(memberId, memberPw, name, mobile, email);
		dto.setGrade("G");
		dto.setEntryDate(Utility.getCurrentDate());
		dto.setMileage(1000);
		
		addMember(dto);
		
		// 부모타입의 변수의 다형성 적용 : 자식객체를 참조(reference)는 가능하지만 타입이 부모타입이기때문에 부모타입으로 자식의 멤버접근 불가
//		Member dto = new GeneralMember(memberId, memberPw, name, mobile, email);
//		dto.setGrade("G");
//		dto.setEntryDate(Utility.getCurrentDate());
//		dto.setMileage(1000);
//		
//		addMember(dto);
		
	}
	
	/**
	 * 회원 존재 유무 조회
	 * @param memberId 아이디
	 * @return 존재시 저장위치 인덱스번호, 미존재시 -1
	 */
	public int exist(String memberId) {
		for (int index = 0; index < list.size(); index++) {
			Object obj = list.get(index);
			if (obj instanceof Member) {
				Member dto = (Member)obj;
				if (dto.getMemberId().equals(memberId)) {
					return index;
				}
			}
		}
		
		// 제공자 : 형님 : 중복체크 결과가 올바르지 않게 나옴
//		for (int index = 0; index < list.size(); index++) {
//			if (list.get(index).equals(memberId)) {		
//				// list.get(index) => Object => Member#equals(Member) : Member 아이디같은지비교
//				// Member#equals(String) : Member 객체하고 String 같은지비교
//				return index;
//			}
//		}
//
		return -1;
	}
	
	/**
	 * 테스트를 위한 회원 초기화 등록 메서드
	 * @return 초기화 회원등록 인원수
	 */
	public int initMember() {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");

		addMember(dto1);
		addMember(dto2);
		addMember(dto3);
		addMember(dto4);
		addMember(dto5);
		
		return list.size();
	}

	/**
	 * 회원 상세조회
	 * @param memberId 회원아이디
	 * @return 존재하면 회원객체, 미존재 null
	 * @see exist(String)
	 */
	public Member getMember(String memberId) {
		int index = exist(memberId);
		if (index >= 0) {
			return (Member)list.get(index);
		}
		
		return null;
	}
}








