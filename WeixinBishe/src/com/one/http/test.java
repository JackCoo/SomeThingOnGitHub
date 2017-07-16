package com.one.http;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import javax.naming.PartialResultException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.one.util.XMLUtil;
import com.sun.media.sound.JARSoundbankReader;
import com.xupt.model.webwechat.Message;
import com.xupt.model.webwechat.User;
import com.xupt.model.webwechat.WeChatMeta;

public class test {
	public static void main(String[] args) {
		
		
		//xmlceshi
		InputStream is;
		try {
			is = new FileInputStream("F:/java/WeixinBishe/src/com/one/http/xml");
			BufferedReader initBr = new BufferedReader(new InputStreamReader(is ));
		    StringBuffer initSb = new StringBuffer();
		    String initLine = null;
		    while((initLine = initBr.readLine()) != null)
		    	initSb.append(initLine);
		    String initResult = initSb.toString();
		    System.out.println(initResult);
			

			
			//创建SAXReader对象，通过read方法由IO流载入XML
			SAXReader reader = new SAXReader();
			Document doc = null;
			try {
				doc = reader.read(new ByteArrayInputStream(content.getBytes("UTF-8")));
			} catch (DocumentException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			//获取根节点
			Element rootElement = doc.getRootElement();
			//创建迭代器，迭代子节点
			Iterator<Element> it0 = rootElement.elementIterator();
			while(it0.hasNext()){
				//获取一子节点并放入map集合
				Element childElement = it0.next();
				Iterator<Element> it1 = childElement.elementIterator();
				while()		
			}
			
			
			Map<String, String> con = new XMLUtil().xmlToMap(content);
			Map<String, String> revokemsg = new XMLUtil().xmlToMap(con.get("revokemsg"));
			System.out.println(revokemsg.get("msgid"));
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

//		Random rm = new Random();
//		long min = 100000000000000L;
//		long max = 999999999999999L;
//		long result = rm.nextLong()%(max-min+1) + min;
//		Double result1 = rm.nextDouble();
//		System.out.println(result1);
//		System.out.println(String.valueOf(result1).substring(4));

		//ClientMsgId: 时间戳左移4位随后补上4位随机数 
//		Random rm = new Random();
//		int min = 1000;
//		int max = 9999;
//		int result = rm.nextInt()%(max-min+1) + min;
//		String clientMsgId = new Date().getTime() + "" + result ;
//		System.out.println(clientMsgId);
//		//分析微信初始化json
////		try {
////				InputStream is = new FileInputStream("F:/java/WeixinBishe/src/com/one/http/微信初始化返回json");
////		        BufferedReader initBr = new BufferedReader(new InputStreamReader(is ));
////		        StringBuffer initSb = new StringBuffer();
////		        String initLine = null;
////		        while((initLine = initBr.readLine()) != null)
////		        	initSb.append(initLine);
////		        String initResult = initSb.toString();
////		        System.out.println(initResult);
////		        
////		        ObjectMapper mapper = new ObjectMapper();
////		        JsonNode node = mapper.readTree(initResult);
////		        
////		        //获取状态值ret
////		        
////		        String retNode = node.get("BaseResponse").get("Ret").asText();
////		        System.out.println(retNode);
////		        
////		        //syncKeyNode JSONnode
////		        JsonNode syncKeyNode = node.get("SyncKey");
////		        
////		        System.out.println(syncKeyNode);
//////		        
////		        
////		        //获取账户信息——从微信初始化返回json中
////		        JsonNode userNode = node.get("User");
////		        System.out.println(userNode);
//		  
//		        User user = mapper.readValue(userNode.toString(), User.class);
//		        System.out.println(user);
//		        
////		        
////		        JsonNode  syncKeyListNode = syncKeyNode.get("List");
////		        System.out.println(syncKeyListNode);
////		        
////		        JsonNode syncKeyKVNode = syncKeyListNode.get(0);
////		        
////		        System.out.println(syncKeyKVNode);
////		        
////		        JsonNode node1 = syncKeyKVNode.findValue("Key");
////		        
////		        System.out.println(node1);
//		        
//		        
//		        //转换SyncKey为特定字符串
////		        JsonNode syncKeyKVNode = syncKeyNode.get("List");
////		        StringBuffer sb = new StringBuffer();
////		        
////		        for (int i = 0; i < 4; i++){
////		        	JsonNode node1 = syncKeyKVNode.get(i);
////		        	sb.append(("|"+node1.get("Key")+"_"+node1.get("Val")));
////		        }
////		        String sbString = sb.toString().substring(1);
////		        System.out.println(sbString);
//		        
//		        
//		} catch (FileNotFoundException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		
//		///测试cookie与httpclient
//		System.out.println("==========================================");
//		WeChatMeta testMeta = new WeChatMeta();
//		testMeta.setWxuin("1549277641");
//		testMeta.setWxsid("fzHqm8TCaSdriHyx");
//		testMeta.setSkey("@crypt_c13cd12c_95ff2e0590d90ed5a09e54dd1647b0d4");
//		testMeta.setDeviceId("e386466068148644");
//		//设置cookie
//		testMeta.setCookieString("pgv_pvi=9853061120; pgv_si=s9367560192; MM_WX_NOTIFY_STATE=1; MM_WX_SOUND_STATE=1; webwx_data_ticket=gSd5+yDeeGjRmwQQ6A+3VE8O;wxuin=1549277641; wxsid=fzHqm8TCaSdriHyx; wxloadtime=1496751369;   webwxuvid=ed43ce477a43bbbe74eb9a2b7d0e47f0cdd049d907ce902fa201d89d0fba9a94f81e014472ea71f931d944365c918f25; webwx_auth_ticket=CIsBELCxhcEDGoAB7SHuKfP3GugcgcnHUptkdjRj4JBqTdPHSFR9uSoNE0pthoEesVPGA35F3em+LZIOjRL27+K+ZkkigVAMccDD3/SZ2bpL/0Zgfyw3nsAIfiIS3uY0mYctSbbBUZnbLBauWCJYBnZqKZwadYJJ308orctgj7r0bHO5StcVo1DY5oc=; login_frequency=1; last_wxuin=1549277641");
//		User testuser = new User();
//		testuser.setUserName("@410a9a1060928cc8cffa4ef40ab24416e0e4fda34e5c469748cb05de2ca25a51");
//		
//		WebWeChat testwx = new WebWeChat();
//		testwx.statusNotify(testMeta, testuser);
//		
//		////
		
		
		
//		////创建json
//		ObjectMapper mapper = new ObjectMapper();
//		ObjectNode rootNode = mapper.createObjectNode();
//		ObjectNode node0 = mapper.createObjectNode();
//		ObjectNode node1 = mapper.createObjectNode();
//		
//		node0.put("DeviceID", "");
//		node0.put("Sid", "");
//		node0.put("Skey", "");
//		node0.put("Uin:xxx", "");
//	
//		node1.put("ClientMsgId", "");
//		node1.put("Content", "");
//		node1.put("FromUserName", "");
//		node1.put("LocalID", "");
//		node1.put("ToUserName", "filehelper");
//		node1.put("Type", 1);
//			
//		rootNode.put("BaseRequest",node0);
//		rootNode.put("Msg",node1);
//		rootNode.put("Scene",0);
//		System.out.println(rootNode);
		
//		
//		//字符串window.synccheck={retcode:"0",selector:"2"}提取测试
//		String testSynv = "window.synccheck={retcode:\"0\",selector:\"2\"}";
		//System.out.println(testSynv.split("retcode")[1].);
//		Pattern pattern = Pattern.compile("");
//		pattern.
//		
		//第一个参数即retcode值
//		System.out.println(testSynv.split("=")[1].split(",")[0].split("\"")[1]);
//		System.out.println(testSynv.split("=")[1].split(",")[1].split("\"")[1]);
//		
//		
//		try {
//		InputStream is = new FileInputStream("F:/java/WeixinBishe/src/com/one/http/获取最新消息json");
//        BufferedReader initBr = new BufferedReader(new InputStreamReader(is ));
//        StringBuffer initSb = new StringBuffer();
//        String initLine = null;
//        while((initLine = initBr.readLine()) != null)
//        	initSb.append(initLine);
//        String initResult = initSb.toString();
//        System.out.println(initResult);
//        
//		//分析返回的Json-包含联系人等信息、本人账户等
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode node = mapper.readTree(initResult);
//        //判断Ret值，0表示成功，1表示失败
//        String ret = node.get("BaseResponse").get("Ret").asText();
//        if(ret == "0"){
//        	
//        	
//        	
//        	//获取SyncKey，用以后续获取最新消息等用途。其会不断更新。
//        	//syncKeyNode JsonNode类型,获取最新消息时使用。（需要post SyncKey段json）
//	        JsonNode syncKeyNode = node.get("SyncKey");
//
//	        //将syncKeyNode节点转换成特定的kv字符串，用以消息检查（同步检测）时GET使用
//	        JsonNode syncKeyKVNode = syncKeyNode.get("List");
//	        StringBuffer sb = new StringBuffer();
//	        for (int i = 0; i < syncKeyKVNode.size(); i++){
//	        	JsonNode node1 = syncKeyKVNode.get(i);
//	        	sb.append(("|"+node1.get("Key")+"_"+node1.get("Val")));
//	        }
//	        String sbString = sb.toString().substring(1);
//
//	        
//	        //消息分析
//	        //消息条数
//	        String msgsNum = node.get("AddMsgCount").asText();
//	        if(msgsNum != "0"){
//	        	System.out.println("获取到:{}条信息"+msgsNum);
//	        	JsonNode msgListNode = node.get("AddMsgList");
//	        	for(int i = 0; i < msgListNode.size(); i++){
//	        		System.out.println(msgListNode.get(i));
//	        		Message msg = mapper.readValue(msgListNode.get(i).toString(), Message.class);
//	        		System.out.println(msg);
//	        	}
//	        }
//        }
//        
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		
		//缓存所有消息
		List<Message> allMsg = new ArrayList<>();
		//以支持https
		System.setProperty("jsse.enableSNIExtension", "false");
		//创建一个微信服务类
		WebWeChat wx = new WebWeChat();
		//获取uuid
		String uuid = wx.getUuid();
		//根据uuid获取二维码，保存。
		wx.getQr(uuid);
		//等待用户扫描，获取头像、跳转地址等信息
		Map<String, String> result = wx.waitToScan(uuid);
		//根据跳转地址去获取登录所需的参数、cookie，将其同uuid一起放入wxMeta中。
		WeChatMeta wxMeta = wx.getWechatMeta(result, uuid);
		//使用wxMeta去初登录微信，获取账户信息、联系人等
		Map<String, Object> msgMap = wx.WeChatInit(wxMeta);
		//使用wxMeta和user去开启消息提醒
		wx.statusNotify(wxMeta, (User)msgMap.get("user"));
		//同步，消息检查，有消息时获取
		while(true){
			Map<String, String> syncResult = wx.syncCheck(wxMeta);
			//同步正常
			if(syncResult.get("retCode").equals("0")){
				//有新的消息
				if(syncResult.get("selector").equals("2")){
					List<Message> msgList = wx.getMessage(wxMeta);
					allMsg.addAll(msgList);
					for (Message message : msgList) {
						//消息撤回
						if(message.getMsgType() == 10002){
							//分析content，获取撤回详细信息
							String content = message.getContent();
							
							
							
							
							//倒序查找被撤回信息
							for(int i = allMsg.size()-1; i >=0; i--){
								if(allMsg.get(i).getMsgId() == revokemsg.get("msgid")){
									//向文件助手发送信息
									wx.sendMsg(wxMeta, (User)msgMap.get("user"), "abc123@撤回id:"+revokemsg.get("msgid")+"撤回内容"+allMsg.get(i).getContent(), "filehelper");	
									
								}
							}
					
						}
				
						
					}
					
				}
				
			}else{
				//同步失败
				System.out.println("结束");
				break;
			}
			
			try {
 				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
