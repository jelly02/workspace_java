package com.work.model.service;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;
import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * 회원을 관리하는 서비스 클래스 >> 추상 클래스 설계 변경
 * 추상클래스 구성 요소 
 * 		> 클래스 구성요소 + [추상 메서드]
 * 
 * - 회원들을 관리하기 위한 자료 저장 구조 : 배열의 다형성 반영 (부모타입으로 진행)
 * - 메서드 Argument 다형성(부모타입), 반환타입??
 * 
 * - 메서드 명(매개변수) : 반환
 * - CRUD 기능의 메서드 argument 다형성, 반환타입
 * 1)  R : 단일조회/상세 조회 > 아이디, 다중조회/전체조회/그룹조회 > 전체 조회(argument x), 등급별 회원 전체 조회
 * 2)  U : 전체 변경 > 전체 삭제/특정삭제, 부분 변경 > 비밀번호 변경
 */
public abstract class MemberServiceAbstract {
	
	 
	/**
	 *  <미완성) 회원 등록 메서드>
	 * - 매개변수 : ?? 다형성 반영 모든 회원을 등록하기 위한 메서드로 제작
	 *  -반환타입
	 */
	 public abstract void addMember(Member dto); //메소드의 body{} 가 없잖아! 
	 
	 /**
	  * CRUD 메서드에서 사용하기 위한 회원 존재 유뮤 및 저장 위치 조회 메서드
	  * @param memberId
	  * @param 
	  */
	 
	 // id 중복 조회 메서드
	 public abstract int exist(String memberId);
	 
	 /**
	  * < 회원 상세 조회 메서드>
	  * - 메서드 명 : getMember()
	  * - 매개변수 : memberId
	  * - 반환타입 : Member(반환타입 다형성 : 부모타입)
	  * 
	  */
	 public abstract Member getMember(String memberId);
	 
	 /**
	  *  전체 조회
	  *  - 메서드 명 : getMember()
	  *  - 매개변수 없음
	  *  - 반환 타입 : 현재 등록된 모든 회원들의 정보만을 저장한 배열, 다형성  Member[]
	  */
	 public abstract Member[] getMember();
	 
	 
	 /**
	  *  회원 정보 전체 변경
	  *  - 메서드 명 : setMember()
	  *  - 매개변수 : Member
	  *  - 반환 타입 : void / 오류 발생시 메세지 처리 
	  */
	 
	 /**
	  *	 회원 비밀번호 변경 
	  *	  - 메서드 명 : setMemberPw()
	  *  - 매개변수 : 아이디, 비밀번호, 변경 비밀번호
	  *  - 반환 타입 : boolean 암호변경성공 true, 실패하면 false	
	  *   */
	 public abstract void setMemberPw(String memberId, String memberPw, String modifyPw );
	 
	 
	
	 /**
	  *  회원 탈퇴
	  *  - 메서드명 : removeMember()
	  *  - 매개변수 : 아이디, 비밀번호
	  *  - 반환타입 : void
	  */
	 
	 public abstract void removeMember(String memberId, String memberPw);
	 
	 /**
	  *  회원 전체 탈퇴
	  *  - 메서드명 : removeMember()
	  *  - 매개변수 : 없음
	  *  - 반환타입 : void
	  */
	 
	 
	 
	 

}