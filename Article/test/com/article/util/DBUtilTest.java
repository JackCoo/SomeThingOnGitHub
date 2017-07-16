package com.article.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.article.model.Article;
import com.article.model.User;

public class DBUtilTest {

	//@Test
	public void testQueryList() {
		
		
		String sql = "select * from user where create_time < ?;";
		//时间 使用new Date().toString(),"2017.10.5 10:00:00"形式
		List<Map<String,Object>> resultList = new DButil().queryToList(sql,"2017.10.5 10:00:00");
		System.out.println(resultList.size());
		System.out.println(resultList);
	
	}
	
	
	//@Test
	public void testQueryMap() {
		
		
		String sql = "select * from user where id = ? and user_name = ? and sex = ? ;";
		Map<String,Object> resultMap = new DButil().queryToMap(sql,10000,"chongyanjie",0);
		//System.out.println(resultMap.size());
		System.out.println(resultMap);
	
	}
	
	
	//@Test
	public void testUpdate() {
		//create_time,update_time,
		
		String sql = "insert into article (title, name,content,author,description,user_id,category_id,create_time) values (?,?,?,?,?,?,?,?);";
		Article a = new Article();
		a.setTitle("shijian测试");
		a.setName("利用update测试");
		a.setContent("hahaha");
		a.setAuthor("nibaba");
		a.setDescription("t");
		a.setCreateTime(new Date());
		a.setUserId(10000);
		a.setCategoryId(1);
		System.out.println(a);
		Integer du = new DButil().update(sql, a);
	
		System.out.println(du);
	}
	
	
	
	//@Test
		public void testQueryToBean() {
			
			
			String sql = "select * from user where id = ? and user_name = ? and sex = ? ;";
			User userBean = new DButil().queryToBean(sql,User.class,10000,"chongyanjie",0);
			//System.out.println(resultMap.size());
			System.out.println(userBean);
		
		}
		
		
		@Test
		//MySQL时间类型测试
		public void testMysqlDate() throws Exception {
			//各种类型时间的表示形式
			System.out.println("java.util.Date:"+new Date());
			System.out.println("java.sql.Date:"+new java.sql.Date(116, 8, 1));
			System.out.println("java.sql.Date:"+new java.sql.Date(new Date().getTime()));
			System.out.println("java.sql.Date:"+ java.sql.Date.valueOf("2018-2-21"));
			System.out.println("java.sql.Time:"+new Time(12, 35, 55));//过时方法
			System.out.println("java.sql.Time:"+new Time(new Date().getTime()));
			System.out.println("java.sql.Time:"+ Time.valueOf("15:06:00"));
			
			
			//java.util.Date转java.sql.Date，删除了时间部分。
			System.out.println("java.util.Date转java.sql.Date");
			Date utilDate = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			System.out.println(sqlDate);
			
			//java.sql.Date转java.util.Date，时间部分为：00：00：00.
			System.out.println("java.sql.Date转java.util.Date");
			sqlDate = new java.sql.Date(116, 8, 1);
			utilDate = new Date(sqlDate.getTime());
			System.out.println(utilDate);
			
			//java.util.Date转java.sql.Time，删除了日期部分。
			System.out.println("java.util.Date转java.sql.Time");
			utilDate = new Date();
			Time sqlTime = new Time(utilDate.getTime());
			System.out.println(sqlTime);
			
			//java.sql.Time转java.util.Date，日期部分为：1970-1-1
			System.out.println("java.sql.Time转java.util.Date");
			sqlTime = Time.valueOf("12:05:20");
			utilDate = new Date(sqlTime.getTime());
			System.out.println(utilDate);
			
			//java.sql.Time+java.sql.Date组合java.util.Date----毫秒数相加似乎并不能正常工作
			System.out.println("java.sql.Time+java.sql.Date组合java.util.Date");
			sqlTime = Time.valueOf("20:00:00");
			System.out.println(sqlTime);
			System.out.println(sqlTime.getTime());
			sqlDate = java.sql.Date.valueOf("2011-08-09");
			System.out.println(sqlDate);
			System.out.println(sqlDate.getTime());
			utilDate = new Date(sqlDate.getTime()+sqlTime.getTime());
			System.out.println(utilDate);
	
			//利用format
			String utilDateString = sqlDate.toString()+" " +sqlTime.toString();
			System.out.println(utilDateString);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			utilDate = dateFormat.parse(utilDateString);
			System.out.println(utilDate);
			
			
			
			///////
//			java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
//			java.sql.Time t = new java.sql.Time(new java.util.Date().getTime());
//			java.util.Date day = new java.util.Date(t.getTime());//日期部分为何没有在转换过程中丢失？
//			
//			System.out.println(d);
//			System.out.println(t);
//			System.out.println(day);
//			//////////////
			
	
			
//			long nowDate = new Date().getTime();
//			System.out.println(nowDate);
			//
//			System.out.println(new java.sql.Date(nowDate));
//			java.sql.Date sqlDate = new java.sql.Date(nowDate);
//			System.out.println(sqlDate);
//			java.util.Date utilDate = new Date(sqlDate.getTime());
//			System.out.println(utilDate);
//			
//			
//			String sqlInsert = "insert into date_test values (?,?,?,?);";
//			String sqlQuery = "select * from date_test;";
//			Connection conn = DButil.getConnection();
//			//插入测试
//			PreparedStatement ptmtInsert = conn.prepareStatement(sqlInsert);
//			//ptmtInsert.setDate(1, Date.);//MySQL中Date对应Java中 java.sql.Date
//
//			//查询测试
//			
			
		}
	

}
