package com.three;
/**
 * 
 * 消息父类
 * 
 * @author C4y
 *
 */
public class BaseMessage {
	private String ToUserName;
	private String FromUserName;
	private Long CreateTime;
	private String MsgType;	
	
	public void setToUserName(String ToUserName){		
		this.ToUserName = ToUserName;
	}
	public String getToUserName(){
		return ToUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	
}
