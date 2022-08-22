package com.problems;

public class DP39BuyAndSellCooldown {
	
	public static int maxProfit(int[] prices, int ind, int buy, int n, int[][] dp) {
        
        if(ind>=n)
            return 0;
        
        if(dp[ind][buy]!=-1)
            return dp[ind][buy];
        
        int pick=0;
        int nopick = 0;
        
        if(buy==1) {
            pick = -prices[ind]+maxProfit(prices, ind+1, 0, n, dp);
            nopick = maxProfit(prices, ind+1, 1, n, dp);
        } else {
            pick = prices[ind]+maxProfit(prices, ind+2, 1, n, dp);
            nopick = maxProfit(prices, ind+1, 0, n, dp);
        }
        
        dp[ind][buy] = Math.max(pick, nopick);
        return dp[ind][buy];
    }
	
	public static int byTabulation(int[] prices, int n) {
		
		int[][] dp = new int[n+2][3];
        
        for(int ind=n-1;ind>=0;ind--) {
            for(int buy=0;buy<=1;buy++) {
                
                int pick=0;
                int nopick = 0;

                if(buy==1) {
                    pick = -prices[ind]+dp[ind+1][0];
                    nopick = dp[ind+1][1];
                } else {
                    pick = prices[ind]+dp[ind+2][1];
                    nopick = dp[ind+1][0];
                }

                dp[ind][buy] = Math.max(pick, nopick);
                
            }
        }
        
        return dp[0][1];
	}

	public static void main(String[] args) {
		
		/**
		 * given a list of stock prices, ‘prices’. Where ‘prices[i]’ represents the price on ‘i’th day. 
		 * Your task is to calculate the maximum profit you can earn by trading stocks 
		 * if you can only hold one stock at a time. After you sell your stock on the ‘i’th day, 
		 * you can only buy another stock on ‘i + 2’ th day or later.
		 */
		
		int[] prices = {4, 9, 0, 4, 10};
		int n = prices.length;
        /*int[][] dp = new int[n+1][2];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return maxProfit(prices, 0, 1, n, dp);*/
        
		System.out.println(byTabulation(prices, n));
	}

}
