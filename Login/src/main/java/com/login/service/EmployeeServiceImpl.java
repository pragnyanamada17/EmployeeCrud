package com.login.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.bean.Employee;
import com.login.dao.EmployeeDao;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee create(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		
			Employee EmployeeRes=dao.findOne(employee.getId());
			EmployeeRes.setId(employee.getId());
			EmployeeRes.setName(employee.getName());
			EmployeeRes.setSalary(employee.getSalary());
			 return dao.save(EmployeeRes);
			
		
				
	}

	@Override
	public List<Employee> findAllEmployees() {
	return dao.findAll();
		}

	@Override
	public void deleteEmployee(int Id) {
		 dao.delete(Id);
		
	}

	@Override
	public Employee findEmployeeById(int Id) {
		return dao.findOne(Id);
		
	}


}
