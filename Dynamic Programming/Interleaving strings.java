//https://leetcode.com/problems/interleaving-string/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s2==null || s3==null) return false;
        if(s1.length()+s2.length() != s3.length()) return false;
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int[] a : memo) Arrays.fill(a,-1);
        return topDown(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), memo);
        // return bottomUp(s1.toCharArray(), s2.toCharArray(), s3.toCharArray());
    }
    
    private static boolean topDown(char[] a, int i, char[] b, int j, char[] c, int[][] memo)
    {
        if(i==a.length && j==b.length) return true;
        else if (i+j==c.length && (i<a.length || j<b.length)) return false;
        
        if(memo[i][j] != -1) return memo[i][j] == 1 ? true : false;
        
//         boolean first=false,second=false;
        
//         if(i<a.length && c[k]==a[i]) first = topDown(a,i+1,b,j,c,k+1,memo);
//         if(j<b.length && c[k]==b[j]) second = topDown(a,i,b,j+1,c,k+1,memo);
        
//         boolean ans = first||second;
        
        // memo[i][j] = ans ? 1 : 0;
        
        memo[i][j] = (i<a.length && c[i+j]==a[i] && topDown(a,i+1,b,j,c,memo)) 
                        || (j<b.length && c[i+j]==b[j] && topDown(a,i,b,j+1,c,memo)) ? 1 : 0;
        
        return memo[i][j]==1 ? true : false;
    }
    
    private static boolean bottomUp(char[] a, char[] b, char[] c)
    {
        int n1=a.length, n2=b.length, n3=c.length;
        boolean[][] dp = new boolean[n1+1][n2+1];

        for(int i=n1; i>=0; i--)
        {
            for(int j=n2; j>=0; j--)
            {
                
                if(i==n1 && j==n2) 
                {
                    dp[i][j] = true;
                    continue;
                }
                dp[i][j] = (i<n1 && a[i]==c[i+j] && dp[i+1][j]) || (j<n2 && b[j]==c[i+j] && dp[i][j+1]); 
            }
        }
        
        return dp[0][0];
    }
}
