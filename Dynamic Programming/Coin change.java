//https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        // return topDown(coins, amount, memo);
        return bottomUp(coins, amount);
    }
    
    private int bottomUp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        
        for(int i=1; i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(i >= coin) {
                    if(dp[i-coin] != Integer.MAX_VALUE) {
                        dp[i] = Integer.min(dp[i], dp[i-coin] + 1); 
                    }
                }
            }
        }
        
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
    
    private int topDown(int[] coins, int amount, int[] memo) {
        if(amount == 0) return 0;
        
        if(memo[amount] != 0) return memo[amount];
        
        //Reducing the amount by a large coin could result in more smaller coins required (ex. more 1s)
        //Instead, reducing by a smaller coin could result in lesser number of total coins
        int min = Integer.MAX_VALUE;
        
        for(int i=coins.length-1; i>=0; i--) {
            if(amount >= coins[i]) {
                int res = topDown(coins, amount - coins[i], memo);
                if(res != -1) {
                    min = Integer.min(min, res);
                }
            }
        }
                
        return memo[amount] = (min == Integer.MAX_VALUE ? -1 : min + 1);
    }
}
