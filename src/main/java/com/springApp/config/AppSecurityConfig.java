package com.springApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	//inject the datasource
	@Autowired
	private DataSource securityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		//testing for in memory authentication
		/*UserBuilder users  = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
				.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("mary").password("test123").roles("MANAGER"))
				.withUser(users.username("jason").password("test123").roles("ADMIN"));
		*/
		
		//provide JDBC Authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}
	
	//configure security of web paths in application
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
				.anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/loginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				.and()
					.logout().permitAll();
	
	
	
	}
	
	
	
	
	
	
	
}
