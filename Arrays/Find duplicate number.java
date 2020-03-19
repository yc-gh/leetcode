// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0], slow = nums[0];
        // int k = nums.length*nums.length;
        do
        {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast!=slow);

        slow = nums[0];
        while(fast!=slow)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
    }
}