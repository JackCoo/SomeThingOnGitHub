package com.xupt.service.impl;


import java.util.Date;

import com.xupt.model.ReqMessage;
import com.xupt.model.RespTextMessage;
import com.xupt.service.MessageService;

public class MessageServiceImpl implements MessageService {

	@Override
	public String recognizeMsgType(ReqMessage reqMessage) {
		return null;
	
	}

	@Override
	public Object doTextMessage(ReqMessage reqMessage) {
		System.out.println(reqMessage);
		RespTextMessage resp = new RespTextMessage();
		resp.setContent("Hello");
		resp.setCreateTime(new Date());
		resp.setFromUserName(reqMessage.getToUserName());
		resp.setToUserName(reqMessage.getFromUserName());
		System.out.println(resp);
		 
		return resp;
	}

}
