package com.exampleportal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exampleportal.Entity.Role;
import com.exampleportal.Entity.User;
import com.exampleportal.Entity.UserRole;
import com.exampleportal.Services.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {
     
	@Autowired
	 private UserService userService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Starting code..");
//	User user=new User();
//	user.setFirstName("Md Ashraf");
//	user.setLastName("Alam");
//	user.setEmail("alamashraf356@gmail.com");
//	user.setEnabled(true);
//	user.setPassword("ashrafalam");
//	user.setPhone("9875356772");
//		user.setProfile("default.png");
//		user.setUsername("ashraf123");
//		Role role1=new Role();
//		role1.setRoleId(100);
//		role1.setRoleName("ADMIN");
//		//------------------------------------------------------------------------------
//	UserRole user_role=new UserRole();
//	user_role.setRole(role1);
//		user_role.setUser(user);
//		//-------------------------------------------------------------------------
//		List<UserRole> userrole=new ArrayList<UserRole>();
//		userrole.add(user_role);
//		User saveduser=this.userService.createUser(user, userrole);
//		System.out.println(saveduser.getUsername());
//		
//		
//		
//		
	}

}
