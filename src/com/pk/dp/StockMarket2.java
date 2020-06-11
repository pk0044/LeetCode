package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @author pk0044
 *
 */
public class StockMarket2 {
    public int maxProfit(int[] prices, int fee) {

    	if(prices.length <= 1) {
    		return 0;
    	}
    	int[][] profit = new int[prices.length][4];
    	
    	profit[0][0] = -prices[0];
    	profit[0][1] = Integer.MIN_VALUE;
    	profit[0][2] = Integer.MIN_VALUE;
    	
    	for(int i=1; i<prices.length; i++) {
    		profit[i][0] = Math.max(profit[i-1][1], profit[i-1][3]) - prices[i];
    		profit[i][1] = Math.max(profit[i-1][0], profit[i-1][2]) + prices[i] - fee;
    		profit[i][2] = Math.max(profit[i-1][0], profit[i-1][2]);
    		profit[i][3] = Math.max(profit[i-1][1], profit[i-1][3]);
    	}
    	
    	int max = Integer.MIN_VALUE;
    	for(int i=0; i<profit.length; i++) {
    		for(int j=0; j<4; j++) {
    			if(profit[i][j] > max) {
    				max = profit[i][j];
    			}
    		}
    	}
    	
    	return max;
    
    }
}
