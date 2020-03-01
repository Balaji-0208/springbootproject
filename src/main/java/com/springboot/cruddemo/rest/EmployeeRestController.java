package com.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cruddemo.dao.EmployeeDao;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{theId}")
	public Employee getEmpById(@PathVariable int theId)
	{
		Employee theEmp=employeeService.findEmpById(theId);
		if(theEmp==null)
		{
			throw new RuntimeException("ID NOT FOUND: "+theId);
		}
		return employeeService.findEmpById(theId);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmp)
	{
		theEmp.setId(0);
		
		employeeService.save(theEmp);
		
		return theEmp;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmp)
	{
		employeeService.save(theEmp);
		
		System.out.println("anil kumar");
		
		return theEmp;
	}
	
	@DeleteMapping("/employees/{theId}")
	public String deleteEmployee(@PathVariable int theId)
	{
		Employee theEmp=employeeService.findEmpById(theId);
		if(theEmp==null)
		{
			throw new RuntimeException("Given Id not Found: "+theId);
		}
		employeeService.delete(theId);
		
		return "Deleted EmpId: "+theId;
	}
	
}
