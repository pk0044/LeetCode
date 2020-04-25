package com.pk.problems;

public class Application {

	public static void main(String[] args) {

//		int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
//		
//		MinPathSum obj = new MinPathSum();
//		System.out.println(obj.minPathSum(a));
		
		LRUCache obj = new LRUCache(10);
		
		
		obj.put(7, 28);
		obj.put(7, 1);
		obj.put(8, 15);
		System.out.println(obj.get(6));
		obj.put(10, 27);
		obj.put(8, 10);
		System.out.println(obj.get(8));
		obj.put(6, 29);
		obj.put(1,9);
		System.out.println(obj.get(6));
		obj.put(10, 7);
//		System.out.println(obj.get(1));
//		System.out.println(obj.get(2));
//		System.out.println(obj.get(3));
//		System.out.println(obj.get(4));
//		System.out.println(obj.get(5));
	}

}
