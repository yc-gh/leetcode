// https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return dp(coins, amount, new int[amount+1]);
    }
    
    private static int dp(int[] coins, int n, int[] dp)
    {   
        if(n<0) return -1;
        if(n==0) return 0;
        if(dp[n]!=0) return dp[n];
        int min = Integer.MAX_VALUE;
        for(int coin : coins)
        {
            if(coin <= n)
            {
                int res = dp(coins, n-coin, dp);
                if(res>=0 && res<min) min = res+1;
            }
        }
        dp[n] = (min==Integer.MAX_VALUE) ? -1 : min;
        return dp[n];
    }
    
    private static int dp(int[] coins, int n)
    {
        int m = coins.length;
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            int min = Integer.MAX_VALUE;
            for(int coin : coins)
            {
                if(i-coin>=0 && dp[i-coin]!=-1)
                    min = dp[i]=dp[i-coin] 
            }
        }
    }
}
