package com.exampleportal.Helper;

public class EmailResponse {
	
	private int otp;
	private boolean status;
	
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EmailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailResponse(int otp, boolean status) {
		super();
		this.otp = otp;
		this.status = status;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
