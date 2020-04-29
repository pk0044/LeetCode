package com.pk.problems;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class MaxPathSum {
	
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
	
	private int getMax(int A, int B) {
		return A > B ? A : B;
	}
	
	
	private int getMaxPath(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			if(root.val < 0) {
				return 0;
			}
			return root.val;
		}
		
		return root.val + getMax(getMaxPath(root.left), getMaxPath(root.right));
	}
	
	private int getMaxFrom(int A, int B, int C) {
		int max = A > B ? A : B;
		max = max > C ? max : C;
		return max;
	}
	
    public int maxPathSum(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	
    	if(root.left == null && root.right == null) {
    		return root.val;
    	}
    	
    	int sum = root.val + getMaxPath(root.left) + getMaxPath(root.right);
    	int leftsum = maxPathSum(root.left);
    	int rightsum = maxPathSum(root.right);
    	return getMaxFrom(sum, leftsum, rightsum);
    }
}
