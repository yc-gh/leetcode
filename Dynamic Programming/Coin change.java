//https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return -1;
        if(amount == 0) return 0;
        
        // int[] memo = new int[amount+1];
        // return topDown(coins, amount, memo);
        
        return bottomUp(coins, amount);
    }
    
    private int bottomUp(int[] coins, int amount)
    {
        int[] dp = new int[amount+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE-1); // or amount + 1
        
        dp[0] = 0;
        
        for(int i=1; i<=amount; i++)
        {
            for(int coin : coins)
            {
                if(coin <= i) dp[i] = Integer.min(dp[i], dp[i-coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    private int topDown(int[] coins, int amount, int[] memo)
    {
        if(amount < 0) return -1;
        else if(amount == 0) return 0;
        
        if(memo[amount] != 0) return memo[amount];
        
        int min = Integer.MAX_VALUE;
        
        for(int coin : coins)
        {
            int rem = topDown(coins, amount-coin, memo);
            if(rem >= 0 && rem < min)
            {
                min = 1 + rem;
            }
        }
        
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }
}
