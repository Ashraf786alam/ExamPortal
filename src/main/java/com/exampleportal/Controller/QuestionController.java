package com.exampleportal.Controller;

import java.security.Principal;
import java.util.Collections;
import java.util.Date;
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

import com.exampleportal.Entity.Question;
import com.exampleportal.Entity.Quiz;
import com.exampleportal.Entity.Score;
import com.exampleportal.Entity.User;
import com.exampleportal.Helper.QuizResponse;
import com.exampleportal.Repository.ScoreRepository;
import com.exampleportal.ServiceImpl.UserDetailsServiceImpl;
import com.exampleportal.Services.QuestionService;
import com.exampleportal.Services.QuizService;
import com.exampleportal.Services.ScoreService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	int correct_answers=0;
	int attempted_questions=0;
	int marks_obtained=0;
	int quizId=0;
	

	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizServic;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private ScoreService scoreServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		
		return ResponseEntity.ok(this.questionService.addQuestion(question));
		
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
		
	}
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<Question>> getQuestionOfQuiz(@PathVariable int quizId){
		
		Quiz quiz=this.quizServic.getQuiz(quizId);
		List<Question> questions=quiz.getQuestions();
		if(questions.size()<quiz.getNumberOfQuestions()) {
			Collections.shuffle(questions);
			return ResponseEntity.ok(questions);
		}
		else {
			questions=questions.subList(0, quiz.getNumberOfQuestions()+1);
			questions.forEach((question)->{
				question.setAnswer("");
			});
			Collections.shuffle(questions);
			return ResponseEntity.ok(questions);
		}
		
	}
	
	@GetMapping("/{questionId}")
	public ResponseEntity<Question> getSingleQuestion(@PathVariable int questionId){
		return ResponseEntity.ok(this.questionService.getQuestion(questionId));
		
	}
	
	@DeleteMapping("/{questionId}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int questionId){
		
		this.questionService.deleteQuestion(questionId);
		return ResponseEntity.ok().body("Question deleted successfully with id: "+questionId);
	}
	
	
	@PostMapping("/eval-quiz")
	public ResponseEntity<QuizResponse> EvaluateQuiz(Principal principal,@RequestBody List<Question> questions){
		
		this.attempted_questions=0;
		this.correct_answers=0;
		this.marks_obtained=0;
		this.quizId=0;
		
		User user=(User) this.userDetailsService.loadUserByUsername(principal.getName());
		
               System.out.println(questions);
               questions.stream().forEach((question)->{
            	   
            	   Question q=this.questionService.getQuestion(question.getQuestionId());
            	   
            	   if(q.getAnswer().equals(question.getGivenAnswer())) {
            		   
            		   this.correct_answers++;
            		   
            	   }
            	   
            	   if(question.getGivenAnswer()!=null) {
            		   this.attempted_questions++;
            	   }
            	   
            	   quizId=question.getQuiz().getQuizId();
            	   
            	   this.marks_obtained=question.getQuiz().getMaxMarks()/questions.size()*this.correct_answers;
            	   
               });
              
               Score score=new Score();
               score.setDate(new Date());
               score.setMarksobtained(marks_obtained);
               score.setNumberOfattemptedQuestions(attempted_questions);
               score.setNumberOfcorrectAnswer(correct_answers);
               score.setQuiz(this.quizServic.getQuiz(quizId));
               score.setUser(user);
               
               this.scoreServiceImpl.saveScore(score);
               
               QuizResponse quizresponse=new QuizResponse();
               quizresponse.setCorrect_answers(correct_answers);
               quizresponse.setQuestion_attempted(attempted_questions);
               quizresponse.setMarks_obtained(marks_obtained);
		return ResponseEntity.ok(quizresponse);
		
	}
}
