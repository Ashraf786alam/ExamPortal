package com.exampleportal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleportal.Entity.Category;
import com.exampleportal.Entity.Quiz;

public interface QuizRepository  extends JpaRepository<Quiz,Integer>{
	
	public List<Quiz> findByCategory(Category category);
	
	public List<Quiz> findByActive(boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category category,boolean b);

}
