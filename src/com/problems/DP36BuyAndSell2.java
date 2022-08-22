package com.problems;

import java.util.Arrays;

public class DP36BuyAndSell2 {
	
	public static long maxProfit(int[] val, int ind, int buy, int n, long[][] dp) {
		
		if(ind==n)
			return 0;
		
		if(dp[ind][buy]!=-1)
			return dp[ind][buy];
		
		long pick=0;
		long nopick=0;
		if(buy==1) {
			pick = -val[ind]+maxProfit(val, ind+1, 0, n, dp);
			nopick = 0+maxProfit(val, ind+1, 1, n, dp);
		} else {
			pick = val[ind]+maxProfit(val, ind+1, 1, n, dp);
			nopick = 0+maxProfit(val, ind+1, 0, n, dp);
		}
		
		dp[ind][buy] = Math.max(pick, nopick);
		
		return dp[ind][buy];
	}

	public static void main(String[] args) {
		
		//can perform any number of transaction but can't be overlap
		//You may make as many transactions as you want but can not have more than one transaction at a time 
		//i.e, if you have the stock, you need to sell it first, and then only you can buy it again.
		int[] value = {7, 1, 5, 3, 6, 4};
		int n = 6;
		/*long[][] dp = new long[n+1][2];
		for(long[] row:dp)
		Arrays.fill(row, -1);
		long ans = maxProfit(values, 0, 1, n, dp);
		System.out.println(ans);*/
		
		
		//----------Tabulation
		long[][] dp = new long[n+1][2];
		
		dp[n][0] = 0; dp[n][1] = 0;
		
		for(int ind=n-1;ind>=0;ind--) {
			
			for(int buy=0;buy<=1;buy++) {
				
				long pick=0;
				long nopick=0;
				if(buy==1) {
					pick = -value[ind]+dp[ind+1][0];
					nopick = dp[ind+1][1];
				} else {
					pick = value[ind]+dp[ind+1][1];
					nopick = dp[ind+1][0];
				}
				
				dp[ind][buy] = Math.max(pick, nopick);
				
			}
			
		}
		
		System.out.println("MaxProfit: "+dp[0][1]);
		

	}

}
