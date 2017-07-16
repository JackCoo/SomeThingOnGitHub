package com.one;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.sun.xml.internal.ws.util.xml.XmlUtil;

public class XMLUtilTest {

	@Test
	public void testMapToXML() throws IOException{
		//创建测试Map
		Map<String,String> map = new HashMap<String,String>();
		//初始化Map
		for(Integer i = 0;i<10;i++){
			map.put("节点"+i, i.toString());			
		}
		//控制台输出
		System.out.println(new XMLUtil().MapToXml(map));
	}
	
	
	
	
	
}
