package com.one.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//创建上下文——加载xml配置文件，处理创建并初始化所有对象。
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//利用context对象的getBean方法获取所需bean。
		Hello he = (Hello)context.getBean("hello");
		//执行bean的方法
		he.getMsg();
		
	}

}
