// https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int tempMax = nums[0];
        int tempMin = nums[0];
        
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]<0)
            {
                tempMax = tempMax ^ tempMin;
                tempMin = tempMin ^ tempMax;
                tempMax = tempMax ^ tempMin;
            }
            
            tempMax = Integer.max(nums[i], tempMax*nums[i]);
            tempMin = Integer.min(nums[i], tempMin*nums[i]);
            
            max = Integer.max(max, tempMax);
        }
        
        return max;
    }
}