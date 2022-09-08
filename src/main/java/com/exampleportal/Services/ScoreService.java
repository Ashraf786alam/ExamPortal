package com.exampleportal.Services;

import java.util.List;

import com.exampleportal.Entity.Quiz;
import com.exampleportal.Entity.Score;

public interface ScoreService {
	
	public Score saveScore(Score score);
	
	public List<Score> getAllScoresOfQuiz(int userId,int quizId);
	
	public List<Score> findScoreByQuiz(int quizId);

}
