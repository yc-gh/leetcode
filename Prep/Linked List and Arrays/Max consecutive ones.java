//https://leetcode.com/problems/max-consecutive-ones/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length, maxLen = 0, len = 0;
        
        for(int i=0; i<n; i++) {
            if(nums[i] == 1) {
                len++;
            }
            else {
                len = 0;
            }
            maxLen = Integer.max(len, maxLen);
        }
        
        return maxLen;
    }
}
