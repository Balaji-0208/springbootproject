package com.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.EmployeeDao;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDao employeeDao;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findEmpById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findEmpById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmp) {
		// TODO Auto-generated method stub
		employeeDao.save(theEmp);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		// TODO Auto-generated method stub
		employeeDao.delete(theId);
	}

}
