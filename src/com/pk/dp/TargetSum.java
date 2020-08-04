package com.pk.dp;


/**
 * problem link : https://leetcode.com/problems/target-sum/
 * @author pk0044
 *
 */


public class TargetSum {
	private int solutionBF(int[] nums, int S, int sum, int index) {
		if(index >= nums.length) {
			if(sum == S) {
				return 1;
			}else {
				return 0;
			}
		}
		
		return solutionBF(nums, S, sum+nums[index], index+1) + solutionBF(nums, S, sum-nums[index], index+1);
	}
	
	
	private int solutionDP(int[] nums, int S) {
		int[][] DP = new int[nums.length][1001];
		
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<=S; j++) {
				
			}
		}
	}
    public int findTargetSumWays(int[] nums, int S) {
        return solutionBF(nums, S, 0, 0);
    }
}
