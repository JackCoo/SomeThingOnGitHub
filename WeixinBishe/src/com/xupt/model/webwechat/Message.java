package com.xupt.model.webwechat;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息类
 * 装载微信返回的最新消息
 * 
 * @author C4y
 *
 */
public class Message {

	@JsonProperty("MsgId")
	private String msgId;
	@JsonProperty("FromUserName")
	private String FromUserName;
	@JsonProperty("ToUserName")
	private String ToUserName;
	@JsonProperty("MsgType")
	private int MsgType;
	@JsonProperty("Content")
	private String Content;//消息内容
	@JsonProperty("Status")
	private int Status;
	@JsonProperty("ImgStatus")
	private int ImgStatus;
	@JsonProperty("CreateTime")
	private int CreateTime;
	@JsonProperty("VoiceLength")
	private int VoiceLength;
	@JsonProperty("PlayLength")
	private int PlayLength;
	@JsonProperty("FileName")
	private String FileName;
	@JsonProperty("FileSize")
	private String FileSize;
	@JsonProperty("MediaId")
	private String MediaId;
	@JsonProperty("Url")
	private String Url;
	@JsonProperty("AppMsgType")
	private int AppMsgType;
	@JsonProperty("StatusNotifyCode")
	private int StatusNotifyCode;
	@JsonProperty("StatusNotifyUserName")
	private String StatusNotifyUserName;
	@JsonProperty("RecommendInfo")
	private RecommendInfo RecommendInfo;
	@JsonProperty("ForwardFlag")
	private int ForwardFlag;
	@JsonProperty("AppInfo")
	private AppInfo AppInfo;
	@JsonProperty("HasProductId")
	private int HasProductId;
	@JsonProperty("Ticket")
	private String Ticket;
	@JsonProperty("ImgHeight")
	private int ImgHeight;
	@JsonProperty("ImgWidth")
	private int ImgWidth;
	@JsonProperty("SubMsgType")
	private int SubMsgType;
	@JsonProperty("NewMsgId")
	private long NewMsgId;
	@JsonProperty("OriContent")
	private String OriContent;
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public int getMsgType() {
		return MsgType;
	}
	public void setMsgType(int msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getImgStatus() {
		return ImgStatus;
	}
	public void setImgStatus(int imgStatus) {
		ImgStatus = imgStatus;
	}
	public int getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(int createTime) {
		CreateTime = createTime;
	}
	public int getVoiceLength() {
		return VoiceLength;
	}
	public void setVoiceLength(int voiceLength) {
		VoiceLength = voiceLength;
	}
	public int getPlayLength() {
		return PlayLength;
	}
	public void setPlayLength(int playLength) {
		PlayLength = playLength;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileSize() {
		return FileSize;
	}
	public void setFileSize(String fileSize) {
		FileSize = fileSize;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public int getAppMsgType() {
		return AppMsgType;
	}
	public void setAppMsgType(int appMsgType) {
		AppMsgType = appMsgType;
	}
	public int getStatusNotifyCode() {
		return StatusNotifyCode;
	}
	public void setStatusNotifyCode(int statusNotifyCode) {
		StatusNotifyCode = statusNotifyCode;
	}
	public String getStatusNotifyUserName() {
		return StatusNotifyUserName;
	}
	public void setStatusNotifyUserName(String statusNotifyUserName) {
		StatusNotifyUserName = statusNotifyUserName;
	}
	public int getForwardFlag() {
		return ForwardFlag;
	}
	public void setForwardFlag(int forwardFlag) {
		ForwardFlag = forwardFlag;
	}
	public int getHasProductId() {
		return HasProductId;
	}
	public void setHasProductId(int hasProductId) {
		HasProductId = hasProductId;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	public int getImgHeight() {
		return ImgHeight;
	}
	public void setImgHeight(int imgHeight) {
		ImgHeight = imgHeight;
	}
	public int getImgWidth() {
		return ImgWidth;
	}
	public void setImgWidth(int imgWidth) {
		ImgWidth = imgWidth;
	}
	public int getSubMsgType() {
		return SubMsgType;
	}
	public void setSubMsgType(int subMsgType) {
		SubMsgType = subMsgType;
	}
	public long getNewMsgId() {
		return NewMsgId;
	}
	public void setNewMsgId(long newMsgId) {
		NewMsgId = newMsgId;
	}
	public String getOriContent() {
		return OriContent;
	}
	public void setOriContent(String oriContent) {
		OriContent = oriContent;
	}
	public RecommendInfo getRecommendInfo() {
		return RecommendInfo;
	}
	public void setRecommendInfo(RecommendInfo recommendInfo) {
		RecommendInfo = recommendInfo;
	}
	public AppInfo getAppInfo() {
		return AppInfo;
	}
	public void setAppInfo(AppInfo appInfo) {
		AppInfo = appInfo;
	}
	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", FromUserName=" + FromUserName + ", ToUserName=" + ToUserName
				+ ", MsgType=" + MsgType + ", Content=" + Content + ", Status=" + Status + ", ImgStatus=" + ImgStatus
				+ ", CreateTime=" + CreateTime + ", VoiceLength=" + VoiceLength + ", PlayLength=" + PlayLength
				+ ", FileName=" + FileName + ", FileSize=" + FileSize + ", MediaId=" + MediaId + ", Url=" + Url
				+ ", AppMsgType=" + AppMsgType + ", StatusNotifyCode=" + StatusNotifyCode + ", StatusNotifyUserName="
				+ StatusNotifyUserName + ", RecommendInfo=" + RecommendInfo + ", ForwardFlag=" + ForwardFlag
				+ ", AppInfo=" + AppInfo + ", HasProductId=" + HasProductId + ", Ticket=" + Ticket + ", ImgHeight="
				+ ImgHeight + ", ImgWidth=" + ImgWidth + ", SubMsgType=" + SubMsgType + ", NewMsgId=" + NewMsgId
				+ ", OriContent=" + OriContent + "]";
	}
	
	
	
	
}
