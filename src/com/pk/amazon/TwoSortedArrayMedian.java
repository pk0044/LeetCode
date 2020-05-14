package com.pk.amazon;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * @author pk0044
 *
 */
public class TwoSortedArrayMedian {
	
	private double findMedian(int[] nums1, int[] nums2, int midx, int midy) {

	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        if(l1 < l2) {
        	int midx = (nums1.length) / 2;
        	int midy = (nums1.length + nums2.length + 1) / 2 - midx;
        	res = findMedian(nums1, nums2, midx, midy);
        }else {
        	int midx = nums2.length / 2;
        	int midy = (nums1.length + nums2.length + 1) / 2 - midx;
        	res = findMedian(nums2, nums1, midx, midy);
        }
        return res;
    }
}
