package com.pk.leetcode.linkedlist;

/**
 * problem link : https://leetcode.com/problems/intersection-of-two-linked-lists/
 * @author pk0044
 *
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class IntersectionOfLL {
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        ListNode curr = headB;
        while(curr.next != null) {
        	curr = curr.next;
        }
        
        curr.next = headB;
        
        ListNode slowNode = headA;
        ListNode fastNode = headA;
        ListNode contactNode = null;
        while(true) {
        	slowNode = slowNode.next;
        	fastNode = fastNode.next.next;
        	
        	if(slowNode == fastNode) {
        		contactNode = slowNode;
        		break;
        	}
        }
        return res;
    }
}
