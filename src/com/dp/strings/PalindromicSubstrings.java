package com.dp.strings;

public class PalindromicSubstrings {
	
	public static int palingdrom(String str, int left, int right) {
		int count = 0;
		
		while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)) {
			count++;
			left--;
			right++;
			
		}
		
		return count;
	}
	
	public static int countPalindromSubstring(String s) {
	
		int n = s.length();
        int res = 0;

        for(int i=0;i<n;i++) {
        	
        	
        	int count1 = palingdrom(s, i, i);
	   		int count2 = palingdrom(s, i, i+1);
	   		 
	   		res += count1;
	   		res += count2;


        }
        
        
        return res;
		
	}
	
	
	public static int countPalindromSubstringUsingDP(String s) {
		
		int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for(int gap=0;gap<n;gap++) {

            int row = 0;

            for(int col=gap;col<dp.length;col++) {

                if(gap==0) {

                    dp[row][col] = true;

                } else if(gap==1) {

                    if(s.charAt(row)==s.charAt(col))
                        dp[row][col] = true;

                } else {

                     if(s.charAt(row)==s.charAt(col) && dp[row+1][col-1])
                        dp[row][col] = true;

                }

                if(dp[row][col]==true) {
                    count++;
                }

                row++;
            }
        }
            
            
        return count;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "babad";  
		
		//there are palingdrom substring: "b","a","b","a","d","bab","aba". so there are total 7 substring 
		System.out.println("Count Palindromic Substring: "+countPalindromSubstringUsingDP(str)); 
		
		System.out.println("Count Palindromic Substring: "+countPalindromSubstring(str)); 

	}

}
