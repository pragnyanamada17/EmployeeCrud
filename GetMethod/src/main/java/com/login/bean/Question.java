package com.login.bean;


public class Question {
    
	
    private  int Id;
	
	private String Question;
	
	private String Answer;
	
	
	

	
	public Question(int id, String question, String answer) {
		super();
		Id = id;
		Question = question;
		Answer = answer;
	}





	public int getId() {
		return Id;
	}





	public void setId(int id) {
		Id = id;
	}





	public String getQuestion() {
		return Question;
	}





	public void setQuestion(String question) {
		Question = question;
	}





	public String getAnswer() {
		return Answer;
	}





	public void setAnswer(String answer) {
		Answer = answer;
	}





	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

}
