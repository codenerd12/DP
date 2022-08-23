package com.problems;

public class DP40BuyAndSellTransactionFee {
	
	public static int maxProfit(int[] prices, int ind, int buy, int n, int fee, int[][] dp) {
        
        if(ind==n)
            return 0;
        if(dp[ind][buy]!=-1)
            return dp[ind][buy];
        
        int pick = 0;
        int nopick = 0;
        if(buy==1) {
            pick = -prices[ind]+maxProfit(prices, ind+1, 0, n, fee, dp);
            nopick = maxProfit(prices, ind+1, 1, n, fee, dp);
        } else {
           pick = prices[ind]+maxProfit(prices, ind+1, 1, n, fee, dp)-fee;
           nopick = maxProfit(prices, ind+1, 0, n, fee, dp);             
        }
        
        dp[ind][buy] = Math.max(pick, nopick);
        return dp[ind][buy];
    }
	
	public static int tabulation(int[] prices , int n, int fee) {
		
		  int[][] dp = new int[n+1][2];
	        
	        for(int ind=n-1;ind>=0;ind--) {
	            
	            for(int buy=0;buy<=1;buy++) {
	                
	                int pick=0;
	                int nopick=0;
	                if(buy==1) {
	                    pick = -prices[ind]+dp[ind+1][0];
	                    nopick = dp[ind+1][1];
	                } else {
	                    pick = prices[ind]+dp[ind+1][1]-fee;
	                    nopick = dp[ind+1][0];
	                }
	                
	                dp[ind][buy] = Math.max(pick, nopick);
	                
	            }
	            
	        }
	        
	      return dp[0][1];
	}

	public static void main(String[] args) {
		
		/**
		 * Given 'N' number of days and an array 'PRICES' of size 'N' price of the chocolate each day. 
		 * and variable 'FEE' fee for the transaction. Find the maximum profit.
		 */
		
		int[] prices = {1, 3, 5, 6};
		int n = prices.length;
		int fee = 2;
		 /*int[][] dp = new int[n+1][2];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return maxProfit(prices, 0, 1, n, fee, dp);*/
		
		System.out.println(tabulation(prices, n, fee));
		
	}

}
