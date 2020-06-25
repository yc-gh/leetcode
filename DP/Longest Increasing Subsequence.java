// https://leetcode.com/problems/longest-increasing-subsequence/

// Binary search
class Solution {
    public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
        int i = 0, j = size;
        while (i < j) {
            int m = (i + j) / 2;
            if (tails[m] < x)
                i = m + 1;
            else
                j = m;
        }
        tails[i] = x;
        if (i == size) ++size;
    }
    return size;
}
}


// Memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2) return nums.length;
        int[][] memo = new int[nums.length+1][nums.length];
        return helper(nums, -1, 0, memo);
    }
    
    static int helper(int[] nums, int prev, int curr, int[][] memo)
    {   
        if(curr>=nums.length) return 0;
        if(memo[prev+1][curr]>0) return memo[prev+1][curr];
        int included = 0;
        if(prev<0 || nums[curr]>nums[prev]) included = 1 + helper(nums, curr, curr+1, memo);
        int notIncluded = helper(nums, prev, curr+1, memo);
        return memo[prev+1][curr] = Integer.max(included, notIncluded);
    }
}