package com.three;

import java.util.Date;

import org.apache.derby.iapi.types.XML;

/**
 * 
 * 消息响应
 * 
 * @author C4y
 *
 */
public class MessageBuilder {
/**
 * 响应文本消息
 * 
 * @param toUserName
 * @param fromUserName
 * @param content
 * @return
 */
	public String doTextMessage (String toUserName,String fromUserName,String content){
		//返回文消息
		TextMessage textMessage = new TextMessage();
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setFromUserName(toUserName);
		textMessage.setToUserName(fromUserName);
		textMessage.setMsgType("text");
		//根据请求的content返回不同文本--单独成方法以便重写？
		switch (content){
			case "1":
				textMessage.setContent("doTextSwt1:"+content);
				break;
			default :
				textMessage.setContent("doTextSwD:"+content);
		
		}
		//将生成的texMessage对象转成XML
		String out = new XMLUtil().ObjectToXml(textMessage);
		return out;
	}
	
	public String doVoiceMessage (String toUserName,String fromUserName,String recognition){
		//返回文消息
		TextMessage textMessage = new TextMessage();
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setFromUserName(toUserName);
		textMessage.setToUserName(fromUserName);
		textMessage.setMsgType("text");
		//根据识别的recognition返回不同文本--单独成方法以便重写？
		textMessage.setContent("doVoiceRec:"+recognition);
		//将生成的texMessage对象转成XML
		String out = new XMLUtil().ObjectToXml(textMessage);
		return out;
	}
}
