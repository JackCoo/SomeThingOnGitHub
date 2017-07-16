package com.one.javaconfig.beanwiring.manualwiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.one.javaconfig.beanwiring.manualwiring.thirdpackages.CompactDisc;
import com.one.javaconfig.beanwiring.manualwiring.thirdpackages.HeyJudy;


/**
 * 我们无法在第三方组件的类上加@Component将其声明为一个组件类，无法采用自动配置。
 * 因为采用显示配置，该配置类的组件扫描注解也就没有存在的必要了。
 * 但依赖第三方组件的类依然可以使用@Autowired来自动装配，从上下文中寻找bean，满足依赖关系。
 * 
 * 采用在JavaConfig中声明bean，将第三方对象注册到Spring上下文中。
 * 
 * @Bean：该注解告知Spring，该方法将返回一个对象，将此对象注册到Spring上下文中。等同于XML里的<bean>标签
 * 		@Bean(name = "xxx"),为该bean设置一个ID。
 */
@Configuration	
//@ComponentScan
public class CDplayerConfig {
	
	@Bean(name = "123")
	public CompactDisc Yellow(){
		return new HeyJudy();
		//return new com.one.javaconfig.beanwiring.manualwiring.thirdpackages.Yellow();
	}
	
}
