//https://leetcode.com/problems/longest-palindromic-subsequence/


public class Solution {
    public int longestPalindromeSubseq(String s) {
        return dp(s);
    }
    
    private static int dp(String str)
    {
        char[] chars = str.toCharArray();
        int n = chars.length;
        
        // int[][] dp = new int[2][n];
        
        int[] dp = new int[n];
        
        // int flag = 0;
        
        for(int i=n-1; i>=0; i--)
        {
            // dp[i][i] = 1;
            // dp[flag][i] = 1;
            dp[i] = 1;
            int pre = 0;
            for(int j=i+1; j<n; j++)
            {
                // if(chars[i]==chars[j]) dp[flag][j] = 2 + dp[flag^1][j-1];
                // else dp[flag][j] = Integer.max(dp[flag^1][j], dp[flag][j-1]);
                
                int saved = dp[j];
                if(chars[i]==chars[j]) dp[j] = 2 + pre;
                else dp[j] = Integer.max(dp[j], dp[j-1]);
                pre = saved;
            }
            
            // flag^=1;
        }
        
        // return dp[flag^1][n-1];
        
        return dp[n-1];
    }
}
