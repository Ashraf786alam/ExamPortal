package com.exampleportal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleportal.Entity.Reply;
import com.exampleportal.Entity.User;

public interface ReplyRepository extends JpaRepository<Reply,Integer> {
	
	public List<Reply> findByUserid(int userid);

}
