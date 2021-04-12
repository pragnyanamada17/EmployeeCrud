package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.bean.Employee;
import com.login.service.EmployeeService;

import login.com.exception.EmployeeExitsException;


@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	@Autowired
	EmployeeService service;

	@SuppressWarnings("unused")
	@PostMapping("/create")
	
	public ResponseEntity<Employee> CreateEmployee(@RequestBody Employee employee) {
		Employee employeeRes=new Employee();
		if((employeeRes!=null)) {
			throw new EmployeeExitsException("emloyee already exits");
		}
		else
			
		 employeeRes = service.create(employee);
		return new ResponseEntity<>(employeeRes, new HttpHeaders(), HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee) {
		Employee employeeRes=new Employee();
		 employeeRes = service.update(employee);
		return new ResponseEntity<>(employeeRes, new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public  ResponseEntity<List<Employee>> findAll(){
		List<Employee> list=service.findAllEmployees();
		return new ResponseEntity<List<Employee>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{Id}")
	public String deleteEmployee(@PathVariable("Id") int Id) {
		
		service.deleteEmployee(Id);
		return "Deleted";
		
}
	@GetMapping("/getdetails/{Id}")
	public ResponseEntity<Employee> findEmployeeId(@PathVariable("Id") int Id) {
		Employee emp=service.findEmployeeById(Id);
//		if(emp==null) {
//			throw new IdNotFoundException("id not found");
//		}
//		else
		
		return new ResponseEntity<Employee>(emp,new HttpHeaders(),HttpStatus.OK);
	}
	}
