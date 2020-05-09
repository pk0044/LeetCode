package com.pk.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * problem link : https://leetcode.com/problems/most-common-word/
 * @author pk0044
 *
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Boolean> bannedMap = new HashMap<String, Boolean>();
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        String res = "";
        
        for(int i=0; i<banned.length; i++){
            bannedMap.put(banned[i], true);
        }
        
        String word = "";
        
        int index = 0;
        int max = -1;
        int wc = 0;
        while(index < paragraph.length()) {
        	if((paragraph.charAt(index) >= 'a' && paragraph.charAt(index) <= 'z') || (paragraph.charAt(index) >= 'A' && paragraph.charAt(index) <= 'Z')) {
        		word = word + paragraph.charAt(index);
        	}else if(!"".equals(word)){
        		word = word.toLowerCase();
        		if(!bannedMap.containsKey(word)) {
        			if(wordCount.containsKey(word)) {
        				wc = wordCount.get(word) + 1;
        			}else {
        				wc = 1;
        			}
        			
        			if(wc > max) {
        				max = wc;
        				res = word;
        			}
        			wordCount.put(word, wc);
        		}
        		word = "";
        	}
        	index++;
        }
        
        index = index - 1;
        if((paragraph.charAt(index) >= 'a' && paragraph.charAt(index) <= 'z') || (paragraph.charAt(index) >= 'A' && paragraph.charAt(index) <= 'Z')) {
    		word = word.toLowerCase();
    		if(!bannedMap.containsKey(word)) {
    			if(wordCount.containsKey(word)) {
    				wc = wordCount.get(word) + 1;
    			}else {
    				wc = 1;
    			}
    			
    			if(wc > max) {
    				max = wc;
    				res = word;
    			}
    			wordCount.put(word, wc);
    		}
        }
        
        return res;
    }
}
