package com.one.javaconfig.beanwiring.autowiring.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 类CDplayerConfig通过注解定义了Spring装配的规则
 * @ComponentScan：在Spring中启用组件扫描，默认扫描该基础包下有@Component的类，并在Spring中为其创建一个bean。
 * 		@ComponentScan(basePackages={"包名1","包名2".....})：设置多个基础包(扫描包）
 * 		@ComponentScan(basePackageClasses = {Class1,Class2...}):将多个类所在的包设为基础包。
 * @author C4y
 *
 *@Configuration:JavaConfig类,声明为一个配置类。
 */
@Configuration	
@ComponentScan
public class CDplayerConfig {

}
