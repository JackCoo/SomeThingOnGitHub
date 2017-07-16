package com.one.xmlconfig.beanwiring.soundsystem;

import org.springframework.stereotype.Component;

/**
 * 
 * CompactDisc的实现类
 * @Component：组件类，告知Spring为其创建bean。
 * 		@Component("This a name"):为bean指定一个ID。
 * @author C4y
 *
 */
@Component("This a name")
public class Yellow implements CompactDisc{

	private String title = "Yellow";
	private String artist = "coldplay";
	public void play(){
		System.out.println("正在播放" + title + artist);
	}
}
