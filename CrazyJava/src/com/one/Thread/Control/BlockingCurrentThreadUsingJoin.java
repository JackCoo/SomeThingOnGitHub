package com.one.Thread.Control;

/*
 * join阻塞
 * .join();
 * 使用join阻塞当前线程，直至被join的线程执行结束
 */

public class BlockingCurrentThreadUsingJoin extends Thread {

	private int count;
	
	//继承Thread并重写run方法
	public void run(){
		
		for ( ; count < 20; count ++){
			
			//输出当前线程名及其实例变量		
			System.out.println(Thread.currentThread().getName() +"  "+ count);
			
		}
		
	}
	public static void main(String[] args) throws Exception {
		
		for(int i = 0;i < 20;i++){
			
			//再i=10时启动线程
			if (i==10){
						
				//创建实例，并调用start方法启动线程
				BlockingCurrentThreadUsingJoin jt = new BlockingCurrentThreadUsingJoin();
				jt.start();
				//1.使用join阻塞当前main线程，直至jt线程执行完毕
				jt.join();

			}
			System.out.println(Thread.currentThread().getName() +"  "+ i);
		}

		
	}

}
