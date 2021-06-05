package com.concert.service;

import java.util.ArrayList;

import com.concert.model.Member;

/**
 * 서비스 클래스 
 * 
 * @author KIMJURI
 *
 */


public class MemberService {
	
	/**  회원들을 저장하기 위한 자료 저장 구조 */
	private ArrayList<Member> list = new ArrayList<Member>();
	
	/** 기본 생성자 */
	public MemberService() {}
	
	/** 현재 등록한 전체 회원 조회 */
	public ArrayList getMember() {
		return list;
	}
	
	/**
	 *  회원 등록 메서드
	 * @param member
	 */
	public void addMember(Member member) {
		
		int index = exist(member.getMemberId());
		
		if(index >= 0 ) {
			//아이디 존재 > 예외 발생
			//addMember을 호출한 곳에서 반환
		//	throw new DuplicateException(member.getMemberId());
		}
		
		list.add(member);
		
	}

	/**
	 * 회원 존재 유무 조회 메서드
	 * @param memberId 아이디
	 * @return 존재 시 저장 위치 인덱스 번호, 미존재시 -1
	 */

	private int exist(String memberId) {

		for (int index = 0; index < list.size(); index++) {
			if(list.get(index).getMemberId().equals(memberId)) {
				return index;
			}
		}
		return -1;
	}

}
