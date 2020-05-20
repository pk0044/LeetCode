package com.pk.amazon;

import java.util.ArrayList;
import java.util.List;

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
	
	private void inOrderTwoBST(TreeNode R1, TreeNode R2, List<Integer> res) {
		 if(R1 != null && R2 != null) {
			 if(R1.val < R2.val) {
				 inOrderTwoBST(R1, R2.left, res);
			 }else {
				 inOrderTwoBST(R1.left, R2, res);
			 }
			 
			 if(R1.val < R2.val) {
				 res.add(R1.val);
				 inOrderTwoBST(R1, R2.right, res);
			 }else {
				 res.add(R2.val);
				 inOrderTwoBST(R1.right, R2, res);
			 }
			 
		 }else if(R1 != null) {
			 inOrderTwoBST(R1.left, R2, res);
		 }else if(R2 != null) {
			 inOrderTwoBST(R1, R2.left, res);
		 }
		 
		 if(R1 != null && R2 != null) {

		 }else if(R1 != null) {
			 res.add(R1.val);
		 }else if(R2 != null) {
			 res.add(R2.val);
		 }
		 
		 if(R1 != null && R2 != null) {
			 if(R1.val > R2.val) {
				 inOrderTwoBST(R1.right, R2, res);
			 }else {
				 inOrderTwoBST(R1, R2.right, res);
			 }
		 }else if(R1 != null) {
			 inOrderTwoBST(R1.right, R2, res);
		 }else if(R2 != null) {
			 inOrderTwoBST(R1, R2.right, res);
		 }
	}
	
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<Integer>();
        
        inOrderTwoBST(root1, root2, res);
        
        return res;
    }
}
