package org.fkit.service;

import java.util.List;

import org.fkit.model.User;

/**
 * User服务层接口
 * */
public interface UserService {
	
	/**
	 * 判断用户登录
	 * @param String loginname
	 * @param String password
	 * @return 找到返回User对象，没有找到返回null
	 * */
	User login(String loginname,String password);
	List<User> getAllUser();
	
	//根据token查找用户
	User getUserByToken(String token);
}
