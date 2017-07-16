package org.fkit.model;

import java.util.Date;

public class AuctionRecord {

	private Integer id;
	private Integer goodsId;//商品ID
	private Integer userId;//出价者ID
	private double bidPrice;//出价
	private Date createTime;//创建时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "AuctionRecord [id=" + id + ", goodsId=" + goodsId + ", userId=" + userId + ", bidPrice=" + bidPrice
				+ ", createTime=" + createTime + "]";
	}

	
}
