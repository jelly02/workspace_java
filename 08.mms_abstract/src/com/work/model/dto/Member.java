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
	public Member() {} 
	
	/**
	 *  사용자 입력 필수 데이터 초기화 생성자
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name= name;
		this.mobile = mobile;
		this.email = email;
		
	}

		
	/**
	 *  회원 필수 데이터 초기화 생성자
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		this(memberId, memberPw, mobile, name,  email);
		this.entryDate = entryDate;
		this.grade = grade;
		
	}
	

	/**
	 * 
	 * 모두 
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 * @param mileage
	 * @param manager
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage, String manager) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.entryDate = entryDate;
		this.grade = grade;
		this.mileage = mileage;
		this.manager = manager;
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
		return "부모"+memberId + ", " + memberPw + ", " + name + ", " + mobile + ", " + email + ", " + entryDate + ", " + grade
				+ ", " + mileage + ", " + manager;
	}

	@Override
	//얘는 아무 숫자만 넘겨주면 상관 없음
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
		
//		return 1004;
	}

	@Override
	public boolean equals(Object obj) {
		//현재 객체과 obj가 같다면
		if (this == obj)
			return true;
		//parameter로 전달 받은 obj가 null(어떠한 객체도 참조하고 있지 않음)이면 
		if (obj == null)
			return false;
		//getClass():Member 클래스
		if (getClass() != obj.getClass())
			return false;
		
		/*위의 코드를 통과했다면 같은 클래스라는 의미*/
		
		//캐스팅
		Member other = (Member) obj;
		
		//캐스팅한 객체의 memberId가 null 이 아니면
		if (memberId == null) {
			//전달 받은 객체의 id가 아니면
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		
		/*결과 : parameter로 들어온 obj가 멤버 객체가 들어왔고 멤버객체의 id가 null이 아니고 동일한 정보를 가지고 있다!*/
		
	
		return true;
	}

	
	

}
	
