package com.one.xmlconfig.beanwiring.soundsystem;

import org.springframework.stereotype.Component;

/**
 * CompactDisc的另一个实现类
 * 
 * 测试Spring自动装配，有多个bean满足匹配时（这里HeyJudy和Yellow都是CompactDisc的实现类，匹配CDPlayerTest中的cd属性。）
 * 此时会抛异常。
 * 注释掉@Component即可
 * @author C4y
 *
 */

//@Component
public class HeyJudy implements CompactDisc {

	@Override
	public void play() {
		// TODO 自动生成的方法存根

	}

}
