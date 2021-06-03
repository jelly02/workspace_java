package com.work.exception;

public class DuplicateException  extends Exception {
	
	public DuplicateException() {
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(String message) {
		super("중복 예외 : "+message);
	}
}
