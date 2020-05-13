package com.pk.amazon;

import java.util.Stack;

/**
 * problelm link : https://leetcode.com/problems/maximal-rectangle/
 * @author pk0044
 *
 */
public class MaximalRectangle {
	private int findMaxRec(int[][] mat) {
		Stack<Integer> st = new Stack<Integer>();
		int index = 0;
		int max = 0;
		for(int i=0; i<mat.length; i++) {
			index = 0;
			int area = 0;
			int top = 0;
			while(index < mat[0].length) {
				if(st.isEmpty() || mat[i][st.peek()] <= mat[i][index]) {
					st.push(index++);
				}else {
					top = st.pop();
					area = mat[i][top] * (st.isEmpty() ? index : index - st.peek() - 1);
					if(area > max) {
						max = area;
					}
				}
			}
			
			while(st.isEmpty()) {
				top = st.pop();
				area = mat[i][top] * (st.isEmpty() ? index : index - st.peek() - 1);
				if(area > max) {
					max = area;
				}
			}
		}
		return max;
	}
	
	
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0) {
    		return 0;
    	}
    	
    	if(matrix[0].length == 0) {
    		return 0;
    	}
    	
    	int[][] mat = new int[matrix.length][matrix[0].length];
    	
    	for(int i=0; i<matrix.length; i++){
    		for(int j=0; j<matrix[0].length; j++) {
    			if(matrix[i][j] == '1') {
    				mat[i][j] = 1;
    			}else {
    				mat[i][j] = 0;
    			}
    		}
    	}
    	
    	for(int i=1; i<matrix.length; i++) {
    		for(int j=0; j<matrix[0].length; j++) {
    			if(matrix[i][j] == '1') {
    				mat[i][j] = mat[i][j] + mat[i-1][j];
    			}
    		}
    	}
    	
    	int max = findMaxRec(mat);
    	
    	return max;
    }	
}
