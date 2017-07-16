package com.one.Thread.Create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * Callable+Future 实现多线程
 * 允许返回值、抛出异常
 * @author C4y
 *
 */
public class CreateThreadUsingCallable implements Callable {
	
	private int count;
	
	//1.创建Callable接口的实现类，并实现run方法
	@Override
	public String call() throws Exception {
		
		for ( ; count < 20; count ++){
			
			//输出当前线程名及其实例变量		
			System.out.println(Thread.currentThread().getName() +"  "+ count);
			
		}
		
		return "执行结束！";
	}
	public static void main(String[] args) {
		
			//2.创建Callable实现类的实例
			CreateThreadUsingCallable cc = new CreateThreadUsingCallable();
			//3.使用FutureTask包装Callable对象
			FutureTask<String> ft = new FutureTask(cc);
			
		for(int i = 0;i < 20;i++){
			
			//再i=10时启动线程，线程并不会立即执行
			if (i==10){

				//4.将FutureTask对象作为Thread的target来创建新线程
				new Thread(ft).start();
				//5.获取Thread的返回值——阻塞
				try {
					 System.out.println(ft.get());
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}
			System.out.println(Thread.currentThread().getName() +"  "+ i);
			

	}


			
		}

}
