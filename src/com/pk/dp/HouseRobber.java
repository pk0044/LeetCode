package com.pk.dp;


/**
 * problem link : https://leetcode.com/problems/house-robber/
 * @author pk0044
 *
 */
public class HouseRobber {
	private int robBF(int[] nums, int index, int loot) {
		if(index >= nums.length) {
			return loot;
		}
		
		int c2 = 0;
		if(index+1 < nums.length) {
			c2 = nums[index+1];
		}
		
		return Math.max(robBF(nums, index+2, loot+nums[index]), robBF(nums, index+3, loot+c2));
	}
	
	private int robDP(int[] nums) {
        if(nums.length == 0) {
			return 0;
		}
        if(nums.length == 1){
            return nums[0];
        }
		int[] loot = new int[nums.length];
		
		loot[0] = nums[0];
		loot[1] = Math.max(nums[0], nums[1]);
		
		for(int i=2; i<nums.length; i++) {
			loot[i] = Math.max(nums[i] + loot[i-2], loot[i-1]);
		}
		
		return loot[nums.length-1];
	}
    public int rob(int[] nums) {
       // return robBF(nums, 0, 0);
    	return robDP(nums);
    }
}
