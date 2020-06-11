package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author pk
 *
 */
public class StockWithCoolDown {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
        	return 0;
        }
        
        int[][] prof = new int[prices.length][4];
        
        prof[0][0] = -prices[0];
        prof[0][1] = Integer.MIN_VALUE;
        prof[0][2] = Integer.MIN_VALUE;
        
        for(int i=1; i<prices.length; i++) {
    		prof[i][0] = prof[i-1][3] - prices[i];
        	prof[i][1] = Math.max(prof[i-1][0], prof[i-1][2]) + prices[i];
        	prof[i][2] = Math.max(prof[i-1][0], prof[i-1][2]);
        	prof[i][3] = Math.max(prof[i-1][1], prof[i-1][3]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<prof.length; i++) {
        	for(int j=0; j<=3; j++) {
        		if(prof[i][j] > max) {
        			max = prof[i][j];
        		}
        	}
        }
        return max;
    }
}
