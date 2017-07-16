package com.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * jdbc基本步骤
 * @author C4y
 *仅用于测试
 */
public class DBUtil {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/iot";
	private static final String USER = "root";
	private static final String PASSWD = "55b71d";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得数据库连接
		Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
		//3.创建Statement对象，用以操作数据库
		Statement stat = conn.createStatement();
		//4.通过excuteQuery方法执行查询,返回结果集
		ResultSet rs = stat.executeQuery("select * from user");
		
		System.out.println("ID     "+"NAME  "+"PASSWD  ");
		//5.通过next方法遍历结果集
		while (rs.next()){
			//6.通过相应的get方法获取数据
			int id = rs.getInt("ID");
			String name = rs.getString("UserName");
			String passwd = rs.getString("PassWord");
			
			System.out.println(id+" "+" "+name+"   "+passwd);
			
			
		}
	}
}
