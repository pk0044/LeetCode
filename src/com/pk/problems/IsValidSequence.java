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
public class IsValidSequence {
	
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
	  
	private boolean isValidSquenceUtil(TreeNode root, int[] arr, int index) {
		
		boolean res = true;
		
		if(root == null && index >= arr.length) {
			return true;
		}
		
		if(root != null && index >= arr.length) {
			return false;
		}
		
		if(root == null && index < arr.length) {
			return false;
		}
		
		if(root != null && index < arr.length) {
			if(root.val != arr[index]) {
				return false;
			}else if(root.left != null && root.right == null){
				res = isValidSquenceUtil(root.left, arr, index+1);
			}else if(root.right != null && root.left == null) {
				res = isValidSquenceUtil(root.right, arr, index+1);
			}else if(root.left != null && root.right != null) {
				res = isValidSquenceUtil(root.left, arr, index+1) || isValidSquenceUtil(root.right, arr, index+1);
			}else if(root.left == null && root.right == null) {
				if(index < arr.length -1) {
					res = false;
				}else if(root.val == arr[index]) {
					res = true;
				}else {
					res = false;
				}
			}
		}else {
			res = false;
		}
		
		return res;
	}
	
    public boolean isValidSequence(TreeNode root, int[] arr) {
    	return isValidSquenceUtil(root, arr, 0);
    }
}
