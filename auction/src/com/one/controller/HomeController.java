package com.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;;
/**
 * 主页控制器
 * 处理“/”的请求
 * 
 * @Controller：注明这是一个控制器组件类
 * @RequestMapping：映射
 * 		value="xxx","xxx"...：该方法映射多个URL路径
 * 		method=RequestMethod.GET,请求方式
 * @author C4y
 *
 */
@Controller //声明为一个控制器,基于Component注解，因而会被声明到Spring上下文中。
public class HomeController {

	@RequestMapping(value="/",method=RequestMethod.GET) //处理对“/”的GET请求
	public String home(){
		//“home”会被SpringMVC解读为视图名，DispatcherServlet会要求视图解析器将逻辑名转换成实际的视图。——即WEB-INF/Views/home.jsp
		return "home";//返回视图名
	}
}
