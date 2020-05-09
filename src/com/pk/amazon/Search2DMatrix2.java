package com.pk.amazon;

/**
 * 
 * problem link : https://leetcode.com/problems/search-a-2d-matrix-ii/
 * @author pk0044
 *
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) {
        	return false;
        }
        
        int n = matrix[0].length;
        
        int start = 0;
        int end = n - 1;
        int mid = n - 1;
        for(int i=0; i<m; i++) {
        	if(matrix[i][mid] == target) {
        		return true;
        	}else if(matrix[i][mid] > target) {
        		start = 0;
        		end = mid - 1;
        	}else {
        		start = mid + 1;
        		end = n - 1;
        	}
        	while(start <= end) {
        		mid = (start + end) / 2;
        		if(matrix[i][mid] == target) {
        			return true;
        		}else if(matrix[i][mid] > target) {
        			end = mid - 1;
        		}else {
        			start = mid + 1;
        		}
        	}
        }
        
        return false;
    }
}
