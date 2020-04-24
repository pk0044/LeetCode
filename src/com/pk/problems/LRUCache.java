package com.pk.problems;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

	Map<Integer, Node> map;
	int capacity;
	int size;
	Node head;
	Node last;
	
	public class Node{
		int key;
		int val;
		boolean availability;
		Node prev;
		Node next;
		
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.availability = true;
		}
	}
	
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.last = null;
    }
    
    public int get(int key) {
    	int res = -1;
        if(!map.containsKey(key)) {
        	res = -1;
        }else if(map.containsKey(key) && map.get(key).availability == false) {
        	res = -1;
        }else {
        	res = map.get(key).val;
        	Node tmp = map.get(key);
        	if(size > 1 && tmp == last) {
        		last = last.prev;
        		last.next = null;
        		tmp.next = head;
        		head.prev = tmp;
        		head = tmp;
        	}
        }
        return res;
    }
    
    public void put(int key, int value) {
    	if(size == 0) {
    		Node curr = new Node(key, value);
    		map.put(key, curr);
    		head = curr;
    		last = curr;
    		size++;
    	}else if(this.capacity == 1){
    		if(head != null) {
    			head.availability = false;
    		}
    		Node curr = new Node(key, value);
    		map.put(key, curr);
    		head = curr;
    		last = curr;
    	}else if(map.containsKey(key) && map.get(key).availability == true) {
    		if(this.size > 1) {
        		if(map.get(key) == last) {
        			Node tmp = last;
        			last = last.prev;
        			tmp.next = head;
        			head.prev = tmp;
        			head = tmp;
        		}else if(map.get(key) == head){
        			map.get(key).val = value;
        		}else{
        			Node tmp = map.get(key);
        			Node prev = tmp.prev;
        			prev.next = tmp.next;
        			tmp.next.prev = prev;
        			tmp.prev = null;
        			tmp.next = head;
        			head = tmp;
        		}
    		}
    		map.get(key).val = value;
    	}else if(this.size < this.capacity) {
    		Node curr = new Node(key, value);
    		map.put(key, curr);
    		curr.next = head;
    		head.prev = curr;
    		head = curr;
    		size++;
		}else if(this.size >= this.capacity) {
			Node curr = new Node(key, value);
			map.put(key, curr);
			curr.next = head;
			head.prev = curr;
			head = curr;
			last.availability = false;
			last = last.prev;
			last.next = null;
		}
    }
}
