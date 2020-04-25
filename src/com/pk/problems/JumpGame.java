package com.pk.problems;

public class JumpGame {
    public boolean canJump(int[] nums) {
    	int size = nums.length;
    	boolean res = true;
    	int max_pos = 0;
    	int jump_pos = 0;
    	
    	for(int i=0; i<size; i++) {
    		if(nums[i] == 0) {
    			if(i == max_pos && i != size-1) {
    				res = false;
    				break;
    			}
    		}else if(nums[i] > 0) {
        		jump_pos = i + nums[i];
        		if(jump_pos > max_pos) {
        			max_pos = jump_pos;
        		}
        	}
    	}
    	return res;
    }
}
