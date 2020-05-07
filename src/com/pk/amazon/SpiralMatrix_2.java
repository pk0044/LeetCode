package com.pk.amazon;

/**
 * 
 * problem link : https://leetcode.com/problems/spiral-matrix-ii/
 * 
 * @author pk0044
 *
 */
public class SpiralMatrix_2 {
    public int[][] generateMatrix(int n) {
        if(n == 0) {
        	return new int[0][0];
        }
        
        int[][] res = new int[n][n];
        
        int count = 1;
        
        int rstart = 0;
        int rend = n - 1;
        
        int cstart = 0;
        int cend = n - 1;
        
        while(rstart <= rend && cstart <= cend) {
        	
        	for(int i=cstart; i<=cend; i++) {
        		res[rstart][i] = count;
        		count++;
        	}
        	
        	for(int i=rstart+1; i<=rend; i++) {
        		res[i][cend] = count;
        		count++;
        	}
        	
        	if(rstart < rend) {
        		for(int i=cend-1; i>=cstart; i--) {
        			res[rend][i] = count;
        			count++;
        		}
        	}
        	
        	if(cstart < cend) {
        		for(int i=rend-1; i>rstart; i--) {
        			res[i][cstart] = count;
        			count++;
        		}
        	}
        	
        	rstart++;
        	rend--;
        	cstart++;
        	cend--;
        }
        
        return res;
    }
    
}
