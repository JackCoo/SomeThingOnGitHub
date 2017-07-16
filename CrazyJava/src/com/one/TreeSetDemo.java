package com.one;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		//1.向TreeSet添加不同类型的对象
		//1.1ClassCastException--TreeSet不能添加不同类型的对象,因comparato方法的强传
//		Set ts =new TreeSet<>();
//		ts.add(new String ("123"));
//		ts.add(new Date());
		
		//1.2HashSet可以添加不同类型对象
//		Set hs = new HashSet();
//		hs.add(new String("jj11"));
//		hs.add(new Date());
//		for(Object obj :hs){
//			System.out.println(obj);
//			//System.out.println( (String)obj );		
//		}
		
		//2.向TreeSet里添加可变对象，而后修改对象的值	---现象出现为可能，与输入的id值有关
		Phone p1 = new Phone(-3);
		Phone p2 = new Phone(-2);
		Phone p3 = new Phone(5);
		Phone p4 = new Phone(9);
		//添加Phone对象到TreeSet中
		TreeSet ts = new TreeSet();
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		ts.add(p4);
		//打印ts
		System.out.println(ts);
		//修改对象
		p1.id = 5;
		p4.id = -8;

		//此时TreeSet 无序且重复
		
		System.out.println(ts);
		//修改后的对象无法删除，甚至未修改但与已修改的对象相同的也无法删除
		System.out.println(ts.remove(p4));
		System.out.println(ts.remove(new Phone(-8)));
		System.out.println(ts);
		
	}

}

/*
 * 
 * 
 */
class Phone implements Comparable {
	
	int id;
	public Phone (int id){
		this.id = id;
	}
	
	//重写comparaTo方法,比较ID值
	@Override
	public int compareTo(Object obj) {
		//转化成同一类型以进行比较
		Phone objCastPhone = (Phone)obj;

//		if (id == objCastPhone.id){
//			//两对象相等
//			return 0;
//		}else if(id > objCastPhone.id){
//			//大于传入的obj对象
//			return 1;
//		}else {
//			return -1;
//		}
		
		return id > objCastPhone.id ? 1:id < objCastPhone.id ? -1:0;
	}
	
	
	//重写toString方法
	public String toString(){
		return "PhoneID:"+id;	
	}
	
	
	//重写equalsfangfa
	public boolean equals(Object obj){
		
		if (this == obj){
			//先比较引用变量指向的地址
			return true;
		}
		//再比较id值
		if (obj != null && obj.getClass() == Phone.class) {
			Phone objCastPhone = (Phone)obj;
			return this.id == objCastPhone.id;	
		}
		
		return false;
	}
	
}
