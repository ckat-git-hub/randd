package com.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.Message;
import com.data.service.AntiqueDataExportService;

@RestController
@RequestMapping(value = "/v1/exportdata")
public class AntiqueDataController {
	
	@Autowired
	private AntiqueDataExportService antiqueDataExportService;
	
	@RequestMapping(value = "/to/msaccess")
	public String getAllRecords() {
		antiqueDataExportService.exportFormDataAsMSAccessForm();
		return "Successfully Exported to Form";
	}
	
	@RequestMapping(value = "/msg")
	public Message getMessage() {
		Message msg = new Message();
		msg.setId("msg100");
		msg.setMessage("Hello Man How Are You ?");
		return msg;
	}

}
