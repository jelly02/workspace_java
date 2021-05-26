/**
 * 
 */
package com.work.model.dto;

/**
 * <pre>
 * 일반 회원 도메인 클래스
 * 회원(부모클래스)의 자식(상속)
 * 
 * #일반 회원 속성
 * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 휴대폰
 * 5. 이메일
 * 6. 가입일
 * 7. 등급
 * 8. 마일리지
 * 
 * </pre>
 * @author Jay
 *
 */

//같은 패키지에 있는 클래스는 import하지 않아도 된다
public class GeneralMember extends Member {
	
	/** 일반 회원 마일리지*/
	private int mileage;

	/**
	 * 회원 입력 필수데이터 초기화 생성자 
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	
	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email) {
		
		//자식 객체의 생성자에서 부모객체의 생성자를 미지정 
		super(memberId,  memberPw,  name,  mobile,  email); 
		//>>javac가 자동으로 부모의 기본 생성자를 super() 자동 지정 호출 수행 : 부모 Member의 기본 생성자 출력됨
		
		//부모의 private 멤버 변수는 접근 권한으로 인해서 자식 클래스 접근 불가
		//부모로부터 상속받은 setter() 메서드를 이용해서 데이터 초기화 수행
		setMemberId(memberId);
		setMemberPw(memberPw);
		setName(name);
		setMobile(mobile);
		setEmail(email);
		setGrade("G");
		setEntryDate("2021-05-26");
		
		System.out.println("자식 일반 입력 필수 데이터 초기화 생성자");
	}
	
	//일반 회원의 모든 데이터 초기화 생성자 
	/**
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 * @param mileage
	 */
	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.mileage = mileage;
	}

	
	
	
	
	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	
	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	

}
