//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int i = 0, n = nums.length, k = 0;
        
        while(i < n) {
            int curr = nums[i];
            nums[k++] = nums[i];
            while(i < n-1 && nums[i] == nums[i+1]) i++;
            i++;
        }
        
        return k;
    }
}
