package com.work.exception;

public class UserException extends Exception {
	
	//컨+스페이스
	public UserException() {
		super("사용자가 만든 예외");
	}
	
	public UserException(String message) {
		super("사용자가 만든 예외 : "+message);
	}

}
