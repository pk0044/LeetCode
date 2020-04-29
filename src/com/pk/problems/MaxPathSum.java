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
	
	int flag = 0;
	int max = Integer.MIN_VALUE;
	
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
		
		int childsum = getMax(getMaxPath(root.left), getMaxPath(root.right));
		if(root.val < 0) {
			if(childsum + root.val > 0) {
				return childsum + root.val;
			}else {
				return 0;
			}
		}
		return childsum + root.val;
	}
	
	private int getMaxFrom(int A, int B, int C) {
		int max = A > B ? A : B;
		max = max > C ? max : C;
		return max;
	}
	
	private int maxPathSumUtil(TreeNode root) {
	   	if(root == null) {
    		return 0;
    	}
    	
    	if(root.val > max) {
    		max = root.val;
    	}
    	
    	if(root.val >= 0) {
    		flag = 1;
    	}
    	
    	if(root.left == null && root.right == null) {
    		if(root.val < 0) {
    			return 0;
    		}
    		return root.val;
    	}
    	
    	int sum = root.val + getMaxPath(root.left) + getMaxPath(root.right);
    	int leftsum = maxPathSumUtil(root.left);
    	int rightsum = maxPathSumUtil(root.right);
    	return getMaxFrom(sum, leftsum, rightsum);
	}
	
    public int maxPathSum(TreeNode root) {
    	int res = maxPathSumUtil(root);
    	
    	if(flag == 0) {
    		return max;
    	}
    	
    	return res;
    }
}
