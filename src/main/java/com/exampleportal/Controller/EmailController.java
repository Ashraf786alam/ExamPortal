package com.exampleportal.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleportal.Entity.User;
import com.exampleportal.Helper.EmailResponse;
import com.exampleportal.Repository.UserRepository;
import com.exampleportal.Services.EmailService;
import com.sun.mail.iap.Response;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/email")
	public ResponseEntity<?> sendEmail(@RequestBody String email){
		
		User user=this.userRepo.findByEmail(email);
		if(user!=null) {
			
		

        int min=1000;
        int max=10000;
		int otp = (int)(Math.random()*(max-min+1)+min);  
		System.out.println("OTP="+otp);
		
		//send email 
		
		String subject="OTP From Quiz Portal";
		String message=""+
		                "<div style='border:1px solid green; padding:20px'>"
				        +"<h4>"
		                +"<h5> OTP is from Quiz Portal Application</h5>"
		                +"<n>"
		                +"OTP :"
				        +"<b>"+otp
				        +"<n>"
				        +"</h4>"
				        +"</div>";
		                		
		String to=email;
		boolean flag=emailService.sendEmail(subject, message, to);
		EmailResponse emailResponse=new EmailResponse();
		if(flag) {
			
			emailResponse.setOtp(otp);
			emailResponse.setStatus(flag);
			return new ResponseEntity<>(emailResponse,HttpStatus.OK);
		}
		else {
			emailResponse.setStatus(false);
			return new ResponseEntity<>(emailResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		else {
			EmailResponse emailResponse=new EmailResponse();
			emailResponse.setMessage("Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(emailResponse);
		}
	}

}
