package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/min-cost-climbing-stairs/
 * @author pk0044
 *
 */


public class MinCostClimbingStairs {
	
	private int minCostClimbingStairsBrute(int[] cost, int start, int end, int totalCost) {
		
		if(start > end) {
			return Integer.MAX_VALUE;
		}
		
		if(start == end) {
			return totalCost;
		}
		int currCost = 0;
		if(start >= 0) {
			currCost = cost[start];
		}
		return Math.min(minCostClimbingStairsBrute(cost, start + 1, end, totalCost + currCost), minCostClimbingStairsBrute(cost, start + 2, end, totalCost + currCost));
	}
	
	
	public int minCostClimbingStairsDP(int[] cost) {
		
        if(cost.length <= 2) {
			return 0;
		}
		int[] C= new int[cost.length+1];
		C[0] = cost[0];
		
		C[1] = cost[1];
		
		for(int i=2; i<cost.length; i++) {
			C[i] = (C[i-1] < C[i-2] ? C[i-1] : C[i-2]) + cost[i];
		}
		
		C[cost.length] = C[cost.length - 1] < C[cost.length-2] ? C[cost.length - 1] : C[cost.length - 2];
		
		return C[cost.length];

	}
	
    public int minCostClimbingStairs(int[] cost) {
      //  return minCostClimbingStairsBrute(cost, -1, cost.length-1, 0);
    	return minCostClimbingStairsDP(cost);
    }
}
