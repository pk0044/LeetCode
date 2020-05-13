package com.pk.amazon;

import java.util.Stack;

/**
 * problem link : https://leetcode.com/problems/largest-rectangle-in-histogram/
 * @author pk0044
 *
 */
public class LargestRecHistorgram {
    public int largestRectangleArea(int[] heights) {
    	if(heights.length == 0) {
    		return 0;
    	}
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	int l = heights.length;
    	int index = 0;
    	int maxArea = 0;
    	int area = 0;
    	int top = 0;
    	
    	while(index < l) {
    		if(stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
    			stack.push(index++);
    		}else {
    			top = stack.pop();
    			area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
    			if(area > maxArea) {
    				maxArea = area;
    			}
    		}
    	}
    	
    	while(!stack.isEmpty()) {
    		top = stack.pop();
    		area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1 );
    		if(area > maxArea) {
    			maxArea = area;
    		} 
    	}
    	
    	return maxArea;
    }
}
