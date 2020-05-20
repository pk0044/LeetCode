package com.pk.amazon;

import java.util.Arrays;

/**
 * problem link : https://leetcode.com/problems/next-permutation/
 * @author pk0044
 *
 */
public class NextPermute {
	
	private int findNext(int index, int[] nums) {
		int res = 0;
		for(int i=nums.length - 1; i>index; i--) {
			if(nums[i] > nums[index]) {
				res = i;
				break;
			}
		}
		return res;
	}
	
	
	private void swap(int A, int B, int[] nums) {
		int temp = nums[A];
		nums[A] = nums[B];
		nums[B] = temp;
	}
	
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
        	return;
        }
        
        int index = nums.length - 1;
        
        while(index > 0) {
        	if(nums[index] > nums[index - 1]) {
        		int nextIndex = findNext(index-1, nums);
        		swap(nextIndex, index-1, nums);
        		Arrays.sort(nums, index, nums.length);
        		break;
        	}else {
        		index--;
        	}
        }
        
        if(index == 0) {
        	Arrays.sort(nums, 0, nums.length);
        }
    }
}
