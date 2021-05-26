package com.work.model.dto;

public class Member {
	
	private String memberId;
	private String memberPw;
	private String name;
	private String mobile;
	private String email;
	private String entryDate;
	private String grade;
	private int mileage;
	private String manager;
	
	/**
	 * 회원 도메인 클래스 
	 * >> 모든 회원들의 공통(일반화) : 부모 클래스 설계 변경 
	 *  * 1. 아이디
	 * 2. 비밀번호
	 * 3. 이름
	 * 4. 휴대폰
	 * 5. 이메일
	 * 6. 가입일
	 * 7. 등급
	 * 8. 마일리지
	 */

	/** 기본 생성자 */
	//컨+스페이스
	public Member() {
		System.out.println("부모 기본 생성자");
	} 
	
	/**
	 *  사용자 입력 필수 데이터 초기화 생성자
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name= name;
		this.mobile = mobile;
		this.email = email;
		
		System.out.println("부모 회원 필수 데이터 초기화 생성자");
	}

		
	/**
	 *  회원 필수 데이터 초기화 생성자
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		this(memberId, memberPw, mobile, name,  email);
		this.entryDate = entryDate;
		this.grade = grade;
		
		System.out.println("부모 회원 필수 데이터 초기화 생성자");
	}
	
	
	

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberPw
	 */
	public String getMemberPw() {
		return memberPw;
	}

	/**
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
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

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return memberId + ", " + memberPw + ", " + name + ", " + mobile + ", " + email + ", " + entryDate + ", " + grade
				+ ", " + mileage + ", " + manager;
	}
	
	

}
