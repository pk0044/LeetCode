package com.pk.stack;

import java.util.ArrayList;
import java.util.Stack;

public class PostFix {
	
	private int getInt(String s) {
		int X = 0;
		if(s.charAt(0) == '-') {
			for(int i=1; i<s.length(); i++) {
				X = X * 10 + (s.charAt(i) - '0');
			}
			X = X * (-1);
		}else {
			for(int i=0; i<s.length(); i++) {
				X = X * 10 + (s.charAt(i) - '0');
			}
		}
		return X;
	}

    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int index = 0;
        
        while(index < A.size()){
        	if(A.get(index).equals("*")) {
        		int X = stack.pop();
        		int Y = stack.pop();
        		int res = X * Y;
        		stack.add(res);
        	}else if(A.get(index).equals("/")) {
        		int X = stack.pop();
        		int Y = stack.pop();
        		int res = Y / X;
        		stack.add(res);
        	}else if(A.get(index).equals("+")) {
        		int X = stack.pop();
        		int Y = stack.pop();
        		int res = X + Y;
        		stack.add(res);
        	}else if(A.get(index).equals("-")) {
        		int X = stack.pop();
        		int Y = stack.pop();
        		int res = Y - X;
        		stack.add(res);
        	}else {
        		stack.add(getInt(A.get(index)));
        	}
        	index++;
        }
        int res = stack.pop();
        return res;
    }
}
