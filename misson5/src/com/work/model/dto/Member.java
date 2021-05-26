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
	 *  기본 생성자 
	 */
	public Member() {}
	

	/**
	 * 사용자 입력 데이터 초기화 생성자
	 * @param memberId
	 * @param memberPw
	 * @param mobile
	 * @param email
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name= name;
		this.mobile = mobile;
		this.email = email;
	}


	/**
	 * 필수 데이터 초기화 생성자
	 * @param memberId : 아이디
	 * @param memberPw : 비밀번호
	 * @param name : 이름
	 * @param mobile : 핸드폰 번호
	 * @param entryDate : 가입날짜
	 * @param grade : 등급
	 * @param email : 이메일
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		this(memberId, memberPw, mobile, name,  email);
		this.entryDate = entryDate;
		this.grade = grade;
	}


	/**
	 * @param memberId : 아이디
	 * @param memberPw : 비밀번호
	 * @param name : 이름
	 * @param mobile : 핸드폰 번호
	 * @param entryDate : 가입날짜
	 * @param grade : 등급
	 * @param mileage : 마일리지
	 * @param manager : 우수회원 담당매니저
	 * @param email : 이메일
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage, String manager) {
		this(memberId, memberPw, name, mobile,  email, entryDate, grade);
		this.mileage = mileage;
		this.manager = manager;
	}

	/**
	 *  아이디 검증 규칙
	 *  -- 최소 6자리, 최대 30자리
	 *  -- 문자열 길이 메서드 : {@link String#length()}
	 *  @return 아이디 길이가 6~30자리 이내면 true, 그렇지 않으면 false
	 */
	
	private boolean isMemberId(String memberId) {
		
		if(memberId.length() >= 6 && memberId.length() <= 30) {
			return true;
		}else {
			return false;
		}
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
		boolean result = isMemberId(memberId);
		
		if(result)
		{
			this.memberId = memberId;
		} else {
			System.out.println("[오류] 아이디는 6~30자리 이내로 입력하세요.");
		}
		
	}

	
	/**
	 *  비밀번호 검증 규칙
	 *  -- 최소 6자리, 최대 20자리
	 *  -- 문자열 길이 메서드 : {@link String#length()}
	 *  @return 비밀번호 길이가 6~30자리 이내면 true, 그렇지 않으면 false
	 */
	
	private boolean isMemberPw(String memberPw) {
		int length = memberPw.length();
		
		if(length >= 6 && length<= 20) {
			return true;
		}
		
		return false;
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
		
		
		if(isMemberPw(memberPw)){
			this.memberPw = memberPw;
			return;
		}
		
		System.out.println("[오류] 비밀번호는 6자리 ~ 20자리 이내로 입력하세요");
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

	//문자열 비교 메서드
	public boolean equals(String grade){
		
//		if(grade.equals("G")) {
//			return true;
//		}else if(grade.equals("S")) {
//			return true;
//		}else if(grade.equals("A")) {
//			return true;
//		}else {
//			return false;
//		}
		
//		return grade.equals("G")|| grade.equals("S") ||grade.equals("A");		
		
		switch(grade){
			case "G" :
			case "S" :
			case "A" :
				return true;
			default :
				return false;
		}
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
		
		boolean result = equals(grade);
		
		if(result)
		{
			this.grade = grade;
		} else {
			System.out.println("[오류] 등급은 'G','S','A' 로 설정되어있습니다.");
		}
		
	}

	/**
	 *  마일리지 검증 규칙
	 *  -- 0~100,000
	 *  @return 마일리지가 0~100,000 이내면 true, 그렇지 않으면 false
	 */
	
	private boolean isMileage(int mileage) {
		
		if(mileage>= 0 && mileage <= 100000) {
			return true;
		}
			return false;
		
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

		if(isMileage(mileage))
		{
			this.mileage = mileage;
		} else {
			System.out.println("[오류] 마일리지는 0~100,000이내 입니다.");
		}
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
