// https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        Integer currmax = null;
        int count = 0;
        for(int num : nums)
        {
            if(count==0)
            {
                currmax=num;
            }
            
            count += (num==currmax) ? 1 : -1;
            
        }
        return currmax;
    }
}