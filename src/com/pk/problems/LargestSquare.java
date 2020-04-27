package com.pk.problems;

public class LargestSquare {
	private int getMin(int A, int B, int C) {
		int min = 0;
		min = A < B ? A : B;
		min = min < C ? min : C;
		return min;
	}
	
    public int maximalSquare(char[][] matrix) {
    	int res = -1;
    	
    	int l = matrix.length;
    	if(l == 0) {
    		return 0;
    	}
    	int b = matrix[0].length;
    	
    	int[][] sum = new int[l][b];
    	
    	for(int i=0; i<l; i++) {
            if(matrix[i][0] == '1'){
                sum[i][0] = 1;
            }else{
                sum[i][0] = 0;
            }
    	}
    	
    	for(int i=0; i<b; i++) {
            if(matrix[0][i] == '1'){
                sum[0][i] = 1;
            }else{
                sum[0][i] = 0;
            }
    	}
    	
    	for(int i=1; i<l; i++) {
    		for(int j=1; j<b; j++) {
    			if(matrix[i][j] == '1') {
    				sum[i][j] = getMin(matrix[i-1][j]-'0', matrix[i][j-1]-'0', matrix[i-1][j-1]-'0') + 1;
    				if(res < sum[i][j]) {
    					res = sum[i][j];
    				}
    			}else {
    				sum[i][j] = 0;
    			}
    		}
    	}
    	
 
    	return res;
    }
}
