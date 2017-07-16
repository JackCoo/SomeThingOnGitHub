package org.fkit.controller;

import java.util.List;

import org.fkit.model.Goods;
import org.fkit.service.TestGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestGoodsController {

	@Autowired
	private TestGoodsService testGoodsService;

	/**
	 * 处理/testgoodslist请求
	 * */
	@RequestMapping(value="/testgoodslist")
	 public String main(Model model){
		// 获得所有图书集合
		List<Goods> goods_list = testGoodsService.getAll();
		System.out.println(goods_list);
		// 将图书集合添加到model当中
		model.addAttribute("goods_list", goods_list);
		// 跳转到main页面
		return "testgoods";
	}
	
}
