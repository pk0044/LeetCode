package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/longest-palindromic-substring/
 * @author pk0044
 *
 */
public class LongestPalSub {
	int maxIndex = 0;
	int maxLength = 0;
	
	private void findLargestPalindrome(String s) {
		int l = s.length();
		if(l == 0) {
			maxLength = 0;
			return;
		}
		
		boolean[][] isPal = new boolean[l][l];
		
		for(int i=0; i<l; i++) {
			isPal[i][i] = true;
			maxLength = 1;
		}
		
		for(int i=0; i<l-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				isPal[i][i+1] = true;
				maxIndex = i;
				maxLength = 2;
			}else {
				isPal[i][i+1] = false;
			}
		}
		
		for(int i=3; i<=l; i++) {
			for(int j=0; j<l-i+1; j++) {
				int k = j + i - 1;
				
				if(s.charAt(j) == s.charAt(k)  && isPal[j+1][k-1] == true) {
					isPal[j][k] = true;
					if(i > maxLength) {
						maxLength = i;
						maxIndex = j;
					}
				}else {
					isPal[j][k] = false;
				}
			}
		}
		
	}
	
	private String returnLongestPalSub(String s) {
		String res = "";
		for(int i=maxIndex; i<maxIndex+maxLength; i++) {
			res = res + s.charAt(i);
		}
		return res;
	}
	
    public String longestPalindrome(String s) {
        String res = "";
        findLargestPalindrome(s);
        if(maxLength != 0) {
        	res = returnLongestPalSub(s);
        }  
        return res;
    }
}
