package com.pk.leetcode.arrays;


/**
 * problem link : https://leetcode.com/problems/kth-largest-element-in-an-array/
 * @author pk0044
 *
 */

public class KthLargesElement {
	
	private void swap(int[] nums, int A, int B) {
		int temp = nums[A];
		nums[A] = nums[B];
		nums[B] = temp;
	}
	
	private int partition(int[] nums, int start, int end) {
		int p = nums[start];
		int index = end;
		for(int i=end; i>start; i--) {
			if(nums[i] >= p) {
				swap(nums, i, index);
				index--;
			}
		}
		swap(nums, index, start);
		return index;
	}
	
	private int quickSort(int[] nums, int K, int start, int end) {
		int p = partition(nums, start, end);
		if(p == nums.length-K) {
			return nums[p];
		}
		
		if(nums.length-K > p) {
			return quickSort(nums, K, p+1, end);
		}
		
		return quickSort(nums, K, start, p-1);
	}
	
    public int findKthLargest(int[] nums, int k) {
    	int res = 0;
    	res = quickSort(nums, k, 0, nums.length-1);
    	return res;
    }
    
}
