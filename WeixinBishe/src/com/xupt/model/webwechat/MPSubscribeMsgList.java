/**
  * Copyright 2017 bejson.com 
  */
package com.xupt.model.webwechat;
import java.util.List;

/**
 * Auto-generated: 2017-06-05 13:46:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MPSubscribeMsgList {

    private String UserName;
    private int MPArticleCount;
    private List<MPArticleList> MPArticleList;
    private int Time;
    private String NickName;
    public void setUserName(String UserName) {
         this.UserName = UserName;
     }
     public String getUserName() {
         return UserName;
     }

    public void setMPArticleCount(int MPArticleCount) {
         this.MPArticleCount = MPArticleCount;
     }
     public int getMPArticleCount() {
         return MPArticleCount;
     }

    public void setMPArticleList(List<MPArticleList> MPArticleList) {
         this.MPArticleList = MPArticleList;
     }
     public List<MPArticleList> getMPArticleList() {
         return MPArticleList;
     }

    public void setTime(int Time) {
         this.Time = Time;
     }
     public int getTime() {
         return Time;
     }

    public void setNickName(String NickName) {
         this.NickName = NickName;
     }
     public String getNickName() {
         return NickName;
     }

}