package org.fkit.model;

import java.util.Date;

public class Goods {

	
	private Integer id;
	private String name;
	
	private String briefDescription;
	
	private Integer categoryId;
	
	private Integer userId;
	
	private Double price;
	
	private Double priceStep;
	private Integer isAuction;
	private String description;
	private String imgsUrl;
	private String htmlUrl;
	private String status;
	private Date bidStart;
	private Date bidStop;
	private Double bestBidPrice;
	private Integer bestBidUserId;
	private Integer owner;
	private Integer isDel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBriefDescription() {
		return briefDescription;
	}
	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPriceStep() {
		return priceStep;
	}
	public void setPriceStep(Double priceStep) {
		this.priceStep = priceStep;
	}
	public Integer getIsAuction() {
		return isAuction;
	}
	public void setIsAuction(Integer isAuction) {
		this.isAuction = isAuction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgsUrl() {
		return imgsUrl;
	}
	public void setImgsUrl(String imgsUrl) {
		this.imgsUrl = imgsUrl;
	}
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getBidStart() {
		return bidStart;
	}
	public void setBidStart(Date bidStart) {
		this.bidStart = bidStart;
	}
	public Date getBidStop() {
		return bidStop;
	}
	public void setBidStop(Date bidStop) {
		this.bidStop = bidStop;
	}
	public Double getBestBidPrice() {
		return bestBidPrice;
	}
	public void setBestBidPrice(Double bestBidPrice) {
		this.bestBidPrice = bestBidPrice;
	}
	public Integer getBestBidUserId() {
		return bestBidUserId;
	}
	public void setBestBidUserId(Integer bestBidUserId) {
		this.bestBidUserId = bestBidUserId;
	}
	public Integer getOwner() {
		return owner;
	}
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", briefDescription=" + briefDescription + ", categoryId="
				+ categoryId + ", userId=" + userId + ", price=" + price + ", priceStep=" + priceStep + ", isAuction="
				+ isAuction + ", description=" + description + ", imgsUrl=" + imgsUrl + ", htmlUrl=" + htmlUrl
				+ ", status=" + status + ", bidStart=" + bidStart + ", bidStop=" + bidStop + ", bestBidPrice="
				+ bestBidPrice + ", bestBidUserId=" + bestBidUserId + ", owner=" + owner + ", isDel=" + isDel + "]";
	}
	
	
}
