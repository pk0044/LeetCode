package com.pk.problems;

public class LCS {
	private int getMax(int A, int B) {
		return A > B ? A : B;
	}
    public int longestCommonSubsequence(String text1, String text2) {
        int res = 0;
        
        int l1 = text1.length();
        int l2 = text2.length();
        
        int[][] lcs = new int[l1+1][l2+1];
        
        for(int i=0; i<=l1; i++) {
        	for(int j=0; j<=l2; j++) {
        		if(i == 0 || j == 0) {
        			lcs[i][j] = 0;
        		}else if(text1.charAt(i-1) == text2.charAt(j-1)) {
        			lcs[i][j] = lcs[i-1][j-1] + 1;
        		}else {
        			lcs[i][j] = getMax(lcs[i-1][j], lcs[i][j-1]);
        		}
        	}
        }
        res = lcs[l1][l2];

        return res;
    }
}
