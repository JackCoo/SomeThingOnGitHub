package com.netease;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

public class JiYueShu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long sum = 0;
		if(scan.hasNextLine()){
			int n = scan.nextInt();
			for(int i = 1;i <= n; i++){
				
				sum += function(i);
			}
			
			
		}
		System.out.println(sum);
		
		//System.out.println(function(6));
	}
	
	public static int function(int x){
		int fa = 0;
		if(x%2 == 0){
			for(int i = x-1;i > 0;i = i-2){
				if(x%i == 0){
					//System.out.println(i);
					fa = i;	
					break;
				}
			}
			
		}else{
			
			fa = x;
		}
		return fa;
	}

}
