package com.pk.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * problem link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @author pk0044
 *
 */
public class PhoneNumber {
	private void letterCombinationUtil(String digits, int index, int l, String str, Map<Character, String> map, List<String> res) {
		if(index == l) {
			res.add(str);
			return;
		}
		if(str.charAt(index) == '7' || str.charAt(index) == '9') {
			letterCombinationUtil(digits, index+1, l, str+map.get(str.charAt(index)).charAt(0), map, res);
			letterCombinationUtil(digits, index+1, l, str+map.get(str.charAt(index)).charAt(1), map, res);
			letterCombinationUtil(digits, index+1, l, str+map.get(str.charAt(index)).charAt(2), map, res);
			letterCombinationUtil(digits, index+1, l, str+map.get(str.charAt(index)).charAt(3), map, res);
		}else {
			letterCombinationUtil(digits, index+1, l, str+map.get(str.charAt(index)).charAt(0), map, res);
			letterCombinationUtil(digits, index+1, l, str+map.get(str.charAt(index)).charAt(1), map, res);
			letterCombinationUtil(digits, index+1, l, str+map.get(str.charAt(index)).charAt(2), map, res);
		}
	}
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinationUtil(digits, 0, digits.length(), "", map, res);
        return res;
    }
}
