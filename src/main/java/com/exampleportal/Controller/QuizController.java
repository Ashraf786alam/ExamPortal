package com.exampleportal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleportal.Entity.Category;
import com.exampleportal.Entity.Quiz;
import com.exampleportal.Helper.ApiResponse;
import com.exampleportal.Services.CategoryService;
import com.exampleportal.Services.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
   
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private CategoryService categoryService;
	   
	@PostMapping("/")
	   public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
		   
	   }
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable int quizId){
		return ResponseEntity.ok(this.quizService.getQuiz(quizId));
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Quiz>> getAllQuiz(){
		return ResponseEntity.ok(this.quizService.getQuizes());
		
	}
	
	@DeleteMapping("/{quizId}")
	public ResponseEntity<ApiResponse> deleteQuiz(@PathVariable int quizId){
		this.quizService.deleteQuiz(quizId);
		ApiResponse response=new ApiResponse();
		response.setMessage("Quiz deleted successfully with id :"+quizId);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<Quiz>> findQuizByCategory(@PathVariable int categoryId){
		return ResponseEntity.ok(this.quizService.findQuizByCategory(categoryId));
		
	}
	
	@GetMapping("/active")
	public ResponseEntity<List<Quiz>> findActiveQuiz(){
		return ResponseEntity.ok(this.quizService.findActiveQuiz());

		
	}
	
	@GetMapping("/active/category/{categoryId}")
	public ResponseEntity<List<Quiz>> findActiveQuizOfCategory(@PathVariable int categoryId){
		Category category=this.categoryService.getCategory(categoryId);
		return ResponseEntity.ok(this.quizService.getActiveQuizOfCategory(category));
		
	}
}
