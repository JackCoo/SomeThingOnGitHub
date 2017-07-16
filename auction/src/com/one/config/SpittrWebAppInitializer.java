package com.one.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * 配置Servlet容器
 * 
 * @author C4y
 *
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	//指定配置类
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	//将DispatcherServlet映射到“/”，处理所有请求。
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
