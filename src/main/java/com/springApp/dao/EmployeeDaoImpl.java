package com.springApp.dao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springApp.entity.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("Error checking 1");
		// create a query 
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		System.out.println("Error checking 2");
		// execute query and get result list
		List<Employee> employees = theQuery.list();
		//System.out.println("Result Fetch : "+employees.toString());
		System.out.println("Fetch");
		// return the results
		return employees;

	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the employees
		currentSession.saveOrUpdate(theEmployee);
		System.out.println("Object saved");
	}

	@Override
	public Employee getEmployee(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from database using the primary key username
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//Test theEmployee = currentSession.get(Test.class, theUsername);
		System.out.println("Fetching DAO  : "+theEmployee.toString());
		
		//return the result
		return theEmployee;
	
	}

	@Override
	public void deleteEmployee(int theId) {
		// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
			@SuppressWarnings("rawtypes")
			Query theQuery = 
					currentSession.createQuery("delete from Employee where id=:userName");
			
		//set the value for the user name
			theQuery.setParameter("userName", theId);
			
		//execute the query
			theQuery.executeUpdate();
	}

	@Override
	public String getEmployeeEmailId(int theId) {
		
		//get current session in hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		//query to get the email id 
		Query theQuery = currentSession.createQuery("Select email from Employee where id=:theID");
		
		//set the parameter value
		theQuery.setParameter("theID", theId);
		
		String email = (String)theQuery.uniqueResult();
		System.out.println("the email id : "+ email);
		
		return email;
	}

	@Override @Transactional
	public List getAllEmailID() {
		
		//get the current hibernate session
		Session currentSession  = sessionFactory.getCurrentSession();
		
		//get all the email in the array
		Query theQuery = currentSession.createQuery("SELECT distinct(email) FROM Employee");
		 
		List<String> email =theQuery.getResultList();
			
		Iterator itr =  email.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}
		//return the array
		return email;
	}

	
	
}

