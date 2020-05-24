package com.pk.arrays;

/**
 * problem link : https://leetcode.com/problems/max-chunks-to-make-sorted/
 * @author pk0044
 *
 */
public class MaxChunkSort {
    public int maxChunksToSorted(int[] arr) {
    	if(arr.length == 0) {
    		return 0;
    	}
    	int count = 0;
    	int max = arr[0];
    	int index = 0;
    	
    	while(index < arr.length) {
    		if(arr[index] > max) {
    			max = arr[index];
    		}else if(index == max) {
    			count++;
    			if(index+1 < arr.length) {
    				max = index+1;
    			}
    		}
    		index++;
    	}
    	
    	return count;
    }
}
