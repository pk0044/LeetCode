package com.pk.problems;

/**
 * Problem Statement 
 * 
 * Given an array nums of n integers where n > 1,  return an array output such that 
 * output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Example:
 * Input : [1,2,3,4]
 * Output : [24,12,8,6]
 * 
 * link : https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/
 * 
 * @author pk0044
 *
 */

public class ProductExceptSelf {
	

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int product = 1;
        int zerocount = 0;
        int prodouctWithoutZero = 1;
        
        int[] output = new int[size];
        
        for(int i=0; i<size; i++){
            
                if(nums[i] == 0){
                    zerocount++;
                }
            
                if(nums[i] != 0){
                    product = product * nums[i];
                }
        }
        
        for(int i=0; i<size; i++){
            if(nums[i] == 0 && zerocount < 2){
                output[i] = product;
            }else if(nums[i] != 0 && zerocount == 0){
                output[i] = product / nums[i];
            }else{
                output[i] = 0;
            }
        }
        
        return output;
    }

}
