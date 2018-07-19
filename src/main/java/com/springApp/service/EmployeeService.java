package com.springApp.service;

import java.util.List;

import com.springApp.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public void saveEmployee(Employee theEmployee);
	
	public Employee getEmployee(int theId);
	
	public void deleteEmployee(int theId);

	public String getEmployeeEmailId(int theId);
}
