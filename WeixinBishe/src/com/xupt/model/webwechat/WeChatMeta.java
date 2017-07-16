package com.xupt.model.webwechat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.client.CookieStore;

import com.fasterxml.jackson.databind.JsonNode;
/**
 * 
 * 微信登录、获取消息等操作所需的数据
 * @author C4y
 *
 */
@XmlRootElement(name="error")
public class WeChatMeta {
	
	private String ret;
	private String message;
	private String wxsid;
	private String wxuin;
	private String passTicket;
	private String isgrayscale;
	private String skey;
	
	private String uuid;
	private String synckey;
	private String deviceId;
	private JsonNode syncKeyNode;

	//private CookieStore cookieStore;
	
	private String cookieString;
	
	public String getCookieString() {
		return cookieString;
	}

	public void setCookieString(String cookieString) {
		this.cookieString = cookieString;
	}

//	public CookieStore getCookieStore() {
//		return cookieStore;
//	}
//
//	public void setCookieStore(CookieStore cookieStore) {
//		this.cookieStore = cookieStore;
//	}

	public WeChatMeta() {
		deviceId = "e" + "526987125698514";
	}
	
	public JsonNode getSyncKeyNode() {
		return syncKeyNode;
	}

	public void setSyncKeyNode(JsonNode syncKeyNode) {
		this.syncKeyNode = syncKeyNode;
	}

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getSynckey() {
		return synckey;
	}
	public void setSynckey(String synckey) {
		this.synckey = synckey;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	@XmlElement(name = "skey")
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
	@XmlElement(name = "ret")
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	@XmlElement(name = "message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@XmlElement(name = "wxsid")
	public String getWxsid() {
		return wxsid;
	}
	public void setWxsid(String wxsid) {
		this.wxsid = wxsid;
	}
	@XmlElement(name = "wxuin")
	public String getWxuin() {
		return wxuin;
	}
	public void setWxuin(String wxuin) {
		this.wxuin = wxuin;
	}
	@XmlElement(name = "pass_ticket")
	public String getPassTicket() {
		return passTicket;
	}
	public void setPassTicket(String passTicket) {
		this.passTicket = passTicket;
	}
	@XmlElement(name = "isgrayscale")
	public String getIsgrayscale() {
		return isgrayscale;
	}
	public void setIsgrayscale(String isgrayscale) {
		this.isgrayscale = isgrayscale;
	}
	@Override
	public String toString() {
		return "WeChatMeta [ret=" + ret + ", message=" + message + ", wxsid=" + wxsid + ", wxuin=" + wxuin
				+ ", passTicket=" + passTicket + ", isgrayscale=" + isgrayscale + ", skey=" + skey + ", uuid=" + uuid
				+ ", synckey=" + synckey + ", deviceId=" + deviceId + ", syncKeyNode=" + syncKeyNode + ", cookieString="
				+ cookieString + "]";
	}
	
	
}
