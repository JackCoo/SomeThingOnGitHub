package org.fkit.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement
public class StatusMessage {

	private Integer messageId;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "StatusMessage [messageId=" + messageId + ", message=" + message + "]";
	}
	
}
