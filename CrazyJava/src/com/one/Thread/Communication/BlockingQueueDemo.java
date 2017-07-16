package com.one.Thread.Communication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 * 使用BlockingQueue接口控制线程通信，实现典型的生产者-消费者模型
 * BlockingQueue很好的解决了多线程中，如何高效安全“传输”数据的问题
 * 阻塞方法：
 * 		put，尝试把元素放入BQ，如果已满，则阻塞该线程；
 * 		take，尝试从BQ 头部取出元素，若队列为空，则阻塞该线程
 * 常用实现类：ArrayBlockingQueue和LinkedBlockingQueue
 * 
 * @author C4y
 *
 */
public class BlockingQueueDemo {
	
	public static void main(String[] args){
		//1.创建一个容量为2 的阻塞队列
		BlockingQueue<String> bg = new ArrayBlockingQueue<>(2);
		//启动两个生产者线程和一个消费者线程
		new Producer(bg).start();
		new Producer(bg).start();
		new Consumer(bg).start();
	}
	
	
}

//生产者
class Producer extends Thread {
	
	private BlockingQueue<String> bg;
	//即将生产的数据数组
	private String[] strArr = {"1","2","3"};
	
	//构造器——获得BlockingQueue
	public Producer(BlockingQueue<String> bg){
		
		this.bg = bg;
	}
	//重写run方法——尝试生产100分数据
	public void run (){
		
		for (int i = 0;i < 100;i++){
			System.out.println("生产者准备生产....");
			try {
					//尝试放入元素，如果队列已满，则线程阻塞
					bg.put(strArr[i % 3]);
					
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("生产完成,"+"仓库:"+bg);
		}
		
	}
}

//消费者
class Consumer extends Thread {
	
	private BlockingQueue<String> bg;
	
	public Consumer (BlockingQueue<String> bg){
		
		this.bg = bg;
		
	}
	
	public void run(){
		
		for (int i = 0;i < 100;i++){
			
			System.out.println("消费者准备消费...");
			
			try {
				
					System.out.println("--消费了:"+bg.take());
					
			} catch (Exception e){e.printStackTrace();};
			
			System.out.println("消费者成功消费,"+"仓库:"+bg);
		}
		
	}
}