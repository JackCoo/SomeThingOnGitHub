package com.xupt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xupt.model.ReqMessage;
import com.xupt.model.RespTextMessage;
import com.xupt.service.MessageService;

@Controller
public class WechatController {
	private MessageService ms;
	
	//微信接入验证
	@RequestMapping(value = "/wechat", method = RequestMethod.GET)
	@ResponseBody
	public String doCheck(
			@RequestParam(name="signature") String signature,
			@RequestParam(name="timestamp") String timestamp,
			@RequestParam(name="nonce") String nonce,
			@RequestParam(name="echostr") String echostr
			){
		
		System.out.println(signature+timestamp+echostr);
		System.out.println("Resp："+echostr);
		return echostr;
		
		
	}
	
	@RequestMapping(value = "/wechat", method = RequestMethod.POST,consumes = "text/xml")
	@ResponseBody
	public Object wechatServ(
			@RequestBody ReqMessage reqMessage
			){
		
		
		
		//根据不同的消息类型调用相应的响应方法
		switch (reqMessage.getMsgType()) {
			case "text":{
				ms.doTextMessage(reqMessage);
				break;
			}
			case "event":{
				switch (reqMessage.getEventType()){
					case "subscribe":
						//关注事件
						if(reqMessage.getEventKey()==null){
							//普通关注事件
							//TODO
						}else{
							//未关注时的扫码事件
							//TODO
						}
						break;
					case "unsubscribe":
						//取消关注事件
						//TODO
						break;
					case "SCAN":{
						//已关注时的扫码事件
						//TODO
						break;
					}
					case "LOCATION":
						//上报地理位置事件
						//TODO
						break;
					case "CLICK":{
						//自定义菜单事件-点击菜单拉取消息事件
						String eventKey =  reqMessage.getEventKey();//事件的key值，与自定义菜单接口中KEY值对应
						//TODO
						break;
					}
					case "VIEW":{
						//自定义菜单事件-点击菜单跳转链接事件
						String eventKey = reqMessage.getEventKey();//事件KEY值，设置的跳转URL
						//TODO
					}
					default :
						break;
				}
				break;
			}
			case "image":{//用{}来限定局部变量的作用于在该case内
				//图片消息
				//TODO
				break;
			}
			case "voice":{
				//TODO;
				break;
			}
			case "video":{

				//TODO
				break;
			}	
			case "shortvideo":{

				//TODO
				break;
			}
			case "location":{
				break;
			}
			case "link":{
				break;
			}
			default :
				break;
		}
		
		
		
		
		
		
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
