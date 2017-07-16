package com.three;

import java.util.ArrayList;
import java.util.List;

public class CheckUtil {
	
	private static final String TOKEN = "wechat";
	
	public static boolean CheckSignature(String signature,String timestamp,String nonce){
		
		List<String> list= new ArrayList<String>();
		list.add(nonce);
		list.add(timestamp);
		list.add(TOKEN);
		list.sort();
		return null;
	}
}
