package com.article.model;

import java.util.Date;

public class Article {
	
	
	private String title;//标题
	private Integer id;
	private String name;//文章名称
	private String content;//文章内容
	private String author;//文章作者
	private String description;//概要
	private String isPublish;//是否发布
	private String isDel;//是否删除
	private Date createTime;
	private Date updateTime;
	private Integer userId;//发布者id
	private Integer categoryId;//分类id
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", id=" + id + ", name=" + name + ", content=" + content + ", author="
				+ author + ", description=" + description + ", isPublish=" + isPublish + ", isDel=" + isDel
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", userId=" + userId + ", categoryId="
				+ categoryId + "]";
	}
	
	

}
