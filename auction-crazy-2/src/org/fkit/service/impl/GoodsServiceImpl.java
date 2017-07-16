package org.fkit.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.fkit.dto.GoodsOverview;
import org.fkit.dto.StatusMessage;
import org.fkit.mapper.GoodsMapper;
import org.fkit.model.Goods;
import org.fkit.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
//	@Autowired
//	private GoodsOverview goodOv;
//	@Autowired
//	private List<GoodsOverview> goodOvList;
	@Autowired
	private StatusMessage statMessage;
	@Override
	public Goods getGoodsByID(int Id) {
		return goodsMapper.selectGoodById(Id);
	}

	@Override
	public List<Goods> getGoodsByName(String name) {
		return goodsMapper.selectGoodsByName(name);
	}

	@Override
	public List<GoodsOverview> getLastGoods(int maxId, int num) {

		
		//获取num条，maxId偏移 的User数据
		List<Goods> goodsList =  goodsMapper.selectLastGoods(maxId, num);
		//重新封装成DTO数据形式
		List<GoodsOverview> goodOvList = new ArrayList<>();
		//GoodsOverview goodOv = new GoodsOverview();List里放置对象的应用，故应在循环里new，已产生不同的对象。
		for (int i = 0; i < goodsList.size(); i++){

			GoodsOverview goodOv = new GoodsOverview();
			goodOv.setBidStart(goodsList.get(i).getBidStart());
			goodOv.setBidStop(goodsList.get(i).getBidStop());
			goodOv.setBriefDescription(goodsList.get(i).getBriefDescription());
			goodOv.setCategoryId(goodsList.get(i).getCategoryId());
			goodOv.setFirstImgUrl(goodsList.get(i).getFirstImgUrl());
			goodOv.setId(goodsList.get(i).getId());
			goodOv.setIsAuction(goodsList.get(i).getIsAuction());
			goodOv.setName(goodsList.get(i).getName());
			goodOv.setPrice(goodsList.get(i).getPrice());
			goodOv.setStatus(goodsList.get(i).getStatus());
			goodOv.setUserId(goodsList.get(i).getUserId());
			
			System.out.println(goodOv);
			goodOvList.add(goodOv);
			
			System.out.println(goodOvList);
		}
		return goodOvList;
	}

	@Override
	public List<Goods> customGetGoods() {
		return goodsMapper.customSelectGoods();
	}

	@Override
	public StatusMessage doAuction(int goodsId, int userId, double price) {
		Goods goods = goodsMapper.selectGoodById(goodsId);
		if (goods.getIsDel() == 1){
			statMessage.setMessageId(-4);
			statMessage.setMessage("该商品已删除");
		}
		//验证是否为拍卖商品
		else if(goods.getIsAuction() == 0){
			statMessage.setMessageId(-1);
			statMessage.setMessage("该商品不是拍卖商品");
		}
		//验证商品是否处于拍卖时段
		else if(goods.getBidStart().after(new Date()) || goods.getBidStop().before(new Date())){
			statMessage.setMessageId(-2);
			statMessage.setMessage("未处于拍卖时段");
		}
		else {
			//尝试向数据库提交拍价——价格小于当前竞价将会被驳回
			Integer result = goodsMapper.updateAuctionPrice(goodsId, userId, price);
			System.out.println("GOODS表更新了："+result);
			//数据库未更新，竞拍价不符要求。
			if (result == 0){
				statMessage.setMessageId(-3);
				statMessage.setMessage("竞拍价小于当前值或者SQL执行错误");
			}
			//符合的竞拍，记录竞拍流水
			else {
				System.out.println("符合竞拍要求，记录竞拍流水。");
				goodsMapper.insertAuctionRecord(goodsId, userId, price);
				statMessage.setMessageId(1);
				statMessage.setMessage("竞拍价已提交");
			}	
		}
		return statMessage;//竞拍成功
	}

	@Override
	public StatusMessage doBuy(int goodsId, int userId) {
		
		Goods goods = goodsMapper.selectGoodById(goodsId);
		if (goods.getIsDel() == 1){
			statMessage.setMessageId(-1);
			statMessage.setMessage("该商品已删除");
		}
		//该商品不是非拍卖商品
		if (goods.getIsAuction() == 1){
			statMessage.setMessageId(-2);
			statMessage.setMessage("该商品不能直接购买");
		}
		else if (goods.getStatus() != 10){
			statMessage.setMessageId(-3);
			statMessage.setMessage("该商品此已售卖");
		}
		else {
			Integer satus = goodsMapper.updateNonAuctionForBuy(goodsId, userId);
			if (satus == 0 ){
				statMessage.setMessageId(-4);
				statMessage.setMessage("SQL执行错误");
			}
			else{
				statMessage.setMessageId(1);
				statMessage.setMessage("购买成功");
			}
			
		}
		return statMessage;
	}

	
}
