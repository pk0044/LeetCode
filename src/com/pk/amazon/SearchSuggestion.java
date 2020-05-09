package com.pk.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * problem link : https://leetcode.com/problems/search-suggestions-system/
 * 
 * @author pk0044
 *
 */
public class SearchSuggestion {
	class TrieNode{
		TrieNode[] child;
		boolean isleaf;
		
		public TrieNode() {
			child = new TrieNode[26];
			isleaf = false;
		}
	}
	
	TrieNode root = new TrieNode();
	
	private void insertIntoTrieNode(String str) {
		TrieNode temp = root;
		for(char ch : str.toCharArray()) {
			if(temp.child[ch - 'a'] == null) {
				temp.child[ch - 'a'] = new TrieNode();
			}
			
			temp = temp.child[ch - 'a'];
		}
		
		temp.isleaf = true;
	}
	
	private void findSuggestionsUtils(TrieNode prefixEndNode, String str, List<List<String>> res) {
		List<String> suggestions = new ArrayList<String>();
		String suggestedWord = str;
		while(true) {
			for(int i=0; i<26; i++) {
				if(prefixEndNode.child[i] != null) {
					suggestedWord = suggestedWord + 'a' + i;
					
				}
			}
		}
	}
	
	private void findSuggestions(String str, List<List<String>> res) {
		String resStr = "";
		TrieNode temp = root;
		
		for(char ch : str.toCharArray()) {
			if(temp.child[ch - 'a'] != null) {
				temp = temp.child[ch - 'a'];
			}
		}
		
		findSuggestionsUtils(temp, str, res);
	}
	
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	
    	for(String str : products) {
    		insertIntoTrieNode(str);
    	}
    	
    	for(int i=1; i<=searchWord.length(); i++) {
    		findSuggestions(searchWord.substring(0, i), res);
    	}
    	return res;
    }
}
