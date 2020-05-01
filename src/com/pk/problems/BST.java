package com.pk.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class BST {
	public class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	/**
	 * 
	 * 	Node structure
	 * 
	 *  public class Node{
	 *  	int val;
	 *  	Node left;
	 *  	Node right;
	 *  }
	 * 
	 * 
	 * 				 100
	 * 				/	\
	 * 			-200     200
	 * 			 /  \	 /  \
	 * 		  -400 -150 150 300
	 * 				 \
	 * 				-155
	 * 				/
	 * 			  -150
	 * 			
	 *  Left view of the above tree will be : 100 -200 -400
	 *  
	 */
	
	Node root;
	public void createTree() {
		root = new Node(100);
		root.left = new Node(-200);
		root.right = new Node(200);
		root.left.left = new Node(-400);
		root.left.right = new Node(-150);
		root.right.left = new Node(150);
		root.right.right = new Node(300);
		root.left.right.right = new Node(-155);
		root.left.right.right.left = new Node(-150);
		//printLeftView(root);
	}
	
	/**
	 * function for left view
	 * @param root
	 */
	public void printLeftView(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		queue.add(null);
		
		Node prev = null;
		Node curr = null;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			
			if(prev == null && curr != null) {
				System.out.println(curr.val);
			}
			
			if(prev == null && curr == null) {
				break;
			}
			
			if(curr != null && curr.left != null) {
				queue.add(curr.left);
			}
			
			if(curr != null && curr.right != null) {
				queue.add(curr.right);
			}
			
			if(queue.peek() == null) {
				queue.add(null);
			}
			prev = curr;
			
			if(queue.isEmpty()) {
				break;
			}
		}
	}
	
	/**
	 * function for right view of binary tree
	 * output : 100 200 300 -155 -150
	 * @param root
	 */
	public void printRightView(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		queue.add(null);
		Node curr = null;
		Node prev = null;
		
		while(!queue.isEmpty()) {
			
			curr = queue.poll();
			
			if(prev == null && curr != null) {
				System.out.println(curr.val);
			}
			
			if(curr != null && curr.right != null) {
				queue.add(curr.right);
			}
			
			if(curr != null && curr.left != null) {
				queue.add(curr.left);
			}
			
			if(!queue.isEmpty() && curr != null && queue.peek() == null) {
				queue.add(null);
			}
			
			prev = curr;
		}
	}
	
	
	/**
	 *  function to print the bottom view of a binary tree
	 */
	
	int minHd = Integer.MAX_VALUE;
	int maxHd = Integer.MIN_VALUE;
	
	public class Pair{
		Node node;
		int height;
		
		public Pair(Node node, int height) {
			this.node = node;
			this.height = height;
		}
	}
	
	private void printBottomViewUtil(Node root, int hd, int height, Map<Integer, Pair> map) {
		if(root == null) {
			return;
		}
		
		if(hd < minHd) {
			minHd = hd;
		}
		
		if(hd > maxHd) {
			maxHd = hd;
		}
		
		if(map.containsKey(hd)) {
			if(height >= map.get(hd).height) {
				Pair tmp = new Pair(root, height);
				map.put(hd, tmp);
			}
		}else {
			Pair tmp = new Pair(root, height);
			map.put(hd, tmp);
		}
		
		if(root.left != null) {
			printBottomViewUtil(root.left, hd-1, height+1, map);
		}
		
		if(root.right != null) {
			printBottomViewUtil(root.right, hd+1, height+1, map);
		}
	}
	
	public void printBottomView(Node root) {
		if(root == null) {
			return;
		}
		
		Map<Integer, Pair> map = new HashMap<Integer, Pair>();
		int hd = 0;
		int height = 0;
		
		printBottomViewUtil(root, hd, height, map);
		
//		for(Map.Entry<Integer, Pair> entry : map.entrySet()) {
//			System.out.println(entry.getValue().node.val);
//		}
		
		for(int i=minHd; i<=maxHd; i++) {
			System.out.println(map.get(i).node.val);
		}
	}
}
