package com.one.Thread.Create;

public class CreatThreadUsingThread extends Thread{

	//继承Thread的线程之间不会共享 实例变量
	private int count;
	
	//1.继承Thread并重写run方法
	public void run(){
		
		for ( ; count < 20; count ++){
			
			//输出当前线程名及其实例变量		
			System.out.println(Thread.currentThread().getName() +"  "+ count);
			
		}
		
	}
	public static void main(String[] args) {
		
		for(int i = 0;i < 20;i++){
			
			//再i=10时启动线程，线程并不会立即执行
			if (i==10){
						
				//2.创建实例，并调用start方法启动线程
				new CreatThreadUsingThread().start();
				new CreatThreadUsingThread().start();

			}
			System.out.println(Thread.currentThread().getName() +"  "+ i);
		}

	}

}
