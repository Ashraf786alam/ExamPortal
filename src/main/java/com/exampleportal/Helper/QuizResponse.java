package com.exampleportal.Helper;

public class QuizResponse {
	
	private int correct_answers;
	private int question_attempted;
	
	public QuizResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuizResponse(int correct_answers, int question_attempted, int marks_obtained) {
		super();
		this.correct_answers = correct_answers;
		this.question_attempted = question_attempted;
		this.marks_obtained = marks_obtained;
	}
	public int getCorrect_answers() {
		return correct_answers;
	}
	public void setCorrect_answers(int correct_answers) {
		this.correct_answers = correct_answers;
	}
	public int getQuestion_attempted() {
		return question_attempted;
	}
	public void setQuestion_attempted(int question_attempted) {
		this.question_attempted = question_attempted;
	}
	public int getMarks_obtained() {
		return marks_obtained;
	}
	public void setMarks_obtained(int marks_obtained) {
		this.marks_obtained = marks_obtained;
	}
	private int marks_obtained;

}
