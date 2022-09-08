package com.exampleportal.Services;

import java.util.List;

import com.exampleportal.Entity.Category;
import com.exampleportal.Entity.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public List<Quiz> getQuizes();
	
	public Quiz getQuiz(int quizId);
	
	public void deleteQuiz(int quizId);
	
	public List<Quiz> findQuizByCategory(int categoryId);
	
	public List<Quiz> findActiveQuiz();
	
	public List<Quiz> getActiveQuizOfCategory(Category category);

}
