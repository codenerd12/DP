package com.problems;

public class JumpGameII {
	
	static int min = Integer.MAX_VALUE;
	
	private static int minJump(int[] nums, int ind) {
		
		if(ind>=nums.length-1)
			return 0;
		
		if(nums[ind]==0)
			return 100000;
		
		for(int i=nums[ind];i>=1;i--)
			min = Math.min(min, 1+minJump(nums, ind+i));
		
		
		return min;
	}

	public static void main(String[] args) {
		
		int[] nums = {2,3,1,1,4};
		
		minJump(nums, 0);
		System.out.println(min);
	}

}
