package com.one.Thread.Synchronization;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行取钱——由于线程调度器的随机性，多个线程同时操作同一个数据时，出现线程安全问题
 * 线程同步方法：
 * 1.同步代码块，同步监视器，加锁————修改————释放锁
 * 		使用 synchronized(obj) {
 * 			}
 * 		来包围代码块，其中obj为同步监视器，推荐使用 共享资源 作为同步监视器。代码块执行完毕后，线程会释放对监视器的锁定
 * 
 * 2.同步方法：
 * 		使用synchronized来修饰需要线程同步的方法,同步监视器为this，即调用该方法的对象。
 * 
 * 3.同步锁:
 * 		通过显示的定义同步锁对象来实现同步，同步锁由Lock对象充当。常用的是ReentrantLock（可重入锁）.
 * 		建议使用finally来确保在必要时释放锁。
 * @author C4y
 *
 */
public class BankProblem extends Thread {
	
	
	private Account account;
	private double drawMoney;
	
	//传入需要操作的账户对象、金额
	public BankProblem(Account account,double drawMoney){
		
		this.account = account;
		this.drawMoney = drawMoney;
		
	}
	
	//运行取钱方法，当多个线程同时修改一个 共享数据时，将涉及数据安全问题
	public void run(){
		
		//1.使用同步代码块
//		synchronized (account) {
//			
//			account.drawMoney(drawMoney);	
//		}
		
		account.drawMoney(drawMoney);	

	}
	public static void main (String[] args ){
		
		//创建一个银行账户
		Account account = new Account(03121207, 1000);
		//同时模拟两个线程同时对同一个账户进行取钱
		BankProblem bt1 = new BankProblem(account, 500);
		BankProblem bt2 = new BankProblem(account, 600);
		
		bt1.start();
		bt2.start();
		
	}
}

/*
 * 银行账户 
 * 
 */
class Account {
	
	//3.1新建一个同步锁 lock对象
	private final ReentrantLock lock = new ReentrantLock();
	
	//账户ID、余额
	private Integer accountID;
	private double balance;
	
	//构造器
	public Account (Integer accountID,double balance){
		this.accountID = accountID;
		this.balance = balance;	
	}
	
	//2.同步的取钱方法
	//public synchronized void drawMoney(double drawMoney){
	
	//普通的取钱方法
	public void drawMoney(double drawMoney){
		
		//3.2 使用lock()方法 加锁
		lock.lock();
		if (balance >= drawMoney){
			
			System.out.println("取钱成功，金额为：" + drawMoney);
			//线程问题出现在此处——多个线程同时进入了if代码段，将无法保证操作后余额>0
			balance -= drawMoney;
			System.out.println("余额为：" + balance);

		}else{
			
			System.out.println("余额不足！");
		}
		//3.3 使用unlock()方法 释放锁
		lock.unlock();
	}
	
	//doset、doget
	public void setAccountID (Integer accountID){
		this.accountID = accountID;
		
	}
	
	public Integer getAccountID (){
		
		return accountID;
	}
	
	public void setBalance(double balance){
		
		this.balance = balance;
	}
	
	public double getBalance(){
		
		return balance;
	
	}
}