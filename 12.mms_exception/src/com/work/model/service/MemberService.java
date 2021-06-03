package com.work.model.service;

import java.util.ArrayList;
import java.util.Random;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.work.exception.DuplicateException;
import com.work.exception.RecodeNotFoundException;
import com.work.model.dto.Member;

import com.work.util.Utility;

/**
 * Collection API 활용 변경
	- Generic

 * @author Administrator
 *
 */


public class MemberService {
	
	/**  회원들을 저장하기 위한 자료 저장 구조 */
	private ArrayList<Member> list = new ArrayList<Member>();
	
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
	 * @throws RecodeNotFoundException 
	 */
	public boolean setMember(Member dto) throws RecodeNotFoundException {
		
		int index = exist(dto.getMemberId());
		
		//존재
		if(index >= 0) {
			list.set(index, dto); //set은 반환타입이 변경 전 객체(boolean으로 해야함)
			return true;
		}
		

		throw new RecodeNotFoundException(dto.getMemberId());
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
		
		if(index >= 0 && list.get(index).getMemberPw().equals(memberPw)) {
			list.get(index).setMemberPw(memberPw);
			return true;
		}
		return false; // 아이디가 존재하지 않거나, 기존 비밀번호가 틀린 경우
	}
	
	/**
	 *  회원 탈퇴
	 *  
	 * @param memberId 아이디
	 * @param memberPw 비밀번호 
	 * @return 성공시 탈퇴 회원 기존 정보, 실패시 null
	 * @throws RecodeNotFoundException 
	 */
	public Member removeMember(String memberId ,String memberPw) throws RecodeNotFoundException {
		
			int index = exist(memberId);
			
			if(index >= 0 && list.get(index).getMemberPw().equals(memberPw)) {
						return (Member) list.remove(index);
			}
			
			throw new RecodeNotFoundException(memberId);
		
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
	 * @throws DuplicateException 
	 * 
	 */
	public void addMember(Member dto) throws DuplicateException {
		
//		if (exist(dto.getMemberId()) == -1) {
//				//등록
//				list.add(dto);
//		}else {
//			System.out.println("[오류] : 동일한 아이디가 존재합니다. : "+dto.getMemberId());
//		}
		
		int index = exist(dto.getMemberId());
		
		if(index >= 0 ) {
			//아이디 존재 > 예외 발생
			//addMember을 호출한 곳에서 반환
			throw new DuplicateException(dto.getMemberId());
		}
		
		list.add(dto);
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
	 * @throws DuplicateException 
	 */
	
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) throws DuplicateException {
	
		// 부모타입은 자식 요소를 접근 못해서 상속 다 받은 자식껄로 쓴다!
		Member dto = new Member(memberId, memberPw,name,mobile ,email );
		
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
		
		/*collection
		for (int index = 0; index < list.size(); index++) {
			Object obj = list.get(index);
			if (obj instanceof Member) {
				Member dto = (Member)obj;
				if (dto.getMemberId().equals(memberId)) {
					return index;
				}
			}
		}
		*/
		
		for (int index = 0; index < list.size(); index++) {
			if(list.get(index).getMemberId().equals(memberId)) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	 *  테스트를 위한 회원 초기화 등록 메서드
	 * @return 초기화 된 회원 수를 반환
	 * @throws DuplicateException 
	 */
	
	public int initMember() throws DuplicateException {
		
		Member dto1 = new Member("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000, null);
		Member dto2 = new Member("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000, null);
		Member dto3 = new Member("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", 0,"강동원");
		Member dto4 = new Member("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", 0,"김하린");
		Member dto5 = new Member("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A");

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
	 * @throws RecodeNotFoundException 
	 */
	
	public Member getMember (String memberID) throws RecodeNotFoundException {
		
		int index = exist(memberID);
		
		if(index >= 0) {
			//Type mismatch: cannot convert from Object to Member > Member로 Casting
			return (Member)list.get(index); 
		}
		
//		return null;
//		존재하지 않은 회원일 경우
		throw new RecodeNotFoundException(memberID);
	}
	
	
	//로그인
	public boolean login (String memberId, String memberPw) {
		
		int index = exist(memberId);
		
		if(index >=0 ) {
			if(list.get(index).getMemberPw().equals(memberPw)) {
				return true;
			}	
		}
		return false;
	}
	
	
	/*우수회원 등업처리
	(1) 일반 회원이 본인의 마일리지 정보를 조회하고 > 관리자(시스템) 등업요청
	*
	*/
	
	//아이디 찾기
	public boolean findId(String mobile) {
		

		
		
		return false;
	}
	
	
	//비밀번호 변경
	public String changePw(String memberId, String memberPw) {
		
		Random random = new Random();
		int index = exist(memberId);
		
		if(index >=0 ) {
			if(list.get(index).getMemberPw().equals(memberPw)) {
	//			list.get(index).setMemberPw(random.nextInt(100)*4);
			}	
		}
		
	
		return null;
	}
	
	
	
	
}
