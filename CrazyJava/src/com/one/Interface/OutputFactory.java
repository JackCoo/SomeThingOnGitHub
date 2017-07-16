package com.one.Interface;
/**
 * Output工厂类
 * 返回Output接口实现类
 * 
 * 当具体实现类需要更改时，只需修改getOutput方法。
 * 此举将生成Output对象的逻辑集中在OutputFactory中进行集中管理。
 * 依赖Output对象的类只与Output接口耦合而不与具体实现类耦合。
 * @author C4y
 *
 */
public class OutputFactory {

	public Output getOutput(){
		//返回Output接口实现类Printer的一个实例
		return new Printer();
	}
}
