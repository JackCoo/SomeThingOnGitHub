package com.one.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.one.controller.HomeController;

public class HomeControllerTest {

	@Test
	public void testHomePage(){
		
		HomeController controller = new HomeController();
		//MockMvc mockmvc = standaloneSetup(controller).build();
	}

}
