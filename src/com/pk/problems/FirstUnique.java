package com.pk.problems;

import java.util.HashMap;
import java.util.Map;

class FirstUnique {

	public class Node{
		int value;
		boolean status;
		Node prev;
		Node next;
		
		public Node(int value) {
			this.value = value;
			this.status = true;
		}
	}
	
	Node head = null;
	Node last = null;
	
	private Map<Integer, Node> map = new HashMap<Integer , Node>();
	
    public FirstUnique(int[] nums) {
        for(int i=0; i<nums.length; i++) {
        	add(nums[i]);
        }
    }
    
    public int showFirstUnique() {
		if(head == null) {
			return -1;
		}
		return head.value;
    }
    
    public void add(int value) {
        if(map.containsKey(value) && map.get(value).status == true) {
        	Node node = map.get(value);
        	if(node == head) {
        		if(head.next == null) {
        			head = null;
        			last = null;
        		}else {
        			head = head.next;
        			head.prev = null;
        		}
        	}else if(node == last) {
        		last = last.prev;
        		last.next = null;
        	}else {
        		node.prev.next = node.next;
        		node.next.prev = node.prev;
        	}
        	node.status = false;
        }else {
        	Node tmp = new Node(value);
        	map.put(value, tmp);
        	
        	if(head == null) {
        		head = tmp;
        		last = tmp;
        	}else {
        		last.next = tmp;
        		tmp.prev = last;
        		last = tmp;
        	}
        }
    }
}