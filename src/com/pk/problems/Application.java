package com.pk.problems;

public class Application {

	public static void main(String[] args) {

//		int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
//		
//		MinPathSum obj = new MinPathSum();
//		System.out.println(obj.minPathSum(a));
//		JumpGame obj = new JumpGame();
//		int[] nums = {0};
//		
//		
//		System.out.println(	obj.canJump(nums));
		
//		RangeBitwise obj = new RangeBitwise();
//		System.out.println(obj.rangeBitwiseAnd(17, 19));
		
//		LCS obj = new LCS();
//		System.out.println(obj.longestCommonSubsequence("abcde", "ace"));
		
		LargestSquare obj = new LargestSquare();
		char[][] a = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(obj.maximalSquare(a));
	}

}
