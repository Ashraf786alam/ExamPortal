package com.exampleportal.Services;

import java.util.List;

import com.exampleportal.Entity.Question;
import com.exampleportal.Entity.Quiz;

public interface QuestionService {
	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public List<Question> getQuestions();
	
	public Question getQuestion(int questionId);
	
	public List<Question> allQuestionOfAQuiz(Quiz quiz);
    
	public void deleteQuestion(int questionId);
}
