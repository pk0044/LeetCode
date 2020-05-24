package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/longest-palindromic-subsequence/
 * @author pk0044
 *
 */
public class LongestPalSubSeq {
	/**
	 * bruteforce approach
	 * @param s
	 * @param start
	 * @param end
	 * @param count
	 * @return
	 */
	private int longestPalSubSeqUtil(String s, int start, int end, int count) {
		
		if(start > end) {
			return 0;
		}
		
		if(start == end) {
			return 1;
		}
		
		if(s.charAt(start) == s.charAt(end)) {
			return longestPalSubSeqUtil(s, start+1, end-1, count) + 2;
		}
		
		return Math.max(longestPalSubSeqUtil(s, start+1, end, count), longestPalSubSeqUtil(s, start, end-1, count));
	}
	
	private int dplongestpal(String S) {
		int[][] mat = new int[S.length()][S.length()];
		
		for(int i=0; i<S.length(); i++) {
			mat[i][i] = 1;
		}
		
		for(int i=0; i<S.length()-1; i++) {
			if(S.charAt(i) == S.charAt(i+1)) {
				mat[i][i+1] = 2;
			}else {
				mat[i][i+1] = 1;
			}
		}
		
		int max = 0;
		
		for(int i=3; i<=S.length(); i++) {
			for(int j=0; j<S.length()-i+1; j++) {
				if(S.charAt(j) == S.charAt(j+i-1)) {
					mat[j][j+i-1] = mat[j][j+i-1] + 2;
				}else {
					mat[j][j+i-1] = Math.max(mat[j+1][j+i-1], mat[j][j+i]);
				}
				if(mat[j][j+i-1] > max) {
					max = mat[j][j+i-1];
				}
			}
		}
		
		return max;
	}
	
	/**
	 * memorization approach
	 * @param S
	 * @param start
	 * @param end
	 * @param mat
	 * @return
	 */
	private int longestPalSubSeqDP(String S, int start, int end, int[][] mat) {
		if(start > end) {
			return 0;
		}
		
		if(start == end) {
			mat[start][end] = 1;
			return 1;
		}
		
		if(S.charAt(start) == S.charAt(end)) {
			if(mat[start][end] == -1) {
				mat[start][end] = longestPalSubSeqDP(S, start+1, end-1, mat) + 2;
			}
			return mat[start][end];
		}
		
		return Math.max(longestPalSubSeqDP(S, start+1, end, mat), longestPalSubSeqDP(S, start, end-1, mat)); 
	}
	
    public int longestPalindromeSubseq(String s) {
    	int[][] mat = new int[s.length()-1][s.length()-1];
    	for(int i=0; i<s.length(); i++) {
    		for(int j=0; j<s.length(); j++) {
    			mat[i][j] = -1;
    		}
    	}
    	
    	return longestPalSubSeqDP(s, 0, s.length()-1, mat);
    }
}
