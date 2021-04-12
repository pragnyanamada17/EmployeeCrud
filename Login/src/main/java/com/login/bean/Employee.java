package com.login.bean;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Emptable")
public class Employee {
    
	@Id
	
	@Column(name = "ID")
    private  int Id;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private String salary;
	
	
	

	public int getId() {
		return Id;
	}


	public void setId(int id) {
		this.Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, String salary) {
		super();
		Id = id;
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


}
