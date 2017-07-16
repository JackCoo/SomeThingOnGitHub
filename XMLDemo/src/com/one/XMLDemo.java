package com.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.KeyStore.Entry.Attribute;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.thoughtworks.xstream.XStream;
/**
 * 利用Dom4J解析、生成XML
 * 
 * @author C4y
 *
 */
public class XMLDemo {
	//解析XML方法-xml转map
	public static void parseXML(){
		try {
			File f = new File("F:/java/XML/src/demo.xml");
			//1.创建SAXReader
			SAXReader reader = new SAXReader();
			System.out.println("Start");
			
			//2.通过read方法加载xml，获取document对象——read方法提供file和InputStream作为参数
			Document doc = reader.read(f);
			//3.通过document获取根节点,返回element对象
			Element rootElement = doc.getRootElement();
			//通过getname方法获取节点标签名
			System.out.println("根节点名：" + rootElement.getName());
			//通过elementIterator方法获取迭代器，迭代其子节点
			Iterator it =  rootElement.elementIterator();
			//4.遍历迭代器获取根节点下的所有子节点
			while (it.hasNext()){
				Element childElement = (Element) it.next();
				//通过getname获取子节点的标签名
				System.out.println("   二级节点：" + childElement.getName());
				//通过attributevalue方法获取特定的属性值。另有List的集合获取所有属性
				System.out.println("    节点属性值：" + childElement.attributeValue("category"));
				//通过elementIterator方法获取迭代器，迭代其二级节点的子节点即三级节点。
				Iterator<Element> itt = childElement.elementIterator();//泛型，指定为Element
				//或者不使用迭代器，获取子节点的List集合
				//List<Element> =childElement.elements(); 
				while(itt.hasNext()){
					Element thirdElement = itt.next();
					//通过getname和gettext方法获取节点名和节点值
					System.out.println("       三级节点：" + thirdElement.getName() + " = " +thirdElement.getText());
		
				}
				
			}
			System.out.println("End");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	//生成XML方法——map转xml
	public void craetXML(){
		//1.通过documenthelp的create方法创建document对象,代表整个xml文件。——
		Document doc = DocumentHelper.createDocument();
		//2.添加根节点及其属性值
		Element rootElement = doc.addElement("rss");
		rootElement.addAttribute("version", "2.0");
		//3.在根节点下添加子节点
		Element childElement1 = rootElement.addElement("title");
		//4.通过addtext添加节点值
		childElement1.addText("news.baidu.com");
		//添加更多的子节点
		Element childElement2 = rootElement.addElement("description");
		childElement2.addText("百度新闻订阅");
		//System.out.print();
		//5.保存生成的xml文件
		try {
			
			//XMLWriter writer;
			//构建输出流用以输出XML
			FileOutputStream out = new FileOutputStream("xmlcreat.xml");
			//一些可选参数1.格式化xml文件（缩进与换行）2.设置编码方式
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("GBK");
			//6.通过XMLWriter对象的write方法输出xml，format为可选参数
			XMLWriter writer = new XMLWriter(out,format);
			writer.write(doc);
			writer.close();
			//通过Document对象的asXml方法可将生成的xml转换成String
			//String xml = doc.asXML();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/**
 * java对象转xml
 * xstream、xpp3、xmlpull包
 * @param book
 * @return
 */
	public String objectToXml(Book book){
		//新建一个xstream对象
		XStream xstream = new XStream();
		//为类重命名——修改根元素，默认根元素为 包名.类名
		xstream.alias("xml", Book.class);
		//为成员变量重命名——修改节点
		xstream.aliasField("姓名", Book.class, "name");
		
		
		//通过toXML方法返回String类型的xml文档s
		String out = xstream.toXML(book);
		//System.out.println(book);
		
		return out;
			
	} 
	
	
	public static void main(String[] args) {
		
		//parseXML();
		//new XMLDemo().craetXML();
		Book book = new Book();
		book.setAuthor("C4y");
		book.setName("测试");
		book.setPrice("10.25");
		
		//new XMLDemo().objectToXml(book);
	}

}
