package com.one.javaconfig.beanwiring.autowiring.soundsystem.somehomeworks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.one.javaconfig.beanwiring.autowiring.soundsystem.CompactDisc;

/**
 * MediaPlayer的实现类，播放CD。
 * @author C4y
 *
 */

@Component
public class CDPlayer implements MediaPlayer {

	@Autowired
	private CompactDisc cd;
	
	@Override
	public void play() {
		
		cd.play();
	}

}
