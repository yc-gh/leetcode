//https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        int n = nums.length;
        
        for(int i=1; i<n; i++) {
            currSum += nums[i];
            currSum = Integer.max(currSum, nums[i]);
            maxSum = Integer.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}
