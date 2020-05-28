package com.pk.dp;

public class MinCoin {
	
	public int coinChangeBruteForce(int[] coins, int index, int start,  int end, int count) {
		if(index >= coins.length) {
			return Integer.MAX_VALUE;
		}
		if(start > end) {
			return Integer.MAX_VALUE;
		}
		if(start == end) {
			return count;
		}
		
		return Math.min(coinChangeBruteForce(coins, index+1, start, end, count), coinChangeBruteForce(coins, index, start+coins[index], end, count+1));
	}
	
	public int coinChangeDP(int[] coins, int amount) {
		if(coins.length == 0 || amount == 0) {
			return -1;
		}
		
		int[] count = new int[amount+1];
		count[0] = 0;
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=amount; i++) {
			min = Integer.MAX_VALUE;
			for(int j=0; j<coins.length; j++) {
				if(coins[j] <= i) {
					if(count[i - coins[j]] == Integer.MAX_VALUE) {
						count[i] = Integer.MAX_VALUE;
					}else {
						count[i] = count[i - coins[j]] + 1;
					}
				}else {
					count[i] = Integer.MAX_VALUE;
				}
				if(count[i] < min) {
					min = count[i];
				}
			}
			count[i] = min;
		}
		
		if(count[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		
		return count[amount];
	}
	
    public int coinChange(int[] coins, int amount) {
    	System.out.println(coinChangeDP(coins, amount));
        return coinChangeBruteForce(coins, 0, 0, amount, 0);
    }
}
