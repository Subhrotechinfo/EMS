package com.springApp.dao;

import java.util.List;


import com.springApp.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	
	public void saveEmployee(Employee theEmployee);
	
	public Employee getEmployee(int theId);
	
	public void deleteEmployee(int theId);

	public List getAllEmailID();

	public String getEmployeeEmailId(int theId);
	
}
