package com.one.xmlconfig.beanwiring.soundsystem;

/**
 * MediaPlayer的实现类，播放CD。
 * @author C4y
 *
 */

public class CDPlayer implements MediaPlayer {


	private CompactDisc cd;
	
	public CDPlayer(CompactDisc cd){
		this.cd = cd;
		
	}

	public void play() {
		
		cd.play();
	}

}
