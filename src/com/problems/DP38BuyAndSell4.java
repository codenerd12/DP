package com.problems;

import java.util.Arrays;

public class DP38BuyAndSell4 {

	public static int maxProfit(int[] prices, int ind, int transNo, int k, int n, int[][] dp) {
        
        if(ind==n || transNo == 2*k)
            return 0;
        
        if(dp[ind][transNo]!=-1)
            return dp[ind][transNo];
        
        int pick = 0;
        int nopick = 0;
        if(transNo%2==0) {
            pick = -prices[ind]+maxProfit(prices, ind+1, transNo+1, k, n, dp);
            nopick = maxProfit(prices, ind+1, transNo, k, n, dp);
        } else {
            pick = prices[ind]+maxProfit(prices, ind+1, transNo+1, k, n, dp);
            nopick = maxProfit(prices, ind+1, transNo, k, n, dp);
        }
        
        dp[ind][transNo] = Math.max(pick, nopick);
        
        return dp[ind][transNo];
    }
	public static void main(String[] args) {
		
		int[] prices = {3, 2, 6, 5, 0, 3};
		int n = prices.length;
		int k = 2;
		/*int[][] dp = new int[n+1][2*k];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        //return maxProfit(prices, 0, 0, k, n, dp);
        System.out.println(maxProfit(prices, 0, 0, k, n, dp));*/
		
		//----------Tabulation
		 int[][] dp = new int[n+1][2*k+1];
	        
	        for(int ind = n-1;ind>=0;ind--) {
	        	
	        	for(int tran=2*k-1;tran>=0;tran--) {
	                    
	                	int pick = 0;
	                    int nopick = 0;
	                    if(tran%2==0) {
	                        pick = -prices[ind]+dp[ind+1][tran+1];
	                        nopick = dp[ind+1][tran];
	                    } else {
	                        pick = prices[ind]+dp[ind+1][tran+1];
	                        nopick = dp[ind+1][tran];
	                    }
	                    
	                    dp[ind][tran] = Math.max(pick, nopick);
	            }
	        }
	        
	        System.out.println("Max Profit perform by K Transactions: "+dp[0][0]);
		

	}

}
