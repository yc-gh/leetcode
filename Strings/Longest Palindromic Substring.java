//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        if(s==null) return "";
        if(s.length()<2) return s;
        int n = s.length();
        // return dp(s,n);
        return nondp(s.toCharArray(),n);
    }
    
    private static String nondp(char[] s, int n)
    {
        int start=0, end=0;
        for(int i=0; i<n; i++)
        {
            char c = s[i];
            int left=i, right=i;
            
            while(left>=0 && s[left]==c) left--;
            while(right<n && s[right]==c) right++;
            
            while(left>=0 && right<n)
            {
                if(s[left]!=s[right]) break;
                left--;
                right++;
            }
            
            left++;
            
            if(right-left > end-start) 
            {
                start = left;
                end = right;
            }
        }
        return new String(Arrays.copyOfRange(s,start,end));
    }
    
    private static String dp(String s, int n)
    {
//         int[][] dp = new int[n][n];
//         int[] max = new int[2];
//         int maxlen = 1;
        
//         for(int i=n-1; i>=0; i--)
//         {
//             for(int j=i; j<n; j++)
//             {
//                 if(s.charAt(i)==s.charAt(j))
//                 {
//                     if(j-i<2)
//                     {
//                        dp[i][j] = j-i+1; 
//                     }
//                     else
//                     {
//                         if(dp[i+1][j-1]>0) dp[i][j] = 2+dp[i+1][j-1]; 
//                     }
//                 }
//                 if(dp[i][j]>maxlen)
//                 {
//                     max[0] = i;
//                     max[1] = j;
//                     maxlen = dp[i][j];
//                 }
//             }
//         }
//         return s.substring(max[0],max[1]+1);
        
        boolean[][] dp = new boolean[n][n];
        int[] max = new int[2];
        
        for(int i=n-1; i>=0; i--)
        {
            for(int j=i; j<n; j++)
            {
                if(s.charAt(i)==s.charAt(j) && (j-i<3 || dp[i+1][j-1]))
                {
                    dp[i][j] = true;
                    if(j-i+1 > max[1]-max[0]+1)
                    {
                        max[0]=i;
                        max[1]=j;
                    }
                }
            }
        }
        return s.substring(max[0],max[1]+1);
    }
}
