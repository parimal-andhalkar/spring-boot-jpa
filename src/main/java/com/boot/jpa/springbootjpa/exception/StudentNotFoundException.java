package com.boot.jpa.springbootjpa.exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends RuntimeException {

	private HttpStatus errorCode;
	private String errorMessage;

	public StudentNotFoundException() {
	}

	public StudentNotFoundException(HttpStatus errorCode, String errorMessage) {
		
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	

}
