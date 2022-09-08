package com.exampleportal.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Scores")
public class Score {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int scoreId;
	
	private int numberOfcorrectAnswer;
	
	private int numberOfattemptedQuestions;
	
	private int marksobtained;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="quiz_Id")
	private Quiz quiz;
	
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	private Date date;

	

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Score(int scoreId, int numberOfcorrectAnswer, int numberOfattemptedQuestions, int marksobtained, Quiz quiz,
			User user, Date date) {
		super();
		this.scoreId = scoreId;
		this.numberOfcorrectAnswer = numberOfcorrectAnswer;
		this.numberOfattemptedQuestions = numberOfattemptedQuestions;
		this.marksobtained = marksobtained;
		this.quiz = quiz;
		this.user = user;
		this.date = date;
	}

	public int getNumberOfcorrectAnswer() {
		return numberOfcorrectAnswer;
	}

	public void setNumberOfcorrectAnswer(int numberOfcorrectAnswer) {
		this.numberOfcorrectAnswer = numberOfcorrectAnswer;
	}

	public int getNumberOfattemptedQuestions() {
		return numberOfattemptedQuestions;
	}

	public void setNumberOfattemptedQuestions(int numberOfattemptedQuestions) {
		this.numberOfattemptedQuestions = numberOfattemptedQuestions;
	}

	public int getMarksobtained() {
		return marksobtained;
	}

	public void setMarksobtained(int marksobtained) {
		this.marksobtained = marksobtained;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
