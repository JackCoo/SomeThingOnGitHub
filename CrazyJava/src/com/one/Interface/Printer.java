package com.one.Interface;
/**
 * Output接口的实现类
 * @author C4y
 *
 */
public class Printer implements Output {

	@Override
	public void out() {
		System.out.println("Printer 打印输出！");
		
	}

	@Override
	public void getData(String msg) {
		System.out.println("Print");
		
	}

}
