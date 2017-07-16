package com.xupt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xupt.dao.TestDao;
import com.xupt.model.Test;
import com.xupt.service.TestService;


@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDao testDao;
	@Override
	public List<Test> getAllTest() {
		System.out.println("111");
		return testDao.selectAll();
	}

}
