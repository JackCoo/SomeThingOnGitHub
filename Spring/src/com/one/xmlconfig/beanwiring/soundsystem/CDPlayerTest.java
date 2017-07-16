package com.one.xmlconfig.beanwiring.soundsystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 *测试 CompactDisc的实现类Yellow被成功注入到CDPlayerTest类
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 使用SpringJUnit4ClassRunner，以便在开始前自动创建Spring上下文
 * @ContextConfiguration(classes=CDplayerConfig.class)
 * 从CDplayerConfig中加载配置
 * @Autowired：自动装配，bytype，通过该注释声明依赖，Spring自动满足bean依赖的一种方法。注入一个可设置为CompactDisc类型的 bean到测试类。
 * 		可用于构造器、setter、属性。
 * 		没有匹配的bean：抛出异常。若将@Autowired的required属性设置为false，不抛异常，但未装配状态的属性可能会有NullPointerException。
 * 		多个bean满足依赖关系时，抛异常。
 * @author C4y
 *
 */


public class CDPlayerTest {
	

	private CompactDisc cd;

//	public void setCd(CompactDisc cd) {
//		this.cd = cd;
//	}

	@Test
	public void test() {
		assertNotNull(cd);
		cd.play();
	}

}
