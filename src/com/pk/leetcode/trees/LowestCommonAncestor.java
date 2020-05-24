package com.pk.leetcode.trees;

/**
 * problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author pk0044
 *
 */
public class LowestCommonAncestor {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root != null && p.val < root.val && q.val < root.val) {
    		return lowestCommonAncestor(root.left, p, q);
    	}
    	
    	if(root != null && p.val > root.val && q.val > root.val) {
    		return lowestCommonAncestor(root.right, p, q);
    	}
    	
    	return root;
    }
}
