package com.xupt.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * SpringMVC 接收XML并转换成java对象
 * 注意：
 * 	1.@XmlRootElement(name="xml")，注解及其name属性必须。
 * 	2.@(name="ToUserName"),必须
 * @author C4y
 *
 */
@XmlRootElement(name="xml")
public class ReqMessage {
	private String toUserName;
	private String fromUserName;
	private String content;
	private String msgType;
	private String event;
	private String eventType;
	private String eventKey;
	private String ticket;
	private String latitude;
	private String longitude;
	private String precision;
	private String picUrl;
	private String mediaId;
	private String msgId;
	private String format;
	private String recognition;
	private String msgID;
	private String thumbMediaId;
	private String locationX;
	private String locationY;
	private String label;
	private String title;
	private String scale;
	private String description;
	private String url;
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	@XmlElement(name="Content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	@XmlElement(name="Event")
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	@XmlElement(name="EventKey")
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	@XmlElement(name="Ticket")
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	@XmlElement(name="Latitude")
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@XmlElement(name="Longitude")
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@XmlElement(name="Precision")
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	@XmlElement(name="PicUrl")
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	@XmlElement(name="MsgId")
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	@XmlElement(name="Format")
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	@XmlElement(name="Recognition")
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	@XmlElement(name="MsgID")
	public String getMsgID() {
		return msgID;
	}
	public void setMsgID(String msgID) {
		this.msgID = msgID;
	}
	@XmlElement(name="ThumbMediaId")
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	@XmlElement(name="Label")
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@XmlElement(name="Title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name="Scale")
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	@XmlElement(name="Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement(name="Url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@XmlElement(name="eventType")
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	@XmlElement(name="Location_X")
	public String getLocationX() {
		return locationX;
	}
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}
	@XmlElement(name="Location_Y")
	public String getLocationY() {
		return locationY;
	}
	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}
	@Override
	public String toString() {
		return "ReqMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", content=" + content
				+ ", msgType=" + msgType + ", event=" + event + ", eventKey=" + eventKey + ", ticket=" + ticket
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", precision=" + precision + ", picUrl="
				+ picUrl + ", mediaId=" + mediaId + ", msgId=" + msgId + ", format=" + format + ", recognition="
				+ recognition + ", msgID=" + msgID + ", thumbMediaId=" + thumbMediaId + ", location_X=" + locationX
				+ ", location_Y=" + locationY + ", label=" + label + ", title=" + title + ", scale=" + scale
				+ ", description=" + description + ", url=" + url + "]";
	}
	
	
	

	
	
}
