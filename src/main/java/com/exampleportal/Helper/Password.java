package com.exampleportal.Helper;

public class Password {
	
	private String newpassword;
	private String confirmpassword;
	private String email;
	@Override
	public String toString() {
		return "Password [newpassword=" + newpassword + ", confirmpassword=" + confirmpassword + ", email=" + email
				+ "]";
	}
	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Password(String newpassword, String confirmpassword, String email) {
		super();
		this.newpassword = newpassword;
		this.confirmpassword = confirmpassword;
		this.email = email;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
