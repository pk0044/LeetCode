package com.pk.dp;

/**
 * bruteforce apporach to find the min cost path in a matrix from start to end cell
 * @author pk0044
 *
 */
public class MinCostBruteForce {
	
	private int findMinUtil(int X1, int Y1, int X2, int Y2, int cost, int[][] matrix) {
		if(X1 == X2 && Y1 == Y2) {
			return cost;
		}
		
		System.out.println(X1 + "  " + Y1);
		
		int path1 = Integer.MAX_VALUE;
		int path2 = Integer.MAX_VALUE;
		
		if(X1+1 <= X2) {
			path1 = findMinUtil(X1+1, Y1, X2, Y2, cost + matrix[X1+1][Y1], matrix);
		}
		
		if(Y1+1 <= Y2) {
			path2 = findMinUtil(X1, Y1+1, X2, Y2, cost + matrix[X1][Y1+1], matrix);
		}
		
		return path1 < path2 ? path1 : path2;
	}
	
	public int findMinCost(int[][] matrix) {
		int l = matrix.length;
		if(l == 0) {
			return 0;
		}
		
		int b = matrix[0].length;
		if(b == 0) {
			return 0;
		}
		
		if(l == 1 && b == 1) {
			return matrix[0][0];
		}
		
		return findMinUtil(0, 0, l-1, b-1, matrix[0][0], matrix);
	}
}
