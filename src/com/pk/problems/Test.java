package com.pk.problems;

public class Test {
	
	private static void change(int[] a) {
		a[0] = 1000;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		
		change(a);
		
		System.out.println(a[0]);
		
	}
}
