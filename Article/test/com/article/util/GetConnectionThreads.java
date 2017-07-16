package com.article.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.article.dao.UserDao;
import com.article.model.User;

public class GetConnectionThreads extends Thread{
	
	
	public void run(){
		
		Connection conn = DButil.getConnection();
		System.out.println(Thread.currentThread().getName()+conn);
		User ud = new UserDao().queryUser("chongyanjie");
		System.out.println(ud);
		
		
	}
	
	public static void main (String[] args){
		
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		new GetConnectionThreads().start();
		
		
	}

}
