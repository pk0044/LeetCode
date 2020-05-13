package com.pk.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * problem link : https://leetcode.com/problems/subsets/
 * @author pk0044
 *
 */
public class Subsets {
	
	private void findSubSets(int i, int[] nums, List<List<Integer>> res) {
		List<Integer> sets = new ArrayList<Integer>();
		
		for(int j=0; j<nums.length; j++) {
			if((i & (1 << j)) > 0) {
				sets.add(nums[j]);
			}
		}
		
		res.add(sets);
	}
	
    public List<List<Integer>> subsets(int[] nums) {
    	
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0; i< 1 << nums.length; i++) {
        	findSubSets(i, nums, res);
        }
        return res;
    }
}
