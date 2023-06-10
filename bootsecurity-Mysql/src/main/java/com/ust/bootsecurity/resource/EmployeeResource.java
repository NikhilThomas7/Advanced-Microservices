package com.ust.bootsecurity.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResource {
	
	@GetMapping("/")
	public String greet() {
		return "working";
	}
	
	@GetMapping("/admin")
	public String greetAdmin() {
		return "admin@work";
	}
	
	@GetMapping("/user")
	public String greetUser() {
		return "user working";
	}

}
