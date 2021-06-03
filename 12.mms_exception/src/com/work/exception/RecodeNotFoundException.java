package com.work.exception;

public class RecodeNotFoundException extends Exception {  
	
	public RecodeNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public RecodeNotFoundException(String message) {
		super("사용자 예외 : "+message);
	}
}

