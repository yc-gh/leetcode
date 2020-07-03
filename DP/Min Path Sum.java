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

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n+1][m+1];
        for(int i=0; i<=n; i++) Arrays.fill(memo[i], -1);
        return dp(grid, 0, 0, memo);
    }
    
    private static int dp(int[][] grid, int x, int y, int[][] memo)
    {
        if(x==grid.length-1 && y==grid[0].length-1) 
        {
            return memo[x][y] = grid[x][y];
        }
        
        else if(x>=grid.length || y>=grid[0].length) return Integer.MAX_VALUE;
        
        if(memo[x][y] != -1) return memo[x][y];
        
        return memo[x][y] = grid[x][y] + Integer.min(dp(grid,x+1,y,memo), dp(grid,x,y+1,memo));
    }
}
