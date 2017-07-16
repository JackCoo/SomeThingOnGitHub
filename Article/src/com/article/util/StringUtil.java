package com.article.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

/**
 * 
 * 将列名转换成JavaBean属性名
 * 即将数据库字段命名转换成Java的驼峰命名；
 * 例如：user_name ==> userName
 * @param column
 * @return
 */
	public static String columnToProperty(String column){
		//将字符串按“_”分割
		String[] splitColumn = column.split("_");
		//创建StringBuilder对象
		StringBuilder property = new StringBuilder();
		//第一个单词无需首字母大写，直接添加到sb对象内
		property.append(splitColumn[0]);
		//遍历剩下的String数组，将每一个单词首字母大写后添加到sb对象尾部
		for(int i = 1;i < splitColumn.length;i++){
			
			property.append(splitColumn[i].substring(0, 1).toUpperCase()+splitColumn[i].substring(1));	
		}
		
		return property.toString();
		
	}
	
	public static String propertyToColumn(String property){
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < property.length();i++){
			if(Character.isUpperCase(property.charAt(i))){
				
				sb.append("_");
				sb.append(property.substring(i, i+1).toLowerCase());
			}else{
				
				sb.append(property.charAt(i));
			}
		}
		
		return sb.toString();
		
	}
	
/**
 * 
 * 由数据库列名推断出对应的JavaBean setter方法名
 * 	
 * @param column
 * @return
 */
	public static String getSetterName(String column){
		//利用columnToProperty方法，先将 列名 转换成 属性名 
		String properName = columnToProperty(column);
		//添加"set",并将属性名的首字母大写
		String setterName = "set" + properName.substring(0,1).toUpperCase() +properName.substring(1);
		return setterName;
	}
	

/**
* 
* 由数据库字段名推断出对应的JavaBean getter方法名
* 	
* @param column
* @return
*/
	public static String getGetterName(String column){
		//利用columnToProperty方法，先将 列名 转换成 属性名 
		String properName = columnToProperty(column);
		//添加"get",并将属性名的首字母大写
		String getterName = "get" + properName.substring(0,1).toUpperCase() +properName.substring(1);
		return getterName;
	}	

/**
 * 由sql字符串获得其中的Column字符串数组
 * 
 * @return
 */
	public static List<String> sqlStrToColumn(String sql){
		//正则表达式，验证规则。
		String regEx1 = "(?<=\\().*?(?=\\))";
		String regEx2 = "(?<=\\()[^\\)]+";
		//通过静态方法compile将指定的正则表达式编译并返回Pattern对象。--pattern是正则表达式编译后的表现模式
		Pattern p = Pattern.compile(regEx1);
		//通过Pattern的matcher方法创建Matcher对象。--matcher对象是一状态机器，根据pattern对象作为匹配模式对字符串开展匹配检查。
		Matcher m = p.matcher(sql);
		//放置 列名 的数组
		List<String> columns = new ArrayList<>();
		//System.out.println(m.groupCount());
		
		int count = 0;//匹配项计数
		int columnCount = 0;//列名计数
		int paraCount = 0;//Prepare Statement SQL语句中 ？计数
		//尝试在目标字符串里 查找下一个匹配
		while(m.find()){
				count++;
				//处理包含列名的匹配项，即第一个匹配项。
				if(count == 1){
					//返回当前查找获得的匹配子字符串
					String column = m.group();
					//将包含多个列名的字符串拆分成单个列名的数组
					String[] columnspit = column.split(",");
					//获取 字段个数--用以对比和？数是否相同
					columnCount = columnspit.length;
					//处理 列名前后的空格，放入返回的List中
					for (String str : columnspit) {
						//System.out.println(str.trim());
						columns.add(str.trim());
					}
				}else if(count >= 2) {
					//获取 SQL语句中？个数
					paraCount = m.group().split(",").length;
					if(paraCount != columnCount){
						System.out.println("SQL语句错误：不匹配的？个数!");
						return null;
						
					}
				}
			}
		
		return columns;
		
	}
}


