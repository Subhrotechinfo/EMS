package com.springApp.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;



public class EmployeeList {
	
	private List<Employee> empList;
	public EmployeeList() {
	}

	public EmployeeList(List<Employee> empList) {
		this.empList = empList;
	}
	@XmlElement(name="employee")
	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

}

