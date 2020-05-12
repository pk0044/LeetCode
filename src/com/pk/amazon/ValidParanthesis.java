package com.pk.amazon;

import java.util.Stack;

/**
 * 
 * problem link : https://leetcode.com/problems/valid-parentheses/
 * @author pk0044
 *
 */
public class ValidParanthesis {
    public boolean isValid(String s) {
    	boolean res = true;
    	int l = s.length();
    	if(l == 0) {
    		return true;
    	}
    	Stack<Character> stack = new Stack<Character>();
    	
    	int index = 0;
    	while(index < l) {
    		if(s.charAt(index) == '(' || s.charAt(index) == '{' || s.charAt(index) == '[') {
    			stack.add(s.charAt(index));
    		}else if(s.charAt(index) == ')' && !stack.isEmpty() && stack.peek() == '(') {
    			stack.pop();
    		}else if(s.charAt(index) == '}' && !stack.isEmpty() && stack.peek() == '{') {
    			stack.pop();
    		} else if(s.charAt(index) == ']' && !stack.isEmpty() && stack.peek() == '[') {
    			stack.pop();
    		}else {
    			res = false;
    			break;
    		}
    			
    		index++;
    	}
    	
    	if(!stack.isEmpty()) {
    		res = false;
    	}
    	
    	return res;
    }
}
