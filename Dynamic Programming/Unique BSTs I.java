//https://leetcode.com/problems/unique-binary-search-trees/

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int level=1; level<=n; level++)
            for(int root=1; root<=level; root++)
                dp[level] += dp[root-1]*dp[level-root];
        return dp[n];
    }
}
