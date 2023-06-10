package com.ust.billingservice.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/billserver")
public class BillingService {
	

	@GetMapping
	public String welcome() {
		return "bill generated" ;
	}
	
	@GetMapping("/status")
	public String status() {
		return "bill generated with gst" ;
	}

}
