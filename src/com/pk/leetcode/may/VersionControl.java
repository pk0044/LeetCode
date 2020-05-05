package com.pk.leetcode.may;

public class VersionControl {
	
	private boolean isBadVersion(int version) {
		
		if(version >= 1 && version <= 3) {
			return true;
		}
		if(version >= 4 && version <= 5) {
			return false;
		}

		return false;
	}
	
    
    public int firstBadVersion(int n) {
    	int start = 0;
    	int end = n;
    	int mid = 0;
    	
    	while(start <= end) {
    		mid = start + (end - start) / 2;
    		if(!isBadVersion(mid)) {
    			start = mid + 1;
    		}else {
    			end = mid - 1;
    		}
    	}
    	
    	if(!isBadVersion(mid)) {
    		return mid + 1;
    	}
    	
    	return mid;
    }
}
