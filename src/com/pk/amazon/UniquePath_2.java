package com.pk.amazon;

public class UniquePath_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if(n == 0) {
        	return 0;
        }
        
        int m = obstacleGrid[0].length;
        
        int[][] res = new int[n][m];
        
        if(obstacleGrid[0][0] == 1) {
        	res[0][0] = 0;
        }else {
        	res[0][0] = 1;
        }
        
        for(int i=1; i<n; i++) {
        	if(obstacleGrid[i][0] == 1) {
        		res[i][0] = 0;
        	}else {
        		res[i][0] = res[i-1][0];
        	}
        }
        
        for(int i=1; i<m; i++) {
        	if(obstacleGrid[0][i] == 1) {
        		res[0][i] = 0;
        	}else {
        		res[0][i] = res[0][i-1];
        	}
        }
        
        for(int i=1; i<n; i++) {
        	for(int j=1; j<m; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			res[i][j] = 0;
        		}else {
        			res[i][j] = res[i-1][j] + res[i][j-1];
        		}
        	}
        }
        
        return res[n-1][m-1];
    }
}
