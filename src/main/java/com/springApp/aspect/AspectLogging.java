package com.springApp.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

	//setup 
	private Logger logger  = Logger.getLogger(getClass().getName());
	
	//setup pointcut expression for controller
	@Pointcut("execution(* com.springApp.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//setup pointcut expression for service
	@Pointcut("execution(* com.springApp.service.*.*(..))")
	private void forServicePackage() {}
		
	//setup pointcut expression for dao
	@Pointcut("execution(* com.springApp.dao.*.*(..))")
	private void forDAOPackage() {}	

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	//add @before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display methods we are calling 
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("@Before  --> "+theMethod);
		
		//displaying the arguments to the method
		//get the arguments 
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru and display args
		for (Object tempArg : args) {
			logger.info("Arguments Checking --> "+tempArg);
		}
	}
	
	
	
	//add @afterreturning
	@AfterReturning(pointcut="forAppFlow()"	, returning="theResult")	
	public void afterReturning(JoinPoint theJoinPoint , Object theResult) {
		
		//display the method returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("@After Returning --> "+theMethod);
		
		//display data returned
		logger.info("Result --> "+theResult);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
