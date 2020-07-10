<<<<<<< HEAD:DP/Coin change.java
// https://leetcode.com/problems/coin-change/

// Bottom up
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Integer.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        if (dp[amount] != Integer.MAX_VALUE)
            return dp[amount];

        return -1;
    }
}

// Top down
=======
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
>>>>>>> 0ce27c1e613e423652af7f144fdb9f5032f5df8a:Interview Questions/DP/Coin change.java
