package com.exampleportal.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleportal.Entity.Score;
import com.exampleportal.Entity.User;
import com.exampleportal.Repository.UserRepository;
import com.exampleportal.ServiceImpl.UserDetailsServiceImpl;
import com.exampleportal.Services.ScoreService;

@RestController
@RequestMapping("/score")
@CrossOrigin("*")
public class ScoreController {
	
	@Autowired
	private ScoreService  scoreServiceImpl;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<Score>> getAllScoreOfAQuizByUser(@PathVariable int quizId,Principal principal){
		User user=(User) this.userDetailsService.loadUserByUsername(principal.getName());
		List<Score> scores=this.scoreServiceImpl.getAllScoresOfQuiz(user.getId(),quizId);
		return new ResponseEntity<List<Score>>(scores,HttpStatus.OK);
		
	}
	
	@GetMapping("/admin/quiz/{quizId}")
	public ResponseEntity<List<Score>> getAllScoreOfAQuiz(@PathVariable int quizId){
		
		System.out.println("request aya haii....................");
		List<Score> scores=this.scoreServiceImpl.findScoreByQuiz(quizId);
		return new ResponseEntity<List<Score>>(scores,HttpStatus.OK);
		
	}

}
