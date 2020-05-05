package com.pk.algorithms;

public class QuickSort {
	
	int[] a = {1, 5, 90, 100, 0, -20, -40, -100};
	
	public void quickSort(int start, int end) {
		
		if(start < end) {
			int pivot = end;
			int index = -1;
			
			for(int i=0; i<end; i++) {
				if(a[i] < a[pivot]) {
					index++;
					int temp = a[index];
					a[index] = a[i];
					a[i] = temp;
				}
			}
			
			index++;
			int temp = a[pivot];
			a[pivot] = a[index];
			a[index] = temp;
			
			quickSort(start, index-1);
			quickSort(index+1, end);
		}
		
	}
	
	public void display() {
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
