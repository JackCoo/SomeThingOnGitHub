package com.netease;

import java.util.Scanner;
/**
 * 
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 * 例如：半径的平方如果为25
 * 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
 * @author C4y
 *
 */
public class Point {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer l = 0;
		Integer sum = 0;
		if(scan.hasNextInt()){
			l=scan.nextInt();
			double r = Math.sqrt(l);
			
			for (int x = 0;x < r;x++){
				
				for(int y =0;y <= r;y++){
					if(l==y*y+x*x){
						sum++;
					}else if(l<y*y+x*x){
						break;
					}
				}
			}
			sum *=4;
			System.out.println(sum);
		}

	}

}
