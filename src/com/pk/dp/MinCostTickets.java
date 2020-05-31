package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/minimum-cost-for-tickets/
 * @author pk0044
 *
 */
public class MinCostTickets {
	
	private int getMin(int A, int B, int C) {
		int min = A;
		min = B < min ? B : min;
		min = C < min ? C : min;
		return min;
	}
	
	private int mincostTicketsBF(int[] days, int[] costs, int index, int totalCost) {
		if(index >= days.length) {
			return totalCost;
		}
		
		int c1 = mincostTicketsBF(days, costs, index+1, totalCost + costs[0]);
		int travelPass = days[index] + 6;
		
		int index2 = index;
		while(index2 < days.length && days[index2] < travelPass) {
			index2++;
		}
		
		int c2 = mincostTicketsBF(days, costs, index2, totalCost + costs[1]);
		
		index2 = index;
		travelPass = days[index] + 29;
		
		while(index2 < days.length && days[index2] < travelPass) {
			index2++;
		}
		
		int c3 = mincostTicketsBF(days, costs, index2, totalCost + costs[2]);
		
		return getMin(c1, c2, c3);
	}
	
	private int get7dayPass(int index, int[] days, int[] costs, int[] totalCosts) {
		int travelPass = days[index] - 6;
		int index2 = index;
		while(index2 >= 0 && days[index2] >= travelPass) {
			index2--;
		}
		
		if(index2 < 0) {
			return costs[1];
		}
		
		return totalCosts[index2] + costs[1];
	}
	
	private int get30dayPass(int index, int[] days, int[] costs, int[] totalCosts) {
		int travelPass = days[index] - 29;
		int index2 = index;
		
		while(index2 >= 0 && days[index2] >= travelPass) {
			index2--;
		}
		
		if(index2 < 0) {
			return costs[2];
		}
		
		return totalCosts[index2] + costs[2];
	}
	
	private int minCostDP(int[] days, int costs[]) {
		if(days.length == 0) {
			return 0;
		}
		
		int[] totalCost = new int[days.length];
		
		totalCost[0] = getMin(costs[0], costs[1], costs[2]);
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		for(int i=1; i<days.length; i++) {
			c1 = totalCost[i-1] + costs[0];
			c2 = get7dayPass(i, days, costs, totalCost);
			c3 = get30dayPass(i, days, costs, totalCost);
			
			totalCost[i] = getMin(c1, c2, c3);
		}
		
		return totalCost[days.length-1];
	}
	
    public int mincostTickets(int[] days, int[] costs) {
     //   return mincostTicketsBF(days, costs, 0, 0);
    	return minCostDP(days, costs);
    }
}
