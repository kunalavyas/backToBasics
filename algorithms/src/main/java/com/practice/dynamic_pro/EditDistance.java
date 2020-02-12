package com.practice.dynamic_pro;

public class EditDistance {

	/**
	 *  Without Dynamic programming
	 * @param str1 : First string
	 * @param str2 : Second string
	 * @param m : length of First string
	 * @param n : length of Second string
	 * @return
	 */
	int editDistance(String str1,String str2, int m , int n)
	{
		//If str1 empty then insert str2
		if(m==0)
			return n;
		//If str2 empty then insert str1
		if(n==0)
			return m;
		if(str1.charAt(m-1)==str2.charAt(n-1))
			return editDistance(str1,str2,m-1,n-1);
		return 1+min(editDistance(str1,str2,m,n-1),editDistance(str1, str2, m-1, n),editDistance(str1, str2, m-1, n-1));
	}
	int min(int x, int y, int z) {
		if(x<=y && x<=z)
			return x;
		if(x<=y && y<=z)
			return z;
		else
			return y;
	}
	
	public static void main(String[] args)
	{
		String str1="sunday";
		String str2="saturday";
		EditDistance e=  new EditDistance();
		System.out.println(e.editDistance(str1, str2, str1.length(), str2.length()));
	}
}
