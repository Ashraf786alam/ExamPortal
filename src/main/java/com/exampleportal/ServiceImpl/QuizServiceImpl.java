package com.exampleportal.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleportal.Entity.Category;
import com.exampleportal.Entity.Quiz;
import com.exampleportal.Exception.ResourceNotFoundException;
import com.exampleportal.Repository.CategoryRepository;
import com.exampleportal.Repository.QuizRepository;
import com.exampleportal.Services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
    
	@Autowired
	private QuizRepository quizRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> getQuizes() {
		
		return this.quizRepo.findAll();
	}

	@Override
	public Quiz getQuiz(int quizId) {
		
		return this.quizRepo.findById(quizId).orElseThrow(()-> new ResourceNotFoundException("Quiz","Id",""+quizId));
	}
 
	@Override
	public void deleteQuiz(int quizId) {
        
		
          this.quizRepo.deleteById(quizId);
		
	}

	@Override
	public List<Quiz> findQuizByCategory(int categoryId) {
		Category category=this.categoryRepo.findById(categoryId).get();
		return this.quizRepo.findByCategory(category);
	}

	@Override
	public List<Quiz> findActiveQuiz() {
		
		List<Quiz> activequizes=this.quizRepo.findByActive(true);
		
		return activequizes;
	}

	@Override
	public List<Quiz> getActiveQuizOfCategory(Category category) {

       List<Quiz> activequizesofcategory=this.quizRepo.findByCategoryAndActive(category, true);
		return activequizesofcategory;
	}

}
