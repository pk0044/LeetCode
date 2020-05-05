package com.pk.leetcode.may;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
    	Map<Character, Boolean> map = new HashMap<Character, Boolean>(); 
        for(int i=0; i<J.length(); i++) {
        	map.put(J.charAt(i), true);
        }
        
        int count = 0;
        for(int i=0; i<S.length(); i++) {
        	if(map.containsKey(S.charAt(i)) && map.get(S.charAt(i)) == true) {
        		count++;
        	}
        }
        
        return count;
    }
}
