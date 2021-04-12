package com.login.service;

import java.util.List;

import com.login.bean.Employee;

public interface EmployeeService {

	Employee create(Employee employee);

	Employee update(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployee(int Id);

	Employee findEmployeeById(int empId);

}
