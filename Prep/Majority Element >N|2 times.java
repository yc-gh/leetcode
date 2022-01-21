//https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        int majorityEle = nums[0];
        int majorityCount = 1;
        
        for(int i=1; i<nums.length; i++) {
            int curr = nums[i];
            if(curr == majorityEle) {
                majorityCount++;
            }
            else {
                majorityCount--;
                if(majorityCount == 0) {
                    majorityEle = curr;
                    majorityCount = 1;
                }
            }
        }
        
        return majorityEle;
    }
}
