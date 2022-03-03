//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        return bottomUp(s);
    }
    
    private String bottomUp(String s) {
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(s.charAt(i) == s.charAt(j) && ((j-i < 3) || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(res == null || j-i+1 > res.length()) res = s.substring(i, j+1);
                }
            }
        }
        
        return res;
    }
}
