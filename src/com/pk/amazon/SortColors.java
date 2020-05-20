package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/sort-colors/
 * @author pk0044
 * 
 * red - 0, white - 1, blue - 2
 *
 */
public class SortColors {
	
    public void sortColors(int[] nums) {
    	if(nums.length == 0 || nums.length == 1) {
    		return;
    	}
    	
    	int start = 0;
    	int end = nums.length - 1;
    	int index = 0;
    	
    	while(index <= end && start < end) {
    		if(nums[index] == 0) {
    			nums[index] = nums[start];
    			nums[start] = 0;
    			start++;
    			index++;
    		}else if(nums[index] == 2) {
    			nums[index] = nums[end];
    			nums[end] = 2;
    			end--;
    			index++;
    		}else {
    			index++;
    		}
    	}
    }

}
