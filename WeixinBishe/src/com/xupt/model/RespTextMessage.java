package com.xupt.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class RespTextMessage extends RespBaseMessage {

	private String content;

	public RespTextMessage(){
		super.setMsgType("text");
	}
	
	@XmlElement(name="Content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "RespTextMessage [content=" + content + ", toString()=" + super.toString() + "]";
	}
	
}
