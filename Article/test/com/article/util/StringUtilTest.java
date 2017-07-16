package com.article.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class StringUtilTest {

	//@Test
	public void testColumnToProperty() {

		System.out.println(StringUtil.columnToProperty("user"));
	}
	
	//@Test
	public void testGetGetterName(){
		
		System.out.println(StringUtil.getGetterName("user_name"));
		
	}
	
	
	
	
	@Test
	public void testsqlStrToColumn(){
		String sql = "insert into article (title, name,content,author,description,create_time,update_time,user_id,category_id) values (?,?,?,?,?,?,?,?,?);";

		List<String> res = StringUtil.sqlStrToColumn(sql);
		System.out.println(res);
	}
	
	@Test
	public void testPropertyToColumn(){
		
		String str = "userNameId";
		System.out.println(StringUtil.propertyToColumn(str));
		
	}
}
