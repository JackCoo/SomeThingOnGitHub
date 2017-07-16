package com.one.Thread.Control;
/**
 * 
 * 线程睡眠
 * 暂停当前线程，进入阻塞状态。
 * Thread.sleep();
 * @author C4y
 *
 */
public class ThreadSleep {

	private int count;
	

	public static void main(String[] args) throws InterruptedException {
		

		for(int i = 0;i < 20;i++){
			
			if (i==10){
				//1.使用sleep方法，暂停当前线程，进入阻塞状态		
				Thread.sleep(1000);
			}
			System.out.println(Thread.currentThread().getName() +"  "+ i);
		}
		
		
	}

}
