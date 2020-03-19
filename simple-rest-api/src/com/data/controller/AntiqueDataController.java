package com.data.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.Message;

@RestController
@RequestMapping(value = "/v1/antiquedata")
public class AntiqueDataController {
	
	@RequestMapping(value = "/hello")
	public String getAllRecords() {
		return "Hello";
	}
	
	@RequestMapping(value = "/msg")
	public Message getMessage() {
		Message msg = new Message();
		msg.setId("msg100");
		msg.setMessage("Hello Man How Are You ?");
		return msg;
	}

}
