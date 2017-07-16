package com.xupt.service;

import com.xupt.model.ReqMessage;

public interface MessageService {
	String recognizeMsgType(ReqMessage reqMessage);
	Object doTextMessage(ReqMessage reqMessage);
}
