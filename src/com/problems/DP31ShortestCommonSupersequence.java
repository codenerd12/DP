package com.problems;

import java.util.Arrays;

public class DP31ShortestCommonSupersequence {

	private static int[][] lcs(String str1, String str2, int m, int n) {
		
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
			dp[i][0] = 0;
		for(int i=0;i<=n;i++)
			dp[0][i] = 0;
		
		
		for(int i=1;i<=m;i++) {
			
			for(int j=1;j<=n;j++) {
				
				if(str1.charAt(i-1)==str2.charAt(j-1))
					dp[i][j] = 1+dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "brute";
		String str2 = "groot";
		
		
		int m = str1.length();
		int n = str2.length();
		
		
		
		int[][] dp = lcs(str1, str2, m, n);
		
		int i=m;
		int j=n;
		String ans = "";
		while(i>0 && j>0) {
			
			if(str1.charAt(i-1)==str2.charAt(j-1)) {
				ans+=str1.charAt(i-1);
				i--;
				j--;
			} else if(dp[i-1][j] > dp[i][j-1]) {
				ans+=str1.charAt(i-1);
				i--;
			} else {
				ans+=str2.charAt(j-1);
				j--;
			}
			
		}
		
		while(i>0) {
			ans+=str1.charAt(i-1);
			i--;
		}
		
		while(j>0) {
			ans+=str2.charAt(j-1);
			j--;
		}
		
		System.out.println(ans);

	}

}
