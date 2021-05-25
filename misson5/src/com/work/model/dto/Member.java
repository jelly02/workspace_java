package com.work.model.dto;

public class Member {
	
	//String userId (unique/not null) , String password (not null), int point, String level, 
	//String signInDate (not null), String phone (unique/not null), String email (unique/not null)
	
	 String userId;
	 String password;
	 int point;
	 int level;
	 String signInDate; 
	 String phone;
	 String email;
	
	public Member(String userId, String password, int point, int level, String signInDate, String phone, String email) {

		this.userId = userId;
		this.password = password;
		this.point = point;
		this.level = level;
		this.signInDate = signInDate;
		this.phone = phone;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getSignInDate() {
		return signInDate;
	}

	public void setSignInDate(String signInDate) {
		this.signInDate = signInDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
