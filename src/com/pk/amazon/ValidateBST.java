package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/validate-binary-search-tree/
 * @author pk0044
 *
 */
public class ValidateBST {
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
	
	private boolean isValid(TreeNode root, long max, long min) {
		if(root == null) {
			return true;
		}
		
		if(root.val <= min || root.val >= max) {
			return false;
		}
		
		if(root.left != null && root.val <= root.left.val) {
			return false;
		}
		
		if(root.right != null && root.val >= root.right.val) {
			return false;
		}

		return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
	}
	
    public boolean isValidBST(TreeNode root) {
    	boolean res = true;
    	if(root == null) {
    		return true;
    	}
    	
		if(root.left != null && root.val <= root.left.val) {
			return false;
		}
		
		if(root.right != null && root.val >= root.right.val) {
			return false;
		}
		
    	res = isValid(root.left, root.val, Long.MIN_VALUE) && isValid(root.right, Long.MAX_VALUE, root.val);
    	return res;
    }
}
