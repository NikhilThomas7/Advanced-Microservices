package com.ust.sluethclient.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class sleuthclient {
	
	@Autowired
	RestTemplate template;
	
	private static final Logger logger = LoggerFactory.getLogger(sleuthclient.class);
	
	@GetMapping("/data")
	public String callService() {
		logger.info("in client resource");
		
		String result = template.getForObject("http://localhost:9092/service/data", String.class);
		return result;
	}
	

}
