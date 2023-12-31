package com.ust.bootsecurity.resource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ust.bootsecurity.service.MyUserDetailsService;

@EnableWebSecurity

public class EmpSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	UserDetailsService  userdetailsservice;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		

		auth.userDetailsService(userdetailsservice);		
	}
	
	
	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder getPasswordEncoder(){
		
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	@Override
	protected  void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/admin")
		.hasRole("ADMIN")//only admin can access admin endpoints
		.antMatchers("/user")
		.hasAnyRole("USER","ADMIN")//can be accessed by both admin and user
		.antMatchers("/")
		.permitAll()
		.and()
		.formLogin();
		
		
	}
	
//	 @Override
//	    public void configure(WebSecurity web) throws Exception {
//	        web
//	            .ignoring()
//	            .antMatchers("/h2-console/**");
//	    }
//	

}
