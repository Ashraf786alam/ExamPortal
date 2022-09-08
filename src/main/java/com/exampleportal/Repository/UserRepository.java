package com.exampleportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleportal.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);

}
