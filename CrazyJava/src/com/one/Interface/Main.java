package com.one.Interface;

public class Main {

	public static void main(String[] args) {
		//创建一个Output共产类的实例
		OutputFactory of = new OutputFactory();
		//由工厂类获取一个Output对象
		Output op = of.getOutput();
		//将op注入到Computer对象中
		Computer co = new Computer(op);
		//调用Computer对象的print方法——实际调用Printer的out方法
		co.print();
	}

}
