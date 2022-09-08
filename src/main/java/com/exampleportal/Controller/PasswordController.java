package com.exampleportal.Controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleportal.Entity.User;
import com.exampleportal.Repository.UserRepository;

@RestController
@RequestMapping("/password")
@CrossOrigin("*")
public class PasswordController {
	
	
	@Autowired
	private BCryptPasswordEncoder bcryptpasswordencoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/password-check")
	public ResponseEntity<?> PasswordCheck(@RequestBody String password,Principal principal){
		//System.out.println(data);
		User user=this.userRepo.findByUsername(principal.getName());
		if(this.bcryptpasswordencoder.matches(password,user.getPassword())) {
			
			return ResponseEntity.ok(Map.of("Message","Password matched"));
		}
		return ResponseEntity.ok(Map.of("Message","Password not matched"));
		
	}
	
	@PostMapping("/change-password")
	public ResponseEntity<Map> PasswordChange(@RequestBody String newpassword,Principal principal){
		
		
		User user=this.userRepo.findByUsername(principal.getName());
		user.setPassword(this.bcryptpasswordencoder.encode(newpassword));
		this.userRepo.save(user);
		return ResponseEntity.ok(Map.of("message","Password changed successfully"));

           
		
	}

}
