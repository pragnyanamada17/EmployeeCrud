package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.bean.Question;
import com.login.service.QuestionService;


@RestController
@RequestMapping("/click")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	@Autowired
	QuestionService service;

	@SuppressWarnings("unused")
	@PostMapping("/create")
	
	public ResponseEntity<Question> CreateQuestion(@RequestBody Question question) {
		Question questionRes=new Question();
	
			
		questionRes = service.create(question);
		return new ResponseEntity<>(questionRes, new HttpHeaders(), HttpStatus.OK);
	}
}