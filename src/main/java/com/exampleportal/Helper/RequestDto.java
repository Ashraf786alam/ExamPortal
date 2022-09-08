package com.exampleportal.Helper;

import java.util.Date;

public class RequestDto {
	
	private int requestId;
	
	private String content;
	
	private String action;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	private Date date;
	
	private String email;
	
	private String phone;
	
	private String username;
	
	private int userId;

	public RequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDto(int requestId, String content, Date date, String email, String phone, String username,
			int userId) {
		super();
		this.requestId = requestId;
		this.content = content;
		this.date = date;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.userId = userId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
