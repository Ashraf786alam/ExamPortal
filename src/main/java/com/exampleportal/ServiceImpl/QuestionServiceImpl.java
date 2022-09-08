package com.exampleportal.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleportal.Entity.Question;
import com.exampleportal.Entity.Quiz;
import com.exampleportal.Repository.QuestionRepository;
import com.exampleportal.Services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
    
	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public List<Question> getQuestions() {
		
		return this.questionRepo.findAll();
	}

	@Override
	public Question getQuestion(int questionId) {
		
		return this.questionRepo.findById(questionId).get();
	}

	@Override
	public List<Question> allQuestionOfAQuiz(Quiz quiz) {
		
		return this.questionRepo.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(int questionId) {
       
		Question question= new Question();
		question.setQuestionId(questionId);
       this.questionRepo.delete(question);
		
	}

}
