package org.fkit.service.impl;

import java.util.List;

import org.fkit.mapper.BookMapper;
import org.fkit.mapper.TestGoodsMapper;
import org.fkit.model.Goods;
import org.fkit.service.TestGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testGoodsService")
public class TestGoodsServiceImpl implements TestGoodsService {
	
	@Autowired
	private TestGoodsMapper testGoodsMapper;
	
	@Override
	public List<Goods> getAll() {
		return testGoodsMapper.findAll();
	}

}
