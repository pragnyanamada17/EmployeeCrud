package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.bean.Question;
import com.login.service.QuestionServiceImpl;

@RestController
@RequestMapping("/click")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

	@Autowired
	QuestionServiceImpl questionServiceImpl;

	@GetMapping("/link/{Id}")
	public ResponseEntity<Question> findQuestionId(@PathVariable("Id") int Id) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).body(questionServiceImpl.excel(Id));
	}
	
@PostMapping("/create")
	
	public ResponseEntity<Question> CreateEmployee(@RequestBody Question q) throws Exception {
	Question Ques=new Question();

	Ques = QuestionServiceImpl.create(q);
	return new ResponseEntity<>(Ques, new HttpHeaders(), HttpStatus.OK);
}
}
