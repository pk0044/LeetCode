package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @author pk0044
 *
 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveNthNode {
	
	public class ListNode {
	    public int val;
	    public ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	

	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null) {
    		return head;
    	}
    	
    	int index = 1;
    	ListNode first = head;
    	ListNode second = head;
    	
    	while(index <= n) {
    		first = first.next;
    		index++;
    	}
    	
    	if(first == null) {
    		head = head.next;
    		return head;
    	}
    	
    	while(first != null && first.next != null) {
    		first = first.next;
    		second = second.next;
    	}
    	
    	if(second.next != null) {
    		second.next = second.next.next;
    	}
    	
    	return head;
    }
}
