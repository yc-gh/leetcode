//https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/

class Solution {
    public int minOperations(int[] nums) {
        Integer prev = nums[0];
        int ans = 0;
        
        for(int i=1; i<nums.length; i++) {
            int curr = nums[i];
            if(curr <= prev) {
                ans += (prev - curr + 1);
                prev = prev + 1;
            }
            else {
                prev = curr;
            }
        }
        
        return ans;
    }
}
