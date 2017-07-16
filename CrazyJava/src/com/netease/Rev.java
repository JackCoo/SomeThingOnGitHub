package com.netease;

import java.util.Scanner;
/**
 * 
 * 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
 * 如果 X = 123，则rev(X) = 321;
 * 如果 X = 100，则rev(X) = 1.
 * 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？ 
 * 输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。
 * 输出rev(rev(x) + rev(y))的值
 * @author C4y
 *
 */
public class Rev {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		if(scan.hasNextLine()){
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			System.out.println(rev(rev(x) + rev(y)));
		}
	}
	
	public static int rev(int x){
		
		String str = String.valueOf(x);
		StringBuilder sb = new StringBuilder();
		for(int i = str.length()-1; i >= 0;i--){
			sb.append(str.charAt(i));
		}
		
		return Integer.parseInt(sb.toString());
	}

}
