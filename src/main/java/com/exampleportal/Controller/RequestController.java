package com.exampleportal.Controller;

import java.security.Principal;
import java.util.Date;
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

import com.exampleportal.Entity.Request;
import com.exampleportal.Entity.User;
import com.exampleportal.Helper.RequestDto;
import com.exampleportal.Repository.UserRepository;
import com.exampleportal.Services.RequestService;

@RestController
@RequestMapping("/request")
@CrossOrigin("*")
public class RequestController {
	
	@Autowired
	private RequestService requestServiceImpl;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/")
	public ResponseEntity<Request> saveRequest(@RequestBody Request request,Principal principal){
		
		User user=this.userRepo.findByUsername(principal.getName());
		request.setUser(user);
		request.setDate(new Date());
		
		return ResponseEntity.status(HttpStatus.OK).body(this.requestServiceImpl.addRequest(request));
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<RequestDto>> allRequest(){
		
		return new ResponseEntity<>(this.requestServiceImpl.getAllRequest(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{requestId}")
	public ResponseEntity<List<RequestDto>> deleteSingleRequest(@PathVariable int requestId){
		return ResponseEntity.status(HttpStatus.OK).body(this.requestServiceImpl.deleteRequest(requestId));
		
	}

}
