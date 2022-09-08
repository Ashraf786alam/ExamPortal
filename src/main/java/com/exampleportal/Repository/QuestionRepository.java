package com.exampleportal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleportal.Entity.Question;
import com.exampleportal.Entity.Quiz;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
	
	public List<Question> findByQuiz(Quiz quiz);

}
