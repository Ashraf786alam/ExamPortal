package com.exampleportal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleportal.Entity.Quiz;
import com.exampleportal.Entity.Score;
import com.exampleportal.Entity.User;

public interface ScoreRepository extends JpaRepository<Score,Integer> {
	
	public List<Score> findByUserAndQuiz(User user,Quiz quiz);
	
	public List<Score> findByQuiz(Quiz quiz);


}
