package com.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.bean.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {


	
}