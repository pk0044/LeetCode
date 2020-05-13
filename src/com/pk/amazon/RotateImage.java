package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/rotate-image/
 * @author pk0044
 *
 */
public class RotateImage {
	
	private void transpose(int[][] matrix) {
		int temp = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=i; j<matrix[0].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
    public void rotate(int[][] matrix) {
    	if(matrix.length == 0) {
    		return;
    	}
    	
    	if(matrix[0].length <= 1) {
    		return;
    	}
    	
    	transpose(matrix);
    	int temp = 0;
    	for(int i=0; i<matrix.length; i++) {
    		int start = 0;
    		int end = matrix[0].length - 1;
    		
    		while(start < end) {
    			
    			temp = matrix[i][start];
    			matrix[i][start] = matrix[i][end];
    			matrix[i][end] = temp;
    			
    			start++;
    			end--;
    		}
    	}
    }
}
