package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/minimum-falling-path-sum/
 * @author pk0044
 *
 */
public class MinFallPathS {
	
	private int minFallingPathSumBF(int[][] A, int index, int cost) {
		if(index == A.length) {
			return cost;
		}
		
		int min = Integer.MAX_VALUE;
		int curr = 0;
		for(int i = 0; i<A[0].length; i++) {
			curr = minFallingPathSumBF(A, index+1, cost + A[index][i]);
			if(curr < min) {
				min = curr;
			}
		}
		
		return min;
	}
	
	private int getMin(int row, int col, int[][] A) {
		int min = Integer.MAX_VALUE;
		if(A[row][col] < min) {
			min = A[row][col];
		}
		
		if(col - 1 >= 0 && A[row][col-1] < min) {
			min = A[row][col-1];
		}
		
		if(col+1 < A[0].length && A[row][col+1] < min) {
			min = A[row][col+1];
		}
		
		return min;
	}
	
	private int minDP(int[][] A) {
		if(A.length == 0) {
			return 0;
		}
		
		if(A[0].length == 0) {
			return 0;
		}
		
		int l = A.length;
		int b = A[0].length;
		
		int[][] cost = new int[l][b];
		
		for(int i=0; i<A[0].length; i++) {
			cost[0][i] = A[0][i];
		}
		
		for(int i = 1; i < A.length; i++) {
			for(int j = 0; j<A[0].length; j++) {
				cost[i][j] = A[i][j] + getMin(i-1, j, cost);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<A[0].length; i++) {
			if(cost[cost.length-1][i] < min) {
				min = cost[cost.length-1][i];
			}
		}
		
		
		return min;
	}
	
    public int minFallingPathSum(int[][] A) {
      //  return minFallingPathSumBF(A, 0, 0);
    	return minDP(A);
    }
}
