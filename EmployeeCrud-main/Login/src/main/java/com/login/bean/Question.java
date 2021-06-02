package com.login.bean;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Qtable")
public class Question {
    
	@Id
	
	@Column(name = "ID")
    private  String Id;
	@Column(name = "question")
	private String question;
	@Column(name = "answer")
	private String answer;
	public String getId() {
		return Id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setId(String id) {
		Id = id;
	}
	public Question(String id, String question, String answer) {
		super();
		Id = id;
		this.question = question;
		this.answer = answer;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	


}
