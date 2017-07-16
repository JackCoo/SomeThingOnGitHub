package com.one.util;

import java.util.Date;

/**
 * 
 * 时间戳工具集
 * 
 * @author C4y
 *
 */
public class Time {

	/* 返回当前时间戳字符串 */
	public String getTimeStamp(){
		
		String timestamp = String.valueOf(new Date().getTime());
		return timestamp;
		
	}
	
	public String getNegaTimeStamp(){
		return null;
		
		
	}
}
