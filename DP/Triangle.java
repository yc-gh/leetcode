//https://leetcode.com/problems/triangle/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // int[][] memo = new int[triangle.size()][];
        // for(int i=0; i<triangle.size(); i++)
        // {
        //     memo[i] = new int[triangle.get(i).size()];
        //     Arrays.fill(memo[i],-1);
        // }
        return dp(triangle);
    }
    
    private static int dp(List<List<Integer>> t, int r, int c, int[][] memo)
    {
        if(r>=t.size()) return 0;
        if(memo[r][c]!=-1) return memo[r][c];
        memo[r][c] = t.get(r).get(c) + 
                            Integer.min(dp(t,r+1,c,memo), dp(t,r+1,c+1,memo));
        System.out.println("c="+c);
        return memo[r][c];
    }
    
    private static int dp(List<List<Integer>> t)
    {
        int r = t.size();
        int c = t.get(r-1).size();
        int[] dp = new int[r+1];
        for(int i=r-1; i>=0; i--)
        {
            for(int j=0; j<c; j++)
            {
                if(j<t.get(i).size())
                {
                    dp[j] = t.get(i).get(j) + Integer.min(dp[j],dp[j+1]);
                }
            }
        }
        return dp[0];
    }

}
