package org.fkit.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.fkit.dto.GoodsOverview;
import org.fkit.dto.ListGoodsOverview;
import org.fkit.dto.StatusMessage;
import org.fkit.mapper.GoodsMapper;
import org.fkit.model.Goods;
import org.fkit.model.User;
import org.fkit.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private Goods goods;
	
	
	//获取指定ID的商品详情
	@RequestMapping(value="/goods/detail")
    @ResponseBody
	public Goods getGoodsByID(String id){
		
		goods = goodsService.getGoodsByID(Integer.parseUnsignedInt(id));
		
		return goods;
	}
	
	
	//上传文件测试页面
	@RequestMapping(value="/upload")
	public String showUploadPage(){
		return "upload";
	}
	
	
	//上传文件接口
	@RequestMapping(value="/doupload",method=RequestMethod.POST)
	public String uploadGoods(@RequestParam("file") MultipartFile[] files, Model model){
		System.out.println("文件处理中");
		if(files!=null && files.length>0){
			//循环获取files中的文件
			for(int i = 0;i <files.length; i++){
				MultipartFile file = files[i];
				try {
					FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:\\java\\auction-crazy-2\\WebContent\\views",System.currentTimeMillis()+file.getOriginalFilename()));
					model.addAttribute("message", "Success!");
				} catch (IOException e) {
					model.addAttribute("message", "Failed");
				}
			}
				
			}

		return "uploadResult";
	
	}
	
	//获取最新的N条商品信息
	@RequestMapping(value="/goods/newest",method=RequestMethod.POST)
	@ResponseBody
	public ListGoodsOverview getNewestGoods(
			@RequestParam(value = "num", defaultValue = "60000" ) int num, 
			@RequestParam(value = "start", defaultValue = "20" ) int maxId ){

		List<GoodsOverview> goodsOvList = goodsService.getLastGoods(maxId, num);
		
		ListGoodsOverview gol = new ListGoodsOverview();
		gol.setGoodOvList(goodsOvList);
		//System.out.println(goodsOvList);
		
		return gol;
		
	}

	//竞拍
	@RequestMapping(value = "/goods/auction", method = RequestMethod.POST)
	@ResponseBody
	public StatusMessage doAuction(
			@RequestParam("goodsId") int goodsId,
			@RequestParam("price") int price,
			HttpServletRequest httpsp
			){
		
		StatusMessage statusMessage = goodsService.doAuction(goodsId, ((User) httpsp.getAttribute("user")).getId(), price);
		System.out.println(statusMessage);
		return statusMessage;
		
		
	}
	
	//购买非拍卖商品
	@RequestMapping(value = "/goods/buy", method = RequestMethod.POST)
	@ResponseBody
	public StatusMessage doBuy(
			@RequestParam("goodsId") int goodsId,
			HttpServletRequest httpsp
			){
		
		StatusMessage statusMessage = goodsService.doBuy(goodsId, ((User) httpsp.getAttribute("user")).getId());
		System.out.println(statusMessage);
		return statusMessage;
	}
	
	
}
