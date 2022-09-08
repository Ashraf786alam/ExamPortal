package com.exampleportal.Exception;

public class BadCredentials extends RuntimeException {
	
	private String message;

	public BadCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BadCredentials(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
