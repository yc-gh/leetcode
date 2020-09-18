//https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int[] memo = new int[cost.length];
        // return Integer.min(topDown(cost, 0, memo), topDown(cost, 1, memo));
        
        return bottomUp(cost);
    }
    
    private int topDown(int[] cost, int index, int[] memo)
    {
        if(index >= cost.length) return 0;
        
        if(memo[index] > 0) return memo[index];
        
        
        return memo[index] = cost[index] + Integer.min(topDown(cost, index+1, memo), topDown(cost, index+2, memo));
        
    }
    
    private int bottomUp(int[] cost)
    {
        int[] dp = new int[cost.length+2];
        
        for(int i=cost.length-1; i>=0; i--)
        {
            dp[i] = cost[i] + Integer.min(dp[i+1], dp[i+2]);
        }
        
        return Integer.min(dp[0],dp[1]);
    }
}
