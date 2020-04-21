package com.pk.problems;

import java.util.List;

/**
 * problem link : https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
 * @author pk0044
 *
 */


interface BinaryMatrix {
	public int get(int x, int y);
	public List<Integer> dimensions();
};

public class LeftMostColWithOne {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int res = -1;
        List<Integer> dim = binaryMatrix.dimensions();
        int row = dim.get(0);
        int col = dim.get(1);
        
        if(row == 0 || col == 0){
            return -1;
        }
        
        int r = 0;
        int c = col-1;
        
        while(c >= 0){
            if(binaryMatrix.get(0,c) == 1){
                c--;
            }else{
                break;
            }
        }
        
        r++;
        
        while(r < row && c >= 0){
            if(binaryMatrix.get(r,c) == 1){
                c--;
            }else{
                r++;
            }
        }
        
        if(c == col-1){
            res = -1;
        }else{
            res = c+1;
        }
        return res;
    }
}
