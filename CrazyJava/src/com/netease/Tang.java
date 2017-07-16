package com.netease;

import java.util.Scanner;

public class Tang {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		if(scan.hasNextLine()){
			int a1 = scan.nextInt();
			int a2 = scan.nextInt();		
			int a3 = scan.nextInt();
			int a4 = scan.nextInt();
			//float a = (a1+a3)/2;//两数相除会取整
			if((a1+a3)%2 == 0 ){//判断a1+a2是否为偶数
				int a = (a1+a3)/2;
				int b = a3-a;
				int c = a4-b;
				if(a>=0&&b>=0&&c>=0)
					System.out.println(a+" "+b+" "+c);	
				else
					System.out.println("No");
			}

			else
				System.out.println("No");
		}
	}

}
