package com.one.Thread.Create;


public class SecondThread implements Runnable
{
	private int i ;
	public void run()
	{
		for ( ; i < 20 ; i++ )
		{
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
		}
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 20;  i++)
		{
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
			if (i == 10)
			{
				SecondThread st = new SecondThread(); 
				new Thread(st).start();
				new Thread(st).start();
			}
		}
	}
}

