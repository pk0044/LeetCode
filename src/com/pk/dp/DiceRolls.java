package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * @author pk0044
 *
 */
public class DiceRolls {
	private int diceRollsBF(int d, int f, int target, int sum, int diceNum) {

		if(diceNum == d && target == sum) {
			return 1;
		}
		
		if(sum > target) {
			return 0;
		}
		
		if(diceNum >= d) {
			return 0;
		}
		int ways = 0;
		for(int i=1; i<=f; i++) {
			ways = ways + diceRollsBF(d, f, target, sum + i, diceNum+1);
		}
		
		return ways;
	}
	
	private int diceRollsDP(int d, int f, int target) {
        if(d * f < target || target < d) {
			return 0;
		}
		int[][] DP = new int[d+1][target+1];
		for(int i=0; i<=d; i++) {
			DP[i][0] = 1;
		}

		int mod = (int)Math.pow(10, 9) + 7;

		for(int i=1; i<=d; i++) {
			for(int j=1; j<=target; j++) {
				for(int k=1; k<=f; k++) {
					if(j - k >= 0) {
						DP[i][j] = (DP[i][j] + DP[i-1][j-k]) % mod; 
					}
				}
			}
		}
		
		return DP[d][target];
	}
	
    public int numRollsToTarget(int d, int f, int target) {
        return diceRollsBF(d, f, target, 0, 0);
    }
}
