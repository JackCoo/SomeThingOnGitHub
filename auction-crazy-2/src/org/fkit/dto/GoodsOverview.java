package org.fkit.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.stereotype.Component;

/**
 * 
 * 商品信息概述
 * 用于首页商品信息的简略显示
 * @XmlElement(nillable = true)
 * 		解决null值标签不显示
 * @author C4y
 *
 */
@Component
@XmlRootElement
public class GoodsOverview {

	private Integer id;//商品ID
	
	private String name;//商品名
	
	private String firstImgUrl;//商品简介图片（首页图片）
	private String briefDescription;//商品简介
	
	private Integer categoryId;//所属类别ID
	
	private Integer userId;//发布者ID
	
	private Double price;//价格（竞拍起价/贩卖价格）
	private Integer isAuction;//是否为竞拍商品（0：竞拍商品，1：直接卖）
	
	private Integer status;//商品状态（10：）
	private Date bidStart;
	private Date bidStop;
	
	@XmlElement(nillable = true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@XmlElement(nillable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(nillable = true)
	public String getFirstImgUrl() {
		return firstImgUrl;
	}
	public void setFirstImgUrl(String firstImgUrl) {
		this.firstImgUrl = firstImgUrl;
	}
	@XmlElement(nillable = true)
	public String getBriefDescription() {
		return briefDescription;
	}
	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}
	@XmlElement(nillable = true)
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@XmlElement(nillable = true)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@XmlElement(nillable = true)
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@XmlElement(nillable = true)
	public Integer getIsAuction() {
		return isAuction;
	}
	public void setIsAuction(Integer isAuction) {
		this.isAuction = isAuction;
	}
	@XmlElement(nillable = true)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@XmlElement(nillable = true)
	public Date getBidStart() {
		return bidStart;
	}
	public void setBidStart(Date bidStart) {
		this.bidStart = bidStart;
	}
	@XmlElement(nillable = true)
	public Date getBidStop() {
		return bidStop;
	}
	public void setBidStop(Date bidStop) {
		this.bidStop = bidStop;
	}
	@Override
	public String toString() {
		return "GoodsOverview [id=" + id + ", name=" + name + ", firstImgUrl=" + firstImgUrl + ", briefDescription="
				+ briefDescription + ", categoryId=" + categoryId + ", userId=" + userId + ", price=" + price
				+ ", isAuction=" + isAuction + ", status=" + status + ", bidStart=" + bidStart + ", bidStop=" + bidStop
				+ "]";
	}
 
	
}
