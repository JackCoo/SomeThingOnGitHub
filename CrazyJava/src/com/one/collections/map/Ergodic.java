package com.one.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * map遍历方法
 * 
 * 获取Map集合的keySet或者entrySet
 * 再利用foreach遍历或者迭代器Iterator迭代
 * 
 * Map利用Entry内部类来封装key-value对
 * 使用entrySet效率较高
 * @author C4y
 *
 */


public class Ergodic {
	
	//1.利用foreach 遍历 keySet()
	private void forEachKeySet(Map<String, String> map){
		
		System.out.println("    1.foreach 和 keySet()");
		for (String key : map.keySet()) {
			
			String value = map.get(key);
			//System.out.println(key + " " + value);
		}
		
	}
	
	//2.利用foreach 遍历 entrySet()--快
	private void forEachEntrySet(Map<String, String> map){
	
		System.out.println("    2.foreach 和 entrySet()");
		for (Entry<String, String> entry : map.entrySet()){
			
			String key = entry.getKey();
			String value = entry.getValue();
			//System.out.println(key + " " + value);
		}
		
	}
	
	//3.利用迭代器Iterator 迭代 keySet
	private void iteratorKeySet(Map<String, String> map){
		
		System.out.println("    3.利用迭代器Iterator 迭代keySet");
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
						
			//直接输出，两次.next()会往下迭代两次
			//System.err.println(it.next() + map.get(it.next()));
			
			String key = it.next();
			String value = map.get(key);
			//System.out.println( key + " " + value );	
			
		}
		
		
	}
	
	//4.利用迭代器Iterator 迭代 entrySet
	private void iteratorEntryKey(Map<String, String> map){
		
		System.out.println("    4.利用迭代器Iterator 迭代 entrySet");
		Iterator<Entry<String, String>> it2 = map.entrySet().iterator();
		while(it2.hasNext()){
			
			Entry<String, String> entry = it2.next();
			String key = entry.getKey();
			String value = entry.getValue();
			//System.out.println(key + "  "  + value );
			
		}
		
	}
	public static void main (String[] args){
		
		//初始化数据
		Map<String, String> map = new HashMap<>();
		for(int i = 0;i < 100000;i++)
			map.put(String.valueOf(i), String.valueOf(i));
		
		long start;
		long end;
		
				
		start = System.currentTimeMillis();
		new Ergodic().forEachKeySet(map);
		end = System.currentTimeMillis();
		System.out.println("耗时："+ (end -start) + "ms");
		
		start = System.currentTimeMillis();
		new Ergodic().forEachEntrySet(map);
		end = System.currentTimeMillis();
		System.out.println("耗时："+ (end -start) + "ms");

		start = System.currentTimeMillis();
		new Ergodic().iteratorKeySet(map);
		end = System.currentTimeMillis();
		System.out.println("耗时："+ (end -start) + "ms");
		
		start = System.currentTimeMillis();
		new Ergodic().iteratorEntryKey(map);
		end = System.currentTimeMillis();
		System.out.println("耗时："+ (end -start) + "ms");
		

	}
	
	
}
