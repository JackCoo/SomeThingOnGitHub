package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.fkit.model.Goods;

/**
 * 
 * Goods DAO接口
 * 
 * @Param("xxx")
 * 		mybatis注解，用以识别形参。
 * @author ASUS
 *
 */
public interface GoodsMapper {

	//按ID查找商品
	Goods selectGoodById(int Id );
	//按商品名查找商品
	List<Goods> selectGoodsByName(String name);
	//获取自maxID开始的最新num条数据
	List<Goods> selectLastGoods(@Param("maxId") int maxId , @Param("num") int num);
	//商品高级搜索
	List<Goods> customSelectGoods();
	//提交竞拍价格
	Integer  updateAuctionPrice(@Param("goodsId") int goodsId , @Param("userId") int userId ,@Param("price") double price);
	//插入竞拍记录
	Integer  insertAuctionRecord(@Param("goodsId") int goodsId , @Param("userId") int userId ,@Param("price") double price);
	//购买非拍卖商品
	Integer updateNonAuctionForBuy(@Param("goodsId") int goodsId , @Param("userId") int userId );
}
