package com.pk.problems;

import java.util.HashMap;
import java.util.Map;

class FirstUnique {

	
	public class Node{
		int value;
		Node prev;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	Node head = null;
	Node last = null;
	
	private Map<Integer, Node> map = new HashMap<Integer , Node>();
	
    public FirstUnique(int[] nums) {
        
    }
    
    public int showFirstUnique() {
		return 0;
    }
    
    public void add(int value) {
        if(map.containsKey(value)) {
        	Node node = map.get(value);
        }else {
        	Node tmp = new Node(value);
        	map.put(value, tmp);
        }
    }
}