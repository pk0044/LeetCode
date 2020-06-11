package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * at most two transaction is possible
 * @author pk0044
 *
 */
public class StockMarket3 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
        	return 0;
        }
        
        int b1 = Integer.MIN_VALUE;
        int b2 = Integer.MIN_VALUE;
        int s1 = 0;
        int s2 = 0;
        
        for(int i=0; i<prices.length; i++) {
        	b1 = Math.max(b1, -prices[i]);
        	s1 = Math.max(s1, prices[i] - b1);
        	b2 = Math.max(b2,  s1 - prices[i]);
        	s2 = Math.max(s2, prices[i] - b2);
        }
        
        return s2;
    }
}
