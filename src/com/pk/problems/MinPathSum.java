package com.pk.problems;

import java.util.PriorityQueue;



public class MinPathSum {
	
	private int getMin(int A, int B) {
		return A > B ? B : A;
	}
	
    public int minPathSum(int[][] grid) {
    	
    	if(grid.length == 0) {
    		return 0;
    	}
    	
    	int r = grid.length;
    	int c = grid[0].length;
    	
    	int[][] tc = new int[r][c];
    	
    	tc[0][0] = grid[0][0];
    	
    	for(int i=1; i<r; i++) {
    		tc[i][0] = tc[i-1][0] + grid[i][0];
    	}
    	
    	for(int i=1; i<c; i++) {
    		tc[0][i] = tc[0][i-1] + grid[0][i];
    	}
    	
    	for(int i=1; i<r; i++) {
    		for(int j=1; j<c; j++) {
    			tc[i][j] = getMin(tc[i-1][j], tc[i][j-1]) + grid[i][j];
    		}
    	}
    	
		return grid[r-1][c-1];
    }
}
