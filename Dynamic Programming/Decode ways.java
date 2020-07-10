//https://leetcode.com/problems/decode-ways/

class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        // return dp(s.toCharArray(),0,new int[s.length()]);
        return dp(s.toCharArray());
    }
    
    private static int dp(char[] s, int curr, int[] dp)
    {
        if(curr==s.length) return 1;
        if(dp[curr]>0) return dp[curr];
        int count = 0;
        if(s[curr]>'0') count += dp(s,curr+1,dp);
        if(curr<s.length-1 && s[curr]=='1') count += dp(s,curr+2,dp);
        else if(curr<s.length-1 && s[curr]=='2' && s[curr+1]<='6') count += dp(s,curr+2,dp); 
        return dp[curr] = count;
    }
    
    private static int dp(char[] s)
    {
        int[] dp = new int[s.length+1];
        dp[s.length] = 1;
        for(int i=s.length-1; i>=0; i--)
        {
            if(s[i]>'0') dp[i] += dp[i+1];
            if(i<s.length-1 && s[i]=='1') dp[i] += dp[i+2];
            else if(i<s.length-1 && s[i]=='2' && s[i+1]<='6') dp[i] += dp[i+2];
        }
        return dp[0];
    }
}
