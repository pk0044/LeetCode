package com.pk.amazon;

/**
 * problem link : https://leetcode.com/problems/merge-two-sorted-lists/
 * @author pk0044
 *
 */
public class MergeTwoList {
	
	public class ListNode {
	     int val;
	     ListNode next;

	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode res = null;
    	ListNode temp;
    	
    	if(l1 == null) {
    		res = l2;
    		return res;
    	}else if(l2 == null) {
    		res = l1;
    		return res;
    	}
    	
    	if(l1.val < l2.val) {
    		temp = l1;
    		res = l1;
    		l1 = l1.next;
    		temp.next = null;
    	}else {
    		temp = l2;
    		res = l2;
    		l2 = l2.next;
    		temp.next = null;
    	}
    	
    	ListNode curr = null;
    	
    	while(l1 == null || l2 == null) {
    		if(l1.val <= l2.val) {
    			curr = l1;
    			l1 = l1.next;
    			temp.next = curr;
    		}else {
    			curr = l2;
    			l2 = l2.next;
    			temp.next = curr;
    		}
    		temp = temp.next;
    		temp.next = null;
    	}
    	
    	if(l1 != null) {
    		temp.next = l1;
    	}
    	
    	if(l2 != null) {
    		temp.next = l2;
    	}
    	
    	return res;
    }
}
