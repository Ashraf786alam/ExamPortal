package com.exampleportal.ServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleportal.Entity.Quiz;
import com.exampleportal.Entity.Score;
import com.exampleportal.Entity.User;
import com.exampleportal.Repository.QuizRepository;
import com.exampleportal.Repository.ScoreRepository;
import com.exampleportal.Repository.UserRepository;
import com.exampleportal.Services.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	private ScoreRepository scoreRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private QuizRepository quizRepo;

	@Override
	public Score saveScore(Score score) {

		Score savedScore=this.scoreRepo.save(score);
   
		return savedScore;
	}

	@Override
	public List<Score> getAllScoresOfQuiz(int userId,int quizId) {
		
		User user=(User) this.userRepo.findById(userId).get();
		
		Quiz quiz= this.quizRepo.findById(quizId).get();

         List<Score> scores=this.scoreRepo.findByUserAndQuiz((com.exampleportal.Entity.User) user,quiz);
		return scores;
	}

	@Override
	public List<Score> findScoreByQuiz(int quizId) {
		
		Quiz quiz=this.quizRepo.findById(quizId).get();
		List<Score> scores=this.scoreRepo.findByQuiz(quiz);
		return scores;
	}

}
