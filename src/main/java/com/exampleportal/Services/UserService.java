package com.exampleportal.Services;

import java.util.List;

import com.exampleportal.Entity.User;
import com.exampleportal.Entity.UserRole;

public interface UserService {
	
	public User createUser(User user,List<UserRole> userRoles) throws Exception;

	public User getUser(String username);
	
	public boolean checkUserFromBackend(String username);

	public void deleteUser(int id);

	public User updateUser(User user,int userId);
	
	public boolean findUserByEmail(String email,String newpassword);

}
