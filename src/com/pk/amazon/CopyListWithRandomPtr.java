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
	public Node copyRandomList(Node head) {
		if(head == null) {
			return null;
		}
		
		Node temp = head;
		
		while(temp != null) {
			Node copyNode = new Node(temp.val);
			copyNode.next = temp.next;
			temp.next = copyNode;
			if(copyNode.next != null) {
				temp = copyNode.next;
			}else {
				break;
			}
		}
		
		Node prev = head;
		temp = head.next;
		Node head2 = temp;
		
		while(prev != null && temp != null) {
			if(prev.random != null) {
				temp.random = prev.random.next;
			}else {
				temp.random = null;
			}

			prev.next = temp.next;
			if(temp.next != null) {
				temp.next = temp.next.next;
			}
			prev = prev.next;
			temp = temp.next;
		}
		
		return head2;
	}
}
