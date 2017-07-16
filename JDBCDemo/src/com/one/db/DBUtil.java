package com.one.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * 
 * @author C4y
 *
 */
public class DBUtil {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/iot";
	private static final String USER = "root";
	private static final String PASSWD = "55b71d";
	private static Connection conn = null;
	
	//静态块，初始化数据库
	static {
		try {
			 //1.加载mysql驱动
			 Class.forName("com.mysql.jdbc.Driver");
			 //2.取得数据库连接
			 conn = DriverManager.getConnection(URL, USER, PASSWD);
			 
			} catch (SQLException e) {
				System.out.println("无法连接数据库");
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
			System.out.println("JDBC驱动加载失败");
			e.printStackTrace();
		}	
	}
	
	/**
	 * 
	 * 获取connection
	 * @return
	 * 非static方法不能通过 类名.方法 访问，需先实例化。
	 */
	public static Connection getConnection(){
		return conn;
	
	}
	
	
}
