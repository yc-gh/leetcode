// https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxsum = nums[0], currsum = nums[0];
        
        for(int i=1; i<nums.length; i++)
        {
            currsum = Integer.max(nums[i], nums[i]+currsum);
            maxsum = Integer.max(currsum, maxsum);
        }
        
        return maxsum;
    }
}

// Equivalent

class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE, currsum = 0;
        
        for(int i=0; i<nums.length; i++)
        {            
            currsum += nums[i];
            if(currsum > maxsum)
            {
                maxsum = currsum;
            }
            if(currsum < 0)
            {
                currsum = 0;
            }
        }
        
        return maxsum;
    }
}