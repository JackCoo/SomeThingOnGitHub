package com.three;
/**
 * 图文消息的组成部分
 * 
 * @author C4y
 *
 */
public class News {

	private String Title;//图文消息标题
	private String Description;//图文消息描述
	private String PicUrl;//图片链接
	private String Url;//点击跳转链接
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
}
