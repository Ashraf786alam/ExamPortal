package com.exampleportal.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exampleportal.Entity.User;
import com.exampleportal.Exception.ResourceNotFoundException;
import com.exampleportal.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
 
	
	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                
		User user=this.userRepo.findByUsername(username);
		if(user==null) {
			System.out.println("User not found");
			throw new ResourceNotFoundException("User","username",username);
		}
		else {
			
			return user;
		}

		
	}

}
