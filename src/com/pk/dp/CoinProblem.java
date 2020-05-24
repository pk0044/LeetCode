package com.pk.dp;

/**
 * question
 * 
 * Given 3 numbers {1, 3, 5}, we need to tell
 * the total number of ways we can form a number 'N' 
 * using the sum of the given three numbers.
 * 
 * @author pk0044
 *
 */
public class CoinProblem {
	
	private int findTotalWaysUtil(int start, int end) {
		
		//System.out.println(start);
		
		if(start == end) {
			return 1;
		}
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
		if(start + 1 <= end) {
			count1 = findTotalWaysUtil(start+1, end);
		}
		
		if(start + 3 <= end) {
			count2 = findTotalWaysUtil(start+3, end);
		}
		
		if(start + 5 <= end) {
			count3 = findTotalWaysUtil(start+5, end);
		}
		
		return count1 + count2 + count3;
	}
	
	public int findTotalWaysUtilDP(int N) {
		if(N <= 1) {
			return 1;
		}
		
		int[] a = new int[N+1];
		
		a[0] = 1;
		a[1] = 1;
		
		for(int i=2; i<= N; i++) {

			if(i - 1 >= 0) {
				a[i] = a[i] + a[i-1];
			}
			
			if(i - 3 >= 0) {
				a[i] = a[i] + a[i-3];
			}
			
			if(i - 5 >= 0) {
				a[i] = a[i] + a[i-5];
			}
		}
		
		return a[N];
	}
	
	public int findTotalWays(int N) {
		return findTotalWaysUtil(0, N);
	}
}
