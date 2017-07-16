package com.three;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.tools.sysinfo;
import org.dom4j.DocumentException;

import sun.security.ssl.HandshakeMessage;

public class WechatServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		
		//System.out.println(signature+timestamp+echostr);
		PrintWriter out = resp.getWriter();
		out.print(echostr);
		System.out.println("Resp："+echostr);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应编码
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			//获取Post数据，转MAP
			Map<String,String> map = new XMLUtil().xmlToMap(req);
			System.out.println("-req:\n"+map);
			//获取请求消息的公共参数
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			//String content =map.get("Content");
			String msgType = map.get("MsgType");
			
			String respString = "";//局部变量需显式初始化
			//根据不同的消息类型调用相应的响应方法
			switch (msgType) {
				case "text":{
					String content =map.get("Content");
					respString = new MessageBuilder().doTextMessage(toUserName, fromUserName, content);
					break;
				}
				case "event":{
					String eventType = map.get("Event");
					switch (eventType){
						case "subscribe":
							//关注事件
							if(map.get("EventKey")==null){
								//普通关注事件
								//TODO
							}else{
								//未关注时的扫码事件
								String eventKey = map.get("EventKey");
								String ticket = map.get("Ticket");
								//TODO
							}
							break;
						case "unsubscribe":
							//取消关注事件
							//TODO
							break;
						case "SCAN":{
							//已关注时的扫码事件
							String eventKey = map.get("EventKey");
							String ticket = map.get("Ticket");
							//TODO
							break;
						}
						case "LOCATION":
							//上报地理位置事件
							String latitude = map.get("Latitude");
							String longitude = map.get("Longitude");
							String precision = map.get("Precision");
							//TODO
							break;
						case "CLICK":{
							//自定义菜单事件-点击菜单拉取消息事件
							String eventKey = map.get("EventKey");//事件的key值，与自定义菜单接口中KEY值对应
							//TODO
							break;
						}
						case "VIEW":{
							//自定义菜单事件-点击菜单跳转链接事件
							String eventKey = map.get("EventKey");//事件KEY值，设置的跳转URL
							//TODO
						}
						default :
							break;
					}
					break;
				}
				case "image":{//用{}来限定局部变量的作用于在该case内
					//图片消息
					String picUrl = map.get("PicUrl");//图片链接
					String mediaId = map.get("MediaId");//图片消息媒体id，可以调用多媒体文件下载接口拉取数据
					String msgId = map.get("MsgId");//消息id，64位整型
					//TODO
					break;
				}
				case "voice":{
					String mediaId = map.get("MediaId");//语音消息媒体id，可以调用多媒体文件下载接口拉取数据
					String format = map.get("Format");//语音格式，如amr，speex等
					String msgId = map.get("MsgID");//消息id，64位整型
					String recognition = map.get("Recognition");//语音识别结果
					//TODO
					respString = new MessageBuilder().doVoiceMessage(toUserName, fromUserName, recognition);
					break;
				}
				case "video":{
					String mediaId = map.get("MediaId");//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
					String thumbMediaId = map.get("ThumbMediaId");//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
					String msgId = map.get("MsgID");//消息id，64位整型
					//TODO
					break;
				}	
				case "shortvideo":{
					String mediaId = map.get("MediaId");//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
					String thumbMediaId = map.get("ThumbMediaId");//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
					String msgId = map.get("MsgID");//消息id，64位整型
					//TODO
					break;
				}
				case "location":{
					String location_X = map.get("Location_X");//地理位置维度
					String location_Y = map.get("Location_Y");//地理位置经度
					String scale = map.get("Scale");//地图缩放大小
					String label = map.get("Label");//地理位置信息
					String msgId = map.get("MsgId");//消息id，64位整型
				}
				case "link":{
					String Title = map.get("Title");//消息标题
					String Description = map.get("Description");//消息描述
					String Url = map.get("Url");//消息链接
					String MsgId = map.get("MsgId");//消息id，64位整型
				}
				default :
					break;
			}
			
			
			//返回——构建MAP、转XML
//			Map<String, String> respMap = new HashMap<String,String>();
//			respMap.put("ToUserName", FromUserName);
//			respMap.put("FromUserName", ToUserName);
//			respMap.put("CreateTime", new Date().toString());
//			respMap.put("MsgType", "text");
//			respMap.put("Content", "Test:"+Content);
//			String respString = new XMLUtil().MapToXml(respMap);	
			
			//返回——构建对象、转XML
//			TextMessage respText = new TextMessage();
//			respText.setToUserName(fromUserName);
//			respText.setFromUserName(toUserName);
//			respText.setCreateTime(new Date().getTime());
//			respText.setMsgType("text");
//		    respText.setContent("测试："+content);
//			respString = new XMLUtil().ObjectToXml(respText);
//			

//			//打印响应XML
			System.out.println("-respString:\n"+respString);
			out.write(respString);
		

			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
