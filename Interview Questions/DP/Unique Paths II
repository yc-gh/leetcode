//https://leetcode.com/problems/unique-paths-ii/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] dp = new int[r+1][c+1];
        for(int i=r-1; i>=0; i--)
        {
            for(int j=c-1; j>=0; j--)
            {
                if(i==r-1 && j==c-1) 
                {
                    if(obstacleGrid[i][j]==1) return 0;
                    dp[i][j] = 1;
                }
                else
                {
                    if(obstacleGrid[i][j]==1) dp[i][j] = 0;
                    else
                    {
                        dp[i][j] = dp[i+1][j] + dp[i][j+1];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
