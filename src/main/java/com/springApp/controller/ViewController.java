package com.springApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springApp.entity.Employee;
import com.springApp.service.EmployeeService;


@Controller
@RequestMapping("/view")
public class ViewController {
	
	//inject service
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/pdf/{id}")
	public String generatePDF(@PathVariable("id") int theId, Model theModel) {
		
		//System.out.println("Id : "+theId);
		
		//get the employee form DB
		Employee theEmployee = employeeService.getEmployee(theId);
		List<Employee> emp = new ArrayList<>();
		emp.add(theEmployee);
		
		theModel.addAttribute("pdfinfo",emp);
		//System.out.println("ID: "+theId+"  t:   "+tw);
		return "pdf";
	}
	
	@GetMapping("/excel/{id}")
	public String generateExcel(@PathVariable("id") int theId, Model theModel) {
		
		//get the employee form DB
		Employee theEmployee = employeeService.getEmployee(theId);
		List<Employee> emp = new ArrayList<>();
		emp.add(theEmployee);
		System.out.println("Excel"+emp);
		theModel.addAttribute("excelinfo",emp);
		
		return "excel";
	}
	
	
	
	
}

