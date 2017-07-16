package com.one.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.one.model.User;

public class userDaoTest {

	//@Test
	public void addUsertest() throws Exception {
		
		User user = new User();
		user.setPassWord("86585861");
		user.setUserName("junit");
		
		userDao u = new userDao();
		u.addUser(user);
	}
	
	
	@Test
	public void findUsertest() throws Exception {
		
		User user = new User();
		//user.setPassWord("86585861");
		user.setUserName("junit5");
		
		userDao u = new userDao();
		u.findUser(user);
	}
	

	
}
