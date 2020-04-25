package com.pk.problems;

public class RangeBitwise {
	
    public int rangeBitwiseAnd(int m, int n) {
    	while(m < n) {
    		n -= (n & -n);
    	}
    	return n;
    }
}
