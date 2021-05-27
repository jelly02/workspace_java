package com.work.static_test;

/**
 *   회원 도메인 클래스
 *   1. 아이디
 *   2. 이름
 *   3. 휴대폰
 *   
 *   #설계 규칙
 *   1. encapsulation
 *   2. 생성자 중복정의 : 기본, 전체
 *   3. toString()
 *   4. equals(), hashcode() 재정의 : 아이디 같으면 같은 객체 
 *   
 */
public class SimpleMember {
	
	//Static 멤버 변수 = class 변수 > 객체 생성 없이 사용 가능, 모든 객체가 공유하는 변수
	public static int CLASS_COUNT;
	
	//인스턴스 번수 : 객체 생성 후 참조 변수 명을 통해서 해당 객체에서 사용 
	public int instancCount;
	
	//static block 초기화
	static {
		CLASS_COUNT = 1234567;
		System.out.println("static block 초기화 : 클래스가 로드 될 때 딱 한 번만 수행합니다");
	}
	
	//인스턴스 block 초기화
	{
		System.out.println("객체 생성할 때마다 수행합니다");
	}
	
	
	// 회원 id, 회원 이름, 회원 휴대폰
	private String memberId;
	private String name;
	private String mobile;
	
	public SimpleMember() {}
	
	/**
	 * @param memberId
	 * @param name
	 * @param mobile
	 */
	public SimpleMember(String memberId, String name, String mobile) {
		this.memberId = memberId;
		this.name = name;
		this.mobile = mobile;
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleMember other = (SimpleMember) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return memberId + ", " + name + ", " + mobile;
	}
	
	
	
	

}
