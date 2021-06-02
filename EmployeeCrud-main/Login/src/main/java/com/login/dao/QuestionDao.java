package com.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.bean.Question;
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {


	
}