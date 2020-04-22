package com.pk.problems;

public class SubArrayWithKSum {
    public int subarraySum(int[] nums, int k) {
        
        int size = nums.length;
        int res = 0;
        
        if(size == 0){
            return 0;
        }
        
        if(size == 1 && nums[0] == k){
            return 1;
        }
        
        int[] sumArray = new int[size];
        
        sumArray[0] = nums[0];
        if(sumArray[0] == k){
            res = res + 1;
        }
        
        for(int i=1; i<size; i++){
            sumArray[i] = sumArray[i-1] + nums[i];
             if(sumArray[i] == k){
                 res = res + 1;
             }
        }
        
        
        for(int i=0; i<size-1; i++){
            for(int j=i+1; j<size; j++){
                if(sumArray[j] - sumArray[i] == k){
                    res = res + 1;
                }
            }
        }
        
        return res;
    }
}
