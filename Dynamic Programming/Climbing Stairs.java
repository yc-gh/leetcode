// https://leetcode.com/problems/climbing-stairs/

class Solution {
    public int climbStairs(int n) {
        // int[] memo = new int[n + 1];
        // return topDown(0, n, memo);
        return bottomUp(n);
    }
    
    private int topDown(int step, int total, int[] memo) {
        if(step == total) return 1;
        else if(step > total) return 0;
        if(memo[step] > 0) return memo[step];
        return memo[step] = topDown(step+1, total, memo) + topDown(step+2, total, memo);
    }
    
    private int bottomUp(int total) {
        int[] dp = new int[total + 2];
        
        dp[total] = 1;
        
        for(int i=total-1; i>=0; i--) 
        {
            dp[i] = dp[i+1] + dp[i+2];
        }
        
        return dp[0];
    }
}
