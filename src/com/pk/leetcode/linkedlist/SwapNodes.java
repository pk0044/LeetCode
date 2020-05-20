package com.pk.leetcode.linkedlist;

/**
 * problem link : https://leetcode.com/problems/swap-nodes-in-pairs/
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
public class SwapNodes {
	
	 public class ListNode {
		    int val;
		    ListNode next;
		    ListNode() {}
		    ListNode(int val) { this.val = val; }
		    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	
    public ListNode swapPairs(ListNode head) {
        
    	if(head == null || head.next == null) {
    		return head;
    	}
    	
    	
    	ListNode tmp = head;
    	ListNode end2;
    	ListNode end1 = head;
    	ListNode first;
    	ListNode sec = null;
    	
    	while(tmp != null) {
    		
    		first = tmp;
    		if(first != null) {
        		sec = tmp.next;
    		}
    		
    		if(sec != null) {
    			end2 = sec.next;
    		}else {
    			end2 = null;
    		}
    		
    		if(sec != null) {
        		sec.next = first;
    		}
    		first.next = null;
    		
    		if(first == head) {
    			head = sec;
    		}else {
    			end1.next = sec;
    		}
    		
    		
    		end1 = first;
    		
    		tmp = end2;
    	}
    	
    	return head;
    }
}
