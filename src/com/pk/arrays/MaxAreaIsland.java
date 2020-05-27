package com.pk.arrays;

/**
 * problem link : https://leetcode.com/problems/max-area-of-island/
 * @author pk0044
 *
 */
public class MaxAreaIsland {
	
	private int findArea(int[][] grid, int[][] mat, int X, int Y, int area) {
		if(X+1<grid.length && mat[X+1][Y] == 0 && grid[X+1][Y] == 1) {
			mat[X+1][Y] = 1;
			area = findArea(grid, mat, X+1, Y, area+1);
		}
		
		if(X-1 >= 0 && mat[X-1][Y] == 0 && grid[X-1][Y] == 1) {
			mat[X-1][Y] = 1;
			area = findArea(grid, mat, X-1, Y, area+1);
		}
		
		if(Y+1 < grid[0].length && mat[X][Y+1] == 0 && grid[X][Y+1] == 1) {
			mat[X][Y+1] = 1;
			area = findArea(grid, mat, X, Y+1, area+1);
		}
		
		if(Y-1 >= 0 && mat[X][Y-1] == 0 && grid[X][Y-1] == 1) {
			mat[X][Y-1] = 1;
			area = findArea(grid, mat, X, Y-1, area+1);
		}
		
		return area;
	}
	
    public int maxAreaOfIsland(int[][] grid) {
        int l = grid.length;
        if(l == 0) {
        	return 0;
        }
        
        int b = grid[0].length;
        if(b == 0) {
        	return 0;
        }
        
        int mat[][] = new int[l][b];
        int area = 0;
        int max = 0;
        for(int i=0; i<l; i++) {
        	for(int j = 0; j<b; j++) {
        		if(mat[i][j] == 0 && grid[i][j] == 1) {
        			mat[i][j] = 1;
        			area = findArea(grid, mat, i, j, 1);
        			if(area > max) {
        				max = area;
        			}
        		}
        	}
        }
        return max;
    }
}
