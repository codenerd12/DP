package com.dp.strings;

public class LongestPalingdromicSubstring {
	
	public static String palingdrom(String str, int left, int right) {
		
		while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)) {
			
			left--;
			right++;
			
		}
		
		return str.substring(left+1, right);
	}
	
	public static String longestPalindromSubstring(String s) {
		
		int n = s.length();
		
		String res = "";
		
		for(int i=0;i<n;i++) {
			
		 String s1 = palingdrom(s, i, i);
		 String s2 = palingdrom(s, i, i+1);
		 
		 res = res.length()>s1.length()?res:s1;
		 res = res.length()>s2.length()?res:s2;
			
		}
		
		return res;
	}
	
	public static String longestPalindromSubstringUsingDP(String s) {
		
		int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;

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
                    start = row;
                    end = col+1;
                }

                row++;
            }
        }
            
            
        return s.substring(start, end);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "babad";
		System.out.println("Longest Palindrom String: "+longestPalindromSubstringUsingDP(str));
		
		System.out.println("Longest Palindrom String: "+longestPalindromSubstring(str));

	}

}
