package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootDemoController {
	
	@Autowired
	private SpringBootDemoService springBootDemoService;
	
	@RequestMapping(path = "/hello")
	public String helloSpringBoot() {
		return "Hello Spring Boot";
	}
	
	@RequestMapping(path = "/welcome")
	public String welcomeSpringBoot() {
		return springBootDemoService.getHelloSpringBootMsg();
	}
}
