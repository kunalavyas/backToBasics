package com.practice.dynamic_pro;

public class Factorial {
	
	public static void main(String[] args)
	{
		Factorial f= new Factorial();
		System.out.println("Factorial:"+f.bottomUpFactorial(4));
	}

	public int bottomUpFactorial(int number)
	{
		int dp[]= new int[number+1];
		dp[0]=1;
		for(int i=1;i<=number;i++)
		{
			dp[i]=dp[i-1]*i;
			
		}
		return dp[number];
	}
}
