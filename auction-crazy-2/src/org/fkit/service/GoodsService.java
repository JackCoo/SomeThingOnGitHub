package org.fkit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.fkit.dto.GoodsOverview;
import org.fkit.dto.StatusMessage;
import org.fkit.model.Goods;

import com.sun.org.apache.xerces.internal.util.Status;

public interface GoodsService {

	//按ID查找商品
	Goods getGoodsByID(int Id);
	//按商品名查找商品
	List<Goods> getGoodsByName(String name);
	//获取自maxID开始的最新num条数据
	List<GoodsOverview> getLastGoods(int maxId , int num);
	//商品高级搜索
	List<Goods> customGetGoods();
	//竞拍商品
	StatusMessage doAuction(int goodsId, int userId, double price);
	//购买非竞拍商品
	StatusMessage doBuy(int goodsId, int userId);
}
