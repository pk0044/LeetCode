package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/2-keys-keyboard/
 * @author pk0044
 *
 */
public class KeyBoard {
	private int minStepsBF(int n, int count, int steps, int copied) {
		System.out.println(count);
		if(count == n) {
			return steps;
		}
		
		if(count > n) {
			return Integer.MAX_VALUE;
		}
		
		if(copied == 0) {
			return minStepsBF(n, count, steps+1, count);
		}
		
		if(copied == count) {
			return minStepsBF(n, count + copied, steps+1, copied);
		}
		
		return Math.min(minStepsBF(n, count + copied, steps+1, copied), minStepsBF(n, count, steps+1, count));
		
	}
	
	
    public int minSteps(int n) {
        return minStepsBF(n, 1, 0, 0);
    }
}
