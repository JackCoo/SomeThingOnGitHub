package com.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Taxi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int taxiNum = 0;
		List<Integer> tx = new ArrayList<>();
		List<Integer> ty = new ArrayList<>();
		List<Integer> walkTaxiTIme = new ArrayList<>();
		int gx;
		int gy;
		int walkTime;
		int taxiTime;
		int min;
		
		taxiNum = scan.nextInt();
		for (int i = 0;i < taxiNum;i++){
			tx.add(scan.nextInt());	
		}
		for (int i = 0;i < taxiNum;i++){
			ty.add(scan.nextInt());	
		}
		gx = scan.nextInt();
		gy = scan.nextInt();
		walkTime = scan.nextInt();
		taxiTime = scan.nextInt();
			
		//System.out.println(taxiTime);

		int walkOnlyTime = (Math.abs(gx)+Math.abs(gy))*walkTime;
		
		for (int i = 0;i < taxiNum;i++){
			walkTaxiTIme.add((Math.abs(tx.get(i))+Math.abs(ty.get(i)))*walkTime+((Math.abs(tx.get(i)-gx))+Math.abs(ty.get(i)-gy))*taxiTime);
		}
		if(walkOnlyTime < walkTaxiTIme.get(0))
			min = walkOnlyTime;
		else
			min = walkTaxiTIme.get(0);
		for(int i = 1;i < taxiNum;i++){
			
			if(walkTaxiTIme.get(i) < min)
				min = walkTaxiTIme.get(i);
		}
		System.out.println(min);
		//System.out.println(walkTaxiTIme);
		//System.out.println(walkOnlyTime);
	}

}
