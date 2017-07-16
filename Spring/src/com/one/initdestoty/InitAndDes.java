package com.one.initdestoty;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Bean 的生命周期
 * 1.利用Bean自身的方法，并通过配置文件配置指定相应的执行方法
 * 2.实现Bean生命周期接口
 * 3.容器级生命接口、工厂后处理器接口
 * 
 * 具体的：
 * 初始化：
 * 1.实现InitializingBean接口，重写afterPropertiesSet方法
 * 2.配置init-method
 * 销毁：
 * 类似
 * @author C4y
 *
 */
public class InitAndDes implements InitializingBean ,DisposableBean{

	private String msg;

	public void getMsg() {
		System.out.println(msg); 
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Beans销毁回调函数");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Beans初始化回调函数");
		
	}
	
	public void init(){
		System.out.println("Bean指定的init方法被执行");

	}
	
	public void destory(){
		System.out.println("Bean指定的销毁方法被执行");
	}
	
}
