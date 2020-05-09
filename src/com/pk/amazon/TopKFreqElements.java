package com.pk.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * problem link : https://leetcode.com/problems/top-k-frequent-elements/
 * @author pk0044
 *
 */
public class TopKFreqElements {
	
	
	public class Node{
		int val;
		int freq;
		
		public Node(int val, int freq) {
			this.val = val;
			this.freq = freq;
		}
	}
	
	Node[] heap;
	int size = 0;
	int k = 0;
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	private int getParent(int index) {
		if(index == 0) {
			return -1;
		}
		return (index - 1) / 2;
	}
	
	private int getLeftChild(int index) {
		return 2 * index + 1;
	}
	
	private int getRightChild(int index) {
		return 2 * index + 2;
	}
	
	private void swap(int A, int B) {
		Node temp = heap[A];
		heap[A] = heap[B];
		heap[B] = temp;
	}
	
	
	private void heapify(int index) {
		int maxIndex = index;
		
		int left = getLeftChild(index);
		int right = getRightChild(index);
		
		if(left < size && heap[index].freq > heap[left].freq) {
			maxIndex = left;
		}
		
		if(right < size && heap[maxIndex].freq > heap[right].freq) {
			maxIndex = right;
		}
		
		if(maxIndex != index) {
			swap(index, maxIndex);
			heapify(maxIndex);
		}
	}
	
	private void deleteMin() {
		if(size > 0) {
			swap(0, size-1);
			size--;
			heapify(0);
		}
	}
	
	private void insert(Node node) {
		if(size == 0) {
			heap[0] = node;
			size++;
			return;
		}
		
		if(size < k) {
			heap[size] = node;
			int index = size;
			
			while(index > 0) {
				int parent = getParent(index);
				if(parent >= 0 && heap[parent].freq > heap[index].freq) {
					swap(parent, index);
				}else {
					break;
				}
				index = parent;
			}
			size++;
		}else if(heap[0].freq < node.freq){
			deleteMin();
			insert(node);
		}
	}
	
    public int[] topKFrequent(int[] nums, int k) {
    	this.k = k;
    	int freq;
    	for(int i=0; i<nums.length; i++) {
    		if(map.containsKey(nums[i])){
    			freq = map.get(nums[i]);
    			freq = freq + 1;
    		}else {
    			freq = 1;
    		}
    		map.put(nums[i], freq);
    	}
    	
        heap = new Node[k];
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	Node node = new Node(entry.getKey(), entry.getValue());
        	insert(node);
        }
        
        int[] res = new int[k];
        
        for(int i=0; i<k; i++) {
        	res[i] = heap[i].val;
        }
        
        return res;
    }
}
