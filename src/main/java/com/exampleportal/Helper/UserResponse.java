package com.exampleportal.Helper;

public class UserResponse {
	
	private String message;
	
	private boolean status;
	
	public UserResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}
