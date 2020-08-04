package com.pk.dp;


/**
 * problem link : https://leetcode.com/problems/ones-and-zeroes/
 * @author pk0044
 *
 */
public class OneZero {
	
	private int[][] countDigits(String[] strs){
		int[][] digits = new int[strs.length][2];
		
		
		for(int i=0; i<strs.length; i++) {
			int index = 0;
			int zero = 0;
			int one = 0;
			while(index < strs[i].length()) {
				if(strs[i].charAt(index) == '0') {
					zero++;
				}else {
					one++;
				}
				index++;
			}
			digits[i][0] = zero;
			digits[i][1] = one;
		}
		
		return digits;
	}
	
	private int findMaxBF(int index, int count, int one, int zero, int[][] digits) {
		if(index >= digits.length) {
			return count;
		}
		int used = Integer.MIN_VALUE;
		if(zero >= digits[index][0] && one >= digits[index][1]) {
			used = findMaxBF(index+1, count+1, one - digits[index][1], zero - digits[index][0], digits);
		}
		
		int notused = findMaxBF(index+1, count, one, zero, digits);
		
		return Math.max(used, notused);
	}
	
	private int findMaxDP(String[] strs, int m, int n) {
		int res = 0;
		int[][] digits = countDigits(strs);
		int[][] DP = new int[m][n];
		DP[0][0] = 0;
		DP[digits[0][0]][digits[0][1]] = 1;
		for(int i=1; i<strs.length; i++) {
			
		}
		return res;
	}
    public int findMaxForm(String[] strs, int m, int n) {
        int digits[][] = countDigits(strs);
        return findMaxBF(0, 0, n, m, digits);
    }
}
