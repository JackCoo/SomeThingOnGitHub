/**
  * Copyright 2017 bejson.com 
  */
package com.xupt.model.webwechat;
/**
 * Auto-generated: 2017-06-05 13:46:23
 * 
 *	错误信息类
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BaseResponse {

    private int Ret;//0:表示成功
    private String ErrMsg;
    public void setRet(int Ret) {
         this.Ret = Ret;
     }
     public int getRet() {
         return Ret;
     }

    public void setErrMsg(String ErrMsg) {
         this.ErrMsg = ErrMsg;
     }
     public String getErrMsg() {
         return ErrMsg;
     }

}