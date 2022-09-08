package com.exampleportal.ServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleportal.Entity.Reply;
import com.exampleportal.Repository.ReplyRepository;
import com.exampleportal.Services.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{
    
	@Autowired
	private ReplyRepository replyRepo;
	
	
	@Override
	public Reply saveReply(Reply reply) {
		reply.setDate(new Date());
		return this.replyRepo.save(reply);
	}


	@Override
	public List<Reply> findByUser(int userId) {


		return this.replyRepo.findByUserid(userId);
	}


	@Override
	public List<Reply> deleteReplyById(int replyId) {

		this.replyRepo.deleteById(replyId);
                 
		return this.replyRepo.findAll();
	}

}
