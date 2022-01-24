//https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        
        for(int curr : nums) {
            if(count == 0) {
                candidate = curr;
                count = 1;
            }
            else {
                if(curr == candidate) count++;
                else count--;
            }
        }
        
        return candidate;
    }
}
