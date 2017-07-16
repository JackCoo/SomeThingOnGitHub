package com.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nNum =  scan.nextInt();
		int k =  scan.nextInt();
		List<Integer> n = new ArrayList<>();
		int n1 = 0;
		for (int i = 0;i < nNum;i++){
			n.add(scan.nextInt());
		}
		
		for(int j = 0;j < k;j++){
			n1 = n.get(0);
			for(int i = 0;i < nNum-1;i++){
				n.set(i, n.get(i)+n.get(i+1));	
				if(n.get(i)>=100)
					n.set(i, n.get(i)%100);
			}
			n.set(nNum-1, n.get(nNum-1)+n1);
			if(n.get(nNum-1)>=100)
				n.set(nNum-1, n.get(nNum-1)%100);
			//System.out.println(n);
		}
		//输出
		for(int i = 0;i < nNum-1;i++){
			
			System.out.print(n.get(i)+" ");
		}
		System.out.println(n.get(nNum-1));
	}

}
