package org.fkit.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "GOODS")
public class Goods {

	
	private Integer id;//商品ID
	private String name;//商品名
	private String briefDescription;//商品简介
	private String firstImgUrl;//商品简介图片（首页图片）
	
	private Integer categoryId;//所属类别ID
	private Integer userId;//发布者ID
	private Double price;//价格（竞拍起价/贩卖价格）
	private Integer isAuction;//是否为竞拍商品（0：竞拍商品，1：直接卖）
	
	private Double priceStep;//加价步进（拍卖时）
	private String description;//商品介绍（图文分离格式）
	private String imgsUrl;//商品图片地址（图文分离格式）
	private String htmlUrl;//商品详情页面地址（富文本格式）
	
	private Integer status;//商品状态（10：）
	private Date bidStart;
	private Date bidStop;
	private Double bestBidPrice;
    
	private Integer bestBidUserId;
	private Integer owner;
	private Integer version;
	private Integer isDel;
	
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
	public Double getPriceStep() {
		return priceStep;
	}
	public void setPriceStep(Double priceStep) {
		this.priceStep = priceStep;
	}
	@XmlElement(nillable = true)
	public Integer getIsAuction() {
		return isAuction;
	}
	public void setIsAuction(Integer isAuction) {
		this.isAuction = isAuction;
	}
	@XmlElement(nillable = true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement(nillable = true)
	public String getImgsUrl() {
		return imgsUrl;
	}
	public void setImgsUrl(String imgsUrl) {
		this.imgsUrl = imgsUrl;
	}
	@XmlElement(nillable = true)
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
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
	public String getFirstImgUrl() {
		return firstImgUrl;
	}
	public void setFirstImgUrl(String firstImgUrl) {
		this.firstImgUrl = firstImgUrl;
	}
	@XmlElement(nillable = true)
	public Date getBidStop() {
		return bidStop;
	}
	public void setBidStop(Date bidStop) {
		this.bidStop = bidStop;
	}
	@XmlElement(nillable = true)
	public Double getBestBidPrice() {
		return bestBidPrice;
	}
	public void setBestBidPrice(Double bestBidPrice) {
		this.bestBidPrice = bestBidPrice;
	}
	@XmlElement(nillable = true)
	public Integer getBestBidUserId() {
		return bestBidUserId;
	}
	public void setBestBidUserId(Integer bestBidUserId) {
		this.bestBidUserId = bestBidUserId;
	}
	@XmlElement(nillable = true)
	public Integer getOwner() {
		return owner;
	}
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	@XmlElement(nillable = true)
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	@XmlElement(nillable = true)
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", briefDescription=" + briefDescription + ", categoryId="
				+ categoryId + ", userId=" + userId + ", price=" + price + ", priceStep=" + priceStep + ", isAuction="
				+ isAuction + ", description=" + description + ", imgsUrl=" + imgsUrl + ", htmlUrl=" + htmlUrl
				+ ", status=" + status + ", bidStart=" + bidStart + ", bidStop=" + bidStop + ", bestBidPrice="
				+ bestBidPrice + ", bestBidUserId=" + bestBidUserId + ", owner=" + owner + ", version=" + version
				+ ", isDel=" + isDel + "]";
	}
	
	
}
