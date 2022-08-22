package com.problems;

import java.util.Arrays;

public class DP38BuyAndSell4 {

	public static int maxProfit(int[] prices, int ind, int buy, int k, int n, int[][][] dp) {
        
        if(ind==n || k==0)
            return 0;
        
        if(dp[ind][buy][k]!=-1)
            return dp[ind][buy][k];
        
        int pick = 0;
        int nopick = 0;
        if(buy==1) {
            pick = -prices[ind]+maxProfit(prices, ind+1, 0, k, n, dp);
            nopick = maxProfit(prices, ind+1, 1, k, n, dp);
        } else {
            pick = prices[ind]+maxProfit(prices, ind+1, 1, k-1, n, dp);
            nopick = maxProfit(prices, ind+1, 0, k, n, dp);
        }
        
        dp[ind][buy][k] = Math.max(pick, nopick);
        
        return dp[ind][buy][k];
    }
	public static void main(String[] args) {
		
		int[] prices = {3, 2, 6, 5, 0, 3};
		int n = prices.length;
		int k = 2;
		/*int[][][] dp = new int[n+1][2][k+1];
        for(int[][] rows: dp)
           for(int[] row: rows)
                Arrays.fill(row, -1);
        return maxProfit(prices, 0, 1, k, n, dp);*/
		
		//----------Tabulation
		 int[][][] dp = new int[n+1][2][k+1];
	        
	        for(int ind=n-1;ind>=0;ind--) {
	            for(int buy=0;buy<=1;buy++) {
	                for(int tran=1;tran<=k;tran++) {
	                    
	                    int pick = 0;
	                    int nopick = 0;
	                    if(buy==1) {
	                        pick = -prices[ind]+dp[ind+1][0][tran];
	                        nopick = dp[ind+1][1][tran];
	                    } else {
	                        pick = prices[ind]+dp[ind+1][1][tran-1];
	                        nopick = dp[ind+1][0][tran];
	                    }

	                    dp[ind][buy][tran] = Math.max(pick, nopick);
	                }
	            }
	        }
	        
	        System.out.println("Max Profit perform by K Transactions: "+dp[0][1][k]);
		

	}

}
