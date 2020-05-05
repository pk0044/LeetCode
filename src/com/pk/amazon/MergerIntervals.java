package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/merge-intervals/
 * 
 * @author pk0044
 *
 */
public class MergerIntervals {
	int a[][];
	
	private void swap(int A, int B) {
		int temp1 = a[A][0];
		int temp2 = a[A][1];
		
		a[A][0] = a[B][0];
		a[A][1] = a[B][1];
		
		a[B][0] = temp1;
		a[B][1] = temp2;
	}
	
	private void quickSort(int start, int end) {
		if(start < end) {
			int index = -1;
			int pivot = end;
			
			for(int i=start; i<end; i++) {
				if(a[i][0] < a[pivot][0]) {
					index++;
					swap(index, i);
				}
			}
			
			index++;
			swap(index, pivot);
			
			quickSort(start, index-1);
			quickSort(index+1, end);
		}
	}
	
    public int[][] merge(int[][] intervals) {
        a = intervals;
        quickSort(0, intervals.length-1);
        int[][] res = new int[20][2];
        
        for(int i=1; i<a.length; i++) {
        	if(a[i][0] <= a[i-1][1]) {
        		
        	}
        }
    }
}
