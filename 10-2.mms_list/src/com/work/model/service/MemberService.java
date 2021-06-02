package com.work.model.service;

import java.util.ArrayList;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.util.Utility;

/**
 * Collection API 활용 변경
 * @author Administrator
 *
 */


public class MemberService {
	
	/**  회원들을 저장하기 위한 자료 저장 구조 */
	private ArrayList list = new ArrayList();
	
	/**  
	 * 기본 생성자 : 초기화 회원 등록 수행 
	 * 	   클래스가 실행 될 때 한 번 자동으로 실행 될 메소드
	 * */
	public MemberService() {
//		int count = initMember();
//		System.out.println("초기화 회원 등록 작업이 완료되었습니다. ");
		
	}
	/**  전체 회원 조회 */
	public ArrayList getMember() {
		return list;
	}
	
	/**
	 * 회원 정보 전체 변경 
	 * @return 성공 : true / 실패 : false
	 */
	public boolean setMember(Member dto) {
		
		int index = exist(dto.getMemberId());
		
		//존재
		if(index >= 0) {
			list.set(index, dto); //set은 반환타입이 변경 전 객체(boolean으로 해야함)
			return true;
		}
		
		return false;
	}
	
	/**
	 * 비밀번호 변경 
	 * - 매개변수 : 아이디, 비밀번호, 변경 비밀번호
	 * - 도메인 데이터 각각 : 아이디, 비밀번호, 변경 비밀번호
	 * - 도메인 객체 Member로 받을 수 있을까? > 아니요. 변경 비밀번호 속성이 없다 
	 * @return
	 */
	public boolean setMemberPw(String memberId, String memberPw, String modifyPw) {
		
		int index = exist(memberId);
		
		if(index >= 0) {
			
			//get의 반환타입은 obj
			Object obj = list.get(index);
			
			//obj가 Member의 인스턴스라면
			if(obj instanceof Member) {
				//obj는 memberPW가 없어서 pw가 있는 member로 캐스팅
				Member dto = (Member)obj;
						
				if(dto.getMemberPw().equals(memberPw)){
					dto.setMemberPw(modifyPw);
					return true;
				}
			}
		}
		return false; // 아이디가 존재하지 않거나, 기존 비밀번호가 틀린 경우
	}
	
	/**
	 *  회원 탈퇴
	 *  
	 * @param memberId 아이디
	 * @param memberPw 비밀번호 
	 * @return 성공시 탈퇴 회원 기존 정보, 실패시 null
	 */
	public Member removeMember(String memberId ,String memberPw) {
		
	int index = exist(memberId);
			
			if(index >= 0) {
				
				 Object obj = list.get(index);
				
				if(obj instanceof Member) {
					Member dto = (Member)obj;
							
					if(dto.getMemberPw().equals(memberPw)){
						return (Member) list.remove(index);
					}
				}
			}
		return null;
	}
	
	
	/**
	 * 현재 등록 인원수 조회
	 * @return 현재 등록 인원수
	 */
	public int getCount() {
		return list.size(); //배열의 count가 따로 필요 없음
	}
	
	/**
	 * 회원등록
	 * - 사용자가 입력한 데이터 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * - 시스템에서 최초 부여하는 데이터 : 등급(일반회원), 가입일(오늘 날짜)
	 * @param dto 회원 객체
	 * 
	 */
	public void addMember(Member dto) {
		
		if (exist(dto.getMemberId()) == -1) {
				//등록
				list.add(dto);
		}else {
			System.out.println("[오류] : 동일한 아이디가 존재합니다. : "+dto.getMemberId());
		}
	}
	
	/**
	 * 
	 * 회원 등록 (도메인 속성)
	 *  - 사용자가 입력한 데이터 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * - 시스템에서 최초 부여하는 데이터 : 등급(일반회원), 가입일(오늘 날짜)
	 * 
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
	
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) {
	
		// 부모타입은 자식 요소를 접근 못해서 상속 다 받은 자식껄로 쓴다!
		GeneralMember dto = new GeneralMember(memberId, memberPw,name,mobile ,email );
		
		dto.setGrade("G");
		dto.setEntryDate(Utility.getCorrentDate());
		dto.setMileage(1000);
		
		//addMember(Member dto) 여기로 넘기기!
		//속성 지정 완료! 객체로 만들어서 위로 넘기자!
		
		addMember(dto);
	}
	
	
	
	/**
	 * 회원 존재 유무 조회
	 * 
	 * (1) 저장된 회원의 크기만큼 반복
	 * (2) 저장 객체 조회 (object)
	 * (3) 사용 메서드 : instanceof, type castiong, equals()
	 * 
	 * @param memberId 아이디
	 * @return 존재 시 저장 위치 인덱스 번호, 미존재시 -1
	 */
	
	public int exist(String memberId) {
	// list는 0부터 시작하기 때문에 0보다 작은 수를 리턴
		
/*		(1) obj를 오버라이딩 하지 않았을 때 
 		for(int index = 0; index < list.size(); index++) {
			// get()의 반환타입은 object, 부모는 자식을 못 건드림, memberId 속성 없음
			Object obj = list.get(index); 
				//instanceof		Member가 부모	
				if (obj instanceof Member) {
					//Member로 Casting 하기	
					Member dto = (Member)obj;
						//memberId와 param의 memberId가 같다면
					if(dto.getMemberId().equals(memberId)) {
							return index;
						}
				}
		}
	
		//(2) obj를 오버라이딩 했을 때 
		for(int index=0; index<list.size();index++) {
			
			//Members에서 object를 오버라이딩 했었음
			if(list.get(index).equals(memberId)) {
				return index;
			}
		}*/	
 		
		for (int index = 0; index < list.size(); index++) {
			Object obj = list.get(index);
			if (obj instanceof Member) {
				Member dto = (Member)obj;
				if (dto.getMemberId().equals(memberId)) {
					return index;
				}
			}
		}
		
		return -1;
	}
	
	/**
	 *  테스트를 위한 회원 초기화 등록 메서드
	 * @return 초기화 된 회원 수를 반환
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
	 * 회원 상세 조회
	 * 
	 * @param memberID 회원 아이디
	 * @return 존재하면 회원 객체, 미존재 null
	 */
	
	public Member getMember (String memberID) {
		
		int index = exist(memberID);
		
		if(index >= 0) {
			//Type mismatch: cannot convert from Object to Member > Member로 Casting
			return (Member)list.get(index); 
		}
		
		return null;
	}
	
	
	/**
	 * 
	 */
	public boolean setGrade(String adminId, String memberId, String grade) {
		
		int index = exist(adminId);
		
		if(index >= 0) {
			
			Object obj = list.get(index);
			
			if(obj instanceof Member) {
				
				Member dto = (Member) obj;
				
				if(dto.getGrade().equals("A")) {
					
				//	dto.getMemberId(memberId).setGrade(grade);
					
					return true;
				}
			}
			
		}
		
		
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
