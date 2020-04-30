package com.pk.problems;

import java.util.LinkedList;
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
		printLeftView(root);
	}
	
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
}
