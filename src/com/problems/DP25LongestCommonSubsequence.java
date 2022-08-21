package com.problems;

import java.util.Arrays;

public class DP25LongestCommonSubsequence {
	
	private static int lcs(String str1, int m, String str2, int n, int[][] dp) {
		
		if(n==0 || m==0)
			return 0;
		
		if(dp[m][n]!=-1)
			return dp[m][n];
		
		if(str1.charAt(m-1)==str2.charAt(n-1))
			return 1+lcs(str1, m-1, str2, n-1, dp);
		
		int pick1 = lcs(str1, m-1, str2, n, dp);
		int pick2 = lcs(str1, m, str2, n-1, dp);
		
		dp[m][n] = Math.max(pick1, pick2);
		
		return dp[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "pqr";
		String str2 = "tpuqvr";
		int m = str1.length();
		int n = str2.length();
		/*int[][] dp = new int[m+1][n+1];
		for(int[] row: dp)
			Arrays.fill(row, -1);
		System.out.println("LCS: "+lcs(str1, m, str2, n, dp));*/
		
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
		
		

	}

}
