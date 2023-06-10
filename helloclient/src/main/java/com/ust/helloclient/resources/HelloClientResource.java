package com.ust.helloclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client")
public class HelloClientResource {
	@Autowired
	RestTemplate template;
	
	@GetMapping
	public String testMethod() {
		
		String url = "http://localhost:8097/rest/server/status";
//		String url = "http://localhost:61708/rest/billserver/status";
		String output = template.getForObject(url, String.class);
		return output;
		
	}
	

}
