package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/01-matrix/
 * @author pk0044
 *
 */
public class ZeroDistance {
    public int[][] updateMatrix(int[][] matrix) {
    	int r = matrix.length;
    	if(r == 0) {
    		return new int[0][0];
    	}
    	
    	int c = matrix[0].length;
    	
    	if(c == 0) {
    		return new int[0][0];
    	}
    	
    	int[][] res = new int[r][c];
    	
    	
    	for(int i=0; i<r; i++) {
    		for(int j=0; j<c; j++) {
    			if(matrix[i][j] == 0) {
    				res[i][j] = 0;
    			}else {
    				if(i == 0 && j == 0) {
    					res[i][j] = Integer.MAX_VALUE;
    				}else if(i == 0 && j != 0) {
    					res[i][j] = res[i][j-1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : res[i][j-1] + 1;
    				}else if(i != 0 && j == 0) {
    					res[i][j] = res[i-1][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : res[i-1][j] + 1;
    				}else {
    					res[i][j] = Math.min(res[i-1][j], res[i][j-1]) == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(res[i-1][j], res[i][j-1]) + 1;
    				}
    			}
    		}
    	}
    	
    	for(int i=r-1; i>=0; i--) {
    		for(int j=c-1; j>=0; j--) {
    			if(matrix[i][j] != 0) {
    				if(i == r-1 && j != c-1) {
    					res[i][j] = Math.min(res[i][j], res[i][j+1] + 1);
    				}else if(i != r-1 && j == c-1) {
    					res[i][j] = Math.min(res[i][j], res[i+1][j] + 1);
    				}else {
    					res[i][j] = Math.min(res[i][j], Math.min(res[i][j+1], res[i+1][j]) + 1);
    				}
    			}
    		}
    	}
    	
    	return res;
        
    }
}
