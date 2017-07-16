package com.one.Thread.Control;

/**
 * DaemonThread 后台线程
 * 后台线程随前台线程的死亡而死亡，即使其没有执行完毕
 * setDaemon(true)
 * 
 * @author C4y
 *
 */
public class DaemonThread extends Thread {

	private int count;
	
	//继承Thread并重写run，后台线程与普通线程无异
	public void run (){
		
		for ( ; count < 100; count ++){
			
			//输出当前线程名及其实例变量		
			System.out.println(Thread.currentThread().getName() +"  "+ count);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		for(int i = 0;i < 20;i++){
			
			//再i=10时启动线程
			if (i==10){
				
				//创建Thread子类实例，并调用start启动线程
				DaemonThread dt = new DaemonThread();
				//1.通过setDaemon方法将此线程设置为后台线程,后台线程并未执行完毕就已经死亡
				dt.setDaemon(true);
				dt.start();
								
			}
			System.out.println(Thread.currentThread().getName() +"  "+ i);
		}


	}

}
