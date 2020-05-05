package com.pk.interviewbit;

/**
 * problem link : https://www.interviewbit.com/problems/max-depth-of-binary-tree/
 * 
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

public class MaxDepth {
	
	class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) {
	      val = x;
	      left=null;
	      right=null;
	     }
	}

	private int getMax(int A, int B) {
		return A > B ? A : B;
	}
	
	private int maxDepthUtil(TreeNode A) {
		if(A == null) {
			return 0;
		}
		
		return getMax(maxDepthUtil(A.left), maxDepthUtil(A.right)) + 1;
	}
	
    public int maxDepth(TreeNode A) {
    	return maxDepthUtil(A);
    }
}
