package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/edit-distance/
 * @author pk0044
 *
 */
public class EditDistance {
	private int getMin(int A, int B, int C) {
		int min = Math.min(A, B);
		return Math.min(min, C);
	}
	private int minDisBF(String s1, String s2, int i, int j) {
		if(i < 0) {
			return j+1;
		}
		
		if(j < 0) {
			return i+1;
		}
		
		if(s1.charAt(i) == s2.charAt(j)) {
			return minDisBF(s1, s2, i-1, j-1);
		}
		
		int a = minDisBF(s1, s2, i, j-1);
		int d = minDisBF(s1, s2, i-1, j);
		int r = minDisBF(s1, s2, i-1, j-1);
		
		
		return getMin(a, d, r) + 1;
	}
	
	private int minDP(String s1, String s2) {
		if(s1.length() == 0) {
			return s2.length();
		}
		
		if(s2.length() == 0) {
			return s1.length();
		}
		
		int[][] DP = new int[s2.length() + 1][s1.length() + 1];
		
		for(int i=0; i<s2.length(); i++) {
			DP[i][0] = i;
		}
		
		for(int i=0; i<s1.length(); i++) {
			DP[0][i] = i;
		}
		
		for(int i=1; i<=s2.length(); i++) {
			for(int j=1; j <= s1.length(); j++) {
				if(s2.charAt(i-1) == s1.charAt(j-1)) {
					DP[i][j] = DP[i-1][j-1];
				}else {
					DP[i][j] = getMin(DP[i][j-1], DP[i-1][j], DP[i-1][j-1]) + 1;
				}
			}
		}
		
		return DP[s2.length()][s1.length()];
	}
    public int minDistance(String word1, String word2) {
      //  return minDisBF(word1, word2, word1.length()-1, word2.length()-1);
    	return minDP(word1, word2);
    }
}
