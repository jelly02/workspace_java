package com.work.model.dto;

public class SpecialMember extends Member {
	
	/**
	 * <pre>
	 * 우수 회원 도메인 클래스
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
	 * #우수 회원 속성
	 * 1. 담당자
	 * </pre>
	 * @author Jay
	 *
	 */
	private int mileage;	
	private String manager;

	/**
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 */
		public SpecialMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
				String grade, int mileage, String manager) {
			super(memberId, memberPw, name, mobile, email, entryDate, grade);
			this.mileage = mileage;
			this.manager = manager;
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
	 
	 
	
	
}
