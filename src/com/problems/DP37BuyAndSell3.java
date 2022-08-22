package com.problems;

public class DP37BuyAndSell3 {
	 
	public static int max(int[] prices, int ind, int buy, int cap, int n, int[][][] dp) {
	        if(ind==n || cap==0) return 0;
	        
	        if(dp[ind][buy][cap]!=-1)
	            return dp[ind][buy][cap];
	        
	        int pick = 0;
	        int nopick = 0;
	        if(buy==1) {
	            pick = -prices[ind]+max(prices, ind+1, 0, cap, n, dp);
	            nopick = max(prices, ind+1, 1, cap, n, dp);
	        } else {
	            pick = prices[ind]+max(prices, ind+1, 1, cap-1, n, dp);
	            nopick = max(prices, ind+1, 0, cap, n, dp);
	        }
	        
	        dp[ind][buy][cap] =  Math.max(pick, nopick);
	        
	        return dp[ind][buy][cap];
	    }

	public static void main(String[] args) {
		
		/**1. Buying a stock and then selling it is called one transaction. 
		   2. You are not allowed to do multiple transactions at the same time. 
			  This means you have to sell the stock before buying it again.
			  Also, you can only complete at most 2-transactions.
			  Find the maximum profit that you can earn from these transactions.
		 **/

		int[] prices = {3, 3, 5, 0, 3, 1, 4};
		int n = prices.length;
		int maxTran = 2;
        /*int[][][] dp = new int[n+1][2][2+1];
        for(int[][] rows:dp)
            for(int[] row: rows)
              Arrays.fill(row, -1);  
        int res = max(price, 0, 1, maxTran, n, dp);
        return res;*/
        //----------Tabulation
       int[][][] dp = new int[n+1][2][3];
       //base case
       /*for(int ind=0;ind<=n;ind++)
           for(int buy=0;buy<=1;buy++)
              dp[ind][buy][0] = 0;
       
       for(int buy=0;buy<=1;buy++)
           for(int cap=0;cap<=2;cap++)
              dp[n][buy][0] = 0;*/
       
       for(int ind=n-1;ind>=0;ind--){
           for(int buy=0;buy<=1;buy++) {
               for(int cap=1;cap<=2;cap++) {
                   
                   int pick = 0;
                   int nopick = 0;
                   if(buy==1) {
                       pick = -prices[ind]+dp[ind+1][0][cap];
                       nopick = dp[ind+1][1][cap];
                       
                   } else {
                       pick = prices[ind]+dp[ind+1][1][cap-1];
                       nopick =dp[ind+1][0][cap];
                   }

                   dp[ind][buy][cap] =  Math.max(pick, nopick);
                   
               }                
               
           }
           
       }
       
       System.out.println("Max Profit perform by at most 2 Transactions: "+dp[0][1][2]);
	}

}
