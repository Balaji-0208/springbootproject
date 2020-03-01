package com.springboot.cruddemo.dao;

import java.util.List;

import com.springboot.cruddemo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findEmpById(int theId);
	
	public void save(Employee theEmp);
	
	public void delete(int theId);
}
