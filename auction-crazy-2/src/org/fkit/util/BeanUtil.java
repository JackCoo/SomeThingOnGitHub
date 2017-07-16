package org.fkit.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class BeanUtil {

	public static void main(String[] args) {
		
		System.out.println(getBeanFilesList("org.fkit.model.AuctionRecord"));
		
		System.out.println(genCreateTableSql("org.fkit.model.AuctionRecord"));
		
		//System.out.println(genInsertSql("com.pdt.bean.Dictionary"));
	}
/**
 * 
 * 获取JavaBean类名
 * 全小写，不含包名。
 * 例 user 
 * @param bean
 * @return
 */
	public static String getBeanName(String bean){
		try {
			//利用反射加载名为bean的类,利用toString获取其限定名。
			Class clz = Class.forName(bean);
			String clzStr = clz.toString();
			//提取限定名中的类名，并将其转换为小写。
			String beanName = clzStr.substring(clzStr.lastIndexOf(".")+1).toLowerCase();
			return beanName;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "";
		}
	}
/**
 * 获得JavaBean包含类型的属性列表
 * 
 * @param 类名
 * @return [Integer`id, String`userName.....]
 */
	
	public static List<String> getBeanPropertyList(String bean){
		try {
			//利用反射加载名为bean的类
			Class clz = Class.forName(bean);
			//利用getDeclaredFields方法返回所有类属性（不含父类）
			Field[] strs = clz.getDeclaredFields();
			List<String> propertyList = new ArrayList<String>();
			//遍历Field[]数组，获取包含类型的属性列表
			for (int i = 0; i < strs.length; i++) {
				String protype = strs[i].getType().toString();
				propertyList.add(protype.substring(protype.lastIndexOf(".")+1)+"`"+strs[i].getName());
			}
			return propertyList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getBeanFilesList(String bean){
		try {
			Class clz = Class.forName(bean);
			Field[] strs = clz.getDeclaredFields();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < strs.length; i++) {
				String protype = strs[i].getType().toString();
				if (!strs[i].getName().equals("tableName")&&!strs[i].getType().equals("List")) {
				   sb.append(strs[i].getName()+",");
				}
			}
			sb.deleteCharAt(sb.toString().lastIndexOf(","));
			//System.out.println(sb.toString());
			return sb.toString();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 生成建表語句
	 * @param bean
	 * @return
	 */
	public static String genCreateTableSql(String bean){
		//获取JavaBean的属性列表（包含类型）。
		List<String> beanPropertyList =  getBeanPropertyList(bean);
		//获取JavaBean不含包名的小写类名，拼凑成“create table xxx(”
		StringBuffer sb = new StringBuffer("create table "+getBeanName(bean)+"(\n");
		//遍历属性列表，根据属性类型拼接建表语句
		for (String string : beanPropertyList) {
			//拆分类型名和属性名
			String[] propertys = string.split("`");
			//将属性名转换成列名
			propertys[1] = StringUtil.propertyToColumn(propertys[1]);
			if (!propertys[1].equals("tableName")&&!propertys[1].equals("param")&&!propertys[0].equals("List")) {
				if (propertys[1].equals("id")) {
					sb.append("   id bigint primary key auto_increment,\n");
				} else {
					if (propertys[0].equals("int")||propertys[0].equals("Integer")) {
						sb.append("   " + propertys[1] + " int ,\n");
					} else if (propertys[0].equals("String")) {
						sb.append("   " + propertys[1] + " varchar(255),\n");
					} else if (propertys[0].equals("double")||propertys[0].equals("Double")) {
						sb.append("   " + propertys[1] + " double(10,2),\n");
					} else if (propertys[0].equals("Date")) {
						sb.append("   " + propertys[1] + " datetime,\n");
					} else {
						System.out.println("无法为以下属性加入建表语句：");
						System.out.println(propertys[0]+"  "+propertys[1]);
					}
				}
			} else{
				System.out.println("属性名包含非法字符");
			}
		}
		sb.append(");");
		sb.deleteCharAt(sb.lastIndexOf(","));
		return sb.toString();
	}
	
//	/**
//	 * 生成查询语句
//	 * @param bean
//	 * @return
//	 */
//	public static String genSelectAllSql(String bean){
//		String filesList =  getBeanFilesList(bean);
//		return "select \n "+filesList+" \n from \n wnk_pdt_"+getBeanName(bean)+"";
//	}
//	
//	/**
//	 * 生成插入语句
//	 * @param bean
//	 * @return
//	 */
//	public static String genInsertSql(String bean){
//		String filesList =  getBeanFilesList(bean);
//		int fl = DataUtil.getCountSonStr(filesList,",")+1;
//		String wenhao = "";
//		for (int i = 0; i < fl; i++) {
//			if(i==fl-1){
//				wenhao = wenhao+"?";
//			}else{
//				wenhao = wenhao+"?,";
//			}
//		}
//		return "insert into wnk_pdt_"+getBeanName(bean)+"("+filesList+") values("+wenhao+")";
//	}
}
