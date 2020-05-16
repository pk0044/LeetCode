package com.pk.amazon;

public class JumpGame2 {
    public int jump(int[] nums) {
    	
    	if(nums.length <= 1) {
    		return 0;
    	}
    	
    	if(nums[0] >= nums.length-1) {
    		return 1;
    	}
    	
    	int currentIndex = 1;
    	int jump = 1;
    	int jumpedIndex = nums[0];
    	int nextJumpIndex = nums[0];
    	
    	while(currentIndex < nums.length) {
    		if(currentIndex <= jumpedIndex) {
    			if(currentIndex + nums[currentIndex] > nextJumpIndex) {
    				nextJumpIndex = currentIndex + nums[currentIndex];
    			}
    			
    			if(nextJumpIndex >= nums.length-1) {
    				jump++;
    				break;
    			}
    		}
    		
    		if(currentIndex == jumpedIndex) {
    			jump++;
    			jumpedIndex = nextJumpIndex;
    		}
    		
    		currentIndex++;
    	}

    	return jump;
    }
}
