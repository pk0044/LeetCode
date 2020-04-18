package com.pk.problems;

public class Application {

	public static void main(String[] args) {

		int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
		
		MinPathSum obj = new MinPathSum();
		System.out.println(obj.minPathSum(a));
	}

}
