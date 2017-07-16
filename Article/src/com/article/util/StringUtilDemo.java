package com.article.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilDemo {
/**
 * 
 * 
 * 正则表达式的测试
 * p1
 * (?<=\\() 零宽断言，表示匹配项前有一个(
 * [^\\)]+ 反义，不是）的内容重复一次以上---贪婪，尽可能的匹配更多的非）字符
 * 
 * p2
 * .*? 匹配任何非换行符外的任意字符任意次，但尽可能少。--匹配到第一个）
 * (?=\\)) 零宽断言，表示匹配项后有一个)
 * @param args
 */
	public static void main(String[] args) {


		String sql = "insert into article (title, name,content,author,description,create_time,update_time,user_id,category_id) values (?,?....);";
		//两种匹配括号内 内容的正则表达式---未考虑空格
		Pattern p1 = Pattern.compile("(?<=\\()[^\\)]+");// 
		Pattern p2 = Pattern.compile("(?<=\\().*?(?=\\))");//
		
	
		
		
		
		Matcher m = p2.matcher(sql);
		
	
		while(m.find()){
				String column = m.group();
				System.out.println(column);
				String[] columnspit = column.split(",");
				for (String str : columnspit) {
					System.out.println(str);
				}
				System.out.println();
				System.out.println("--------");
			}
		
		
//		//去除空格的正则表达式
//		System.out.println("空格测试");
//		Pattern p3 = Pattern.compile("\\s+");
//		Matcher m3 = p3.matcher("kkkk  name 55");
//		
//		while(m.find()){
//				String column = m3.group();
//				System.out.println(column);
//			}
	}

}
