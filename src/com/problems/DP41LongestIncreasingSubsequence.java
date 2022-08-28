   package com.problems;

import java.util.Arrays;

public class DP41LongestIncreasingSubsequence {
	
	private static int lis(int[] arr, int ind, int prevInd, int[][] dp) {
		
		if(ind==arr.length)
			return 0;
		
		if(dp[ind][prevInd+1]!=-1)
			return dp[ind][prevInd+1];
		
		int nopick = lis(arr, ind+1, prevInd, dp);
		int pick = 0;
		 
		if(prevInd==-1 || arr[ind]>arr[prevInd])
			pick = 1+lis(arr, ind+1, ind, dp);
		
		
		dp[ind][prevInd+1] = Math.max(nopick, pick);
		
		return dp[ind][prevInd+1];
	}
	
	private static int tabulation(int[] arr) {
		
		int n = arr.length;
		int[][] dp = new int[n+1][n+1];
		
		
		for(int ind=n-1;ind>=0;ind--) {
			
			for(int prevInd=ind-1;prevInd>=-1;prevInd--) {
				
				int nopick = dp[ind+1][prevInd+1];
				int pick = 0;
				
				if(prevInd==-1 || arr[ind]>arr[prevInd])
					pick = 1+dp[ind+1][ind+1];
				
				
				dp[ind][prevInd+1] = Math.max(nopick, pick);
				
			}
		}

		return dp[0][-1+1];
	}
	
	private static int optimized(int[] arr) {
		
		int[] dp = new int[arr.length];
		Arrays.fill(dp,  1);
		int max = Integer.MIN_VALUE;
		
		int[] hash = new int[arr.length];
		int lastIndex = 0;
		
		for(int i=0;i<arr.length;i++) {
			hash[i]  = i;
			
			 for(int prev=0;prev<i;prev++) {
				 
				 if(arr[prev] < arr[i] && 1+dp[prev] > dp[i]) {
					 
					 dp[i] = 1+dp[prev];
					 hash[i] = prev;
				 }
				 
			 }
			 
			 if(dp[i]>max) {
				 max = dp[i];
				 lastIndex = i;
			 }
			
		}
		
		//print sequence
		int[] lis = new int[max];
		int ind = lis.length-1;
		while(hash[lastIndex]!=lastIndex) {
			lis[ind--] = arr[lastIndex];
			lastIndex = hash[lastIndex];
		}
		lis[ind] = arr[lastIndex];
		
		System.out.println(Arrays.toString(lis));
		
		return max;
	}

	public static void main(String[] args) {
		
		int[] arr = {10, 9, 2, 5, 3, 7, 1, 18};
		int n = arr.length;
		/*int[][] dp =  new int[n+1][n+1];
		for(int[] row:dp)
			Arrays.fill(row, -1);
		System.out.println(lis(arr, 0, -1, dp));*/
		
		//-------------Tabulation
		//tabulation(arr);
		
		
		
		System.out.println(optimized(arr));
	}

	

}
