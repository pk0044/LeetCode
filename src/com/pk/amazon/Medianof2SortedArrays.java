package com.pk.amazon;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * @author pk0044
 *
 */
public class Medianof2SortedArrays {
	
	
	int getMin(int A, int B) {
		return A < B ? A : B;
	}
	
	int getMax(int A, int B) {
		return A > B ? A : B;
	}
	
	private double findMedian(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		
		double res = 0.0;
		int start = 0;
		int end = nums1.length - 1;
		
		while(start <= end) {
			int pX = (start + end) / 2;
			int pY = ((nums1.length + nums2.length + 1) / 2) - pX;
			
			int XMax = pX == 0 ? Integer.MIN_VALUE : nums1[pX-1];
			int XMin = pX == nums1.length ? Integer.MAX_VALUE : nums1[pX];
			
			int YMax = pY == 0 ? Integer.MIN_VALUE : nums2[pY-1];
			int YMin = pY == nums2.length ? Integer.MAX_VALUE : nums2[pY];
			
			if(XMax <= YMin && YMax <= XMin) {
				if((l1+ l2) % 2 == 0) {
					res = (double)(getMax(XMax, YMax) + getMin(XMin, YMin)) / 2;
				}else {
					res = (double)getMax(XMax, YMax);
				}
				break;
			}else if(XMax > YMin) {
				end = pX - 1;
			}else {
				start = pX + 1;
			}
			
		}
		
		return res;
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0.0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        if(l1 > l2) {
        	res = findMedian(nums2, nums1);
        }else {
        	res = findMedian(nums1, nums2);
        }
        return res;
    }
}
