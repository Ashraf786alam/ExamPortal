package com.exampleportal.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleportal.Entity.Reply;
import com.exampleportal.Repository.RequestRepository;
import com.exampleportal.Repository.UserRepository;
import com.exampleportal.Services.ReplyService;

@RestController
@RequestMapping("/reply")
@CrossOrigin("*")
public class ReplyController {
	
	@Autowired
	private ReplyService replyServiceImpl;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RequestRepository requestRepo;
	
	@PostMapping("/")
	public ResponseEntity<Reply> saveReply(@RequestBody Reply reply){
		
		
		this.requestRepo.deleteById(reply.getRequestid());
		return  ResponseEntity.status(HttpStatus.OK).body(this.replyServiceImpl.saveReply(reply));
		
	}
	
	@GetMapping("/")
	private ResponseEntity<List<Reply>> getReplyOfUser(Principal principal){
		int userId=this.userRepo.findByUsername(principal.getName()).getId();
		return ResponseEntity.status(HttpStatus.OK).body(this.replyServiceImpl.findByUser(userId));
		
	}
	
	@DeleteMapping("/{replyId}")
	public ResponseEntity<List<Reply>> deleteReply(@PathVariable int replyId){
		return ResponseEntity.status(HttpStatus.OK).body(this.replyServiceImpl.deleteReplyById(replyId));
		
	}
	
	
	
	
	
	

}
