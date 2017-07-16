package com.xupt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xupt.model.Test;
import com.xupt.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	@RequestMapping(value = "/test")
	public String testMethod(){
		System.out.println("testcontroller");
		List<Test> testList = testService.getAllTest();
		System.out.println(testList);
		return "login";
	}
}
