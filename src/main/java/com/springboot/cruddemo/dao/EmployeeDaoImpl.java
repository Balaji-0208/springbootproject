package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		Session theSessiion=entityManager.unwrap(Session.class);
		
		List<Employee> theList=entityManager.createQuery("from Employee",Employee.class).getResultList();
		
		return theList;
	}


	@Override
	@Transactional
	public Employee findEmpById(int theId) {
		// TODO Auto-generated method stub
		
		Session theSessiion=entityManager.unwrap(Session.class);
		
		Employee theEmp=theSessiion.get(Employee.class, theId);
		
		return theEmp;
	}


	@Override
	@Transactional
	public void save(Employee theEmp) {
		// TODO Auto-generated method stub
		
		Session theSessiion=entityManager.unwrap(Session.class);
		
		theSessiion.saveOrUpdate(theEmp);
		
	}


	@Override
	@Transactional
	public void delete(int theId) {
		// TODO Auto-generated method stub
		Session theSessiion=entityManager.unwrap(Session.class);
		
		Employee theEmp=theSessiion.get(Employee.class, theId);
		
		
		theSessiion.delete(theEmp);
	}

}
