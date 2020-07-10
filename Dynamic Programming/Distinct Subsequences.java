//https://leetcode.com/problems/distinct-subsequences/

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // int[][] memo = new int[n+1][m+1];
        // for(int i=0; i<=n; i++) Arrays.fill(memo[i],-1);
        // return backtrack(s, t, n, m, 0, 0, memo);
        return dp(s.toCharArray(), t.toCharArray());
    }
    
    private static int backtrack(String s, String t, int n, int m, int c1, int c2, int[][] memo)
    {
        if(c1>=n && c2<m) return 0;
        if(c2==m) return 1;
        if(memo[c1][c2]!=-1) return memo[c1][c2];
        
        int taken=0, nottaken=0;
        
        if(s.charAt(c1) == t.charAt(c2))
        {
            taken = backtrack(s,t,n,m,c1+1,c2+1,memo);
        }
        
        nottaken = backtrack(s,t,n,m,c1+1,c2,memo);
        
        return memo[c1][c2] = taken + nottaken;
    }
    
    private static int dp(char[] s, char[] t)
    {
//         int[][] dp = new int[n+1][m+1];
//         for(int i=0; i<=n; i++) dp[i][m] = 1;
        
//         for(int i=n-1; i>=0; i--)
//         {
//             for(int j=m-1; j>=0; j--)
//             {
//                 if(s.charAt(i)==t.charAt(j))
//                 {
//                     dp[i][j] = dp[i+1][j+1];
//                 }
//                 dp[i][j] += dp[i+1][j];
//             }
//         }
        
//         return dp[0][0];
        
        
//         int n=s.length, m=t.length;
//         // int[][] dp = new int[n+1][m+1];
//         int[][] dp = new int[2][m+1];
        
//         // for(int i=0; i<=n; i++) dp[i][m] = 1;
//         dp[0][m] = 1;
//         dp[1][m] = 1;
//         int flag = 0;
        
//         for(int i=n-1; i>=0; i--)
//         {
//             for(int j=m-1; j>=0; j--)
//             {
//                 dp[flag][j] = 0;
//                 if(s[i]==t[j])
//                 {
//                     // dp[i][j] += dp[i+1][j+1];
//                     dp[flag][j] = dp[flag^1][j+1];
//                 }
//                 // dp[i][j] += dp[i+1][j];
//                 dp[flag][j] += dp[flag^1][j];
//             }
//             flag^=1;
//         }
        
        int n=s.length, m=t.length;
        
        int[] dp = new int[m+1];
        dp[m] = 1;
        
        for(int i=n-1; i>=0; i--)
        {
            int pre = dp[m];
            for(int j=m-1; j>=0; j--)
            {
                // int saved = dp[j];
                // dp[j] = 0;
                // if(s[i]==t[j])
                // {
                //     dp[j] = pre;
                // }
                // dp[j] += saved;
                // pre = saved;
                
                int saved = dp[j];
                if(s[i]==t[j]) dp[j] += pre;
                pre = saved;
            }
        }
        return dp[0];
    }
}
