package com.exampleportal.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampleportal.Entity.Role;
import com.exampleportal.Entity.User;
import com.exampleportal.Entity.UserRole;
import com.exampleportal.Helper.Password;
import com.exampleportal.Helper.UserResponse;
import com.exampleportal.Services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/test")
	public String test() {
		return "Welcome to backend api of Examportal";
	}
	
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws Exception {
		
		List<UserRole> roles=new ArrayList<>();
		Role role=new Role();
	     role.setRoleId(200);
	     role.setRoleName("NORMAL");
	    
	     UserRole userrole=new UserRole();
	     userrole.setRole(role);
	     userrole.setUser(user);
	     roles.add(userrole);
	     
	     
	     User createdUser=this.userService.createUser(user, roles);
	     return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		
		User user=this.userService.getUser(username);
		return user;
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<UserResponse> DeleteUser(@PathVariable int userId ){
		
		this.userService.deleteUser(userId);
		UserResponse userResponse=new UserResponse();
		userResponse.setMessage("User Deleted with Id: "+userId);
		userResponse.setStatus(true);
		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> UpdateUser(@RequestBody User user,@PathVariable int userId){
		user.setId(userId);
		User updatedUser=this.userService.updateUser(user,userId);
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		
	}
	
	@PostMapping("/check/")
	public ResponseEntity<UserResponse> checkUserFrombackend(@RequestBody String username){
            
		
		System.out.println("Request aya haii");
		
          boolean b=this.userService.checkUserFromBackend(username);
          UserResponse response=new UserResponse();
         if(b) {
        	 response.setMessage("Username Already Exist");
        	 response.setStatus(true);
       	  return new ResponseEntity<>(response,HttpStatus.OK);
         }
         response.setMessage("Username is unique");
         response.setStatus(false);
          return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@PostMapping("/mail/")
	public ResponseEntity<Boolean> getUserByEmail(@RequestBody Password password){
		
		boolean b=this.userService.findUserByEmail(password.getEmail(), password.getNewpassword());
		return ResponseEntity.ok(b);
	}

}
