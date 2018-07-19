package com.springApp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springApp.dao.EmployeeDAO;
import com.springApp.entity.Employee;
import com.springApp.exception.CustomException;
import com.springApp.service.EmployeeService;
import com.springApp.utility.EmailService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	//inject Service
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeDAO dao;
	
	@Autowired
	private EmailService mail;

	
	
	@GetMapping("/list")
	//@ExceptionHandler()
	public String listEmployees(Model theModel) {
		
		//get customers from DAO
		List<Employee> theEmployees = employeeService.getEmployees();
		
		
		//add the customer to the model
		theModel.addAttribute("employees",theEmployees);
		
		return "list-employee";
	}
	
	@GetMapping("/showForm")
	public String setEmployeesForm(Model theModel) {
		
		//create a model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employeeformdata", theEmployee);
		
		return "save";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employeeformdata") Employee theEmployee) {
		 
		//save the employee
		employeeService.saveEmployee(theEmployee);
		return "redirect:/employee/confirmpage";
	}
	
	@GetMapping("/confirmpage")
	public String confirmPage() {
		return "confirmation-page";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int theId ,Model theModel) {
		
		if( theId != 0 ) {
			
			//get the employee from DB
			Employee theEmployee = employeeService.getEmployee(theId);
			
			//set the pre-populated form for the employee
			theModel.addAttribute("updatecustomer",theEmployee);
			return "update";
		}else {
			return "access-denied";
		}
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeDeleteId") int theId) {
		
		employeeService.deleteEmployee(theId);
		return "deleteConfirmed";
	}
	
	@GetMapping("/email")
	public String sendEmail(@RequestParam("employeeEmail") int theId) {
		
		String emailId = employeeService.getEmployeeEmailId(theId);
		
		
		mail.sendSimpleMessage(emailId, "Hello", "This is simple mail"); 
		//mail.sendMessageWithAttachment("subhro.teckinfo@gmail.com", "Hello", "This is simple mail", "C:\\Users\\subhr\\Desktop\\db.txt");
		return "email-confirm";
	}
	
	@GetMapping("/allEmail")
	public String sendEmailToAllEmployees() {
		System.out.println("Email : ");
		
		List<String> e = dao.getAllEmailID();
		
		//iterate over the list
		Iterator itr = e.iterator();
		System.out.println("Printing all emails");
		
		while(itr.hasNext()) {
			
			String eachEmail =(String) itr.next();
			//System.out.println(eachEmail+" ");
			
			//send email to all employees
			mail.sendSimpleMessage(eachEmail, "Over view review", "Hi All "
					+ "This is just a test mail "
					+ "Subhro Chatterjee");
		}
		
		System.out.println("Controller: "+e.toString());	
		return "email-confirm";
	}
	
	@GetMapping("/pdf")
	public String getPdf(Model theModel) {
		
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(1, "Subhro", "Chatterjee", "s@gmail.com"));
		
		theModel.addAttribute("pdfinfo", emp); 
		
		return "pdfView";
	}
	
	
	
}



