//package com.one;
//
//
//import java.util.TreeSet;
//
//public class TreeSetDemo2 {
//
//	public static void main(String[] args) {
//
//		//2.向TreeSet里添加可变对象，而后修改对象的值	
////		Phone p1 = new Phone(-10);
////		Phone p2 = new Phone(-5);
////		Phone p3 = new Phone(1);
////		Phone p4 = new Phone(20);
//		//添加Phone对象到TreeSet中
//		TreeSet ts = new TreeSet();
//		ts.add(new Phone(-3));
//		ts.add(new Phone(-2));
//		ts.add(new Phone(5));
//		ts.add(new Phone(9));
//		//打印ts
//		System.out.println(ts);
//		//修改p4的值为-5，与p2相同
//		Phone first = (Phone)ts.first();
//		first.id = 80;
//		Phone last = (Phone)ts.last();
//		last.id = -5;
//		//此时TreeSet 无序且重复
//		
//		System.out.println(ts);
//		
//		System.out.println(ts.remove(new Phone(-5)));
//		System.out.println(ts);
//		
//	}
//
//}
//
///*
// * 
// * 
// */
//class Phone implements Comparable {
//	
//	int id;
//	public Phone (int id){
//		this.id = id;
//	}
//	
//	//重写comparaTo方法,比较ID值
//	@Override
//	public int compareTo(Object obj){
//		Phone r = (Phone)obj;
//		return id > r.id ? 1 :
//			id < r.id ? -1 : 0;
//	}
//	
//	
//	//重写toString方法
//	public String toString(){
//		return "PhoneID:"+id;	
//	}
//	
//	
//	//重写equalsfangfa
//	public boolean equals(Object obj){
//		if (this == obj)
//		{
//			return true;
//		}
//		if(obj != null && obj.getClass() == Phone.class)
//		{
//			Phone r = (Phone)obj;
//			return r.id == this.id;
//		}
//		return false;
//	}
//	
//}
