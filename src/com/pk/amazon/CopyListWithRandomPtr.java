package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * @author pk0044
 *
 */

class Node {
	int val;
	Node next;
	Node random;
	

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class CopyListWithRandomPtr {
	
	public Node head = null;
	
	public void createList() {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
	}
	
	public void display() {
		Node temp = head;
		
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	public Node copyRandomList(Node head) {
		if(head == null) {
			return null;
		}
		
		Node temp = head;
		
		while(temp != null) {
			Node copyNode = new Node(temp.val);
			copyNode.next = temp.next;
			temp.next = copyNode;
			temp = copyNode.next;
		}
		
	//	display();
		
		Node tmp1 = head;
		Node tmp2 = head.next;
		Node head2 = head.next;
		
		while(tmp1 != null && tmp2 != null) {
			if(tmp1.random != null) {
				tmp2.random = tmp1.random.next;
			}else {
				tmp2.random = null;
			}
			tmp1.next = tmp2.next;
			if(tmp2.next != null) {
				tmp2.next = tmp2.next.next;
			}else {
				tmp2.next = null;
			}
			
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		
		return head2;
	}
}
