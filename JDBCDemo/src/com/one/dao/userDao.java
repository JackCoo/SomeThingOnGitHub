package com.one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.one.db.DBUtil;
import com.one.model.User;

public class userDao {
/**
 * 添加用户
 * @param user
 * @throws Exception
 */
	public void addUser(User user) throws Exception{
		//拼接，sql语句前加空格
		String sql = " insert into user"+
							 " (UserName,PassWord)"+
							 " value("+
							 " ?,?)";
		//获取数据库连接
		Connection conn = DBUtil.getConnection();
		//创建prepareStatement对象
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//使用setXXX方法为i个参数？赋值
		ptmt.setString(1, user.getUserName());
		ptmt.setString(2, user.getPassWord());
		
		ptmt.executeUpdate();
	}	
	
/**
 * 
 * 根据用户名查询用户是否已存在
 * @param user
 * @throws Exception
 */
	public boolean findUser(User user) throws Exception{
		
		String sql = " select UserName"+
				     " from user where"+
				     " UserName = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, user.getUserName());
		
		ResultSet rs = ptmt.executeQuery();
		//nest方法判断结果集是否为空
		return rs.next();		

	}
}
