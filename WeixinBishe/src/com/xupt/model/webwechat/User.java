/**
  * Copyright 2017 bejson.com 
  */
package com.xupt.model.webwechat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-generated: 2017-06-05 13:46:23
 *
 *	微信账号信息类（本人）
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */

//@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	@JsonProperty("Uin")
    private int uin;
	
	@JsonProperty("UserName")
    private String userName;
	
	@JsonProperty("NickName")
	private String nickName;
	
	@JsonProperty("HeadImgUrl")
    private String headImgUrl;
	
	@JsonProperty("RemarkName")
    private String remarkName;
	
	@JsonProperty("PYInitial")
    private String pYInitial;
	
	@JsonProperty("PYQuanPin")
    private String pYQuanPin;
	
	@JsonProperty("RemarkPYInitial")
    private String remarkPYInitial;
	
	@JsonProperty("RemarkPYQuanPin")
    private String remarkPYQuanPin;
	
	@JsonProperty("HideInputBarFlag")
    private int hideInputBarFlag;
	
	@JsonProperty("StarFriend")
    private int starFriend;
	
	@JsonProperty("Sex")
    private int sex;
	
	@JsonProperty("Signature")
    private String signature;
	
	@JsonProperty("AppAccountFlag")
    private int appAccountFlag;

	@JsonProperty("VerifyFlag")
    private int verifyFlag;
	
	@JsonProperty("ContactFlag")
    private int contactFlag;
	
	@JsonProperty("WebWxPluginSwitch")
    private int webWxPluginSwitch;
	
	@JsonProperty("HeadImgFlag")
    private int headImgFlag;
	
	@JsonProperty("SnsFlag")
    private int snsFlag;
	
	public int getUin() {
		return uin;
	}
	public void setUin(int uin) {
		this.uin = uin;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getRemarkName() {
		return remarkName;
	}
	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}
	public String getpYInitial() {
		return pYInitial;
	}
	public void setpYInitial(String pYInitial) {
		this.pYInitial = pYInitial;
	}
	public String getpYQuanPin() {
		return pYQuanPin;
	}
	public void setpYQuanPin(String pYQuanPin) {
		this.pYQuanPin = pYQuanPin;
	}
	public String getRemarkPYInitial() {
		return remarkPYInitial;
	}
	public void setRemarkPYInitial(String remarkPYInitial) {
		this.remarkPYInitial = remarkPYInitial;
	}
	public String getRemarkPYQuanPin() {
		return remarkPYQuanPin;
	}
	public void setRemarkPYQuanPin(String remarkPYQuanPin) {
		this.remarkPYQuanPin = remarkPYQuanPin;
	}
	public int getHideInputBarFlag() {
		return hideInputBarFlag;
	}
	public void setHideInputBarFlag(int hideInputBarFlag) {
		this.hideInputBarFlag = hideInputBarFlag;
	}
	public int getStarFriend() {
		return starFriend;
	}
	public void setStarFriend(int starFriend) {
		this.starFriend = starFriend;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public int getAppAccountFlag() {
		return appAccountFlag;
	}
	public void setAppAccountFlag(int appAccountFlag) {
		this.appAccountFlag = appAccountFlag;
	}
	public int getVerifyFlag() {
		return verifyFlag;
	}
	public void setVerifyFlag(int verifyFlag) {
		this.verifyFlag = verifyFlag;
	}
	public int getContactFlag() {
		return contactFlag;
	}
	public void setContactFlag(int contactFlag) {
		this.contactFlag = contactFlag;
	}
	public int getWebWxPluginSwitch() {
		return webWxPluginSwitch;
	}
	public void setWebWxPluginSwitch(int webWxPluginSwitch) {
		this.webWxPluginSwitch = webWxPluginSwitch;
	}
	public int getHeadImgFlag() {
		return headImgFlag;
	}
	public void setHeadImgFlag(int headImgFlag) {
		this.headImgFlag = headImgFlag;
	}
	public int getSnsFlag() {
		return snsFlag;
	}
	public void setSnsFlag(int snsFlag) {
		this.snsFlag = snsFlag;
	}
	@Override
	public String toString() {
		return "User [uin=" + uin + ", userName=" + userName + ", nickName=" + nickName + ", headImgUrl=" + headImgUrl
				+ ", remarkName=" + remarkName + ", pYInitial=" + pYInitial + ", pYQuanPin=" + pYQuanPin
				+ ", remarkPYInitial=" + remarkPYInitial + ", remarkPYQuanPin=" + remarkPYQuanPin
				+ ", hideInputBarFlag=" + hideInputBarFlag + ", starFriend=" + starFriend + ", sex=" + sex
				+ ", signature=" + signature + ", appAccountFlag=" + appAccountFlag + ", verifyFlag=" + verifyFlag
				+ ", contactFlag=" + contactFlag + ", webWxPluginSwitch=" + webWxPluginSwitch + ", headImgFlag="
				+ headImgFlag + ", snsFlag=" + snsFlag + "]";
	}
    
    

}