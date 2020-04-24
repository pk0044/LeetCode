package com.pk.problems;

public class Application {

	public static void main(String[] args) {

//		int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
//		
//		MinPathSum obj = new MinPathSum();
//		System.out.println(obj.minPathSum(a));
		
		LRUCache obj = new LRUCache(2);
		
		System.out.println(obj.get(2));
		obj.put(2, 6);
		System.out.println(obj.get(1));
		obj.put(1, 5);
		obj.put(1, 2);
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));
	}

}
