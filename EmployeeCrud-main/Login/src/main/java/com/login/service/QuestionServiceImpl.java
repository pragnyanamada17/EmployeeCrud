package com.login.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.bean.Question;
import com.login.dao.QuestionDao;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionDao dao;

	@Override
	public Question create(Question question) {
		return dao.save(question);
	}

	


}
