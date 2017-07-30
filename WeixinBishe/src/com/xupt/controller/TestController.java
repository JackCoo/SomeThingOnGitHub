package com.xupt.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//@ResponseBody
	@RequestMapping(value = "/getGroup")
	public String getGroup(){
		InputStream is;
		String initResult = null;
		try {
			is = new FileInputStream("F:/java/WeixinBishe/WebContent/WEB-INF/jsp/groupJson.jsp");
			BufferedReader initBr = new BufferedReader(new InputStreamReader(is ));
		    StringBuffer initSb = new StringBuffer();
		    String initLine = null;
		    while((initLine = initBr.readLine()) != null)
		    	initSb.append(initLine);
		    initResult = initSb.toString();
		    System.out.println(initResult);
		    
		}catch (Exception e) {
			
		}
		//return initResult;
		return "groupJson";
	}
	
	@RequestMapping(value = "/index")
	public String index(){

		return "index";
	}
	
}
