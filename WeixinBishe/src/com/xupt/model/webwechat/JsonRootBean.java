/**
  * Copyright 2017 bejson.com 
  */
package com.xupt.model.webwechat;
import java.util.List;

/**
 * Auto-generated: 2017-06-05 13:46:23
 * 
 *	微信初始化webwxinit返回数据类
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

	private BaseResponse baseResponse;
    private int Count;//
    private List<ContactList> ContactList;//联系人列表
    private SyncKey SyncKey;
    private User User;
    private String ChatSet;
    private String SKey;
    private int ClientVersion;
    private int SystemTime;
    private int GrayScale;
    private int InviteStartCount;
    private int MPSubscribeMsgCount;
    private List<MPSubscribeMsgList> MPSubscribeMsgList;
    private int ClickReportInterval;
    public void setBaseResponse(BaseResponse BaseResponse) {
         this.baseResponse = BaseResponse;
     }
     public BaseResponse getBaseResponse() {
         return baseResponse;
     }

    public void setCount(int Count) {
         this.Count = Count;
     }
     public int getCount() {
         return Count;
     }

    public void setContactList(List<ContactList> ContactList) {
         this.ContactList = ContactList;
     }
     public List<ContactList> getContactList() {
         return ContactList;
     }

    public void setSyncKey(SyncKey SyncKey) {
         this.SyncKey = SyncKey;
     }
     public SyncKey getSyncKey() {
         return SyncKey;
     }

    public void setUser(User User) {
         this.User = User;
     }
     public User getUser() {
         return User;
     }

    public void setChatSet(String ChatSet) {
         this.ChatSet = ChatSet;
     }
     public String getChatSet() {
         return ChatSet;
     }

    public void setSKey(String SKey) {
         this.SKey = SKey;
     }
     public String getSKey() {
         return SKey;
     }

    public void setClientVersion(int ClientVersion) {
         this.ClientVersion = ClientVersion;
     }
     public int getClientVersion() {
         return ClientVersion;
     }

    public void setSystemTime(int SystemTime) {
         this.SystemTime = SystemTime;
     }
     public int getSystemTime() {
         return SystemTime;
     }

    public void setGrayScale(int GrayScale) {
         this.GrayScale = GrayScale;
     }
     public int getGrayScale() {
         return GrayScale;
     }

    public void setInviteStartCount(int InviteStartCount) {
         this.InviteStartCount = InviteStartCount;
     }
     public int getInviteStartCount() {
         return InviteStartCount;
     }

    public void setMPSubscribeMsgCount(int MPSubscribeMsgCount) {
         this.MPSubscribeMsgCount = MPSubscribeMsgCount;
     }
     public int getMPSubscribeMsgCount() {
         return MPSubscribeMsgCount;
     }

    public void setMPSubscribeMsgList(List<MPSubscribeMsgList> MPSubscribeMsgList) {
         this.MPSubscribeMsgList = MPSubscribeMsgList;
     }
     public List<MPSubscribeMsgList> getMPSubscribeMsgList() {
         return MPSubscribeMsgList;
     }

    public void setClickReportInterval(int ClickReportInterval) {
         this.ClickReportInterval = ClickReportInterval;
     }
     public int getClickReportInterval() {
         return ClickReportInterval;
     }
	@Override
	public String toString() {
		return "JsonRootBean [BaseResponse=" + baseResponse + ", Count=" + Count + ", ContactList=" + ContactList
				+ ", SyncKey=" + SyncKey + ", User=" + User + ", ChatSet=" + ChatSet + ", SKey=" + SKey
				+ ", ClientVersion=" + ClientVersion + ", SystemTime=" + SystemTime + ", GrayScale=" + GrayScale
				+ ", InviteStartCount=" + InviteStartCount + ", MPSubscribeMsgCount=" + MPSubscribeMsgCount
				+ ", MPSubscribeMsgList=" + MPSubscribeMsgList + ", ClickReportInterval=" + ClickReportInterval + "]";
	}

}