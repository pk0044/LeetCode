package com.pk.problems;

/**
 * Problem : There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Example :
 * Input:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * Output : 2.0
 * 
 * 
 * Problem link : https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * @author pk0044
 *
 */

public class MedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	double res = 0.0;
    	
    	int size1 = nums1.length;
    	int size2 = nums2.length;
    	
    	int total = size1 + size2;
    	
    	int mid = total / 2;
    	
    	int flag;
    	
    	if(total % 2 == 0) {
    		flag = 0;
    	}else {
    		flag = 1;
    	}
    	
    	int index = 0;
    	
    	int i1 = 0;
    	int i2 = 0;
    	
    	while(index != mid) {
    		if(nums1[i1] > nums2[i2]) {
    			i2++;
    		}else {
    			i1++;
    		}
    		index++;
    	}
    	
    	if(flag == 0) {
    		
    	}else {
    		
    	}
    	
		return res;
    }
}
