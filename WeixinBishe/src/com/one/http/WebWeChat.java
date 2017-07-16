package com.one.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.one.util.XMLUtil;
import com.xupt.model.webwechat.WeChatMeta22;

import net.sf.json.JSONObject;
import sun.util.locale.provider.LocaleServiceProviderPool.LocalizedObjectGetter;

import com.xupt.model.webwechat.Message;
import com.xupt.model.webwechat.User;
import com.xupt.model.webwechat.WeChatMeta;


public class WebWeChat {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebWeChat.class);

	/**
	 * 获取uuid
	 * 
	 * @return UUID
	 */
	public String getUuid(){

		String uuid = null;
		//创建当前时间戳
		String timestamp = String.valueOf(new Date().getTime());
		try {
			
			//创建一个URL实例
			URL weChatUrl = new URL(Constant.JS_LOGIN + "&_=" + timestamp);
			LOGGER.debug("获取UUID中，请求地址为：{}",weChatUrl);
			//通过openStream方法获取URL所表示资源的字节输入流
			InputStream  is = weChatUrl.openStream();
			//将字节输入流转换成字符输入流
			InputStreamReader isr = new InputStreamReader(is);
			//将字节流加入缓冲
			BufferedReader br = new BufferedReader(isr);
			//读取数据
			String uuidResult = br.readLine();
			LOGGER.debug("UUID请求结果：{}",uuidResult);
			uuid = uuidResult.substring(50, 62);
//			//将uuid放入WeChatMeta
//			wxMeta.setUuid(uuid);
			LOGGER.debug("UUID为：{}",uuid);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return uuid;
	}
	
	/**
	 * 获取二维码
	 * 根据uuid获取二维码并保存在项目目录下
	 * 
	 * @param uuid
	 */
	public void getQr(String uuid){
		try{
			//获取图片输入流
			URL qrUrl = new URL(Constant.QR + uuid);
			LOGGER.debug("获取QR中，请求地址为:{}", qrUrl);
			InputStream qrIs = qrUrl.openStream();
			
			//保存图片
			//1K的数据缓存
			byte[] picDate = new byte[1024];
			//每次读取的数据长度
			int len = 0;
			File imageFile = new File("QR.jpg");  
	        //获取文件输出流  
	        FileOutputStream outStream = new FileOutputStream(imageFile); 
	        //循环从输入流读取byte[1024]数据至picDate，通过输出流将次二进制数据写入文件。
			while((len = qrIs.read(picDate)) != -1){//len=-1表示读取结束
				outStream.write(picDate, 0, len);
			}
	        //关闭输出流  
	        outStream.close(); 
	        LOGGER.info("QR获取成功，保存地址为:{}", imageFile);
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	
	/**
	 * 获取二维码扫描情况
	 * 
	 * 循环请求SCAN_WAIT_TIME次，成功返回Map。
	 * @param uuid
	 * @return 含有状态码windoesCode、头像地址picUrl以及跳转地址redirectUrl的集合
	 */
	public Map<String, String> waitToScan(String uuid){
		//扫描状态码，408：未扫描，201：已扫描，200：登录
		String windoesCode = "408";//未扫描
		int reqTime = 0;//请求计数
        Map<String, String> result = new HashMap<>();
        try{
        	 while( (!windoesCode.equalsIgnoreCase("200")) && reqTime <= Constant.SCAN_WAIT_TIME){//利用equal方法比较，而不是!=;
        		reqTime++;
     	        long timestampLong = new Date().getTime();
     	        //时间戳取反--模拟JS取反：现将数据转换成32位有符号int，然后取反。
     	        int negaTimestampInt = ~(int)timestampLong;
     			URL scanUrl = new URL(Constant.LOGIN + "&uuid=" + uuid + "&tip=1&r=" + negaTimestampInt + "&_=" + timestampLong);
     			LOGGER.debug("等待二维码扫描中，请求地址为:{}", scanUrl);
     			InputStream scanIs = scanUrl.openStream();
     			InputStreamReader scanisr = new InputStreamReader(scanIs);
     			BufferedReader scanbr = new BufferedReader(scanisr);
     			StringBuffer scanResultSb = new StringBuffer();
     			String line;
     			//循环读取所有行
     			while((line = scanbr.readLine()) != null)
     				scanResultSb.append(line);
     			String scanResult = scanResultSb.toString();
     			LOGGER.debug("扫描结果:{}", scanResult);
     			windoesCode = scanResult.substring(12, 15);
     			LOGGER.debug("状态码Windows.Code:{}", windoesCode);
     			//延时2秒
     			Thread.sleep(2000);
     			//依据状态码执行相应操作
     			switch(windoesCode){
     				//已扫描
     				case "201":
     					//提取头像地址
     					result.put("windoesCode", "201");
     					result.put("picUrl", scanResult.split("'")[1]);
     					LOGGER.info("二维码已扫描，等待点击登录。");
     					break;
     				//已点击登录
     				case "200":
     					result.put("windoesCode", "200");
     					result.put("redirectUrl", scanResult.split("\"")[1]);
     					LOGGER.info("已点击登录，后台登录中。");
     					break;
     				default :
     					result.put("windoesCode", "408");
     					LOGGER.info("用户尚未扫描二维码，重试中...");
     					break;
     			}
				LOGGER.debug("扫描状态MAP为:{}", result);	
             }
        	
        	
        }catch (IOException e) {
			// TODO: handle exception
        	e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
       
		return result;
		
	}
	
	/**
	 * 获取登录所需的参数以及Cookie
	 * 
	 * @param scanResult 二维码扫描结果MAP，使用其中redirectUrl
	 * @param uuid 将其放入了WeChatMeta
	 * @return WeChatMeta,包含维持微信登录及相关操作所需的数据
	 */
	public WeChatMeta getWechatMeta(Map<String, String> scanResult, String uuid){
		
		WeChatMeta wxMeta = null;
		
		/****  旧版本  cookie保存为字符串****/
		try{
			
			URL paraUrl = new URL( scanResult.get("redirectUrl") + "&fun=new&version=v2");
			LOGGER.debug("请求微信登录参数，请求的地址为:{}", paraUrl);
	        //使用openConnection获得URLConnection对象，转换成其子类HttpsURLConnection
	        HttpsURLConnection paraHttpsConn = (HttpsURLConnection) paraUrl.openConnection();
	        
	        //获取响应的cookie--获取所有“Set—Cookie”
	        //String cookieString = paraHttpsConn.getHeaderField("Set-Cookie");//只能获取其中一个
	        List<String> cookieList = paraHttpsConn.getHeaderFields().get("Set-Cookie");
	        //遍历集合，拼接cookie,去除Domain Path 等信息
	        StringBuffer sb = new StringBuffer();
	        for (String string : cookieList) {
				sb.append(";"+string.split(";")[0]);
			}
	        String cookieString = sb.toString().substring(1);
	        //获取响应body
			InputStream paraIs = paraHttpsConn.getInputStream();
			InputStreamReader paraIsr = new InputStreamReader(paraIs);
			BufferedReader paraBr = new BufferedReader(paraIsr);
			StringBuffer paraResultSb = new StringBuffer();
			String line = null;
			while((line = paraBr.readLine()) != null){
				paraResultSb.append(line);
			}
			String paraResult = paraResultSb.toString();
			LOGGER.debug("微信登录参数请求结果为:{}", paraResult);
			//将响应——微信所需的参数，写入WeChatMeta
			wxMeta = (WeChatMeta) XMLUtil.convertXmlStrToObject(WeChatMeta.class, paraResult);
			//将之前获得的uuid也放入
			wxMeta.setUuid(uuid);	
			//将cookie放入WeChatMeta
			wxMeta.setCookieString(cookieString);
			
			LOGGER.debug("请求登录参数的响应头为", paraHttpsConn.getHeaderFields());
			LOGGER.debug("封装WeChatMeta对象为:{}", wxMeta);
			LOGGER.debug("封装的Cookie为：{}", wxMeta.getCookieString());
		}catch (IOException e) {
			// TODO: handle exception
		}

		
		/****** 新版本 使用HTTPClient，同时获取cookie，保存至meta********/
		
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		HttpGet httpGet = new HttpGet(scanResult.get("redirectUrl") + "&fun=new&version=v2" );
//		try {
//			
//			HttpResponse httpResp = httpClient.execute(httpGet);
//			HttpEntity httpEntity = httpResp.getEntity();
//			String entityString = EntityUtils.toString(httpEntity);
//			System.out.println(entityString);
//			
//			
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		
		
		
		
		return wxMeta;
		
	}
	/**
	 * 登录并初始化微信
	 * 
	 * @param wxMeta 
	 * @return 含有账户信息、最近联系人、SyncKey等信息 的map
	 */
	public Map<String, Object> WeChatInit(WeChatMeta wxMeta){
		
		Map<String, Object> msgMap = new HashMap<>();
        long timestampLong = new Date().getTime();
        int negaTimestampLong = ~(int)timestampLong;
		String postString = "{\"BaseRequest\":{"
				+ "\"DeviceID\":" + "\""+ wxMeta.getDeviceId() + "\","
				+ "\"Sid\":" + "\""+ wxMeta.getWxsid() + "\","
				+ "\"Skey\":" +"\""+ wxMeta.getSkey() + "\","
				+ "\"Uin\":" + "\""+ wxMeta.getWxuin() + "\""
				+ "}}";
		LOGGER.debug("登录微信POST参数为:{}", postString);
		try {
			
			URL initUrl = new URL(Constant.INIT + "?r=" + negaTimestampLong + "&lang=zh_CN&pass_ticket=" + wxMeta.getPassTicket());
			LOGGER.debug("请求的地址为：{}", initUrl);
	        //使用openConnection获得URLConnection对象，转换成其子类HttpsURLConnection
	        HttpsURLConnection initHttpsConn = (HttpsURLConnection) initUrl.openConnection();
	        
	        //调用HttpsURLConnection的setRequestProperty方法设置Header Cookie————无cookie也行
	        initHttpsConn.setRequestProperty("Cookie", wxMeta.getCookieString());
	        
	        //设置为Post模式相关参数——setDoOutput，以便在连接成功后向服务器post数据
	        initHttpsConn.setRequestMethod("POST");
	        initHttpsConn.setDoOutput(true);
	        // 获取URLConnection对象对应的输出流
	        PrintWriter printWriter = new PrintWriter(initHttpsConn.getOutputStream());
	        // 发送请求参数
	        printWriter.write(postString);//post的参数 xx=xx&yy=yy
	        // flush输出流的缓冲
	        printWriter.flush();
	        InputStream initIs = initHttpsConn.getInputStream();
	        BufferedReader initBr = new BufferedReader(new InputStreamReader(initIs));
	        StringBuffer initSb = new StringBuffer();
	        String initLine = null;
	        while((initLine = initBr.readLine()) != null)
	        	initSb.append(initLine);
	        String initResult = initSb.toString();
	        System.out.println(initResult);
	        LOGGER.debug("请求结果{}", initResult);
	        
	        //分析返回的Json-包含联系人等信息、本人账户等
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode node = mapper.readTree(initResult);
	        //判断Ret值，0表示成功，1表示失败
	        String ret = node.get("BaseResponse").get("Ret").asText();
	        if(ret == "0"){
	        	
	        	LOGGER.debug("登录成功！！");
	        	
	        	//获取SyncKey，用以后续获取最新消息等用途。其会不断更新。
	        	//syncKeyNode JsonNode类型,获取最新消息时使用。（需要post SyncKey段json）
		        JsonNode syncKeyNode = node.get("SyncKey");
		        wxMeta.setSyncKeyNode(syncKeyNode);
		        LOGGER.debug("获取的SyncKey节点：{}", syncKeyNode);
		        //将syncKeyNode节点转换成特定的kv字符串，用以消息检查（同步检测）时GET使用
		        JsonNode syncKeyKVNode = syncKeyNode.get("List");
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < syncKeyKVNode.size(); i++){
		        	JsonNode node1 = syncKeyKVNode.get(i);
		        	sb.append(("|"+node1.get("Key")+"_"+node1.get("Val")));
		        }
		        String sbString = sb.toString().substring(1);
		        wxMeta.setSynckey(sbString);
		        LOGGER.debug("SyncKey节点KV字符串：{}", sbString);
		        
		        //获取账户信息
		        JsonNode userNode = node.get("User");
		        //使用ObjectMapper的readvalue方法将json转换成对象
		        User user = mapper.readValue(userNode.toString(), User.class);
		        LOGGER.info("您的账户信息为：{}", user);
		        
		        ///////将账户、联系人等信息放入map返回
		        msgMap.put("user", user);
		          
	        }else{
	        	
	        	
	        }
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return msgMap;
	}
	
	/**
	 * 同步检查，用以和服务器保持登录状态，同时检查是否有消息。
	 * 
	 * @param wxMeta
	 */
	public Map<String,String> syncCheck(WeChatMeta wxMeta){
		
		 long timestampLong = new Date().getTime();
	     int negaTimestampLong = ~(int)timestampLong;
	     Map<String,String> syncResult = new HashMap<>();
	     try{
	    	 
		    URL syncCheckUrl = new URL(Constant.SYNC_CHECK + "?r=" + timestampLong + "&skey=" + wxMeta.getSkey() 
		    								+ "&sid=" + wxMeta.getWxsid()+"&uin="+wxMeta.getWxuin() + "&deviceid=" 
		    								+ wxMeta.getDeviceId() + "&synckey=" + wxMeta.getSynckey() + "&_=" + negaTimestampLong);
				
		    System.out.println("请求的地址为："+syncCheckUrl);
		    LOGGER.debug("同步检测中，请求的地址为：{}", syncCheckUrl);
		    //使用openConnection获得URLConnection对象，转换成其子类HttpsURLConnection
		    HttpsURLConnection syncCheckHttpsConn = (HttpsURLConnection) syncCheckUrl.openConnection();
		    
	        //调用HttpsURLConnection的setRequestProperty方法设置Header Cookie
		    syncCheckHttpsConn.setRequestProperty("Cookie", wxMeta.getCookieString());
			
		    InputStream syncCheckIs = syncCheckHttpsConn.getInputStream();
			BufferedReader syncCheckBr = new BufferedReader(new InputStreamReader(syncCheckIs));
			StringBuffer syncCheckSb = new StringBuffer();
			String syncCheckLine = null;
			while((syncCheckLine = syncCheckBr.readLine()) != null)
				syncCheckSb.append(syncCheckLine);
			String syncCheckResult = syncCheckSb.toString(); 
			LOGGER.debug("同步检测中结果:{}", syncCheckResult);
			
			//同步结果分析
			//第一个参数即retcode值
			String retCode = syncCheckResult.split("=")[1].split(",")[0].split("\"")[1];
			String selector = syncCheckResult.split("=")[1].split(",")[1].split("\"")[1];
			LOGGER.debug("同步检测结果retCode={},selector={}.", retCode,selector);
			syncResult.put("retCode", retCode);
			syncResult.put("selector", selector);
			
	     }catch (IOException e) {
				// TODO: handle exception
	    	 e.printStackTrace();
	     }
		return syncResult;

	}
	
	/**
	 * 开启状态提箱
	 * @param wxMeta
	 * @param user
	 */
	public void statusNotify(WeChatMeta wxMeta, User user){
		long timestampLong = new Date().getTime();
		String postString = "{\"BaseRequest\":{"
				+ "\"DeviceID\":" + "\""+ wxMeta.getDeviceId() + "\","
				+ "\"Sid\":" + "\""+ wxMeta.getWxsid() + "\","
				+ "\"Skey\":" +"\""+ wxMeta.getSkey() + "\","
				+ "\"Uin\":" + "\""+ wxMeta.getWxuin() + "\""
				+ "},"
				+ "\"Code\":3, "
				+ "\"FromUserName\":" + "\"" + user.getUserName() + "\","
				+ "\"ToUserName\": " + "\"" + user.getUserName() + "\","
				+ "\"ClientMsgId\":" + timestampLong
				+ "}";
		LOGGER.debug("开启状态提醒,Post数据为：{}", postString);
		//创建一个httpclient
		CloseableHttpClient httpclient = HttpClients.createDefault();  
		//创建一个httppost,传入目标地址
		HttpPost httpPost = new HttpPost(Constant.STATUS_NOTUFY + "?lang=zh_CN" + "&pass_ticket" + wxMeta.getPassTicket());
		//
		HttpResponse resp = null;
		
		try {
			//将post字符串封装成StringEntity
			StringEntity stringEntity = new StringEntity(postString);
			//将stringEntity放入请求的body内
			httpPost.setEntity(stringEntity);
			
//			//cookie测试
//			CookieStore cookieStore = new BasicCookieStore();
//			cookieStore.addCookie(new BasicClientCookie("MM_WX_NOTIFY_STATE", "1")); 
//			cookieStore.addCookie(new BasicClientCookie("MM_WX_SOUND_STATE", "1")); 
//			cookieStore.addCookie(new BasicClientCookie("last_wxuin", "1549277641")); 
//			cookieStore.addCookie(new BasicClientCookie("login_frequency", "1")); 
//			cookieStore.addCookie(new BasicClientCookie("mm_lang", "zh_CN")); 
//			cookieStore.addCookie(new BasicClientCookie("pgv_pvi", "7859798016")); 
//			cookieStore.addCookie(new BasicClientCookie("pgv_si", "s5935848448")); 
//			cookieStore.addCookie(new BasicClientCookie("webwx_auth_ticket", "CIsBEI225UQagAERC+fWVuxNGE0nPqPtfM05NGPgkGpN08dIVH25Kg0TSurlykOy5dY4hecJiDRulir8HjIOxoWqSufqbixPQvhB1fwbIZEnBjKgbVP+e4AN3t370vguUbMkn5D4xuA5NV6V02KHCLHmTBPmaN4+uiW8y2CPuvRsc7lK1xWjUNjmhw==")); 
//			cookieStore.addCookie(new BasicClientCookie("webwx_data_ticket", "gSegCm2VZAGYaKPiNVzJmQdz")); 
//			cookieStore.addCookie(new BasicClientCookie("webwxuvid", "ed43ce477a43bbbe74eb9a2b7d0e47f023bc866ba6e91d63c65c2fd1404810a315e11c0939e146c60b3a635d119fcc72")); 
//			cookieStore.addCookie(new BasicClientCookie("wxloadtime", "1496743881")); 
//			cookieStore.addCookie(new BasicClientCookie("wxsid", "ZgGzovuAtPgdklZ6")); 
//			cookieStore.addCookie(new BasicClientCookie("wxuin", "1549277641")); 
//
//			System.out.println(cookieStore.getCookies());
//					
//					
//					
//					
//					
//					
//			CloseableHttpClient httpclient = HttpClients.custom()
//			        .setDefaultCookieStore(cookieStore).build();
//			System.out.println(httpclient.toString());
//			/////
			
			
			//将cookie加入请求头
			httpPost.addHeader("Cookie", wxMeta.getCookieString());
			System.out.println("===================");
			System.out.println(httpPost.getFirstHeader("Cookie"));
			//调用httpclient的excute方法执行请求,获得响应
			resp = httpclient.execute(httpPost);
			//获得响应的实体（body）
			HttpEntity respEntity = resp.getEntity();
			//使用EntityUtils的静态toString方法将HttpEntity转换成String
			String respString = EntityUtils.toString(respEntity);
			System.out.println(respString);
			
//			///cookie测试
//			
//			System.out.println(cookieStore.getCookies());
			
			
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/**
	 * 获取最新消息并更新synckey
	 * cookie未更新
	 * @param wxMeta
	 */
	public List<Message> getMessage(WeChatMeta wxMeta){
		List<Message> msgList = new ArrayList<>();
		long timestampLong = new Date().getTime();
	    int negaTimestampLong = ~(int)timestampLong;
		String postString = "{\"BaseRequest\":{"
				+ "\"DeviceID\":" + "\""+ wxMeta.getDeviceId() + "\","
				+ "\"Sid\":" + "\""+ wxMeta.getWxsid() + "\","
				+ "\"Skey\":" +"\""+ wxMeta.getSkey() + "\","
				+ "\"Uin\":" + "\""+ wxMeta.getWxuin() + "\""
				+ "},"
				+ "\"SyncKey\":" + wxMeta.getSyncKeyNode() + ","
				+ "\"rr\":" + negaTimestampLong
				+ "}";
		LOGGER.debug("获取最新消息，POST参数为：{}", postString);		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(Constant.WX_SYNC + "?sid=" + wxMeta.getWxsid() 
				+ "&skey=" + wxMeta.getSkey() + "&lang=zh_CN" + "&pass_ticket=" + wxMeta.getPassTicket());
		LOGGER.debug("获取最新消息，请求地址为：{}", httpPost.getURI());
		
		HttpResponse resp = null;
		try {
			StringEntity stringEntity = new StringEntity(postString);
			httpPost.setEntity(stringEntity);
			httpPost.addHeader("Cookie", wxMeta.getCookieString());
			
			resp = httpClient.execute(httpPost);
			//获得响应的实体（body）
			HttpEntity respEntity = resp.getEntity();
			//使用EntityUtils的静态toString方法将HttpEntity转换成String,编码方式为utf-8
			String respString = EntityUtils.toString(respEntity,"UTF-8");
			LOGGER.debug("获取最新消息，响应为：{}", respString);
			
			//分析返回的Json-包含联系人等信息、本人账户等
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode node = mapper.readTree(respString);
	        //判断Ret值，0表示成功，1表示失败
	        String ret = node.get("BaseResponse").get("Ret").asText();
	        if(ret == "0"){
	        	
	        	LOGGER.debug("消息获取成功！！");
	        	
	        	//获取SyncKey，用以后续获取最新消息等用途。其会不断更新。
	        	//syncKeyNode JsonNode类型,获取最新消息时使用。（需要post SyncKey段json）
		        JsonNode syncKeyNode = node.get("SyncKey");
		        wxMeta.setSyncKeyNode(syncKeyNode);
		        LOGGER.debug("获取的SyncKey节点：{}", syncKeyNode);
		        //将syncKeyNode节点转换成特定的kv字符串，用以消息检查（同步检测）时GET使用
		        JsonNode syncKeyKVNode = syncKeyNode.get("List");
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < syncKeyKVNode.size(); i++){
		        	JsonNode node1 = syncKeyKVNode.get(i);
		        	sb.append(("|"+node1.get("Key")+"_"+node1.get("Val")));
		        }
		        String sbString = sb.toString().substring(1);
		        wxMeta.setSynckey(sbString);
		        LOGGER.debug("SyncKey节点KV字符串：{}", sbString);
		        
		        //消息分析
		        //消息条数
		        String msgsNum = node.get("AddMsgCount").asText();
		        if(msgsNum != "0"){
		        	LOGGER.debug("获取到:{}条信息", msgsNum);
		        	JsonNode msgListNode = node.get("AddMsgList");
		        	for(int i = 0; i < msgListNode.size(); i++){
		        		System.out.println(msgListNode.get(i));
		        		Message msg = mapper.readValue(msgListNode.get(i).toString(), Message.class);
		        		System.out.println(msg);
		        		msgList.add(msg);
		        	}
		        }
	        }
	        
	        
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return msgList;
	
	}
	
	/**
	 * 发送文本消息
	 * 
	 */
	public void sendMsg(WeChatMeta wxMeta,User user,String content,String toUserName){
		//产生4位随机数
		Random rm = new Random();
		int min = 1000;
		int max = 9999;
		int result = rm.nextInt()%(max-min+1) + min;
		//clientMsgId=时间戳+4位随机数
		String clientMsgId = new Date().getTime() + "" + result ;

	    //创建jsonnode
	    ObjectMapper mapper = new ObjectMapper();
		ObjectNode rootNode = mapper.createObjectNode();
		ObjectNode node0 = mapper.createObjectNode();
		ObjectNode node1 = mapper.createObjectNode();		
		//设置BaseRequest节点	
		node0.put("DeviceID", wxMeta.getDeviceId() );
		node0.put("Sid", wxMeta.getWxsid());
		node0.put("Skey", wxMeta.getSkey());
		node0.put("Uin:xxx", wxMeta.getWxuin());
		//设置Msg节点
		node1.put("ClientMsgId", clientMsgId);
		node1.put("Content", content);
		node1.put("FromUserName",user.getUserName() );
		node1.put("LocalID", clientMsgId);
		node1.put("ToUserName", toUserName);
		node1.put("Type", 1);
			
		rootNode.put("BaseRequest",node0);
		rootNode.put("Msg",node1);
		rootNode.put("Scene",0);
		System.out.println(rootNode);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(Constant.sendMsg + "?lang=zh_CN" + "&pass_ticket=" + wxMeta.getPassTicket());
		LOGGER.debug("发送消息，请求地址为：{}", httpPost.getURI());
		
		HttpResponse resp = null;
		try {
			//解决发送信息乱码
			StringEntity stringEntity = new StringEntity(rootNode.toString(),"UTF-8");
			
			httpPost.addHeader("Cookie", wxMeta.getCookieString());
			httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
			httpPost.setEntity(stringEntity);
			
			resp = httpClient.execute(httpPost);
			//获得响应的实体（body）
			HttpEntity respEntity = resp.getEntity();
			//使用EntityUtils的静态toString方法将HttpEntity转换成String,编码方式为utf-8
			String respString = EntityUtils.toString(respEntity,"UTF-8");
			LOGGER.debug("请求响应为：{}", respString);
			
			//分析返回的Json
	        mapper = new ObjectMapper();
	        JsonNode node = mapper.readTree(respString);
	        //判断Ret值，0表示成功，1表示失败
	        String ret = node.get("BaseResponse").get("Ret").asText();
	        if(ret == "0"){
	        	
	        	LOGGER.debug("发送成功！！");
	        	
	        }else {
	        	
	        	LOGGER.debug("发送失败！！");
	        }
	        
	        
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 获取撤回消息
	 */
	public void getRevokeMsg(){
		
	}
}
