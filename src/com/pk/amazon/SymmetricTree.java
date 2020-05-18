package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/symmetric-tree/
 * @author pk0044
 *
 */
public class SymmetricTree {
	
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
	
	private boolean checkSymUtil(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		}else if(left == null && right != null) {
			return false;
		}else if(left != null && right == null) {
			return false;
		}
		
		if(left.val != right.val) {
			return false;
		}
		
		return checkSymUtil(left.left, right.left) && checkSymUtil(left.right, right.right);
	}
	
    public boolean isSymmetric(TreeNode root) {
        boolean res = true;
        if(root == null) {
        	return true;
        }
        res = checkSymUtil(root.left, root.right);
        return res;
    }
}
