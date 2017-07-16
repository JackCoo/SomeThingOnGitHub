package com.one.model;

import java.util.Set;

public class User {

	private String id;	
	private String userName;
	private String wechatId;
	private Set deviceLimit;
	private String passWord;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public Set getDeviceLimit() {
		return deviceLimit;
	}
	public void setDeviceLimit(Set deviceLimit) {
		this.deviceLimit = deviceLimit;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
