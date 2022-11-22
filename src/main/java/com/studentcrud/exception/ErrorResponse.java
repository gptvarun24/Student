package com.studentcrud.exception;

public class ErrorResponse {
    private String msg;
    
	public ErrorResponse(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ErrorResponse() {
		
	}

}
