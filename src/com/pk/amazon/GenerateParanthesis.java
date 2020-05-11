package com.pk.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * problem link : https://leetcode.com/problems/generate-parentheses/
 * @author pk0044
 *
 */
public class GenerateParanthesis {
	private void generateParenthesisUtil(int open, int close, List<String> res, String str) {
		if(open == 0) {
			while(close > 0) {
				str = str + ")";
				close--;
			}
			res.add(str);
		}else {
	        if(open > 0){
	            str = str + "(";
	            open--;
	    		generateParenthesisUtil(open, close, res, str);
	        }
	        
			if(open < close) {
	            str = str + ")";
	            close--;
	            if(close == 0) {
	            	res.add(str);
	            }else {
	            	generateParenthesisUtil(open, close, res, str);
	            }
			}
		}
		

	}
    public List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<String>();
    	generateParenthesisUtil(n, n, res, "");
    	return res;
    }
}
