package com.exampleportal.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exampleportal.Entity.User;
import com.exampleportal.Entity.UserRole;
import com.exampleportal.Exception.ResourceNotFoundException;
import com.exampleportal.Exception.UserAlreadyExistsException;
import com.exampleportal.Repository.RoleRepository;
import com.exampleportal.Repository.UserRepository;
import com.exampleportal.Services.UserService;

@Service
public class UserServiceImpl implements UserService{
      
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;
	
	
	//creating User
	
	@Override
	public User createUser(User user, List<UserRole> userRoles) throws Exception {
		user.setProfile("Default.png");
		
		//Encode the password and save//
	     user.setPassword(this.bcryptPasswordEncoder.encode(user.getPassword()));
	     
		User localuser=this.userRepo.findByUsername(user.getUsername());
		if(localuser!=null) {
			System.out.println("User Already Exists with username "+user.getUsername());
			throw new UserAlreadyExistsException("User",user.getUsername());
		}
		
		else {
			for(UserRole ur:userRoles) {
				this.roleRepo.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			localuser=this.userRepo.save(user);
		}
		return localuser;
	}

	@Override
	public User getUser(String username) {

        User user=this.userRepo.findByUsername(username);
        if(user==null) {
        	
        	throw new ResourceNotFoundException("User","username",username);
        }
		return user;
	}

	@Override
	public void deleteUser(int id) {

          User user=this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User"," Id",""+id));
          this.userRepo.delete(user);
		
	}

	@Override
	public User updateUser(User user,int userId) {

      User user1=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User"," Id",""+userId));
	  
	  User updatedUser=this.userRepo.save(user);
      return updatedUser;
	}

	@Override
	public boolean checkUserFromBackend(String username) {
                  
		
           User user=this.userRepo.findByUsername(username);
           if(user != null) {
        	 return true;  
           }
		return false;
	}

	@Override
	public boolean findUserByEmail(String email,String newpassword) {

         
		    User user=this.userRepo.findByEmail(email);
		    
		    System.out.println(user);
		    user.setPassword(this.bcryptPasswordEncoder.encode(newpassword));
		    
		    user.setId(user.getId());
		    System.out.println(user);
		    this.userRepo.save(user);
		    return true;
	}

}
