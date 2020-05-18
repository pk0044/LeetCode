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
    	if(nums.length == 0) {
    		return;
    	}
    	
    	int red = -1;
    	int blue = nums.length;
    	
    	int index = 0;
    	
    	while(index < blue) {
    		if(nums[index] == 0) {
    			if(red == index - 1) {
    				red++;
    			}else {
    				red++;
    				int temp = nums[red];
    				nums[red] = nums[index];
    				nums[index] = temp;
    			}
    		}else if(nums[index] == 2) {
    			if(index + 1 == blue) {
    				blue--;
    			}else {
    				blue--;
    				if(nums[blue] == 0) {
    					s
    				}
    			}
    		}
    		index++;
    	}
    }
}
