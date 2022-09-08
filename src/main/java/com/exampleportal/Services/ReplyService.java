package com.exampleportal.Services;

import java.util.List;

import com.exampleportal.Entity.Reply;

public interface ReplyService {
	
	public Reply saveReply(Reply reply);
	
	public List<Reply> findByUser(int userId);
	
	public List<Reply> deleteReplyById(int replyId);

}
