package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/jump-game-ii/
 * @author pk0044
 *
 */
public class JumpGame2 {
	
	/**
	 * bruteforce approach
	 * @param nums
	 * @param start
	 * @param end
	 * @param count
	 * @return
	 */
	private int jumpBrute(int[] nums, int start, int end, int count) {
		if(start == end) {
			return count;
		}
		
		int min = Integer.MAX_VALUE;
		int jump;
		for(int i=1; i<=nums[start]; i++) {
			if(start + i <= end) {
				jump = jumpBrute(nums, start+i, end, count+1);
				if(jump < min) {
					min = jump;
				}
			}
		}
		
		return min;
	}
	
	/**
	 * still not working
	 * @param nums
	 * @return
	 */
	private int jumpDP(int[] nums) {
		if(nums.length <= 1) {
			return 0;
		}
		
		int[] jump = new int[nums.length];
		
		jump[0] = 0;
		boolean flag = false;
		for(int i=0; i<nums.length; i++) {
			for(int j=1; j<=nums[i]; j++) {
				if(i+j <nums.length) {
					jump[i+j] = jump[i] + 1;
				}
				if(i+j == nums.length-1) {
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		
		return jump[nums.length-1];
	}
	
    public int jump(int[] nums) {
    	return jumpBrute(nums, 0, nums.length-1, 0);
    }
}
