package com.exampleportal.Entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="request")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int requestId;
	
	private String content;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int requestId, String content, User user, Date date) {
		super();
		this.requestId = requestId;
		this.content = content;
		this.user = user;
		this.date = date;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private Date date;
	

}
