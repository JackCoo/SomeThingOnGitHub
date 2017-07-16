package com.one.Thread.Communication;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition控制线程通信 ，多线程间协调通信的工具类
 * 对于未使用synchronize关键字 保证线程同步，而使用Lock对象的，其不存在 同步监视器，也就无法使用wait等方法。
 * 
 * 此时，lock替代了同步代码块或同步方法，而condition替代了同步监视器的功能。
 * 
 * lock.newCondition();
 * await、signal、signalALl
 * @author C4y
 *
 */
public class Condition {

	public static void main(String[] args) {
		
		//新建一个模拟账户
		Account acc = new Account(03121207, 0);
		//创建1个取款线程核3个存款线程
		new DrawThread2(acc, 500).start();
		new SaveMoney2(acc, 500).start();
		new SaveMoney2(acc, 500).start();
		new SaveMoney2(acc, 500).start();
	}

}


//取款线程类
class DrawThread2 extends Thread{
	
	
	private Account account;
	private double drawMoney;
	
	//构造器,获得操作账户对象和操作金额
	public DrawThread2 (Account account,double drawMoney){
		
		this.account = account;
		this.drawMoney = drawMoney;
		
	}
	
	//重写run方法--连续取款100次
	public void run(){
		
		try {
			 for(int i = 0; i < 100; i++){
				 
				 account.drawMoney(drawMoney);
				 
			 }
		
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}


//存款线程类
class SaveMoney2 extends Thread  {
	
	private Account account;
	private double saveMoney;
	
	//构造器--获得操作账户对象和操作金额
	public SaveMoney2 (Account account,double saveMoney){
		
		this.account = account;
		this.saveMoney = saveMoney;
		
	}
	
	//重写run方法--连续存款100次
	public void run(){
		
		try {
			for(int i = 0; i < 100; i++){
				
				account.saveMoney(saveMoney);
			}
			
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
/*
 * 银行账户类
 * 
 */
class Account2 {
	
	//1.创建lock对象
	private final ReentrantLock lock = new ReentrantLock();
	//2.创建condition对象
	private final java.util.concurrent.locks.Condition cond = lock.newCondition();
	
	
	//是否存钱标志
	private boolean hasSaved = false;
	//账户ID、余额
	private Integer accountID;
	private double balance;
	
	//构造器
	public Account2 (Integer accountID,double balance){
		this.accountID = accountID;
		this.balance = balance;	
	}
	
	//同步的取钱方法——不考虑余额不足
	public void drawMoney(double drawMoney) throws InterruptedException{
		
		//加锁
		lock.lock();
		
		if (hasSaved == true){
			
			System.out.println("1取钱成功，金额为：" + drawMoney);
			balance -= drawMoney;
			System.out.println("余额为：" + balance);
			
			hasSaved = false;
			//唤醒其他所有线程,但由于hasSaved=false,即使唤醒的线程中有取钱线程也不会执行取钱操作
			cond.signalAll();
			
		}else
			//阻塞等待--等待存钱线程完成存钱操作
			cond.await();


	}
	
	//线程同步的 存钱方法
	public void saveMoney(double saveMoney) throws InterruptedException{
		
		if (hasSaved){
			//阻塞等待--等待取钱方法完成取钱操作
			cond.await();
		}else {
			
			balance += saveMoney;
			System.out.println("0存钱成功，金额为：" + saveMoney);
			System.out.println("余额为：" + balance);
			//更改hasSaved标志状态
			hasSaved = true;
			//唤醒其他所有线程--但由于hasSaved=true,即使唤醒的线程中有存钱线程也不会执行存钱操作
		    cond.signalAll();
			
			
		}
		
			
		
		
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
