package com.article.service;

import java.util.HashMap;
import java.util.Map;

import com.article.dao.UserDao;
import com.article.model.User;

public class LoginService {
	
	public Map<String, String> login(String userName,String password){
		
		//返回的map，包含错误码和部分user信息
		Map<String, String> loginMessage = new HashMap<>();
		UserDao ud = new UserDao();
		User u = ud.queryUser(userName);
		System.out.println("LoginService.login--"+u);
		
		//判断输入的用户密码及数据库查询结果
		if(userName==null || password==null){
			loginMessage.put("errorCode", "-1");//错误码-1 : 用户名和密码不能为空！
		}else if(u.getUserName() == null || u.getIsDel() ==1){
			loginMessage.put("errorCode", "-2");;//错误代码-2：用户不存在或者被删除。
		}else if(!u.getPassword().equals(password)){
			//System.out.println(u.getPassword()+"  " +password);
			loginMessage.put("errorCode", "-3");;//错误代码-3：密码错误。
		}else{
			loginMessage.put("errorCode", "1");//错误代码1：登陆成功
			loginMessage.put("userName", u.getUserName());
			loginMessage.put("headPic", u.getHeadPic());
		}
		return loginMessage;
	}	
}
