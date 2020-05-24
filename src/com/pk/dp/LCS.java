package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/longest-common-subsequence/
 * @author pk0044
 *
 */

public class LCS {
	
	private int LCSBruteUtil(String t1, int index1, String t2, int index2, int l) {
		if(index1 == t1.length() || index2 == t2.length()) {
			return l;
		}
		
		if(t1.charAt(index1) == t2.charAt(index2)) {
			l = l + 1;
			return LCSBruteUtil(t1, index1+1, t2, index2+1, l);
		}
		
		return Math.max(LCSBruteUtil(t1, index1+1, t2, index2, l), LCSBruteUtil(t1, index1, t2, index2+1, l));
	}
	
	public int LCSDP(String T1, String T2){
		int[][] mat = new int[T1.length()+1][T2.length()+1];
		
		for(int i=0; i<=T1.length(); i++) {
			mat[i][0] = 0;
		}
		
		for(int j=0; j<=T2.length(); j++) {
			mat[0][j] = 0;
		}
		
		for(int i=1; i<=T1.length(); i++) {
			for(int j=1; j<=T2.length(); j++) {
				if(T1.charAt(i-1) == T2.charAt(j-1)) {
					mat[i][j] = mat[i-1][j-1] + 1;
				}else {
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		
		return mat[T1.length()][T2.length()];
	}
	
    public int LCSBruteForce(String text1, String text2) {
    	return LCSBruteUtil(text1, 0, text2, 0, 0);
    }
}
