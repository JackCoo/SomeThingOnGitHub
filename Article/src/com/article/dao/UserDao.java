package com.article.dao;

import com.article.model.User;
import com.article.util.DButil;

public class UserDao {
/**
 * 查询用户
 * 根据用户名查询，返回User对象
 * 
 * @param userName
 * @return user
 */
	public User queryUser(String userName){
		
		String sql = "select * from user where user_name = ?";
		User user = new DButil().queryToBean(sql, User.class,userName);
		return user;
	}
}
