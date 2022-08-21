package com.problems;

import java.util.Arrays;

public class DP26PrintLCS {
	
	public static void printLCS(String str1, String str2) {
		
		int m = str1.length();
		int n = str2.length();
		//------------Tabulation
		int[][] dp = new int[m+1][n+1];
		//Base case
		for(int i=0;i<=m;i++)
			dp[i][0] = 0;
		for(int i=0;i<=n;i++)
			dp[0][i] = 0;
		
		for(int i=1;i<=m;i++) {
			
			for(int j=1;j<=n;j++) {
				
				 if(str1.charAt(i-1)==str2.charAt(j-1))
	                 dp[i][j] = 1+dp[i-1][j-1];
	               else {
	                 int pick1 = dp[i-1][j];
	                 int pick2 = dp[i][j-1];

	                 dp[i][j] =  Math.max(pick1, pick2);
	               }
				
			}
		}
		
		System.out.println("LCS: "+dp[m][n]);
		
		//--------------print LCS string
		int len = dp[m][n];
		char[] ch = new char[len];
		Arrays.fill(ch, '$');
		int i = m;
		int j = n;
		int index = len-1;
		while(i>0 && j>0) {
			
			if(str1.charAt(i-1)==str2.charAt(j-1)) {
				ch[index] = str1.charAt(i-1);
				index--;
				i--;
				j--;
			} else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			} else {
				j--;
			}
			
		}
		
		
		System.out.println("String: "+String.valueOf(ch));
	}

	public static void main(String[] args) {

		String str1 = "pqr";
		String str2 = "tpuqvr";
		printLCS(str1, str2);
		
	}

}
