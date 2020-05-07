package com.pk.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * program link : https://leetcode.com/problems/spiral-matrix/
 * 
 * @author pk0044
 *
 */
public class SpiralMatrix_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int n = matrix.length;
        if(n == 0) {
        	return res;
        }
        
        int m = matrix[0].length;
        
        int cstart = 0;
        int cend = m - 1;
        
        int rstart = 0;
        int rend = n - 1;
        
        while(cstart <= cend && rstart <= rend) {
        	
        	for(int i=cstart; i<=cend; i++) {
        		res.add(matrix[rstart][i]);
        	}
        	
        	for(int i=rstart+1; i<= rend; i++) {
        		res.add(matrix[i][cend]);
        	}
        	
        	if(rend > rstart) {
            	for(int i=cend-1; i>=cstart; i--) {
            		res.add(matrix[rend][i]);
            	}
        	}
        	
        	if(cstart < cend) {
            	for(int i=rend-1; i>rstart; i--) {
            		res.add(matrix[i][cstart]);
            	}
        	}
        	
        	cstart++;
        	cend--;
        	rstart++;
        	rend--;
        }
        return res;
    }
}
