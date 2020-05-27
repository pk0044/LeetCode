package com.pk.dp;

/**
 * problem link : https://leetcode.com/problems/palindromic-substrings/
 * @author pk0044
 *
 */
public class NumOfPalSubString {
    public int countSubstrings(String s) {
        int l = s.length();
        if(l == 0) {
        	return 0;
        }
        
        boolean[][] ispal = new boolean[l][l];
        
        int count = 0;
        
        for(int i=0; i<l; i++) {
        	ispal[i][i] = true;
        	count++;
        }
        
        for(int i=0; i<l-1; i++) {
        	if(s.charAt(i) == s.charAt(i+1)) {
        		ispal[i][i+1] = true;
        		count++;
        	}
        }
        
        for(int i=3; i<=l; i++) {
        	for(int j=0; j<l-i+1; j++) {
        		if(s.charAt(j) == s.charAt(j+i-1) && ispal[j+1][j+i-2] == true) {
        			ispal[j][j+i-1] = true; 
        			count++;
        		}
        	}
        }
        
        return count;
    }
}
