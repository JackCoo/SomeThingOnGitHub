package com.article.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;


/**
 * 
 * 数据库链接工具类
 * @author C4y
 *
 */
public class DButil {
	
	final boolean debug = true;
	private static final String URL = "jdbc:mysql://localhost:3306/article";
	private static final String USERNAME = "root";
	private static final String PASSWD = "55b71d";

	
	static{
		
		try {
				//加载数据库驱动
				Class.forName("com.mysql.jdbc.Driver");				
		} catch (ClassNotFoundException e) {
			System.out.println("未找到驱动");
			e.printStackTrace();
		}
		
		
	}
	
/**
 * 
 * 返回数据库链接
 *只有一个链接，并发？
 * @return
 */
	public static Connection getConnection (){
		
		Connection conn = null;
		
		//通过DriverMannger获取数据库链接对象connection
		try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
		} catch (SQLException e) {
			System.out.println("无法链接到数据库");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main (String[] args){
		
		//System.out.println(DButil.getConnection());
	}
	
/**
 * 
 * 将查询结果封装成JavaBean
 * 步骤
 * 1.利用泛型创建JavaBean
 * 2.遍历结果集，由列名推断出变量及setter方法名，进而获得Method和Field对象
 * 3.判断列类型是否和Bean的成员变量类型相符
 * 4.利用反射调用set方法
 * 5.返回注入好的JavaBean
 * @param sql
 * @param beanClass
 * @param Object,SQL参数
 * @return
 */
	public <T> T queryToBean(String sql,Class<T> clazz,Object...parameters){
		
		//获取数据库链接
		Connection conn = DButil.getConnection();
		//创建PreparedStatement和ResultSet对象
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    //根据泛型创建返回Bean对象
	    T bean =null;
	    if(debug==true)
	    	System.out.println("DBUtil.queryToBean--");
		try {	
				//利用反射创建对象(1.Class对象.newInstance 2.需要使用其他构造器时，利用Class对象获得Constructor对象，调用后者的newInstance方法
			    bean = clazz.newInstance();
			    //初始化ps对象，为SQL参数赋值并执行，获得结果集
				ps = conn.prepareStatement(sql);
				for (int i = 0;i < parameters.length;i ++){
					ps.setObject(i+1, parameters[i]);	
				}	
				rs =ps.executeQuery();
				//将结果集的数据放入JavaBean对象中————只处理第一条结果
				if(rs.next()){
					
					//分析结果集
					//利用ResultSet的getMetaData方法，获取结果集的元数据。
					ResultSetMetaData rsmd = rs.getMetaData();
					//遍历结果集
					for (int i = 0;i < rsmd.getColumnCount();i++){
						//获取ResultSetMetaData指定索引的列名(此列名后用于推断JavaBean的变量及setter方法名)
						String columnName = rsmd.getColumnName(i+1);
						
						//获取ResultSetMetaData指定索引列在Java中的类型
						String columnType = rsmd.getColumnClassName(i+1);
						if(debug==true)
							System.out.println("	列类型为：" + columnType);
						
						//获取ResultSetMetaData指定索引的列类型标号
						//System.out.println(rsmd.getColumnType(i+1));
						//获取在Mysql中的列类型
						//System.out.println(rsmd.getColumnTypeName(i+1));
						
						//通过getDeclaredField方法，由成员变量名获得对应的Field对象。columnToProperty方法将列名转换成成员变量名。
						Field beanField = clazz.getDeclaredField(StringUtil.columnToProperty(columnName));
						//通过getType方法获得成员变量的类型。
						Class beanType = beanField.getType();
						if(debug==true)
							System.out.println("	成员变量类型为：" + beanType.getName());
						//仅当 列类型和对应的成员变量类型 相符时，才执行转换赋值操作。
						if((beanType.getName()==columnType) || 
								(columnType =="java.sql.Timestamp" && beanType.getName() == "java.util.Date")){
							
						
							//将列名转换成Bean中的方法名（seter方法）
							String setterName = StringUtil.getSetterName(columnName);
							if(debug==true)
								System.out.println("	setter方法名为："+ setterName);
							//根据setter方法名和其形参类类型列表获得方法Method对象
							Method md = clazz.getMethod(setterName,beanType);
							//获取结果集指定索引的值
							Object value = rs.getObject(i+1);
							//利用反射调用setter方法为bean对象设置成员变量
							md.invoke(bean, value);
							
							
						}else{
							if(debug==true)
								System.out.println("****类型不匹配");
						}
												
					}
					
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		
		catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//System.out.println(conn);
		return bean;
		
		

		
	}
	
/**
 * 
 * 查询为列表；
 * 将查询结果封装成List<Map<String,Object>>；
 * 时间 使用new Date().toString(),"2017.10.5 10:00:00"形式；
 * @param PrepareStatement形式的sql
 * @param 可变形参parameters，PrepareStatement SQL的参数
 * @return List<Map<String,Object>>
 */
	public List<Map<String,Object>> queryToList (String sql,Object...parameters){
		
		//返回的查询结果List
		List<Map<String, Object>> resultList = new ArrayList<>();
		//获取数据库链接
		Connection conn = DButil.getConnection();
		//构建PrepareStatement及ResultSet对象
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
				ps = conn.prepareStatement(sql);
				//利用setObject方法为sql语句的参数赋值，可变形参视为数组.--注意，setObject索引从1开始
				for(int i = 0;i < parameters.length;i ++){
					ps.setObject(i+1, parameters[i]);
				}
				//控制台打印SQL语句
				if(debug==true)
					System.out.println(ps.toString());
				//调用executeQuery方法执行SQL查询，获取结果集
				rs = ps.executeQuery();
				//获取结果集元数据，通过ResultSetMetaData对象可以分析结果集 列名、列数量、列数据类型
				ResultSetMetaData rsmd = rs.getMetaData();
				//遍历结果集，将每一行结果放入Map，并将Map放入List集合
				while (rs.next()){
					
					Map<String, Object> resultMap = new HashMap<>();
					//按K-V = 列名-值 的形式，将结果放入Map。--注意，getColumnName和getObject方法索引从1开始。
					for (int i = 0;i < rsmd.getColumnCount();i ++){
						resultMap.put(rsmd.getColumnName(i+1), rs.getObject(i+1));
					}
					//将Map放入List
					resultList.add(resultMap);
				}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return resultList;
		
	}
	
/**
 * 
 * 查询为Map
 * 利用了queryList方法
 * 将查询出一条结果，封装成Map<String,Object>
 * 如果有多条结果，将返回第一条。没有结果返回null
 * @param PrepareStatement形式的sql
 * @param 可变形参parameters，PrepareStatement SQL的参数
 * @return Map<String,Object>
 */
	public Map<String,Object> queryToMap (String sql,Object...parameters){
		
		List<Map<String,Object>> resultList = queryToList(sql, parameters);
		
		if (resultList.isEmpty()){	
			return null;
		}else{
			
			return resultList.get(0);
		}
		
	}
	
	
/**
 * 时间问题待验证
 * 
 * 根据javabean创建数据库记录
 * 
 * ？个数
 * 1.获得字段名的String数组
 * 2.通过反射获取bean的字段及setter
 * 3.遍历字段数组，若名称与类型均匹配，则调用ps.set
 * 
 * insert into article (title,name,content,author,description,create_time,update_time,user_id,category_id) values
 * (?,?....);
 * @param <T> bean 待写入数据库的JavaBean
 * @param sql sql语句
 * @return Integer
 * 
 */
	public <T> Integer update (String sql,T bean){
		
		//获得数据库链接
		Connection conn = DButil.getConnection();
		PreparedStatement ps = null;	
		//利用反射创建Bean类的Class对象
		Class clazz = bean.getClass();
		//通过StringUtil的静态方法sqlStrToColumn，从SQL语句中获得字段列表
		List<String> columns = StringUtil.sqlStrToColumn(sql);
		if(debug == true)
			System.out.println("DBUtil.update:SQL解析的字段列表为 "+columns);
		
		try {
				//创建PreparedStatement对象
				ps = conn.prepareStatement(sql);
		} catch (SQLException e2) {
			e2.printStackTrace();
			return -1;
		}
		
		//遍历 字段 集合，利用反射得到javabean中相应的值，利用setObject为？赋值
		for (int i = 0; i < columns.size();i++) {
			//获得字段名即其在JavaBean中的getter名
			String column = columns.get(i);
			String getterName = StringUtil.getGetterName(column);
			if(debug==true){
				System.out.println("i = " +i);
				System.out.println("DBUtil.update:SQL字段对应的getter为 "+getterName);
			}
				
			try {
					//ps = conn.prepareStatement(sql);//应该放在for循环外面，否则每次都会重新生成ps对象，报 No value specified for parameter 1
					//获得该字段对应的JavaBean属性的类型
					//Class fieldType = clazz.getDeclaredField(StringUtil.columnToProperty(column)).getType();
					
					//获得该字段对应的JavaBean的getter方法
					Method md = clazz.getDeclaredMethod(getterName);
					if(debug == true)
						System.out.println("DBUtil.update:getter方法返回值 " + md.invoke(bean));
					//利用反射执行getter方法，setObject为SQL参数赋值
					ps.setObject(i+1, md.invoke(bean));	
						
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return -1;
			}	
		}
		
		//////
//		try {
//			ps.setObject(1, clazz.getDeclaredMethod("getTitle").invoke(bean));
//			//ps.setObject(1, "t2");
//			ps.setObject(2, "22");
//			ps.setObject(3, "neirong");
//			ps.setObject(4, "作为");
//			ps.setObject(5, "miaoshu");
//			ps.setObject(6, 10000);
//			ps.setObject(7, 0);
//		} catch (SQLException e1) {
//			// TODO 自动生成的 catch 块
//			e1.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		
				
		try {
				//执行
				ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return -2;
		}
		return 1;
		
	}
	
	

}


