package com.one;

import static org.junit.Assert.*;

import org.junit.Test;

public class XMLTest {

	@Test
	public void testObjectToXml(){
		Book book = new Book();
		book.setAuthor("C4y");
		book.setName("测试");
		book.setPrice("10.25");
		
		String xml = new XMLDemo().objectToXml(book);
		System.out.println(xml);
		
	}

}
