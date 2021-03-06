package com.one.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamer;

/**
 * XML与Map互转
 * @author C4y
 * 利用Junit调试:1.方法无返回值 2.方法不为static 3.@Test
 */
public class XMLUtil {
/**
 * XML转Map集合
 * @param req
 * @return
 * @throws IOException
 * @throws DocumentException
 */
	//@Test
	//---调试.1
	//public void xmlToMap() throws IOException, DocumentException{
	public  Map<String,String> xmlToMap(HttpServletRequest req) throws IOException, DocumentException{
		//创建Map集合用以保存转换后的XML
		Map<String,String> map = new HashMap<String, String>();
		//获取请求的IO流
		InputStream ins = req.getInputStream();
		
		//---调试.2
		//InputStream ins = new FileInputStream("F:/java/Weixin/src/weixintest.xml");
				
		//创建SAXReader对象，通过read方法由IO流载入XML
		SAXReader reader = new SAXReader();
		Document doc = reader.read(ins);
		//获取根节点
		Element rootElement = doc.getRootElement();
		//创建迭代器，迭代子节点
		Iterator<Element> it = rootElement.elementIterator();
		while(it.hasNext()){
			//获取一子节点并放入map集合
			Element childElement = it.next();
			map.put(childElement.getName(), childElement.getText());		
		}
		
		
		//---调试.3 打印map内容
//		for(String key : map.keySet()){
//			System.out.println(key + " = " + map.get(key));	
//		}
		return map;
		
	}
	
	
	public  Map<String,String> xmlToMap(String xml)  {
		//创建Map集合用以保存转换后的XML
		Map<String,String> map = new HashMap<String, String>();
		
		//创建SAXReader对象，通过read方法由IO流载入XML
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
		} catch (DocumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//获取根节点
		Element rootElement = doc.getRootElement();
		//创建迭代器，迭代子节点
		Iterator<Element> it = rootElement.elementIterator();
		while(it.hasNext()){
			//获取一子节点并放入map集合
			Element childElement = it.next();
			map.put(childElement.getName(), childElement.getText());		
		}
		
		//---调试.3 打印map内容
//		for(String key : map.keySet()){
//			System.out.println(key + " = " + map.get(key));	
//		}
		return map;
		
	}
/**
 * Map集合转XML
 * @param map
 * @return String
 * @throws IOException
 */
	public String MapToXml(Map<String,String> map) throws IOException{
		//1.通过DocumentHelp的CreatDocument方法创建Document对象——表示整个XML文档
		Document doc = DocumentHelper.createDocument();
		//2.通过addElement方法添加根节点———微信中为xml
		Element rootElement = doc.addElement("xml");
		//3.遍历map集合，将集合元素添加至子节点
		for(String key:map.keySet()){
			Element childElement = rootElement.addElement(key);
			childElement.setText(map.get(key));
		}	
		//4.将生成的Document对象的xml转换成string并返回
		String out = doc.asXML();
		return out;

	}	

	 /** 
     * 将String类型的xml转换成对象 
     */  
    public static Object convertXmlStrToObject(Class clazz, String xmlStr) {  
        Object xmlObject = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(clazz);  
            // 进行将Xml转成对象的核心接口  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            StringReader sr = new StringReader(xmlStr);  
            xmlObject = unmarshaller.unmarshal(sr);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
        return xmlObject;  
    }  

    
	
	
}