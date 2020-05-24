package com.pk.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * problem link : https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * @author pk0044
 *
 */
public class TwoBST {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	
	private void reverseOrder(TreeNode root, Stack<Integer> stack) {
		if(root != null) {
			reverseOrder(root.right, stack);
			stack.add(root.val);
			reverseOrder(root.left, stack);
		}
	}
	
	private void inorder(TreeNode root, Stack<Integer> stack, List<Integer> res) {
		if(root != null) {
			inorder(root.left, stack, res);
			while(!stack.empty() && stack.peek() <= root.val) {
				res.add(stack.pop());
			}
			res.add(root.val);
			inorder(root.right, stack, res);
		}
	}
	
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<Integer>();
        
        Stack<Integer> stack = new Stack<Integer>();
        
        reverseOrder(root1, stack);
        
        inorder(root2, stack, res);
        
        while(!stack.isEmpty()) {
        	res.add(stack.pop());
        }
        
        return res;
    }
}
