package com.one.http;
/**
 * 
 * 常量
 * 
 * @author C4y
 *
 */
public class Constant {
	
	public static final String JS_LOGIN = "http://login.weixin.qq.com/jslogin?appid=wx782c26e4c19acffb&fun=new&lang=zh_CN";
	public static final String QR = "http://login.weixin.qq.com/qrcode/";
	public static final String LOGIN= "http://login.weixin.qq.com/cgi-bin/mmwebwx-bin/login?loginicon=true";
	//等待扫描二维码重试次数
	public static final int SCAN_WAIT_TIME = 10;
	public static final String INIT = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxinit";
	public static final String SYNC_CHECK = "https://webpush.wx.qq.com/cgi-bin/mmwebwx-bin/synccheck";
	
	public static final String STATUS_NOTUFY = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxstatusnotify";
	
	public static final String WX_SYNC = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxsync";
	
	public static final String sendMsg = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxsendmsg";
	
}
