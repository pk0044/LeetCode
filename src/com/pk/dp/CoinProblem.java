package com.pk.dp;

/**
 * 
 * problem link : https://leetcode.com/problems/coin-change-2/
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
	private int changeBruteForce(int[] coins, int index, int start, int end) {
		if(start == end) {
			return 1;
		}
		
		if(start > end) {
			return 0;
		}
		
		if(index >= coins.length) {
			return 0;
		}
		
		return changeBruteForce(coins, index+1, start, end) + changeBruteForce(coins, index, start+coins[index], end);
	}
	
	private int changeDP(int amount, int[] coins) {
		if(amount == 0) {
			return 0;
		}
		
		if(coins.length == 0) {
			return 0;
		}
		
		int[] total = new int[amount+1];
		total[0] = 1;
		
		for(int i=1; i <= amount; i++) {
			total[i] = 0;
		}
		
		for(int i=0; i<coins.length; i++) {
			for(int j=coins[i]; j <= amount; j++) {
				total[j] = total[j] + total[j - coins[i]];
			}
		}
		
		return total[amount];
	}
	
    public int change(int amount, int[] coins) {
      //  return changeBruteForce(coins, 0, 0, amount);
    	return changeDP(amount, coins);
    }
}
