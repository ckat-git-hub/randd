package com.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.AntiqueRawFeed;
import com.data.service.AntiqueDataService;

@RestController
@RequestMapping(value = "/v1/antiquedata")
public class AntiqueDataController {
	
	@Autowired
	AntiqueDataService antiqueDataService;
	
	@RequestMapping(value = "/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@RequestMapping(value = "/all")
	public List<AntiqueRawFeed> getAllRecords() {
		List<AntiqueRawFeed> arfList = antiqueDataService.getAllRecords();
		return arfList;
	}
	
	@RequestMapping(value = "/create")
	public String createRawFeed() {
		boolean flag = false;
		flag = antiqueDataService.enterRawFeed(flag);
		if(flag) {
			return "Success";
		}
		return "Failure";
	}
	
	@RequestMapping(value = "/query/{feedId}")
	public List<AntiqueRawFeed> getRawFeedById(@PathVariable String feedId) {
		return antiqueDataService.findByFeedId(feedId);
	}

}
