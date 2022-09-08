package com.exampleportal.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reply")
public class Reply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int replyId;
	
	private String content;
	
	private int requestid;
	
	private int userid;
	
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reply(int replyId, String content, int requestid, int userid, Date date) {
		super();
		this.replyId = replyId;
		this.content = content;
		this.requestid = requestid;
		this.userid = userid;
		this.date = date;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private Date date;

}
