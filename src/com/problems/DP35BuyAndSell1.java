package com.problems;

public class DP35BuyAndSell1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7, 1, 5, 3, 6, 4};
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<arr.length;i++) {
			min = Math.min(min, arr[i]);	
			max = Math.max(max, arr[i]-min);
		}
		
		System.out.println(max);

	}

}
