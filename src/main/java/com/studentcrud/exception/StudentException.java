package com.studentcrud.exception;

public class StudentException extends RuntimeException{
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public StudentException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	

}
