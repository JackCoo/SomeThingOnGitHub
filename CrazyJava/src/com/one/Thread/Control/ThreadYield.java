package com.one.Thread.Control;

/**
 * Thread.yield();让当前线程让步，进入就绪状态，让系统线程调度器重新调度一下
 * yield()只能让 不小于当前线程优先级的线程 获得执行机会
 * 
 * 通常使用sleep来控制并发线程的执行
 * setPriority(MAX_PRIORITY);
 * 
 * 多核CPU结果可能无法重现
 * @author C4y
 *
 */
public class ThreadYield extends Thread {

	private int count;
	
	public void run(){
		
		for ( ; count < 20; count ++){
			
			//输出当前线程名及其实例变量		
			System.out.println(Thread.currentThread().getName() +"  "+ count);
			
			//1.count=10时，使用yield方法让当前线程让步
			if (count == 10){
				
				Thread.yield();
			}
			
		}
		
	}
	public static void main(String[] args) {
		
		//启动两个并发线程
		ThreadYield ty1 = new ThreadYield();
		ThreadYield ty2 = new ThreadYield();
		ty1.setPriority(MAX_PRIORITY);
		ty2.setPriority(NORM_PRIORITY);
		ty1.start();
		ty2.start();
		

	}

}
