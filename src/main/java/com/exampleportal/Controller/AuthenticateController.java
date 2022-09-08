package com.exampleportal.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exampleportal.Config.JwtUtil;
import com.exampleportal.Entity.JwtRequest;
import com.exampleportal.Entity.JwtResponse;
import com.exampleportal.Entity.User;
import com.exampleportal.Exception.BadCredentials;
import com.exampleportal.Repository.UserRepository;
import com.exampleportal.ServiceImpl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtutils;
	
	private void authenticate(String username,String password) throws Exception {
		
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		}
		catch(DisabledException e) {
			throw new Exception("User DISABLED: "+e.getMessage());
		}
		catch(BadCredentialsException e) {
			throw new BadCredentials("Username or Password Incorrect");
		}
	}
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> GenerateToken(@RequestBody JwtRequest jwtRequest) throws Exception{

            try {
            	
            	authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
            	
            }
            catch(UsernameNotFoundException e) {
            	
            	throw new UsernameNotFoundException("User Not found with username: "+jwtRequest.getUsername());
            }
            
             UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
             String token=this.jwtutils.generateToken(userDetails);
             System.out.println("Token="+token);
             return ResponseEntity.ok(new JwtResponse(token));
             
		
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		
	   return (User) this.userDetailsService.loadUserByUsername(principal.getName());
	}

}
