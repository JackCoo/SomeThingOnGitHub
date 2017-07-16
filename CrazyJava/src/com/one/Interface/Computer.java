package com.one.Interface;
/**
 * 工厂模式
 * 
 * Computer对象需要一个Printer对象以实现打印功能
 * 若采用 Computer类中组合一个Printer对象，日后需要替换掉Printer，则需要在Computer类中做相应修改。
 * 倘若组合Printer对象的类除了Computer以外还有很多，则工作量会很大。
 * 
 * 采用工厂模式，
 * Computer不与具体的实现类相组合，而是与接口Output组合。
 * 因而，Computer不与具体实现类耦合，而是与接口耦合
 * 系统提供一个工厂类，以创建具体的Output实现类对象。
 * @author C4y
 *
 */
public class Computer {

	private Output op;
	
	public Computer(Output op){
		this.op = op;
	}
	
	public void print(){
		
		op.out();
		
	}
}
