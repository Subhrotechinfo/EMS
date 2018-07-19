package com.springApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springApp.dao.EmployeeDAO;
import com.springApp.entity.Employee;

@Service
public class EmployeeServiveImpl implements EmployeeService{

	//inject the Employee DAO
	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		employeeDao.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		
		return  employeeDao.getEmployee(theId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		
		employeeDao.deleteEmployee(theId);
	}


	@Override
	@Transactional
	public String getEmployeeEmailId(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeEmailId(theId);
	}
	
	
}
