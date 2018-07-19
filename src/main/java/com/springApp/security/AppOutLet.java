package com.springApp.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppOutLet {

	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/loginPage")
	public String showLoginPage() {
		return "custom-Login";
	}
	
	
	
}
