package com.xupt.model.webwechat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendInfo {
	@JsonProperty("UserName")
	private String UserName;
	@JsonProperty("NickName")
	private String NickName;
	@JsonProperty("QQNum")
	private int QQNum;
	@JsonProperty("Province")
	private String Province;
	@JsonProperty("City")
	private String City;
	@JsonProperty("Content")
	private String Content;
	@JsonProperty("Signature")
	private String Signature;
	@JsonProperty("Alias")
	private String Alias;
	@JsonProperty("Scene")
	private int Scene;
	@JsonProperty("VerifyFlag")
	private int VerifyFlag;
	@JsonProperty("AttrStatus")
	private int AttrStatus;
	@JsonProperty("Sex")
	private int Sex;
	@JsonProperty("Ticket")
	private String Ticket;
	@JsonProperty("OpCode")
	private int OpCode;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public int getQQNum() {
		return QQNum;
	}
	public void setQQNum(int qQNum) {
		QQNum = qQNum;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public String getAlias() {
		return Alias;
	}
	public void setAlias(String alias) {
		Alias = alias;
	}
	public int getScene() {
		return Scene;
	}
	public void setScene(int scene) {
		Scene = scene;
	}
	public int getVerifyFlag() {
		return VerifyFlag;
	}
	public void setVerifyFlag(int verifyFlag) {
		VerifyFlag = verifyFlag;
	}
	public int getAttrStatus() {
		return AttrStatus;
	}
	public void setAttrStatus(int attrStatus) {
		AttrStatus = attrStatus;
	}
	public int getSex() {
		return Sex;
	}
	public void setSex(int sex) {
		Sex = sex;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	public int getOpCode() {
		return OpCode;
	}
	public void setOpCode(int opCode) {
		OpCode = opCode;
	}
	@Override
	public String toString() {
		return "RecommendInfo [UserName=" + UserName + ", NickName=" + NickName + ", QQNum=" + QQNum + ", Province="
				+ Province + ", City=" + City + ", Content=" + Content + ", Signature=" + Signature + ", Alias=" + Alias
				+ ", Scene=" + Scene + ", VerifyFlag=" + VerifyFlag + ", AttrStatus=" + AttrStatus + ", Sex=" + Sex
				+ ", Ticket=" + Ticket + ", OpCode=" + OpCode + "]";
	}

	
	
}
