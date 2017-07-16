package com.one.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.tools.ant.taskdefs.Sleep;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.util.XMLUtil;
import com.xupt.model.webwechat.JsonRootBean;
import com.xupt.model.webwechat.WeChatMeta;

import net.sf.json.JSONArray;
/**
 * 
 * 可能出问题的地方：
 * 		1.未使用HTTPS
 * @author C4y
 *
 */
public class WeChatMain {

	public static void main (String[] args) {
		try {
			
			///test
			
			/////
			
			
			//1.获取UUID
			//创建当前时间戳
			String timestamp = String.valueOf(new Date().getTime());
			//创建一个URL实例
			URL weChatUrl = new URL("http://login.weixin.qq.com/jslogin?appid=wx782c26e4c19acffb&fun=new&lang=zh_CN&_="+timestamp);
			System.out.println("请求的地址为："+weChatUrl);
			//System.out.println((String)weChatUrl.getContent());
		
			//通过openStream方法获取URL所表示资源的字节输入流
			InputStream  is = weChatUrl.openStream();
			//将字节输入流转换成自负输入流
			InputStreamReader isr = new InputStreamReader(is);
			//将字节流加入缓冲
			BufferedReader br = new BufferedReader(isr);
			//读取数据
			String uuidResult = br.readLine();
			System.out.println("返回结果："+uuidResult);
			String uuid = uuidResult.substring(50, 62);
			System.out.println("UUID:"+uuid);
			
//			WebWeChat weChat = new WebWeChat();
//			String uuid = weChat.getUuid();
			
			//2.根据UUID获取二维码
			//2.1获取图片输入流
			URL qrUrl = new URL("http://login.weixin.qq.com/qrcode/"+uuid);
			System.out.println("二维码请求地址："+qrUrl);
			InputStream qrIs = qrUrl.openStream();
			
			//2.2保存图片
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
	        System.out.println("保存成功！");
			
			//weChat.getQr();
			
	        //3.等待扫描
	        String windoesCode = "408";//未扫描
	        String picUrl = null;
	        String redirectUrl = null;
	        
	        while(!windoesCode.equalsIgnoreCase("200")){//利用equal方法比较，而不是!=;
	        	//System.out.println("----------------"+windoesCode);
		        long timestampLong = new Date().getTime();
		        //时间戳取反--模拟JS取反：现将数据转换成32位有符号int，然后取反。
		        int negaTimestampLong = ~(int)timestampLong;
				URL scanUrl = new URL("http://login.weixin.qq.com/cgi-bin/mmwebwx-bin/login?loginicon=true&uuid="+uuid+"&tip=1&r="+negaTimestampLong+"&_="+timestampLong);
	//			
	//			HttpURLConnection scanHttpUrl = (HttpURLConnection)scanUrl.openConnection();
	//			scanHttpUrl.setConnectTimeout(5*1000);
				System.out.println("等待扫描请求地址："+scanUrl);
				InputStream scanIs = scanUrl.openStream();
				InputStreamReader scanisr = new InputStreamReader(scanIs);
				BufferedReader scanbr = new BufferedReader(scanisr);
				StringBuffer scanResultSb = new StringBuffer();
				String line;
				//循环读取所有行
				while((line = scanbr.readLine()) != null)
					scanResultSb.append(line);
				String scanResult = scanResultSb.toString();
				System.out.println("返回结果："+scanResult);
				windoesCode = scanResult.substring(12, 15);
				System.out.println("状态码Windows.Code："+windoesCode);
				//延时2秒
				Thread.sleep(2000);
				//依据状态码执行相应操作
				switch(windoesCode){
					//已扫描
					case "201":
						//提取头像地址
						picUrl = scanResult.split("'")[1];
						System.out.println("头像地址："+picUrl);
						break;
					//已点击登录
					case "200":
						redirectUrl = scanResult.split("\"")[1];
						System.out.println("跳转地址："+redirectUrl);
						break;
				}
		        	
	        }

			/*  使用https */
			//4.获取登录参数（uin、skey、sid、pass_ticket）
	        URL paraUrl = new URL(redirectUrl+"&fun=new&version=v2");
	        //使用openConnection获得URLConnection对象，转换成其子类HttpsURLConnection
	        HttpsURLConnection paraHttpsConn = (HttpsURLConnection) paraUrl.openConnection();
	        
	        String cookie = paraHttpsConn.getHeaderField("Cookie");
	        System.out.println(cookie);
	        
			InputStream paraIs = paraHttpsConn.getInputStream();
			InputStreamReader paraIsr = new InputStreamReader(paraIs);
			BufferedReader paraBr = new BufferedReader(paraIsr);
			StringBuffer paraResultSb = new StringBuffer();
			String line = null;
			
			while((line = paraBr.readLine()) != null){
				paraResultSb.append(line);
			}
			String paraResult = paraResultSb.toString();
			System.out.println(paraResult);
			WeChatMeta initPara = (WeChatMeta) XMLUtil.convertXmlStrToObject(WeChatMeta.class, paraResult);
			System.out.println("登录参数对象为：" + initPara);
			
			
			//5.微信初始化
			//5.1产生DeviceID：e+15位随机数
			//利用nextDouble产生0.0-1.0之间的17位随机数（小数点后）
			double ranDou = new Random().nextDouble();
			
			/////////////////////////////////////////随机数
	        long timestampLong = new Date().getTime();
	        //时间戳取反--模拟JS取反：现将数据转换成32位有符号int，然后取反。
	        int negaTimestampLong = ~(int)timestampLong;
			String deviceID = "e595214896258954";
			String postString = "{\"BaseRequest\":{"
					+ "\"DeviceID\":" + "\""+ deviceID + "\","
					+ "\"Sid\":" + "\""+ initPara.getWxsid() + "\","
					+ "\"Skey\":" +"\""+ initPara.getSkey() + "\","
					+ "\"Uin\":" + "\""+ initPara.getWxuin() + "\""
					+ "}}";
			System.out.println("Post数据为："+postString);
			URL initUrl = new URL("https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxinit?r="+negaTimestampLong+"&lang=zh_CN&pass_ticket="+initPara.getPassTicket());
			System.out.println("请求的地址为："+initUrl);
	        //使用openConnection获得URLConnection对象，转换成其子类HttpsURLConnection
	        HttpsURLConnection initHttpsConn = (HttpsURLConnection) initUrl.openConnection();
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
	        
	        //////////Json 转对象 过于冗杂
	        
//	        ObjectMapper mapper = new ObjectMapper();
//	        //JsonRootBean jb = mapper.readValue(initResult, JsonRootBean.class);
//	        //System.out.println(jb);
//	        JsonNode jsonNode = mapper.readTree(initResult);
//	        System.out.println(jsonNode.get("SyncKey"));
	        ///
	        

	        //6.消息检查（登录保持）
	        long timestampLong2 = new Date().getTime();
	        int negaTimestampLong2 = ~(int)timestampLong;
	        
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode node = mapper.readTree(initResult);
	        JsonNode syncKeyNode = node.findValue("SyncKey");
	        JsonNode  syncKeyListNode = syncKeyNode.get("List");
	        System.out.println(syncKeyNode);
	        
	        System.out.println(syncKeyListNode);
	        
	        JsonNode syncKeyKVNode = syncKeyListNode.get(0);
	        
	        System.out.println(syncKeyKVNode);
	        
	        JsonNode node1 = syncKeyKVNode.findValue("Key");
	        
	        System.out.println(node1);
	        
	        StringBuffer sb = new StringBuffer();
	        
	        for (int i = 0; i < 4; i++){
	        	JsonNode syncKeyKVNode2 = syncKeyListNode.get(i);
	        	sb.append(("|"+syncKeyKVNode2.get("Key")+"_"+syncKeyKVNode2.get("Val")));
	        }
	        String sbString = sb.toString().substring(1);
	        System.out.println(sbString);
	        
	        URL syncCheckUrl = new URL("https://webpush.wx.qq.com/cgi-bin/mmwebwx-bin/synccheck"+"?r="+timestampLong2+"&skey="+initPara.getSkey()+"&sid="+initPara.getWxsid()+"&uin="+initPara.getWxuin()+"&deviceid="+deviceID+"&synckey="+sbString+"&_="+negaTimestampLong2);
			
	        System.out.println("请求的地址为："+syncCheckUrl);
	        //使用openConnection获得URLConnection对象，转换成其子类HttpsURLConnection
	        HttpsURLConnection syncCheckHttpsConn = (HttpsURLConnection) syncCheckUrl.openConnection();
	        InputStream syncCheckIs = syncCheckHttpsConn.getInputStream();
	        BufferedReader syncCheckBr = new BufferedReader(new InputStreamReader(syncCheckIs));
	        StringBuffer syncCheckSb = new StringBuffer();
	        String syncCheckLine = null;
	        while((syncCheckLine = syncCheckBr.readLine()) != null)
	        	syncCheckSb.append(syncCheckLine);
	        String syncCheckResult = syncCheckSb.toString();
	        System.out.println(syncCheckResult);
	        
	        
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	
}
