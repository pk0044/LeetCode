package com.pk.amazon;

import java.util.PriorityQueue;

/**
 * problem link : https://leetcode.com/problems/k-closest-points-to-origin/
 * @author pk0044
 *
 */
public class KClosestPointOrigin {
	
	private void swap(int[][] points, int A, int B) {
		int tmp1 = points[A][0];
		points[A][0] = points[B][0];
		points[B][0] = tmp1;
		
		int tmp2 = points[A][1];
		points[A][1] = points[B][1];
		points[B][1] = tmp2;
	}
	
	private int getDistance(int[][] points, int index) {
		return points[index][0] * points[index][0] + points[index][1] * points[index][1];
	}
	
	private int partition(int[][] points, int start, int end) {
		if(start == end) {
			return start;
		}
		
		int p = getDistance(points, end);
		int index = start;
		
		for(int i=start; i<end; i++) {
			if(getDistance(points, i) < p) {
				swap(points, i, index);
				index++;
			}
		}
		
		swap(points, index, end);
		return index;
	}
	
	private void sortKElements(int[][] points, int K, int start, int end){
		if(start >= end) {
			return;
		}
		
		int p = partition(points, start, end);
		
		if(p < K) {
			sortKElements(points, K, start, p-1);
			sortKElements(points, K, p+1, end);
		}else {
			sortKElements(points, K, start, p);
		}
	}
	
    public int[][] kClosest(int[][] points, int K) {
    	int[][] res = new int[K][2];
    	sortKElements(points, K, 0, points.length-1);
    	for(int i=0; i<K; i++) {
    		res[i][0] = points[i][0];
    		res[i][1] = points[i][1];
    	}
    	return res;
    }
}
