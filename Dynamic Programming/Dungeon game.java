//https://leetcode.com/problems/dungeon-game/

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;        
        if(m==0 || n==0) return 0;
        // return topDown(dungeon, 0, 0, new int[m][n]);
        return bottomUp(dungeon, m, n);
    }
    
    private static int topDown(int[][] d, int x, int y, int[][] memo)
    {
        if(x>=d.length || y>=d[0].length) return Integer.MAX_VALUE;
        
        if(memo[x][y]>0) return memo[x][y];
        
        if(x==d.length-1 && y==d[0].length-1) return memo[x][y] = d[x][y]>0 ? 1 : (-1*d[x][y])+1;
        
        // currHealth + d[x][y] = nextHealth
        // nextHealth - d[x][y] = currHealth
        // currHealth should be minimum and >= 1
        
        // int nextHealth = Integer.MAX_VALUE;
        // nextHealth = Integer.min(nextHealth, Integer.min(topDown(d,x+1,y,memo), topDown(d,x,y+1,memo)));
        // nextHealth = nextHealth == Integer.MAX_VALUE ? 1 : nextHealth; // only for last cell (P)
        int nextHealth = Integer.min(topDown(d,x+1,y,memo), topDown(d,x,y+1,memo));
        int currHealth = nextHealth>d[x][y] ? (nextHealth-d[x][y]) : 1 ;
        
        return memo[x][y] = currHealth;
    }
    
    private static int bottomUp(int[][] d, int m, int n)
    {
        int[][] dp = new int[m+1][n+1];
        
        // dp[m-1][n-1] = d[m-1][n-1]>0 ? 1 : (-1*d[m-1][n-1])+1;
        for(int i=0; i<m; i++) dp[i][n] = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) dp[m][j] = Integer.MAX_VALUE;

        
        for(int i=m-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(i==m-1 && j==n-1) 
                {
                    dp[i][j] = d[i][j]>0 ? 1 : (-1*d[i][j])+1;
                    continue;
                }
                int nextHealth = Integer.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = nextHealth>d[i][j] ? (nextHealth-d[i][j]) : 1;
            }
        }
        
        return dp[0][0];
    }
}
