//https://leetcode.com/problems/minimum-path-sum/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=m-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(i==m-1) dp[i][j] = grid[i][j] + dp[i][j+1];
                else if(j==n-1) dp[i][j] = grid[i][j] + dp[i+1][j];
                else dp[i][j] = grid[i][j] + Integer.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
