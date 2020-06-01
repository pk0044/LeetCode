package com.pk.dp;

import java.util.Map;

/**
 * problem link : https://leetcode.com/problems/perfect-squares/
 * @author pk0044
 *
 */
public class PerfectSquare {
	
	private int numSquareBF(int n, int count) {
		
		if(n < 0) {
			return Integer.MAX_VALUE;
		}
		
		if(n == 0) {
			return count;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i*i <= n; i++) {
			min = Math.min(numSquareBF(n - i*i, count+1), min);
		}
		
		return min;
	}
	
	private int numSquareDP(int n) {
		if(n == 0) {
			return 0;
		}
		int[] square = new int[n+1];
		
		square[0] = 0;
		square[1] = 1;
		
		for(int i=2; i<=n; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j*j <= i; j++) {
				min = Math.min(square[i - j*j], min);
			}
			square[i] = min + 1;
		}
		
		return square[n];
	}
	
    public int numSquares(int n) {
        return numSquareBF(n, 0);
    }
}
