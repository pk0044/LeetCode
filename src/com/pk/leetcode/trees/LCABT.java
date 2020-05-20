package com.pk.leetcode.trees;


/**
 * problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author pk0044
 *
 */
public class LCABT {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root != null) {
    		if(root == p || root == q) {
    			return root;
    		}
    		
    		TreeNode left = lowestCommonAncestor(root.left, p, q);
    		TreeNode right = lowestCommonAncestor(root.right, p, q);
    		
    		if(left != null && right != null) {
    			return root;
    		}else if(left != null) {
    			return left;
    		}else if(right != null) {
    			return right;
    		}
    	}
    	
    	return null;
    }
}
