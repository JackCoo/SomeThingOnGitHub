package com.one.Thread.Communication;


/**
 * 线程通信之Synchronized同步的线程间通信 多线程间协调通信
 * 模拟 存——取 依次进行的场景，在多线程的情况下存取依次进行。
 * 
 * 使用 同步监视器 的wait、notifyALL、notify等方法进行线程间通信
 * wait 导致该线程等待
 * notify会唤醒 此监视同步器 等待（wait）的单个线程，随机。
 * notifyALL 唤醒该同步监视器上的所有等待线程
 * @author C4y
 *
 */
public class Synchronized {

	public static void main(String[] args) {
		
		//新建一个模拟账户
		Account acc = new Account(03121207, 0);
		//创建1个取款线程核3个存款线程
		new DrawThread(acc, 500).start();
		new SaveMoney(acc, 500).start();
		new SaveMoney(acc, 500).start();
		new SaveMoney(acc, 500).start();
	}

}


//取款线程类
class DrawThread extends Thread{
	
	
	private Account account;
	private double drawMoney;
	
	//构造器,获得操作账户对象和操作金额
	public DrawThread (Account account,double drawMoney){
		
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
class SaveMoney extends Thread  {
	
	private Account account;
	private double saveMoney;
	
	//构造器--获得操作账户对象和操作金额
	public SaveMoney (Account account,double saveMoney){
		
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
class Account {
	
	//是否存钱标志
	private boolean hasSaved = false;
	//账户ID、余额
	private Integer accountID;
	private double balance;
	
	//构造器
	public Account (Integer accountID,double balance){
		this.accountID = accountID;
		this.balance = balance;	
	}
	
	//同步的取钱方法——不考虑余额不足
	public synchronized void drawMoney(double drawMoney) throws InterruptedException{
		
		if (hasSaved == true){
			
			System.out.println("1取钱成功，金额为：" + drawMoney);
			balance -= drawMoney;
			System.out.println("余额为：" + balance);
			
			hasSaved = false;
			//唤醒其他所有线程,但由于hasSaved=false,即使唤醒的线程中有取钱线程也不会执行取钱操作
			notifyAll();
			
		}else
			//阻塞等待--等待存钱线程完成存钱操作
			wait();


	}
	
	//线程同步的 存钱方法
	public synchronized void saveMoney(double saveMoney) throws InterruptedException{
		
		if (hasSaved){
			//阻塞等待--等待取钱方法完成取钱操作
			wait();
		}else {
			
			balance += saveMoney;
			System.out.println("0存钱成功，金额为：" + saveMoney);
			System.out.println("余额为：" + balance);
			//更改hasSaved标志状态
			hasSaved = true;
			//唤醒其他所有线程--但由于hasSaved=true,即使唤醒的线程中有存钱线程也不会执行存钱操作
			notifyAll();
			
			
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