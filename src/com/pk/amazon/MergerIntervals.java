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
			int index = start-1;
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
        int[][] res;
    	if(intervals.length == 0) {
    		return new int[0][0];
    	}
        a = intervals;
        quickSort(0, intervals.length-1);
        res = new int[intervals.length][2];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];
        int count = 0;
        
        for(int i=1; i<intervals.length; i++) {
        	if(intervals[i][0] <= res[count][1]) {
        		if(intervals[i][1] > res[count][1]) {
        			res[count][1] = intervals[i][1];
        		}
        	}else {
        		count++;
        		res[count][0] = intervals[i][0];
        		res[count][1] = intervals[i][1];
        	}
        }
        
        int[][] finalres = new int[count+1][2];
        
        for(int i=0; i<=count; i++) {
        	finalres[i][0] = res[i][0];
        	finalres[i][1] = res[i][1];
        }
        
        return finalres;
    }

}
