package com.problems;

public class DP27LongestCommonSubstring {

	public static void lcsub(String str1, int m, String str2, int n) {
		
		//------------Tabulation
				int[][] dp = new int[m+1][n+1];
				//Base case
				for(int i=0;i<=m;i++)
					dp[i][0] = 0;
				for(int i=0;i<=n;i++)
					dp[0][i] = 0;
				
				int ans = 0;
				for(int i=1;i<=m;i++) {
					
					for(int j=1;j<=n;j++) {
						
						 if(str1.charAt(i-1)==str2.charAt(j-1)) {
			                 dp[i][j] = 1+dp[i-1][j-1];
						 	 ans = Math.max(ans, dp[i][j]);
							} else {
								dp[i][j] =  0;
							}
						
					}
				}
				
				System.out.println("Lowest Common Substring: "+ans);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcjklp";
		String str2 = "acjkp";
		int m = str1.length();
		int n = str2.length();
		
		lcsub(str1, m, str2, n);
	}

}
