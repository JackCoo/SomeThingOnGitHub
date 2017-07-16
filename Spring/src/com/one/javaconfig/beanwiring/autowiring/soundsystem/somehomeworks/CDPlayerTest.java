package com.one.javaconfig.beanwiring.autowiring.soundsystem.somehomeworks;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.one.javaconfig.beanwiring.autowiring.soundsystem.CDplayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDplayerConfig.class)
public class CDPlayerTest {
	
	@Autowired
	private MediaPlayer mp;
	@Test
	public void test() {
		
		mp.play();
		
	}

}
