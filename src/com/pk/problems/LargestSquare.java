package com.pk.problems;

public class LargestSquare {
	private int getMin(int A, int B, int C) {
		int min = A < B ? A : B;
		min = min < C ? min : C;
		return min;
	}
	
    public int maximalSquare(char[][] matrix) {
    	
    	int max = 0;
    	
    	int l = matrix.length;
    	if(l == 0) {
    		return 0;
    	}
    	
    	int b = matrix[0].length;
    	
    	
    	int[][] sum = new int[l+1][b+1];
    	
    	for(int i=0; i<= l; i++) {
    		sum[i][0] = 0;
    	}
    	
    	for(int i=0; i<= b; i++) {
    		sum[0][i] = 0;
    	}
    	
    	for(int i=1; i<=l; i++) {
    		for(int j=1; j<=b; j++) {
    			if(matrix[i-1][j-1] == '0') {
    				sum[i][j] = 0;
    			}else {
    				sum[i][j] = 1 + getMin(sum[i-1][j], sum[i][j-1], sum[i-1][j-1]);
    				if(sum[i][j] > max) {
    					max = sum[i][j];
    				}
    			}
    		}
    	}
    	return max*max;
    }
}
