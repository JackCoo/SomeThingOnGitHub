package com.one.initdestoty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//创建上下文——加载xml配置文件，处理创建并初始化所有对象。
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//利用context对象的getBean方法获取所需bean。
		InitAndDes he = (InitAndDes)context.getBean("initAndDes");
		//执行bean的方法
		he.getMsg();
		//
		context.registerShutdownHook();
		
	}

}
