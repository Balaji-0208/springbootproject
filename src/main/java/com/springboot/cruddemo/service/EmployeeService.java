package com.springboot.cruddemo.service;

import java.util.List;

import com.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	

	public List<Employee> findAll();
	
	public Employee findEmpById(int theId);
	
	public void save(Employee theEmp);
	
	public void delete(int theId);
}
