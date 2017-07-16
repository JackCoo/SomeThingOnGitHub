package com.one.Interface;
/**
 * Output接口
 * 接口中定义的所有成员都是public访问权限，可以省略。——因为接口是抽象出来的模板，定义的是多个类的公共行为。 
 * 对于接口本身的访问权限可以为public和default。
 * 
 * 接口中的成员：
 * 静态常量
 * 抽象方法
 * 内部类、接口、枚举定义
 * 默认方法、类方法                               
 * @author C4y
 *
 */
public interface Output {
	
	//默认增加public final static修饰——接口中只能定义类常量（静态常量）
	int MAX_CACHE = 50;
	
	//自动增加public abstract修饰——接口中定义的普通方法只能是public的抽象方法。定义一个打印输出方法
	void out();
	void getData(String msg);
	
	//接口中定义的默认方法需要用default修饰
	default void print(String...msgs){
		
		for(String msg:msgs)
			System.out.println(msg);
		
	}
	
	//在接口中定义类方法需要用static修饰
	static void staticTest(){
		
		System.out.println("staticTest");
	}
	
}
