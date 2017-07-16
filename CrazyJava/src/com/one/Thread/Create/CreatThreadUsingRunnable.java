package com.one.Thread.Create;
/**
 * Runnable接口实现多进程
 * 
 * 通过Runnable实现类的实例作为Thread的target来创建多线程
 * @author C4y
 *
 */
public class CreatThreadUsingRunnable implements Runnable{
	
	//采用Runnable接口实现的线程之间能够共享 实例变量
	private int count;
	
	//1.实现Runnable接口，并重写run方法
	@Override
	public void run() {
		
		for ( ; count < 20; count ++){
			
			//输出当前线程名及其实例变量		
			System.out.println(Thread.currentThread().getName() +"  "+ count);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		for(int i = 0;i < 20;i++){
			
			//再i=10时启动线程，线程并不会立即执行
			if (i==10){
						
				//2.创建 Runnable接口实现类的实例
				CreatThreadUsingRunnable cr1 = new CreatThreadUsingRunnable();
				//3.将该对象作为Thread的target来创建Thread对象,同时启动该线程
				new Thread(cr1).start();
				new Thread(cr1).start();
				
				//不同target之间不会共享实例变量
				CreatThreadUsingRunnable cr2 = new CreatThreadUsingRunnable();
				new Thread(cr2).start();
				

			}
			System.out.println(Thread.currentThread().getName() +"  "+ i);
		}


	}


}
