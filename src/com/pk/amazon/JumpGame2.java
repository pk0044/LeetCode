package com.pk.amazon;

public class JumpGame2 {
    public int jump(int[] nums) {
    	
    	int[] jump = new int[nums.length];
    	
    	if(nums.length <= 1) {
    		return 0;
    	}
    	
    	jump[0] = 0;
    	
    	if(nums[0] >= nums.length-1) {
    		return 1;
    	}
    	
    	for(int i=1; i<=nums[0]; i++) {
    		if(i < nums.length) {
    			jump[i] = 1;
    		}
    	}
    	
    	int index = 1;
    	int minJump = 1;
    	int reachedIndex = nums[0];
    	int nextIndex = 0;
    	while(index < nums.length) {
    		if(reachedIndex >= nums.length-1) {
    			break;
    		}
    		
    		if(index <= reachedIndex) {
    			if(index + nums[index] > nextIndex) {
    				nextIndex = index + nums[index];
    			}
    		}else {
    			
    			if(nextIndex >= nums.length-1) {
    				break;
    			}
    			
    			minJump++;
    			
    			for(int i=index; i<=nextIndex; i++) {
    				jump[i] = minJump;
    			}
    			reachedIndex = nextIndex;
    		}
    		index++;
    	}
    	
    	return minJump;
    }
}
