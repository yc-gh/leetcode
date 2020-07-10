//https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        sum = sum>>1;
        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int num : nums)
        {
            for(int j=sum; j>=num; j--)
            {
                dp[j] = dp[j-num] || dp[j];
            }
        }
        return dp[sum];
    }
}
